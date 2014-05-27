/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;
import frame.MainFrame;
import javax.swing.Icon;
import javax.swing.JProgressBar;
import littletyper.Music;


/**
 *
 * @author BruceChen
 */
public class TutorialPanel extends javax.swing.JPanel {

    /**
     * Creates new form TutorialPanel
     */
    private static TutorialPanel tutorSingle;
    private Icon tutorpic;
    private Icon[] tempEnemy;
    private Icon[] tempTutor;
    private Icon[] arrowPoint;
    private Icon[] tutorialGaming;
    private String[] tutorial;
    private int count = 1;
    public Music tutorialMusic;
    
    private TutorialPanel() {
        initComponents();
        tutorpic = new javax.swing.ImageIcon(getClass().getResource("/panel/image/tutorialBGP.png"));
        
        tempTutor = new Icon[3];
        tempEnemy = new Icon[3];
        tempTutor[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_temp.gif"));
        tempTutor[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/attack_temp.gif"));
        tempTutor[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/drink_temp.gif"));
        tempEnemy[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_temp_reverse.gif"));
        tempEnemy[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/hurt_temp_reverse.gif"));
        tempEnemy[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/drink_temp_reverse.gif"));
        arrowPoint = new Icon[8];
        arrowPoint[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_up_left.png"));
        arrowPoint[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_up_right.png"));
        arrowPoint[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_down_left.png"));
        arrowPoint[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_down_right.png"));
        arrowPoint[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_left_down.png"));
        arrowPoint[5] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_left_up.png"));
        arrowPoint[6] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_right_up.png"));
        arrowPoint[7] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/arrow_right_down.png"));
        
        tutorialGaming = new Icon[5];
        tutorialGaming[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/tutorial_gaming1.png"));
        tutorialGaming[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/tutorial_gaming2.png"));
        tutorialGaming[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/tutorial_gaming3.png"));
        
        tutorialBGP.setIcon(tutorpic);
        tempUserPic.setIcon(tempTutor[0]);
        tempEnemyPic.setIcon(tempEnemy[0]);
        Arrow1.setIcon(arrowPoint[0]);
        Arrow2.setIcon(arrowPoint[1]);
        Arrow3.setIcon(arrowPoint[5]);
        Arrow4.setIcon(arrowPoint[6]);
        Arrow5.setIcon(arrowPoint[4]);
        Arrow6.setIcon(arrowPoint[7]);
        Arrow7.setIcon(arrowPoint[2]);
        Arrow8.setIcon(arrowPoint[3]);
        Arrow9.setIcon(arrowPoint[5]);
        tutorialGamingLabel.setIcon(tutorialGaming[0]);
        playerHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/userHP.png")));
        enemyHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/enemyHP.png")));
        endTutorialLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/endTutorial.png")));
        specialATKLabel.setOpaque(true);
        playerMP.setOpaque(true);
        enemyMP.setOpaque(true);
        
        Arrow1.setVisible(false);
        Arrow2.setVisible(false);
        Arrow3.setVisible(false);
        Arrow4.setVisible(false);
        Arrow5.setVisible(false);
        Arrow6.setVisible(false);
        Arrow7.setVisible(false);
        Arrow8.setVisible(false);
        Arrow9.setVisible(false);
        tutorialGamingLabel.setVisible(false);
        initialWordLabel.setVisible(false);
        modifiedWordLabel.setVisible(false);
        completeWordLabel.setVisible(false);
        specialATKLabel.setVisible(false);
        playerMP.setVisible(false);
        enemyMP.setVisible(false);
        endTutorialLabel.setVisible(false);
        
        tutorialMusic = new Music("tutorialBGM.wav");
        
        tutorial = new String[20];
        tutorial[0] = "Welcome to Tutorial!";
        tutorial[1] = "Elements Introduction";
        tutorial[2] = "Player HP Bar";
        tutorial[3] = "Enemy HP Bar";
        tutorial[4] = "Player Name";
        tutorial[5] = "Enemy Name";
        tutorial[6] = "Player MP Bar";
        tutorial[7] = "Enemy MP Bar";
        tutorial[8] = "Player Character";
        tutorial[9] = "Enemy Character";
        tutorial[10] = "Player Points";
        tutorial[11] = "Gaming Introduction";
        tutorialElementLabel.setText(tutorial[0]);
    }
    
    public static TutorialPanel getInstance()
    {
        if(tutorSingle == null)
        {
            tutorSingle = new TutorialPanel();
        }
        return tutorSingle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        tempUserPic = new javax.swing.JLabel();
        tempEnemyPic = new javax.swing.JLabel();
        specialATKLabel = new javax.swing.JLabel();
        completeWordLabel = new javax.swing.JLabel();
        modifiedWordLabel = new javax.swing.JLabel();
        initialWordLabel = new javax.swing.JLabel();
        Arrow1 = new javax.swing.JLabel();
        Arrow2 = new javax.swing.JLabel();
        Arrow3 = new javax.swing.JLabel();
        Arrow4 = new javax.swing.JLabel();
        Arrow5 = new javax.swing.JLabel();
        Arrow6 = new javax.swing.JLabel();
        Arrow7 = new javax.swing.JLabel();
        Arrow8 = new javax.swing.JLabel();
        Arrow9 = new javax.swing.JLabel();
        playerHP = new javax.swing.JLabel();
        playerMP = new javax.swing.JLabel();
        enemyHP = new javax.swing.JLabel();
        enemyMP = new javax.swing.JLabel();
        tutorialGamingLabel = new javax.swing.JLabel();
        endTutorialLabel = new javax.swing.JLabel();
        tutorialElementLabel = new javax.swing.JLabel();
        userScoreLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        enemyNameLabel = new javax.swing.JLabel();
        userApBar = new javax.swing.JProgressBar(JProgressBar.VERTICAL);
        enemyApBar = new javax.swing.JProgressBar(JProgressBar.VERTICAL);
        tutorialBGP = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Back.setText("Back to menu");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 180, 50));
        Back.getAccessibleContext().setAccessibleDescription("");

        Next.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 180, 50));
        add(tempUserPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 80, 80));
        add(tempEnemyPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 80, 80));

        specialATKLabel.setBackground(new java.awt.Color(255, 255, 255));
        specialATKLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        specialATKLabel.setForeground(new java.awt.Color(255, 51, 0));
        specialATKLabel.setText("I'm very special~");
        specialATKLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(specialATKLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        completeWordLabel.setBackground(new java.awt.Color(255, 255, 255));
        completeWordLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        completeWordLabel.setForeground(new java.awt.Color(255, 51, 0));
        completeWordLabel.setText("Hello");
        add(completeWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        modifiedWordLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        modifiedWordLabel.setForeground(new java.awt.Color(255, 51, 0));
        modifiedWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        modifiedWordLabel.setText("Hel");
        modifiedWordLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(modifiedWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 40, 30));

        initialWordLabel.setBackground(new java.awt.Color(255, 255, 255));
        initialWordLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        initialWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        initialWordLabel.setText("Hello");
        initialWordLabel.setToolTipText("");
        initialWordLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        initialWordLabel.setOpaque(true);
        add(initialWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 40, -1));
        add(Arrow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 80, 80));
        add(Arrow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 80, 80));
        add(Arrow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 80, 80));
        add(Arrow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 80, 80));
        add(Arrow5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 80, 80));
        add(Arrow6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 80, 80));
        add(Arrow7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 80, 80));
        add(Arrow8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 80, 80));
        add(Arrow9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 80, 80));

