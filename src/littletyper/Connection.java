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
    ServerSocket welcomeSocket1;
    ServerSocket welcomeSocket2;
    
    int port1 = 7789;
    int port2 = 7790;
    
    public int character1;
    public int character2;
    public String diff;
    
    public Connection()
    {
        try {
            welcomeSocket1 = new ServerSocket(port1);
            welcomeSocket2 = new ServerSocket(port2);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                socket1 = new SocketPackage("server","input","",port1,welcomeSocket1);
                socket2 = new SocketPackage("server","output","",port2,welcomeSocket2);
            }
            else
            {
                socket2 = new SocketPackage("client","output",ip,port1,welcomeSocket2);
                socket1 = new SocketPackage("client","input",ip,port2,welcomeSocket1);
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
                
                /*if(this.socket1.isServer == true)
                {
                    if(this.socket1.welcomeSocket.isClosed() == false)  this.socket1.welcomeSocket.close();
                    if(this.socket2.welcomeSocket.isClosed() == false)  this.socket2.welcomeSocket.close();
                }*/

                if(this.thread1.isAlive())  this.thread1.interrupt();
                if(this.thread2.isAlive())  this.thread2.interrupt();
                
                if(this.socket1.socket.isClosed() == false) this.socket1.socket.close();
                if(this.socket2.socket.isClosed() == false) this.socket2.socket.close();
                
            } catch (Exception ex) {

            }
        
        connected = false;
    }

}
