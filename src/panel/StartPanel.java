/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;
//import javax.swing.*;
import frame.MainFrame;
import java.awt.Color;
import java.io.*;
import java.net.URI; 
import javax.sound.sampled.*;
import javax.swing.Icon;
import littletyper.Music;

/**
 *
 * @author BruceChen
 */
public class StartPanel extends javax.swing.JPanel {

    /**
     * Creates new form StartPanel
     */
    private Music startMusic;
    private Icon startPic;
    
    private static StartPanel startSingle;
    
    private StartPanel() {
        initComponents();
        startMusic = new Music("start.wav");
        startPic = new javax.swing.ImageIcon(getClass().getResource("/panel/image/title.png"));
        startMusic.playLoop();
        jLabel6.setIcon(startPic);
    }
    
    public static StartPanel getInstance()
    {
        if(startSingle == null)
        {
            startSingle = new StartPanel();
        }
        return startSingle;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel1.setText("Single Player Mode");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(496, 342, 251, 38);

        jLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel2.setText("Network Battle Mode");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        add(jLabel2);
        jLabel2.setBounds(496, 386, 251, 38);

        jLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel3.setText("Tutorial");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        add(jLabel3);
        jLabel3.setBounds(496, 430, 251, 38);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel4.setText("Ranking");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        add(jLabel4);
        jLabel4.setBounds(496, 474, 173, 38);

        jLabel5.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel5.setText("Exit");
        jLabel5.setMaximumSize(new java.awt.Dimension(101, 38));
        jLabel5.setMinimumSize(new java.awt.Dimension(101, 38));
        jLabel5.setPreferredSize(new java.awt.Dimension(101, 38));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        add(jLabel5);
        jLabel5.setBounds(496, 518, 101, 38);
        add(jLabel6);
        jLabel6.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        changeTextColor(this.jLabel1, "red");
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        changeTextColor(this.jLabel1, "black");
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        changeTextColor(this.jLabel2, "red");
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        changeTextColor(this.jLabel2, "black");
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        changeTextColor(this.jLabel3, "red");
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        changeTextColor(this.jLabel3, "black");
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        changeTextColor(this.jLabel4, "red");
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        changeTextColor(this.jLabel4, "black");
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        RankingPanel.getInstance().loadRankFile("easy");
        RankingPanel.getInstance().loadRankFile("medium");
        RankingPanel.getInstance().loadRankFile("expert");
        
        RankingPanel.getInstance().initRankPanel("easy");
        RankingPanel.getInstance().initRankPanel("medium");
        RankingPanel.getInstance().initRankPanel("expert");
        
        RankingPanel.getInstance().setRankPanel("easy");
        RankingPanel.getInstance().setRankPanel("medium");
        RankingPanel.getInstance().setRankPanel("expert");
        
        MainFrame.getInstance().SwitchPanel("ranking");
        RankingPanel.getInstance().setTab("easy");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.startMusic.stop();
        MainFrame.getInstance().SwitchPanel("tutorial");
        TutorialPanel.getInstance().tutorialMusic.playLoop();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.startMusic.stop();
        MainFrame.getInstance().SwitchPanel("hostOrClient");
        ChoseCharacterPanel.getInstance().getSelectMusic().playLoop();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        changeTextColor(this.jLabel5, "red");
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        changeTextColor(this.jLabel5, "black");
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.startMusic.stop();
        ChoseCharacterPanel.getInstance().setMode("single");
        MainFrame.getInstance().SwitchPanel("prologue");
        ProloguePanel.getInstance().prologueMusic.playLoop();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void changeTextColor(javax.swing.JLabel label, String color)
    {
        if(color.equals("red"))
        {
            label.setForeground(Color.red);
        }
        else
        {
            label.setForeground(Color.black);
        }
    }
    
    public Music getStartMusic()
    {
        return startMusic;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
