/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frame;
import panel.*;
import java.awt.*;

/**
 *
 * @author BruceChen
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private CardLayout card;
    private static MainFrame mainFrame = null;
        
    private MainFrame() {
        initComponents();
        this.setTitle("Little Typer");
        card  = new CardLayout();
        this.setLayout(card);
        this.add(StartPanel.getInstance(), "start");
        this.add(DifficultyPanel.getInstance(), "difficulty");
        this.add(HostOrClientPanel.getInstance(), "hostOrClient");
        this.add(RankingPanel.getInstance(), "ranking");
        this.add(TutorialPanel.getInstance(), "tutorial");
        this.add(ChoseCharacterPanel.getInstance(), "character");
        this.add(PlayingPanel.getInstance(), "playing");
        this.add(HostPanel.getInstance(), "host");
        this.add(ProloguePanel.getInstance(), "prologue");
        this.add(EndingPanel.getInstance(), "ending");
        this.add(ClientPanel.getInstance(), "client");
        this.add(YouWinPanel.getInstance(), "youWin");
        this.add(YouLosePanel.getInstance(), "youLose");
        this.add(ClientConnectedPanel.getInstance(), "clientConnected");
        this.add(NetworkWinPanel.getInstance(), "netWin");
        //this.add(ClientConnectedPanel.getInstance(), "clientConnected");
    }
    
    public static MainFrame getInstance()
    {
        if(mainFrame == null)
        {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }
    
    public void SwitchPanel (String panelName)
    {
        card.show(this.getContentPane(), panelName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
