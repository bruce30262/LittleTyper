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
import javax.swing.Icon;
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
    
    private Icon[] headIcon;
    
    private RankingPanel() {
        initComponents();
        loadHeadImage();
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
    
    private void loadHeadImage()
    {
        headIcon = new Icon[5];
        headIcon[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"));
        headIcon[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_firen.png"));
        headIcon[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_davis.png"));
        headIcon[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_john.png"));
        headIcon[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_woody.png"));
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
        easyRankPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        rankLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        characterLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        easyHeadLabel3 = new javax.swing.JLabel();
        easyHeadLabel2 = new javax.swing.JLabel();
        easyHeadLabel1 = new javax.swing.JLabel();
        easyNameLabel2 = new javax.swing.JLabel();
        easyNameLabel1 = new javax.swing.JLabel();
        easyNameLabel3 = new javax.swing.JLabel();
        easyScoreLabel1 = new javax.swing.JLabel();
        easyScoreLabel2 = new javax.swing.JLabel();
        easyScoreLabel3 = new javax.swing.JLabel();
        mediumRankPanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        rankLabel1 = new javax.swing.JLabel();
        nameLabel4 = new javax.swing.JLabel();
        characterLabel4 = new javax.swing.JLabel();
        scoreLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mediumHeadLabel3 = new javax.swing.JLabel();
        mediumHeadLabel2 = new javax.swing.JLabel();
        mediumHeadLabel1 = new javax.swing.JLabel();
        mediumNameLabel2 = new javax.swing.JLabel();
        mediumNameLabel1 = new javax.swing.JLabel();
        mediumNameLabel3 = new javax.swing.JLabel();
        mediumScoreLabel1 = new javax.swing.JLabel();
        mediumScoreLabel2 = new javax.swing.JLabel();
        mediumScoreLabel3 = new javax.swing.JLabel();
        expertRankPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        rankLabel2 = new javax.swing.JLabel();
        nameLabel8 = new javax.swing.JLabel();
        characterLabel8 = new javax.swing.JLabel();
        scoreLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        expertHeadLabel3 = new javax.swing.JLabel();
        expertHeadLabel2 = new javax.swing.JLabel();
        expertHeadLabel1 = new javax.swing.JLabel();
        expertNameLabel2 = new javax.swing.JLabel();
        expertNameLabel1 = new javax.swing.JLabel();
        expertNameLabel3 = new javax.swing.JLabel();
        expertScoreLabel1 = new javax.swing.JLabel();
        expertScoreLabel2 = new javax.swing.JLabel();
        expertScoreLabel3 = new javax.swing.JLabel();

        jTabbedPane2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N

        jButton1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton1.setText("Back to menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        rankLabel.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        rankLabel.setText("Rank");

        nameLabel.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        nameLabel.setText("Name");

        characterLabel.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        characterLabel.setText("Character");

        scoreLabel.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        scoreLabel.setText("Score");

        jLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("2");

        jLabel6.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("1");

        jLabel7.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("3");

        easyHeadLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        easyHeadLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        easyHeadLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        easyNameLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        easyNameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyNameLabel2.setText("           ");

        easyNameLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        easyNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyNameLabel1.setText("            ");

        easyNameLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        easyNameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyNameLabel3.setText("            ");

        easyScoreLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        easyScoreLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyScoreLabel1.setText("              ");

        easyScoreLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        easyScoreLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyScoreLabel2.setText("                     ");

        easyScoreLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        easyScoreLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        easyScoreLabel3.setText("                    ");

        javax.swing.GroupLayout easyRankPanelLayout = new javax.swing.GroupLayout(easyRankPanel);
        easyRankPanel.setLayout(easyRankPanelLayout);
        easyRankPanelLayout.setHorizontalGroup(
            easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyRankPanelLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(easyRankPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(easyRankPanelLayout.createSequentialGroup()
                        .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rankLabel)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(easyRankPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(easyNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, easyRankPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(easyNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(easyRankPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(nameLabel))))
                    .addGroup(easyRankPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(easyNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(characterLabel)
                    .addComponent(easyHeadLabel2)
                    .addComponent(easyHeadLabel3)
                    .addComponent(easyHeadLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, easyRankPanelLayout.createSequentialGroup()
                        .addComponent(scoreLabel)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, easyRankPanelLayout.createSequentialGroup()
                        .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(easyScoreLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(easyScoreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(easyScoreLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        easyRankPanelLayout.setVerticalGroup(
            easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, easyRankPanelLayout.createSequentialGroup()
                .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rankLabel)
                    .addComponent(nameLabel)
                    .addComponent(characterLabel)
                    .addComponent(scoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(easyRankPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(easyNameLabel1))
                        .addGap(117, 117, 117)
                        .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(easyNameLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(easyRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(easyNameLabel3))
                        .addGap(65, 65, 65)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(easyRankPanelLayout.createSequentialGroup()
                        .addComponent(easyHeadLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(easyHeadLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(easyHeadLabel3)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(easyRankPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(easyScoreLabel1)
                        .addGap(121, 121, 121)
                        .addComponent(easyScoreLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(easyScoreLabel3)
                        .addGap(112, 112, 112))))
        );

        jTabbedPane2.addTab("Easy", easyRankPanel);

        jButton4.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton4.setText("Back to menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        rankLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        rankLabel1.setText("Rank");

        nameLabel4.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        nameLabel4.setText("Name");

        characterLabel4.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        characterLabel4.setText("Character");

        scoreLabel4.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        scoreLabel4.setText("Score");

        jLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2");

        jLabel8.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("1");

        jLabel9.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("3");

        mediumHeadLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        mediumHeadLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        mediumHeadLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        mediumNameLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        mediumNameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumNameLabel2.setText("           ");

        mediumNameLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        mediumNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumNameLabel1.setText("            ");

        mediumNameLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        mediumNameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumNameLabel3.setText("            ");

        mediumScoreLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        mediumScoreLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumScoreLabel1.setText("              ");

        mediumScoreLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        mediumScoreLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumScoreLabel2.setText("                     ");

        mediumScoreLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        mediumScoreLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mediumScoreLabel3.setText("                    ");

        javax.swing.GroupLayout mediumRankPanelLayout = new javax.swing.GroupLayout(mediumRankPanel);
        mediumRankPanel.setLayout(mediumRankPanelLayout);
        mediumRankPanelLayout.setHorizontalGroup(
            mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mediumRankPanelLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mediumRankPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mediumRankPanelLayout.createSequentialGroup()
                        .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rankLabel1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mediumRankPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mediumNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediumRankPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mediumNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mediumRankPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(nameLabel4))))
                    .addGroup(mediumRankPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mediumNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(characterLabel4)
                    .addComponent(mediumHeadLabel2)
                    .addComponent(mediumHeadLabel3)
                    .addComponent(mediumHeadLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediumRankPanelLayout.createSequentialGroup()
                        .addComponent(scoreLabel4)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediumRankPanelLayout.createSequentialGroup()
                        .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mediumScoreLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mediumScoreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mediumScoreLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        mediumRankPanelLayout.setVerticalGroup(
            mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediumRankPanelLayout.createSequentialGroup()
                .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rankLabel1)
                    .addComponent(nameLabel4)
                    .addComponent(characterLabel4)
                    .addComponent(scoreLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mediumRankPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(mediumNameLabel1))
                        .addGap(117, 117, 117)
                        .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mediumNameLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mediumRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(mediumNameLabel3))
                        .addGap(65, 65, 65)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mediumRankPanelLayout.createSequentialGroup()
                        .addComponent(mediumHeadLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(mediumHeadLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(mediumHeadLabel3)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(mediumRankPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(mediumScoreLabel1)
                        .addGap(121, 121, 121)
                        .addComponent(mediumScoreLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mediumScoreLabel3)
                        .addGap(112, 112, 112))))
        );

        jTabbedPane2.addTab("Medium", mediumRankPanel);

        jButton5.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton5.setText("Back to menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        rankLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        rankLabel2.setText("Rank");

        nameLabel8.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        nameLabel8.setText("Name");

        characterLabel8.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        characterLabel8.setText("Character");

        scoreLabel8.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        scoreLabel8.setText("Score");

        jLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("2");

        jLabel10.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("1");

        jLabel11.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("3");

        expertHeadLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        expertHeadLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        expertHeadLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        expertNameLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        expertNameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expertNameLabel2.setText("           ");

        expertNameLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        expertNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expertNameLabel1.setText("            ");

        expertNameLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        expertNameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expertNameLabel3.setText("            ");

        expertScoreLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        expertScoreLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expertScoreLabel1.setText("              ");

        expertScoreLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        expertScoreLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expertScoreLabel2.setText("                     ");

        expertScoreLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        expertScoreLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expertScoreLabel3.setText("                    ");

        javax.swing.GroupLayout expertRankPanelLayout = new javax.swing.GroupLayout(expertRankPanel);
        expertRankPanel.setLayout(expertRankPanelLayout);
        expertRankPanelLayout.setHorizontalGroup(
            expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expertRankPanelLayout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(expertRankPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expertRankPanelLayout.createSequentialGroup()
                        .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rankLabel2)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(expertRankPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expertNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expertRankPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expertNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(expertRankPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(nameLabel8))))
                    .addGroup(expertRankPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expertNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(characterLabel8)
                    .addComponent(expertHeadLabel2)
                    .addComponent(expertHeadLabel3)
                    .addComponent(expertHeadLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expertRankPanelLayout.createSequentialGroup()
                        .addComponent(scoreLabel8)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expertRankPanelLayout.createSequentialGroup()
                        .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(expertScoreLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expertScoreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expertScoreLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        expertRankPanelLayout.setVerticalGroup(
            expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expertRankPanelLayout.createSequentialGroup()
                .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rankLabel2)
                    .addComponent(nameLabel8)
                    .addComponent(characterLabel8)
                    .addComponent(scoreLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(expertRankPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(expertNameLabel1))
                        .addGap(117, 117, 117)
                        .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(expertNameLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(expertRankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(expertNameLabel3))
                        .addGap(65, 65, 65)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(expertRankPanelLayout.createSequentialGroup()
                        .addComponent(expertHeadLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(expertHeadLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(expertHeadLabel3)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(expertRankPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(expertScoreLabel1)
                        .addGap(121, 121, 121)
                        .addComponent(expertScoreLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(expertScoreLabel3)
                        .addGap(112, 112, 112))))
        );

        jTabbedPane2.addTab("Expert", expertRankPanel);

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel characterLabel;
    private javax.swing.JLabel characterLabel4;
    private javax.swing.JLabel characterLabel8;
    private javax.swing.JLabel easyHeadLabel1;
    private javax.swing.JLabel easyHeadLabel2;
    private javax.swing.JLabel easyHeadLabel3;
    private javax.swing.JLabel easyNameLabel1;
    private javax.swing.JLabel easyNameLabel2;
    private javax.swing.JLabel easyNameLabel3;
    private javax.swing.JPanel easyRankPanel;
    private javax.swing.JLabel easyScoreLabel1;
    private javax.swing.JLabel easyScoreLabel2;
    private javax.swing.JLabel easyScoreLabel3;
    private javax.swing.JLabel expertHeadLabel1;
    private javax.swing.JLabel expertHeadLabel2;
    private javax.swing.JLabel expertHeadLabel3;
    private javax.swing.JLabel expertNameLabel1;
    private javax.swing.JLabel expertNameLabel2;
    private javax.swing.JLabel expertNameLabel3;
    private javax.swing.JPanel expertRankPanel;
    private javax.swing.JLabel expertScoreLabel1;
    private javax.swing.JLabel expertScoreLabel2;
    private javax.swing.JLabel expertScoreLabel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel mediumHeadLabel1;
    private javax.swing.JLabel mediumHeadLabel2;
    private javax.swing.JLabel mediumHeadLabel3;
    private javax.swing.JLabel mediumNameLabel1;
    private javax.swing.JLabel mediumNameLabel2;
    private javax.swing.JLabel mediumNameLabel3;
    private javax.swing.JPanel mediumRankPanel;
    private javax.swing.JLabel mediumScoreLabel1;
    private javax.swing.JLabel mediumScoreLabel2;
    private javax.swing.JLabel mediumScoreLabel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel4;
    private javax.swing.JLabel nameLabel8;
    private javax.swing.JLabel rankLabel;
    private javax.swing.JLabel rankLabel1;
    private javax.swing.JLabel rankLabel2;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreLabel4;
    private javax.swing.JLabel scoreLabel8;
    // End of variables declaration//GEN-END:variables
}
