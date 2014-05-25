/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;
import frame.MainFrame;
import javax.swing.Icon;
import littletyper.Music;

/**
 *
 * @author Alex
 */
public class ProloguePanel extends javax.swing.JPanel {

    /**
     * Creates new form ProloguePanel
     */
    private String[] storyTexts;
    public Music prologueMusic;
    //private Icon backgroundIMG;
    private int i = 0;
    
    private static ProloguePanel prologueSingle;
    
    private ProloguePanel() {
        initComponents();
        //backgroundIMG = new javax.swing.ImageIcon(getClass().getResource("/panel/image/prologueBGimg.png"));
        //storyLabel.setIcon(backgroundIMG);
        prologueMusic = new Music("prologueBGM.wav");
        storyTexts = new String[6];
        storyTexts[0] = "there was @#$%@#$%@";
        storyTexts[1] = "and there was the BOSS  who #@#$%@#";
        storyTexts[2] = "but the !#$!%#@%@";
        storyTexts[3] = "@#$@#^&!&^&$%^*&";
        storyTexts[4] = "THE LITTLE TYPER!!! ";
        storyTexts[5] = "";
    }
    
    public static ProloguePanel getInstance()
    {
        if(prologueSingle == null)
        {
            prologueSingle = new ProloguePanel();
        }
        return prologueSingle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        fighterLabel5 = new javax.swing.JLabel();
        fighterLabel4 = new javax.swing.JLabel();
        fighterLabel1 = new javax.swing.JLabel();
        fighterLabel2 = new javax.swing.JLabel();
        fighterLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        storyLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("endingTEST");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 150, 90));

        fighterLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/defence_woody.png")));
        add(fighterLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 100, 100));

        fighterLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/defence_john.png")));
        add(fighterLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 100, 100));

        fighterLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/defence_davis.png")));
        add(fighterLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 100, 100));

        fighterLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/defence_firen.png")));
        add(fighterLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 100, 100));

        fighterLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/defence_freeze.png")));
        add(fighterLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 100, 100));

        jButton1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton1.setText("skip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 180, 54));

        jButton2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton2.setText("Next");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 180, 50));

        storyLabel.setFont(new java.awt.Font("Impact", 0, 72)); // NOI18N
        storyLabel.setForeground(new java.awt.Color(255, 255, 255));
        storyLabel.setText("Once upon a time ...");
        storyLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        storyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storyLabelMouseClicked(evt);
            }
        });
        add(storyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
        storyLabel.getAccessibleContext().setAccessibleName("  Once upon a time ...");

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/prologueBGimg.png")));
        add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void storyLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storyLabelMouseClicked
        // TODO add your handling code here:
        storyLabel.setText(storyTexts[i]);
        
        if (i <= 4)
            i++;// = (i+1) % 5;
        else
        {
           //background music stop
            this.prologueMusic.stop();
            MainFrame.getInstance().SwitchPanel("character");
            ChoseCharacterPanel.getInstance().choseInit();
            ChoseCharacterPanel.getInstance().getSelectMusic().playLoop();
            i = 0;
            storyLabel.setText("Once upon a time ...");
        }
    }//GEN-LAST:event_storyLabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.prologueMusic.stop();
        MainFrame.getInstance().SwitchPanel("character");
        ChoseCharacterPanel.getInstance().choseInit();
        ChoseCharacterPanel.getInstance().getSelectMusic().playLoop();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        storyLabel.setText(storyTexts[i]);
        
        if (i <= 4)
            i++;// = (i+1) % 5;
        else
        {
           //background music stop
            this.prologueMusic.stop();
            MainFrame.getInstance().SwitchPanel("character");
            ChoseCharacterPanel.getInstance().choseInit();
            ChoseCharacterPanel.getInstance().getSelectMusic().playLoop();
            i = 0;
            storyLabel.setText("Once upon a time ...");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        this.prologueMusic.stop();
        MainFrame.getInstance().SwitchPanel("ending");
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel fighterLabel1;
    private javax.swing.JLabel fighterLabel2;
    private javax.swing.JLabel fighterLabel3;
    private javax.swing.JLabel fighterLabel4;
    private javax.swing.JLabel fighterLabel5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel storyLabel;
    // End of variables declaration//GEN-END:variables
}
