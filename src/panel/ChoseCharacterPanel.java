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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;


/**
 *
 * @author BruceChen
 */
public class ChoseCharacterPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChoseCharacterPanel
     */
    private static ChoseCharacterPanel characterSingle = null;
    private ChoseCharacterPanel() {
        initComponents();
        boxInit();
        choseInit();
    }
    
    public static ChoseCharacterPanel getInstance()
    {
        if(characterSingle == null)
        {
            characterSingle = new ChoseCharacterPanel();
        }
        return characterSingle;
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

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please select a character");

        ch_Label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label2.setText("test2");
        ch_Label2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        ch_Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label3.setText("test3");
        ch_Label3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        ch_Label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label4.setText("test4");
        ch_Label4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        ch_Label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label5.setText("test5");
        ch_Label5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        ch_Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ch_Label1.setText("test1");
        ch_Label1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jButton1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton1.setText("Back to menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jButton2.setText("Next");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addComponent(ch_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(ch_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(ch_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ch_Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(ch_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ch_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
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
    }//GEN-LAST:event_formKeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        MainFrame.getInstance().SwitchPanel("start");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        MainFrame.getInstance().SwitchPanel("difficulty");
    }//GEN-LAST:event_jButton2MouseClicked

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
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ch_Label1;
    private javax.swing.JLabel ch_Label2;
    private javax.swing.JLabel ch_Label3;
    private javax.swing.JLabel ch_Label4;
    private javax.swing.JLabel ch_Label5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private JLabel[] characterBox;
    private Border redBorder;
    private Border blackBorder;
    
    private int cnt;
    
}
