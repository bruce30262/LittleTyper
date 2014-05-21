/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import frame.MainFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import littletyper.LittleTyper;
import littletyper.RankingList;

/**
 *
 * @author BruceChen
 */
public class RankingPanel extends javax.swing.JPanel {

    /**
     * Creates new form RankingPanel
     */
    private static RankingPanel rankSingle;

    private RankingList easyRank;
    private RankingList mediumRank;
    private RankingList expertRank;
    
    private RankingPanel() {
        initComponents();
        checkDir();
        
        easyRank = new RankingList();
        mediumRank = new RankingList();
        expertRank = new RankingList();
        
        checkRankFile("easy");
        checkRankFile("medium");
        checkRankFile("expert");
    }
    
    public static RankingPanel getInstance()
    {
        if(rankSingle == null)
        {
            rankSingle = new RankingPanel();
        }
        return rankSingle;
    }
    
    private void checkDir()
    {
        File dir = new File("rank");
        if(!dir.exists()) //rank directory don't exist
        {
            dir.mkdir();
        }
    }
    
    private void checkRankFile(String diff)
    {
        String path = "rank" + File.separator + diff + "Rank.dat";
        File file = new File(path);
                
        if(!file.exists()) //if file don't exists
        {
            try 
            {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                if(diff.equals("easy"))
                {
                    oos.writeObject(easyRank);
                }
                else if(diff.equals("medium"))
                {
                    oos.writeObject(mediumRank);
                }
                else
                {
                    oos.writeObject(expertRank);
                }
                        
                oos.flush();
                oos.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else //if file exists
        {
            try
            {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                if(diff.equals("easy"))
                {
                    easyRank = (RankingList) ois.readObject();
                }
                else if(diff.equals("medium"))
                {
                    mediumRank = (RankingList) ois.readObject();
                }
                else
                {
                    expertRank = (RankingList) ois.readObject();
                }
                
                ois.close();
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    public RankingList getRankList(String diff)
    {
        if(diff.equals("easy"))
        {
            return this.easyRank;
        }
        else if(diff.equals("medium"))
        {
            return this.mediumRank;
        }
        else
        {
            return this.expertRank;
        }
    }
    
    public void saveRankFile(String diff)
    {
        String path = "rank" + File.separator + diff + "Rank.dat";
        File file = new File(path);
        try 
        {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            if(diff.equals("easy"))
            {
                oos.writeObject(easyRank);
            }
            else if(diff.equals("medium"))
            {
                oos.writeObject(mediumRank);
            }
            else
            {
                oos.writeObject(expertRank);
            }

            oos.flush();
            oos.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void loadRankFile(String diff)
    {
        String path = "rank" + File.separator + diff + "Rank.dat";
        File file = new File(path);
        
        try
        {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            if(diff.equals("easy"))
            {
                easyRank = (RankingList) ois.readObject();
            }
            else if(diff.equals("medium"))
            {
                mediumRank = (RankingList) ois.readObject();
            }
            else
            {
                expertRank = (RankingList) ois.readObject();
            }

            ois.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        jTabbedPane2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N

        jButton1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton1.setText("Back to menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 615, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 494, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Easy", jPanel1);

        jPanel2.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N

        jButton2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton2.setText("Back to menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 615, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 494, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Medium", jPanel2);

        jButton3.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton3.setText("Back to menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 615, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 494, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Expert", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainFrame.getInstance().SwitchPanel("start");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainFrame.getInstance().SwitchPanel("start");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainFrame.getInstance().SwitchPanel("start");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
