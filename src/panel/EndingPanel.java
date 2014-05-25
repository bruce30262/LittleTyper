/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import frame.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import littletyper.RankingList;

/**
 *
 * @author Alex
 */
public class EndingPanel extends javax.swing.JPanel {

    private Icon[] chIMGs;
    private Icon[] walkIMGs;
    private Icon[] liftIMGs;
    private Icon[] liftStillIMGs;
    private Icon bodyIMG = new javax.swing.ImageIcon(getClass().getResource("/panel/image/dead_julian_reverse.png"));
    private Icon cubeIMG = new javax.swing.ImageIcon(getClass().getResource("/panel/image/cube.gif"));
    public int imgID;
    
    private String diffy;
    private int id;
    private int score;
    
    
    /**
     * Creates new form EndingPanel
     */
    
    private static EndingPanel endingSingle;
    
    private EndingPanel() {
        initComponents();
        
        bodyLabel.setIcon(bodyIMG);
        
        chIMGs = new Icon[5];
        chIMGs[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_freeze.gif"));
        chIMGs[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_firen.gif"));
        chIMGs[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_davis.gif"));
        chIMGs[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_john.gif"));
        chIMGs[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_woody.gif"));
        
        walkIMGs = new Icon[5];
        walkIMGs[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/walk_freeze.gif"));
        walkIMGs[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/walk_firen.gif"));
        walkIMGs[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/walk_davis.gif"));
        walkIMGs[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/walk_john.gif"));
        walkIMGs[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/walk_woody.gif"));
        
        liftIMGs = new Icon[5];
        liftIMGs[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_freeze.gif"));
        liftIMGs[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_firean.gif"));
        liftIMGs[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_davis.gif"));
        liftIMGs[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_john.gif"));
        liftIMGs[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_woody.gif"));
        
        liftStillIMGs = new Icon[5];
        liftStillIMGs[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_stand_freeze.png"));
        liftStillIMGs[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_stand_firen.png"));
        liftStillIMGs[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_stand_davis.png"));
        liftStillIMGs[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_stand_john.png"));
        liftStillIMGs[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/lift_stand_woody.png"));
    }
    
    public static EndingPanel getInstance()
    {
        if(endingSingle == null)
        {
            endingSingle = new EndingPanel();
        }
        return endingSingle;
    }
    
    public void setStandIMG(int id)
    {
        chLabel.setIcon(chIMGs[id]);
        this.imgID = id;
    }
    
    public void setWalkIMG(int id)
    {
        chLabel.setIcon(walkIMGs[id]);
    }
    
    public void setWalkPosition (int x, int y)
    {
        setWalkIMG(this.imgID);
        
        chLabel.setLocation(x, y);
    }
    
    public void setCubePosition (int x, int y)
    {   
        cubeLabel.setIcon(cubeIMG);
        cubeLabel.setLocation(x, y);
    }
    
    public void setLiftIMG (int id)
    {
        chLabel.setIcon(liftIMGs[id]);
    }
    
    public void setLiftPosition (int x, int y)
    {
        setLiftIMG(this.imgID);
        chLabel.setLocation(x, y);
    }
    
    public void setLiftStillIMG (int id)
    {
        chLabel.setIcon(liftStillIMGs[id]);
    }
    
    public void setLiftStillPosition (int x, int y)
    {
        setLiftStillIMG(this.imgID);
        chLabel.setLocation(x, y);
    }
    
    public void StartEnding()
    {
        WalkAnimeThd walk = new WalkAnimeThd();
        raiseAnimeThd raise = new raiseAnimeThd();
        walk.start();
        raise.start();
    }
    
    public void SetRankData()
    {
        this.diffy = PlayingPanel.getInstance().getDiffy();
        this.id = PlayingPanel.getInstance().getRoleId();
        this.score = PlayingPanel.getInstance().getScore();
    }
    
    public JDialog getInputDialog()
    {
        return this.inputNameDialog;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputNameDialog = new javax.swing.JDialog();
        sendName = new javax.swing.JButton();
        nameTextBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cubeLabel = new javax.swing.JLabel();
        bodyLabel = new javax.swing.JLabel();
        chLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        inputNameDialog.setAlwaysOnTop(true);
        inputNameDialog.setMinimumSize(new java.awt.Dimension(400, 300));
        inputNameDialog.setResizable(false);

        sendName.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        sendName.setText("OK");
        sendName.setEnabled(false);
        sendName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendNameActionPerformed(evt);
            }
        });

        nameTextBox.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        nameTextBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTextBoxKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel4.setText("Name :");

        jLabel5.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel5.setText("It's a new record!!");

        javax.swing.GroupLayout inputNameDialogLayout = new javax.swing.GroupLayout(inputNameDialog.getContentPane());
        inputNameDialog.getContentPane().setLayout(inputNameDialogLayout);
        inputNameDialogLayout.setHorizontalGroup(
            inputNameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputNameDialogLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(inputNameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputNameDialogLayout.createSequentialGroup()
                        .addComponent(sendName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputNameDialogLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputNameDialogLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(65, 65, 65))))
        );
        inputNameDialogLayout.setVerticalGroup(
            inputNameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputNameDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(inputNameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(sendName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        cubeLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        add(cubeLabel);
        cubeLabel.setBounds(625, 470, 100, 100);

        bodyLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        add(bodyLabel);
        bodyLabel.setBounds(600, 470, 100, 100);

        chLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        add(chLabel);
        chLabel.setBounds(130, 470, 100, 100);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/background_level5.gif")));
        add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void sendNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendNameActionPerformed
        // TODO add your handling code here:
        String userName = nameTextBox.getText();
        if(userName.length() > 0 && userName.length() <= 20)
        {
            RankingList curRank = RankingPanel.getInstance().getRankList(this.diffy);
            curRank.InserNewUser(userName, this.id, this.score);
            RankingPanel.getInstance().saveRankFile(this.diffy);

            RankingPanel.getInstance().loadRankFile("easy");
            RankingPanel.getInstance().loadRankFile("medium");
            RankingPanel.getInstance().loadRankFile("expert");

            RankingPanel.getInstance().initRankPanel("easy");
            RankingPanel.getInstance().initRankPanel("medium");
            RankingPanel.getInstance().initRankPanel("expert");

            RankingPanel.getInstance().setRankPanel("easy");
            RankingPanel.getInstance().setRankPanel("medium");
            RankingPanel.getInstance().setRankPanel("expert");

            inputNameDialog.dispose();
            MainFrame.getInstance().SwitchPanel("ranking");
            RankingPanel.getInstance().setTab(this.diffy);
        }
    }//GEN-LAST:event_sendNameActionPerformed

    private void nameTextBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextBoxKeyTyped
        // TODO add your handling code here:
        String text = nameTextBox.getText();

        if(text.length() > 0)
        {
            sendName.setEnabled(true);
        }
        else
        {
            sendName.setEnabled(false);
        }

        if(text.length() > 20)
        {
            String s = text.substring(0, 20);
            nameTextBox.setText(s);
        }
    }//GEN-LAST:event_nameTextBoxKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel bodyLabel;
    private javax.swing.JLabel chLabel;
    private javax.swing.JLabel cubeLabel;
    private javax.swing.JDialog inputNameDialog;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameTextBox;
    private javax.swing.JButton sendName;
    // End of variables declaration//GEN-END:variables
}

class WalkAnimeThd extends Thread
{
    private int coordX;
    private int coordY;
    
    public WalkAnimeThd()
    {
        this.coordX = 130;
        this.coordY = 470;
    }
    
    public void run()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WalkAnimeThd.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        while (this.coordX <= 600)
        {
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(WalkAnimeThd.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.coordX += 10;
            
            turnWalking();
        }
        turnLifting();
    }

    private void turnWalking()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                EndingPanel.getInstance().setWalkPosition(coordX, coordY);
            }
        });
    }
    
    private void turnLifting()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                EndingPanel.getInstance().setLiftPosition(coordX, coordY);
            }
        });
    }
}

class raiseAnimeThd extends Thread
{
    private int coordX;
    private int coordY;
    
    public raiseAnimeThd()
    {
        this.coordX = 625;
        this.coordY = 485;
    }
    
    public void run()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(raiseAnimeThd.class.getName()).log(Level.SEVERE, null, ex);
        } 
        turnRaising();
        
        while (this.coordY >= 427)
        {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(raiseAnimeThd.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.coordY -= 3;
            
            turnRaising();
        }
        turnLiftStill();
        
        try 
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) 
        {
            Logger.getLogger(raiseAnimeThd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HandleWinThread win = new HandleWinThread();
        win.start();
    }
    
    private void turnRaising()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                EndingPanel.getInstance().setCubePosition(coordX, coordY);
            }
        });
    }
    
    private void turnLiftStill()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                EndingPanel.getInstance().setLiftStillPosition(605, 470);
            }
        });
    }
}

class HandleWinThread extends Thread
{
    String diffy;
    int roleId;
    int score;
    
    public HandleWinThread()
    {
        this.diffy = PlayingPanel.getInstance().getDiffy();
        this.roleId = PlayingPanel.getInstance().getRoleId();
        this.score = PlayingPanel.getInstance().getScore();
    }
    
    public void run()
    {
        RankingList curRank = RankingPanel.getInstance().getRankList(this.diffy);
        
        if(curRank.checkHighEnough(this.score))
        {
            EndingPanel.getInstance().getInputDialog().setLocationRelativeTo(null);
            EndingPanel.getInstance().getInputDialog().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            EndingPanel.getInstance().getInputDialog().setVisible(true);
        }
        else
        {
            MainFrame.getInstance().SwitchPanel("start");
        }
    }
}
