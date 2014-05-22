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
        try {
            
            if(this.socket1.isServer == true)
            {
                this.socket1.welcomeSocket.close();
                this.socket2.welcomeSocket.close();
            }
            
            if(connected == true)
            {
                this.socket1.socket.close();
                this.socket2.socket.close();
                this.thread1.interrupt();
                this.thread2.interrupt();
            }

            connected = false;
        } catch (Exception ex) {
            
        }
    }

}
