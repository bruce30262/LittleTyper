/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;

import frame.MainFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import littletyper.Connection;
import panel.ClientConnectedPanel;
import panel.HostPanel;

/**
 *
 * @author Hans
 */
public class SocketPackage implements java.lang.Runnable
{
    String ip;
    int port;
    boolean isServer;
    boolean isInput;
    
    static ServerSocket welcomeSocket;
    Socket socket;
    public ObjectOutputStream output;
    public ObjectInputStream input;
    

    public SocketPackage(String who, String dir, String i,int p)
    {
        isServer = who.equals("server"); 
        isInput = dir.equals("input");
        
        ip = i;
        port = p;
    }
    
    

    @Override
    public void run() 
    {
        try {
            if(isServer == true) {
                welcomeSocket = new ServerSocket(port);
                socket = welcomeSocket.accept();
            } else {
                socket = new Socket(ip, port);
            }

            if(isInput == true) input = new ObjectInputStream(socket.getInputStream());
            else    output = new ObjectOutputStream(socket.getOutputStream());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection failed...");
            return;
        }
        
        try {
            if(isServer == true)
            {
                if(isInput == true)
                {
                    Connection.getInstance().character2 = Integer.valueOf(input.readObject().toString());
                    HostPanel.getInstance().setEnemyInfo(Connection.getInstance().character2);
                }
                else
                {
                    output.writeObject(Integer.toString(Connection.getInstance().character1));
                    Connection.getInstance().diff = HostPanel.getInstance().getDifficulty();
                    output.writeObject(Connection.getInstance().diff);
                }
                HostPanel.getInstance().connected = true;
            }
            else
            {
                if(isInput == true)
                {
                    ClientConnectedPanel.getInstance().setMyInfo(Connection.getInstance().character1);
                    Connection.getInstance().character2 = Integer.valueOf(input.readObject().toString());
                    ClientConnectedPanel.getInstance().setEnemyInfo(Connection.getInstance().character2);
                    
                    Connection.getInstance().diff = input.readObject().toString();
                    ClientConnectedPanel.getInstance().setDifficultyText(Connection.getInstance().diff);
                    
                    MainFrame.getInstance().SwitchPanel("clientConnected");

                    while(true)
                    {
                        String msg = input.readObject().toString();

                        if(msg.equals("start") == true) break;
                        else    ClientConnectedPanel.getInstance().setDifficultyText(msg);
                    }
                }
                else
                {
                    output.writeObject(Integer.toString(Connection.getInstance().character1));
                }
            }
        } catch(Exception ex) {
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
