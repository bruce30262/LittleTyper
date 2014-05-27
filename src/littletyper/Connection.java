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
import littletyper.SocketPackage;

/**
 *
 * @author Hans
 */
public class Connection
{
    static Connection conct;
    
    boolean connected = false;
    String IP;
    boolean isServer;
    SocketPackage socket1;
    SocketPackage socket2;
    Thread thread1;
    Thread thread2;
    
    int port1 = 7789;
    int port2 = 7790;
    
    public int character1;
    public int character2;
    public String diff;
    
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
            socket2.output.writeObject(msg);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Connection failed.");
        }
    }
       
    public void connect(String who, String ip)
    {
        isServer = who.equals("server") == true;
        IP = ip;
        try {
            if(isServer == true)
            {
                socket1 = new SocketPackage("server","input","",port1);
                socket2 = new SocketPackage("server","output","",port2);
            }
            else
            {
                socket2 = new SocketPackage("client","output",ip,port1);
                socket1 = new SocketPackage("client","input",ip,port2);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection failed..");
            return;
        }
        
        connected = true;
        
        thread1 = new Thread(socket1);
        thread1.start();
        
        thread2 = new Thread(socket2);
        thread2.start();
    }
    
    public void stop() 
    {   
        boolean[] completed = new  boolean[6];
        for(int i=0;i<6;i++)
            completed[i] = false;
        boolean allFinished = false;
        
        while(allFinished == false)
        {
            try {
                
                if(this.socket1.isServer == true)
                {
                    if(completed[4] == false){
                        completed[4] = true;
                        this.socket1.welcomeSocket.close();
                    }
                    if(completed[5] == false){
                        completed[5] = true;
                        this.socket2.welcomeSocket.close();
                    }
                }

                if(completed[0] == false){
                    completed[0] = true;
                    this.thread1.interrupt();
                }
                if(completed[1] == false){
                    completed[1] = true;
                    this.thread2.interrupt();
                }
                if(completed[2] == false){
                    completed[2] = true;
                    this.socket1.socket.close();
                }
                if(completed[3] == false){
                    completed[3] = true;
                    this.socket2.socket.close();
                }
                
                allFinished = true;
                
            } catch (Exception ex) {

            }
        }
        
        connected = false;
    }

}
