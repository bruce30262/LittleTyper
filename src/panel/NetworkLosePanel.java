/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import frame.MainFrame;
import littletyper.Music;

/**
 *
 * @author BruceChen
 */
public class NetworkLosePanel extends javax.swing.JPanel {

    /**
     * Creates new form NetworkLosePanel
     */
    private static NetworkLosePanel nlSingle = null;
    private Music netLoseMusic = new Music("network_lose.wav");
        
    private NetworkLosePanel() {
        initComponents();
    }
    
    public static NetworkLosePanel getInstance()
    {
        if(nlSingle == null)
        {
            nlSingle = new NetworkLosePanel();
        }
        return nlSingle;
    }
    
    public Music getNetLoseMusic()
    {
        return this.netLoseMusic;
    }
    
    public void Ticking()
    {
        NetLoseThread tick = new NetLoseThread();
        tick.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setText("You Lose......");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/lose.png")));
        jLabel2.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addContainerGap(306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

class NetLoseThread extends Thread
{
    public void run()
    {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        while( (endTime - startTime) < 6000)
        {
            endTime = System.currentTimeMillis();
        }
        
        PlayingPanel.getInstance().setNeedSwitch(true);
        MainFrame.getInstance().SwitchPanel("start");
        StartPanel.getInstance().getStartMusic().playLoop();
    }
}