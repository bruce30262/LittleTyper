/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.awt.Color;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.JProgressBar;
import littletyper.Hero;
import littletyper.WordList;

/**
 *
 * @author BruceChen
 */
public class PlayingPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlayingPanel
     */
    
    private static PlayingPanel playSingle;
    
    private String curDiffy;
    private int roleId;
    private int totalWordNum;
    private WordList wordList;
    private Random gen;
    private boolean[] checkRepeat;
    
    private String userCurStr = "";
    private String leftStr = "";
    private String realStr = "";
    private int userCurIndex = 0;
    
    private int userHp = 100;
    private int userAp = 0; // user angry point
    private int bossFakeHp = 0;
    private int bossRealHp = 100;
   
    private BossAtkThread bossThd;
    private long atkTick;
    private int stage;
    
    private boolean typeOk = true;
    
    private Hero hero;
    
    private PlayingPanel() {
        gen = new Random();
        initComponents();
        setBarUI();
    }
    
    public static PlayingPanel getInstance()
    {
        if(playSingle == null)
        {
            playSingle = new PlayingPanel();
        }
        return playSingle;
    }
    
    public void setDifficulty(String d)
    {
        this.curDiffy = d;
        wordList = new WordList(d);
        this.totalWordNum = wordList.getSize();
        this.checkRepeat = new boolean[this.totalWordNum];
        clearRepeat();
        
        bossHpBar.setValue(bossFakeHp);
        userHpBar.setValue(userHp);
        userApBar.setValue(userAp);
        
        stage = 1;
        atkTick = 3000;
        
        hero = new Hero(DifficultyPanel.getInstance().getRoleName());
        hero.ToStand();
        
        genNewWord();
        bossThd = new BossAtkThread(atkTick);
        bossThd.start();
    }
    
    public void clearRepeat()
    {
        for(int i = 0 ; i < this.totalWordNum ; i++)
        {
            checkRepeat[i] = false;
        }
    }
    
    private void setTextColor()
    {
        userWordLabel.setText(String.format("<html><font color='red'>%s</font>%s</html>", 
        this.userCurStr, this.leftStr));
    }
    
    private void setBarUI()
    {
        bossHpBar.setUI(new BasicProgressBarUI());
        bossHpBar.setForeground(Color.RED);
        bossHpBar.setBackground(Color.green);
        userHpBar.setUI(new BasicProgressBarUI());
        userHpBar.setForeground(Color.green);
        userHpBar.setBackground(Color.RED);
        
        userApBar.setUI(new BasicProgressBarUI() );
        //                    {
       //                         protected Color getSelectionBackground() { return Color.black; }
          //                      protected Color getSelectionForeground() { return Color.white; }
        //                    }
       //                 );
        userApBar.setForeground(Color.BLUE);
        //userApBar.selectionForeground(Color.BLUE);
    }
    
    private void genNewWord()
    {
        int index = 0;
        boolean ok = false;
        
        while(!ok)
        {
            index = this.gen.nextInt(this.totalWordNum);
            
            if(checkRepeat[index]) //already has generate
            {
                continue;
            }
            else
            {
                this.realStr = wordList.getWord(index);
                this.leftStr = realStr;
                checkRepeat[index] = true;
                this.userCurIndex = 0;
                this.userCurStr = "";
                ok = true;
            }
        }
        setTextColor();
    }
    
    public void getFocus()
    {
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    public int getUserHp()
    {
        return this.userHp;
    }
    
    public JProgressBar getUserHpBar()
    {
        return this.userHpBar;
    }
    
    public void setUserHp(int hp)
    {
        this.userHp = hp;
    }
    
    public void setUserHpBarValue()
    {
        this.userHpBar.setValue(this.userHp);
    }
    
    public JLabel getIconLabel(String role)
    {
        if(role.equals("hero"))
        {
            return this.userIconLabel;
        }
        else
        {
            return null; //boss label
        }
    }
    
    public Hero getHero()
    {
        return this.hero;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userWordLabel = new javax.swing.JLabel();
        bossHpBar = new javax.swing.JProgressBar();
        userHpBar = new javax.swing.JProgressBar();
        userApBar = new javax.swing.JProgressBar(JProgressBar.VERTICAL);
        userIconLabel = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        userWordLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        userWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userWordLabel.setText("international");

        bossHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bossHpBar.setFocusable(false);
        bossHpBar.setRequestFocusEnabled(false);

        userHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        userHpBar.setFocusable(false);
        userHpBar.setRequestFocusEnabled(false);

        userApBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        userApBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        userApBar.setDoubleBuffered(true);
        userApBar.setFocusable(false);
        userApBar.setRequestFocusEnabled(false);
        userApBar.setString("");
        userApBar.setStringPainted(true);

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_freeze.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(userWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userApBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(bossHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(userIconLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bossHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(userApBar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(userWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userIconLabel)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        if(!this.typeOk) return;
        
        char key = evt.getKeyChar();
        
        if(key == leftStr.charAt(0))
        {
            this.userCurIndex++;
            this.userCurStr = this.realStr.substring(0, this.userCurIndex);
            this.leftStr = this.realStr.substring(userCurIndex);
            setTextColor();
            
            if( userCurIndex == realStr.length() ) //next one
            {
                this.typeOk = false;
                UserAtkThd attack = new UserAtkThd();
                attack.start();
            }
        }    
    }//GEN-LAST:event_formKeyPressed
    
    public void genNext()
    {
        hero.ToStand();
        bossFakeHp += 10;
        bossRealHp -= 10;
        bossHpBar.setValue(bossFakeHp);
        userAp += 20;
        userApBar.setValue(userAp);
        genNewWord();
        bossThd.setStartTime();
        this.typeOk = true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bossHpBar;
    private javax.swing.JProgressBar userApBar;
    private javax.swing.JProgressBar userHpBar;
    private javax.swing.JLabel userIconLabel;
    private javax.swing.JLabel userWordLabel;
    // End of variables declaration//GEN-END:variables
}

class BossAtkThread extends Thread
{
    volatile boolean terminate;
    long startTime;
    long endTime;
    long tick;
    
    public BossAtkThread(long tk)
    {
        this.terminate = false;
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
        this.tick = tk;
    }
    
    public void run() 
    {
        while(!terminate)
        {
            while( (endTime - startTime) < this.tick)
            {
                if(!terminate)
                {
                    endTime = System.currentTimeMillis();
                    continue;
                }
                else
                {
                    break;
                }
            }
            int nowUserHp = PlayingPanel.getInstance().getUserHp() - 10;
            PlayingPanel.getInstance().setUserHp(nowUserHp);
            PlayingPanel.getInstance().setUserHpBarValue();
            //thread.join
            startTime = System.currentTimeMillis();
            endTime = System.currentTimeMillis();
        }
    }  
    
    public void setTerminate(boolean v)
    {
        this.terminate = v;
    }
    
    public void setStartTime()
    {
        this.startTime =  System.currentTimeMillis();
    }
}

class UserAtkThd extends Thread
{
    public void run()
    {
        try
        {
            PlayingPanel.getInstance().getHero().LaunchAtk("normal");
            Thread.sleep(1000);
            PlayingPanel.getInstance().genNext();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}