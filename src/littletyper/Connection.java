/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import panel.ChoseCharacterPanel;
import panel.ClientPanel;
import panel.HostPanel;

/**
 *
 * @author Hans
 */
public class Connection implements java.lang.Runnable
{
    static Connection conct;
    
    String IP;
    boolean isServer;
    ServerSocket welcomeSocket;
    Socket socket;
    ObjectOutputStream output;
    ObjectInputStream input;
    Thread thread;
    int character1;
    int character2;
    
    boolean interrupted;
    
    public static Connection getInstance()
    {
        if(conct == null)
        {
            conct = new Connection();
        }
        return conct;
    }
    
    public void saveMyInfo(int cnt)
    {
        character1 = cnt;
    }
       
    public void connect(String who, String ip) 
    {
        interrupted = false;
        isServer = who.equals("server") == true;
        IP = ip;
        
        thread = new Thread(conct);
        thread.start();
    }
    
    public void stop() 
    {   
        this.thread.interrupt();
        try {
            interrupted = true;
            welcomeSocket.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Network has something wrong.");
        }
    }

    @Override
    public void run()
    {
        int port1 = 7790;
        int port2 = 7790;
        
        try{
            if(isServer == true) 
            {
                welcomeSocket = new ServerSocket(port1);
                socket = welcomeSocket.accept();
            }
            else
            {
                socket = new Socket(IP, port2);
            }
            //input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //output = new DataOutputStream(socket.getOutputStream());
            
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            
            if(isServer == true) 
            {
                //character2 = Integer.valueOf(input.readLine());
                //output.writeBytes(Integer.toString(character1));
                character2 = Integer.valueOf(input.readObject().toString());
                output.writeObject(Integer.toString(character1));
                HostPanel.getInstance().setEnemyInfo(character2);
            }
            else
            {
                //output.writeBytes(Integer.toString(character1));
                //character2 = Integer.valueOf(input.readLine());
                
                output.writeObject(Integer.toString(character1));
                character2 = Integer.valueOf(input.readObject().toString());
                ClientPanel.getInstance().setEnemyInfo(character2);
            }
            
        }catch(Exception ex){
            if(interrupted == false)JOptionPane.showMessageDialog(null, "Connection failed.");
            return;
        }
    }
}
