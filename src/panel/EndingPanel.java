/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

/**
 *
 * @author Alex
 */
public class EndingPanel extends javax.swing.JPanel {

    private Icon[] chIMGs;
    private Icon[] walkIMGs;
    private int imgID;
    
    /**
     * Creates new form EndingPanel
     */
    
    private static EndingPanel endingSingle;
    
    private EndingPanel() {
        initComponents();
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
        
        try 
        {
            Thread.sleep(8000);
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(EndingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.startAnimation();
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
    
    private void startAnimation()
    {
        this.setWalkIMG(this.imgID);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        add(chLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/background_level5.gif")));
        add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel chLabel;
    // End of variables declaration//GEN-END:variables
}