        playerHP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        add(playerHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 256, 47));

        playerMP.setBackground(new java.awt.Color(0, 0, 255));
        add(playerMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 203, 29, 79));

        enemyHP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        add(enemyHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 256, 47));

        enemyMP.setBackground(new java.awt.Color(0, 0, 255));
        add(enemyMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 223, 29, 59));
        add(tutorialGamingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 260, 180));

        endTutorialLabel.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        endTutorialLabel.setForeground(new java.awt.Color(255, 255, 255));
        endTutorialLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endTutorialLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        endTutorialLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        add(endTutorialLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 450, 250));

        tutorialElementLabel.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        tutorialElementLabel.setForeground(new java.awt.Color(255, 255, 255));
        tutorialElementLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tutorialElementLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tutorialElementLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        add(tutorialElementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 450, 250));

        userScoreLabel.setBackground(new java.awt.Color(0, 0, 0));
        userScoreLabel.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        userScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        userScoreLabel.setText("0");
        userScoreLabel.setOpaque(true);
        add(userScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        userNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        userNameLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        userNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameLabel.setText("Temp");
        userNameLabel.setToolTipText("");
        userNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userNameLabel.setOpaque(true);
        add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 70, -1));

        enemyNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        enemyNameLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        enemyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemyNameLabel.setText("Temp");
        enemyNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enemyNameLabel.setOpaque(true);
        add(enemyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 70, -1));

        userApBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        userApBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        userApBar.setDoubleBuffered(true);
        userApBar.setFocusable(false);
        userApBar.setRequestFocusEnabled(false);
        userApBar.setString("");
        userApBar.setStringPainted(true);
        add(userApBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 35, 85));

        enemyApBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        enemyApBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        enemyApBar.setDoubleBuffered(true);
        enemyApBar.setFocusable(false);
        enemyApBar.setRequestFocusEnabled(false);
        enemyApBar.setString("");
        enemyApBar.setStringPainted(true);
        add(enemyApBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 35, 85));
        add(tutorialBGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents
   
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        tempUserPic.setIcon(tempTutor[0]);
        tempEnemyPic.setIcon(tempEnemy[0]);
        Arrow1.setVisible(false);
        Arrow2.setVisible(false);
        Arrow3.setVisible(false);
        Arrow4.setVisible(false);
        Arrow5.setVisible(false);
        Arrow6.setVisible(false);
        Arrow7.setVisible(false);
        Arrow8.setVisible(false);
        Arrow9.setVisible(false);
        tutorialGamingLabel.setVisible(false);
        initialWordLabel.setVisible(false);
        modifiedWordLabel.setVisible(false);
        completeWordLabel.setVisible(false);
        specialATKLabel.setVisible(false);
        playerMP.setVisible(false);
        enemyMP.setVisible(false);
        endTutorialLabel.setVisible(false);
        tutorialElementLabel.setText(tutorial[0]);
        Next.setVisible(true);
        tutorialElementLabel.setVisible(true);
        count = 0;
        this.tutorialMusic.stop();
        StartPanel.getInstance().getStartMusic().playLoop();
        MainFrame.getInstance().SwitchPanel("start");
    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        tutorialElementLabel.setText(tutorial[count]);
        if(count == 0)
            count++;

        switch(count)
        {
            case 0:
                tutorialElementLabel.setText(tutorial[count]);
                count++;
                break;
            case 1:
                tutorialElementLabel.setText(tutorial[count]);
                count++;
                break;
            case 2:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow1.setVisible(true);
                count++;
                break;
            case 3:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow1.setVisible(false);
                Arrow2.setVisible(true);
                count++;
                break;
            case 4:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow2.setVisible(false);
                Arrow3.setVisible(true);
                count++;
                break;
            case 5:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow3.setVisible(false);
                Arrow4.setVisible(true);
                count++;
                break;
            case 6:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow4.setVisible(false);
                Arrow5.setVisible(true);
                count++;
                break;
            case 7:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow5.setVisible(false);
                Arrow6.setVisible(true);
                count++;
                break;
            case 8:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow6.setVisible(false);
                Arrow7.setVisible(true);
                count++;
                break;
            case 9:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow7.setVisible(false);
                Arrow8.setVisible(true);
                count++;
                break;
            case 10:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow8.setVisible(false);
                Arrow9.setVisible(true);
                count++;
                break;
            case 11:
                tutorialElementLabel.setText(tutorial[count]);
                Arrow9.setVisible(false);
                count++;
                break;
            case 12: 
                tutorialElementLabel.setVisible(false);
                tutorialGamingLabel.setVisible(true);
                initialWordLabel.setVisible(true);
                count++;
                break;
            case 13:
                tutorialGamingLabel.setIcon(tutorialGaming[1]);
                modifiedWordLabel.setVisible(true);
                count++;
                break;
            case 14:
                tempUserPic.setIcon(tempTutor[1]);
                tempEnemyPic.setIcon(tempEnemy[1]);
                completeWordLabel.setVisible(true);
                count++;
                break;
            case 15:
                tutorialGamingLabel.setIcon(tutorialGaming[2]);
                initialWordLabel.setVisible(false);
                modifiedWordLabel.setVisible(false);
                completeWordLabel.setVisible(false);
                Arrow5.setVisible(true);
                playerMP.setVisible(true);
                enemyMP.setVisible(true);
                specialATKLabel.setVisible(true);
                count++;
                break;
            case 16:
                tutorialGamingLabel.setVisible(false);
                tempUserPic.setIcon(tempTutor[2]);
                tempEnemyPic.setIcon(tempEnemy[2]);
                Arrow5.setVisible(false);
                endTutorialLabel.setVisible(true);
                Next.setVisible(false);
                specialATKLabel.setVisible(false);
                count++;
                break;
            default:
                tempUserPic.setIcon(tempTutor[0]);
                tempEnemyPic.setIcon(tempEnemy[0]);
                Arrow1.setVisible(false);
                Arrow2.setVisible(false);
                Arrow3.setVisible(false);
                Arrow4.setVisible(false);
                Arrow5.setVisible(false);
                Arrow6.setVisible(false);
                Arrow7.setVisible(false);
                Arrow8.setVisible(false);
                Arrow9.setVisible(false);
                tutorialGamingLabel.setVisible(false);
                initialWordLabel.setVisible(false);
                modifiedWordLabel.setVisible(false);
                completeWordLabel.setVisible(false);
                specialATKLabel.setVisible(false);
                playerMP.setVisible(false);
                enemyMP.setVisible(false);
                endTutorialLabel.setVisible(false);
                count = 0;
        }
    }//GEN-LAST:event_NextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arrow1;
    private javax.swing.JLabel Arrow2;
    private javax.swing.JLabel Arrow3;
    private javax.swing.JLabel Arrow4;
    private javax.swing.JLabel Arrow5;
    private javax.swing.JLabel Arrow6;
    private javax.swing.JLabel Arrow7;
    private javax.swing.JLabel Arrow8;
    private javax.swing.JLabel Arrow9;
    private javax.swing.JButton Back;
    private javax.swing.JButton Next;
    private javax.swing.JLabel completeWordLabel;
    private javax.swing.JLabel endTutorialLabel;
    private javax.swing.JProgressBar enemyApBar;
    private javax.swing.JLabel enemyHP;
    private javax.swing.JLabel enemyMP;
    private javax.swing.JLabel enemyNameLabel;
    private javax.swing.JLabel initialWordLabel;
    private javax.swing.JLabel modifiedWordLabel;
    private javax.swing.JLabel playerHP;
    private javax.swing.JLabel playerMP;
    private javax.swing.JLabel specialATKLabel;
    private javax.swing.JLabel tempEnemyPic;
    private javax.swing.JLabel tempUserPic;
    private javax.swing.JLabel tutorialBGP;
    private javax.swing.JLabel tutorialElementLabel;
    private javax.swing.JLabel tutorialGamingLabel;
    private javax.swing.JProgressBar userApBar;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userScoreLabel;
    // End of variables declaration//GEN-END:variables
}
