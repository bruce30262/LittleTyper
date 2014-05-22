/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;
import frame.MainFrame;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import panel.ChoseCharacterPanel;
import panel.ClientConnectedPanel;
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
    String diff;
    
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
    
    public void saveDiff(String d)
    {
        diff = d;
    }
    
    public void send(String msg)
    {
        try {
            output.writeObject(msg);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Connection failed.");
        }
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
            
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        }catch(Exception ex){
            if(interrupted == false)    JOptionPane.showMessageDialog(null, "Connection failed.");
            return;
        }   
        
        try{
            if(isServer == true) 
            {
                character2 = Integer.valueOf(input.readObject().toString());
                output.writeObject(Integer.toString(character1));
                HostPanel.getInstance().setEnemyInfo(character2);
                
                diff = HostPanel.getInstance().getDifficulty();
                output.writeObject(diff);
                
                HostPanel.getInstance().connected = true;
            }
            else
            {
                ClientConnectedPanel.getInstance().setMyInfo(character1);
                output.writeObject(Integer.toString(character1));
                character2 = Integer.valueOf(input.readObject().toString());
                ClientConnectedPanel.getInstance().setEnemyInfo(character2);
                
                diff = input.readObject().toString();
                ClientConnectedPanel.getInstance().setDifficultyText(diff);
                MainFrame.getInstance().SwitchPanel("clientConnected");
                
                while(true)
                {
                    String msg = input.readObject().toString();
                    
                    if(msg.equals("start") == true) break;
                    else    ClientConnectedPanel.getInstance().setDifficultyText(msg);
                }
            }
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "The Other side has leaved.");
            if(isServer == true) 
            {
                HostPanel.getInstance().reset();
                MainFrame.getInstance().SwitchPanel("host");
            }
            else
            {
                MainFrame.getInstance().SwitchPanel("client");
            }
            return;
        }
    }
}
