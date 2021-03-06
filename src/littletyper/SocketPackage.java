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
import panel.ChoseCharacterPanel;
import panel.ClientConnectedPanel;
import panel.HostPanel;
import panel.PlayingPanel;

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
    
    public Socket socket;
    public ObjectOutputStream output;
    public ObjectInputStream input;
    public ServerSocket welcomeSocket;

    public SocketPackage(String who, String dir, String i,int p, ServerSocket ws)
    {
        isServer = who.equals("server"); 
        isInput = dir.equals("input");
        
        ip = i;
        port = p;
        welcomeSocket = ws;
    }
      
    

    @Override
    public void run() 
    {
        try {
            if(isServer == true) {
                socket = welcomeSocket.accept();
            } else {
                socket = new Socket(ip, port);
            }

            if(isInput == true) input = new ObjectInputStream(socket.getInputStream());
            else    output = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException ex) {
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

                if(isInput == true)
                {
                    while(true)
                    {
                        String msg = input.readObject().toString();
                        if(msg.equals("leave")) break;
                        else if(msg.equals("ult") == true) PlayingPanel.getInstance().setNetworkEnemySpecial();
                        else    PlayingPanel.getInstance().NetworkEnemyAtk(Integer.parseInt(msg));
                    }
                }
                        
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
                    
                    ChoseCharacterPanel.getInstance().getSelectMusic().stop();
                    PlayingPanel.getInstance().setStageBGM(3);
                    PlayingPanel.getInstance().getStageBGM().playLoop();
                    PlayingPanel.getInstance().setDifficultyForNetWork(Connection.getInstance().diff,ChoseCharacterPanel.getInstance().getName(Connection.getInstance().character2));
                    MainFrame.getInstance().SwitchPanel("playing");
                    PlayingPanel.getInstance().getFocus();  
                    
                    while(true)
                    {
                        String msg = input.readObject().toString();
                        if(msg.equals("ult") == true) PlayingPanel.getInstance().setNetworkEnemySpecial();
                        else if(msg.equals("leave") == true)    break;
                        else    PlayingPanel.getInstance().NetworkEnemyAtk(Integer.parseInt(msg));
                    }
                    
                }
                else
                {
                    output.writeObject(Integer.toString(Connection.getInstance().character1));
                }
            }
        } catch(Exception ex) {
            if(isInput == true)
            {
                if(isServer == true) 
                {
                    HostPanel.getInstance().reset();
                    
                    if(PlayingPanel.getInstance().getNeedSwitch())
                    {
                        MainFrame.getInstance().SwitchPanel("host");
                        if(PlayingPanel.getInstance().getStageBGM() != null )
                        {
                            PlayingPanel.getInstance().getStageBGM().stop();
                        }
                    }
                    
                    Connection.getInstance().stop();
                    Connection.getInstance().connect("server", "");
                }
                else
                {
                    if(PlayingPanel.getInstance().getNeedSwitch())
                    {
                        MainFrame.getInstance().SwitchPanel("client");
                        if(PlayingPanel.getInstance().getStageBGM() != null )
                        {
                            PlayingPanel.getInstance().getStageBGM().stop();
                        }
                    }
                    
                    Connection.getInstance().stop();
                }
            }
            return;
        }
    }
    
}
