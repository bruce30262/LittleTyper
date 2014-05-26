/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;
import frame.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import littletyper.RankingList;

/**
 *
 * @author BruceChen
 */
public class YouLosePanel extends javax.swing.JPanel {

    /**
     * Creates new form YouLosePanel
     */
    private static YouLosePanel ylSingle = null;
    
    private String diffy;
    private int id;
    private int score;
    
    private YouLosePanel() {
        initComponents();
    }
    
    public static YouLosePanel getInstance()
    {
        if(ylSingle == null)
        {
            ylSingle = new YouLosePanel();
        }
        return ylSingle;
    }
    
    public void setScoreLabel(String score)
    {
        scoreLabel.setText(score);
    }
    
    public void StartRank()
    {
        this.diffy = PlayingPanel.getInstance().getDiffy();
        this.id = PlayingPanel.getInstance().getRoleId();
        this.score = PlayingPanel.getInstance().getScore();
        
        HandleLoseThread handle = new HandleLoseThread(diffy, id, score);
        handle.start();
    }
    
    public JDialog getInputDialog()
    {
        return this.inputNameDialog;
    }
    
    //public 

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setText("You Lose");

        jLabel2.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel2.setText(":(");

        jLabel3.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel3.setText("Score: ");

        scoreLabel.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        scoreLabel.setText("000000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(313, 313, 313))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(386, 386, 386))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(190, Short.MAX_VALUE))
        );
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
    private javax.swing.JDialog inputNameDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameTextBox;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton sendName;
    // End of variables declaration//GEN-END:variables
}

class HandleLoseThread extends Thread
{
    String diffy;
    int roleId;
    int score;
    
    public HandleLoseThread(String d, int r, int s)
    {
        this.diffy = d;
        this.roleId = r;
        this.score = s;
    }
    
    public void run()
    {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Logger.getLogger(HandleLoseThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RankingList curRank = RankingPanel.getInstance().getRankList(this.diffy);
        
        if(curRank.checkHighEnough(this.score))
        {
            YouLosePanel.getInstance().getInputDialog().setLocationRelativeTo(null);
            YouLosePanel.getInstance().getInputDialog().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            YouLosePanel.getInstance().getInputDialog().setVisible(true);
        }
        else
        {
            StartPanel.getInstance().getStartMusic().playLoop();
            MainFrame.getInstance().SwitchPanel("start");
        }
    }
}
