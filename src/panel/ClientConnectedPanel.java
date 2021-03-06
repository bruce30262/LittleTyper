/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;
import frame.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import panel.HostOrClientPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import littletyper.Connection;

/**
 *
 * @author Hans
 */
public class ClientConnectedPanel extends javax.swing.JPanel {

    private static ClientConnectedPanel ccpSingle = null;
    
    /**
     * Creates new form ClientPanel
     */
    public ClientConnectedPanel() {
        initComponents();
        
        //jButton3.setVisible(false);
    }
    
    public static ClientConnectedPanel getInstance()
    {
        if(ccpSingle == null)
        {
            ccpSingle = new ClientConnectedPanel();
        }
        return ccpSingle;
    }
    
    public void setDifficultyText(String diff)
    {
        choseNameLabel3.setText(diff);
        Connection.getInstance().diff = diff;
    }
    
    public void setMyInfo(int cnt)
    {
        choseLabel.setIcon(ChoseCharacterPanel.getInstance().getIcon(cnt));
        choseNameLabel.setText(ChoseCharacterPanel.getInstance().getName(cnt));
    }
    
    public void setEnemyInfo(int cnt)
    {
        choseLabel1.setIcon(ChoseCharacterPanel.getInstance().getIcon(cnt));
        choseNameLabel1.setText(ChoseCharacterPanel.getInstance().getName(cnt));
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
        jButton3 = new javax.swing.JButton();
        choseLabel = new javax.swing.JLabel();
        choseNameLabel = new javax.swing.JLabel();
        choseLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        choseNameLabel1 = new javax.swing.JLabel();
        choseNameLabel2 = new javax.swing.JLabel();
        choseNameLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 64)); // NOI18N
        jLabel1.setText("Waiting for Start...");

        jButton3.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton3.setText("Disconnect");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        choseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        choseNameLabel.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        choseNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choseNameLabel.setText("Freeze");
        choseNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        choseLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_empty.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel5.setText("VS");

        choseNameLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        choseNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choseNameLabel1.setText("Empty");
        choseNameLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        choseNameLabel2.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        choseNameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choseNameLabel2.setText("Difficulty : ");
        choseNameLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        choseNameLabel3.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        choseNameLabel3.setText("Easy");
        choseNameLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(choseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choseNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(choseLabel)
                            .addGap(73, 73, 73)
                            .addComponent(jLabel5)
                            .addGap(59, 59, 59)
                            .addComponent(choseLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(choseNameLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(choseNameLabel3)
                            .addContainerGap()))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(333, 333, 333))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(161, 161, 161)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(choseLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choseNameLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(choseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choseNameLabel)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choseNameLabel2)
                    .addComponent(choseNameLabel3))
                .addGap(33, 33, 33)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        HostOrClientPanel.changeButtonTextColor(this.jButton3, "red");
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        HostOrClientPanel.changeButtonTextColor(this.jButton3, "black");
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Connection.getInstance().stop();
        MainFrame.getInstance().SwitchPanel("client");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel choseLabel;
    private javax.swing.JLabel choseLabel1;
    private javax.swing.JLabel choseNameLabel;
    private javax.swing.JLabel choseNameLabel1;
    private javax.swing.JLabel choseNameLabel2;
    private javax.swing.JLabel choseNameLabel3;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
