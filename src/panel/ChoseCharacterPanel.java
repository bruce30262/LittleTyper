/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import com.sun.glass.events.KeyEvent;
import frame.MainFrame;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import littletyper.Connection;
import littletyper.Music;
import panel.HostOrClientPanel;


/**
 *
 * @author BruceChen
 */
public class ChoseCharacterPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChoseCharacterPanel
     */
    private Music selectMusic;
    private Icon[] headIcon;
    private String[] roleName;
    private String curRoleName;
    private String mode = "";
    
    private static ChoseCharacterPanel characterSingle = null;
    private ChoseCharacterPanel() {
        initComponents();
        boxInit();
        loadImageAndName();
        choseInit();
        selectMusic = new Music("select.wav");
        curRoleName = "Freeze";
    }
    
    public static ChoseCharacterPanel getInstance()
    {
        if(characterSingle == null)
        {
            characterSingle = new ChoseCharacterPanel();
        }
        return characterSingle;
    }
    
    public Icon getIcon(int cnt)
    {
        return headIcon[cnt];
    }
    
    public String getName(int cnt)
    {
        return roleName[cnt];
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
        ch_Label2 = new javax.swing.JLabel();
        ch_Label3 = new javax.swing.JLabel();
        ch_Label4 = new javax.swing.JLabel();
        ch_Label5 = new javax.swing.JLabel();
        ch_Label1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        headLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please select a character");

        ch_Label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/ch_firen.png"))); // NOI18N
        ch_Label2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ch_Label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ch_Label2MouseClicked(evt);
            }
        });

        ch_Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/ch_davis.png"))); // NOI18N
        ch_Label3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ch_Label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ch_Label3MouseClicked(evt);
            }
        });

        ch_Label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/ch_john.png"))); // NOI18N
        ch_Label4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ch_Label4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ch_Label4MouseClicked(evt);
            }
        });

        ch_Label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/ch_woody.png"))); // NOI18N
        ch_Label5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ch_Label5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ch_Label5MouseClicked(evt);
            }
        });

        ch_Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/ch_freeze.png"))); // NOI18N
        ch_Label1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ch_Label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ch_Label1MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton1.setText("Back to menu");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton2.setText("Next");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        headLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"))); // NOI18N

        nameLabel.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("jLabel2");
        nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 440, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ch_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(ch_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(ch_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(42, 42, 42)
                        .addComponent(ch_Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(ch_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ch_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(headLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
       
        if(key == KeyEvent.VK_LEFT)
        {
            characterBox[cnt].setBorder(blackBorder);
            
            cnt--;
            if(cnt < 0) cnt = 4;
            
            characterBox[cnt].setBorder(redBorder);
        }
        else if(key == KeyEvent.VK_RIGHT)
        {
            characterBox[cnt].setBorder(blackBorder);
            
            cnt = (cnt+1)%5;
            
            characterBox[cnt].setBorder(redBorder);   
        }
        else if(key == KeyEvent.VK_ENTER)
        {
            curRoleName = roleName[cnt];
            if(this.mode.equals("single"))
            {
                toDifficulty();
            }
            else if(this.mode.equals("host"))
            { 
                HostPanel.getInstance().setRole(headIcon[cnt], roleName[cnt], cnt);
                MainFrame.getInstance().SwitchPanel("host");
            }
            else
            {
                ClientPanel.getInstance().setRole(headIcon[cnt], roleName[cnt], cnt);
                MainFrame.getInstance().SwitchPanel("client");
            }
        }
        
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
    }//GEN-LAST:event_formKeyPressed

    private void ch_Label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ch_Label1MouseClicked
        // TODO add your handling code here:
        characterBox[cnt].setBorder(blackBorder);
        cnt = 0;
        characterBox[cnt].setBorder(redBorder);
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
    }//GEN-LAST:event_ch_Label1MouseClicked

    private void ch_Label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ch_Label2MouseClicked
        // TODO add your handling code here:
        characterBox[cnt].setBorder(blackBorder);
        cnt = 1;
        characterBox[cnt].setBorder(redBorder);
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
    }//GEN-LAST:event_ch_Label2MouseClicked

    private void ch_Label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ch_Label3MouseClicked
        // TODO add your handling code here:
        characterBox[cnt].setBorder(blackBorder);
        cnt = 2;
        characterBox[cnt].setBorder(redBorder);
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
    }//GEN-LAST:event_ch_Label3MouseClicked

    private void ch_Label4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ch_Label4MouseClicked
        // TODO add your handling code here:
        characterBox[cnt].setBorder(blackBorder);
        cnt = 3;
        characterBox[cnt].setBorder(redBorder);
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
    }//GEN-LAST:event_ch_Label4MouseClicked

    private void ch_Label5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ch_Label5MouseClicked
        // TODO add your handling code here:
        characterBox[cnt].setBorder(blackBorder);
        cnt = 4;
        characterBox[cnt].setBorder(redBorder);
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
    }//GEN-LAST:event_ch_Label5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.mode.equals("single"))
        {
            this.selectMusic.stop();
            StartPanel.getInstance().getStartMusic().playLoop();
            MainFrame.getInstance().SwitchPanel("start");
        }
        else //must be host or client, back to HostOrClient
        {
            MainFrame.getInstance().SwitchPanel("hostOrClient");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        curRoleName = roleName[cnt];
        if(this.mode.equals("single"))
        {
            toDifficulty();
        }
        else if(this.mode.equals("host"))
        { 
            HostPanel.getInstance().setRole(headIcon[cnt], roleName[cnt], cnt);
            MainFrame.getInstance().SwitchPanel("host");
            Connection.getInstance().saveMyInfo(cnt);
            Connection.getInstance().connect("server","");

        }
        else
        {
            ClientPanel.getInstance().setRole(headIcon[cnt], roleName[cnt], cnt);
            Connection.getInstance().saveMyInfo(cnt);
            MainFrame.getInstance().SwitchPanel("client");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public String getRoleName()
    {
        return this.curRoleName;
    }
    
    private void boxInit()
    {
        characterBox = new JLabel[5];
        
        characterBox[0] = ch_Label1;
        characterBox[1] = ch_Label2;
        characterBox[2] = ch_Label3;
        characterBox[3] = ch_Label4;
        characterBox[4] = ch_Label5;
        
       /* for(int i = 0 ; i < 5 ; i++)
        {
           // BufferedImage myPicture = ImageIO.read(new File("path-to-file"));
            //characterBox[i] = new JLabel("test "+i);
            //characterBox[i].setSize(500,500);
            //characterBox[i].setLocation(160*i,100);
            //this.add(characterBox[i]);
        }*/
        redBorder = javax.swing.BorderFactory.createLineBorder(Color.RED, 3);
        blackBorder = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3);
    }
    
    public void choseInit()
    {
        cnt = 0;
        characterBox[0].setBorder(redBorder);
        characterBox[1].setBorder(blackBorder);
        characterBox[2].setBorder(blackBorder);
        characterBox[3].setBorder(blackBorder);
        characterBox[4].setBorder(blackBorder);
        
        headLabel.setIcon(headIcon[cnt]);
        nameLabel.setText(roleName[cnt]);
        
        if(this.mode.equals("single"))
        {
            jButton1.setText("Back to menu");
        }
        else
        {
            jButton1.setText("Back");
        }
        
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    public Music getSelectMusic()
    {
        return selectMusic;
    }
    
    public void toDifficulty()
    {
        MainFrame.getInstance().SwitchPanel("difficulty");
        DifficultyPanel.getInstance().setRole(headIcon[cnt], roleName[cnt], cnt);
    }
    
    public void loadImageAndName()
    {
        headIcon = new Icon[5];
        headIcon[0] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_freeze.png"));
        headIcon[1] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_firen.png"));
        headIcon[2] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_davis.png"));
        headIcon[3] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_john.png"));
        headIcon[4] = new javax.swing.ImageIcon(getClass().getResource("/panel/image/head_woody.png"));
        
        roleName = new String[5];
        roleName[0] = "Freeze";
        roleName[1] = "Firen";
        roleName[2] = "Davis";
        roleName[3] = "John";
        roleName[4] = "Woody";
    }
    
    public String getMode()
    {
        return this.mode;
    }
    
    public void setMode(String m)
    {
        this.mode = m;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ch_Label1;
    private javax.swing.JLabel ch_Label2;
    private javax.swing.JLabel ch_Label3;
    private javax.swing.JLabel ch_Label4;
    private javax.swing.JLabel ch_Label5;
    private javax.swing.JLabel headLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
    private JLabel[] characterBox;
    private Border redBorder;
    private Border blackBorder;
    
    private int cnt;
}
