/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import littletyper.Enemy;
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
    private int enemyFakeHp = 0;
    private int enemyRealHp = 100;
    private int enemyAp = 0;
   
    private EnemyAtkThread enemyThd;
    private long atkTick;
    private int stage;
    
    private boolean typeOk = true;
    
    private Hero hero;
    private Enemy enemy;
    
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
        
        enemyHpBar.setValue(enemyFakeHp);
        userHpBar.setValue(userHp);
        userApBar.setValue(userAp);
        
        stage = 1;
        atkTick = 3000;
        
        hero = new Hero(DifficultyPanel.getInstance().getRoleName());
        hero.ToStand();
        
        enemy = new Enemy("Firen");
        enemy.ToStand();
        
        genNewWord();
        enemyThd = new EnemyAtkThread(atkTick);
        enemyThd.start();
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
    
    private void setVisibleUserWord()
    {
        userWordLabel.setText("");
    }
    
    private void setBarUI()
    {
        enemyHpBar.setUI(new BasicProgressBarUI());
        enemyHpBar.setForeground(Color.RED);
        enemyHpBar.setBackground(Color.green);
        
        userHpBar.setUI(new BasicProgressBarUI());
        userHpBar.setForeground(Color.green);
        userHpBar.setBackground(Color.RED);
        
        userApBar.setUI(new BasicProgressBarUI() );
        userApBar.setForeground(Color.BLUE);
        
        enemyApBar.setUI(new BasicProgressBarUI() );
        enemyApBar.setForeground(Color.BLUE);
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
        
        /*if(role.equals("hero"))
        {
            return this.userHp;
        }
        else
        {
            return this.userHp;
        }*/
    }
    
    public void setUserHp(int hp)
    {
        this.userHp = hp;
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
            return this.enemyIconLabel; //boss label
        }
    }
    
    public Hero getHero()
    {
        return this.hero;
    }
    
    public Enemy getEnemy()
    {
        return this.enemy;
    }
    
    public void setUserAtkMode(boolean value)
    {
        this.typeOk = value;
        if(value) //enable attack
        {
            setTextColor();
        }
        else //disable attack
        {
            setVisibleUserWord();
        }
    }
    
    public void setEnemyAtkMode(boolean value)
    {
        enemyThd.setCanAtk(value);
    }
    
    public void setAp(String whoAtk)
    {
        if(whoAtk.equals("hero")) //hero atk, userAp+, enemyAp++
        {
            userAp += 10;
            enemyAp += 20;            
        }
        else
        {
            userAp += 20;
            enemyAp += 10;            
        }
        userApBar.setValue(userAp);
        enemyApBar.setValue(enemyAp);
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
        enemyHpBar = new javax.swing.JProgressBar();
        userHpBar = new javax.swing.JProgressBar();
        userApBar = new javax.swing.JProgressBar(JProgressBar.VERTICAL);
        userIconLabel = new javax.swing.JLabel();
        enemyApBar = new javax.swing.JProgressBar(JProgressBar.VERTICAL);
        enemyIconLabel = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        userWordLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        userWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userWordLabel.setText("international");

        enemyHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        enemyHpBar.setFocusable(false);
        enemyHpBar.setRequestFocusEnabled(false);

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

        enemyApBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        enemyApBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        enemyApBar.setDoubleBuffered(true);
        enemyApBar.setFocusable(false);
        enemyApBar.setRequestFocusEnabled(false);
        enemyApBar.setString("");
        enemyApBar.setStringPainted(true);

        enemyIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_freeze_reverse.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userApBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enemyHpBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enemyApBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(userIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enemyIconLabel)
                .addGap(150, 150, 150))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(userWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enemyHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userHpBar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userApBar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enemyApBar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)
                        .addComponent(userWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userIconLabel))
                    .addComponent(enemyIconLabel))
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
                setEnemyAtkMode(false);
                UserAtkThd attack = new UserAtkThd();
                attack.start();
            }
        }    
    }//GEN-LAST:event_formKeyPressed
    
    public void genNext()
    {
        hero.ToStand();
        enemyFakeHp += 5;
        enemyRealHp -= 5;
        enemyHpBar.setValue(enemyFakeHp);
        setAp("hero");
               
        genNewWord();
        enemyThd.setStartTime();
        this.typeOk = true;
        setEnemyAtkMode(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar enemyApBar;
    private javax.swing.JProgressBar enemyHpBar;
    private javax.swing.JLabel enemyIconLabel;
    private javax.swing.JProgressBar userApBar;
    private javax.swing.JProgressBar userHpBar;
    private javax.swing.JLabel userIconLabel;
    private javax.swing.JLabel userWordLabel;
    // End of variables declaration//GEN-END:variables
}

class EnemyAtkThread extends Thread
{
    volatile boolean terminate;
    long startTime;
    long endTime;
    long tick;
    boolean canAtk;
    
    public EnemyAtkThread(long tk)
    {
        this.terminate = false;
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
        this.tick = tk;
        canAtk = true;
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
            
            if(this.canAtk)
            {
                Attacking();
                startTime = System.currentTimeMillis();
                endTime = System.currentTimeMillis();
            }
            else
            {
                continue;
            }
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
    
    public void setCanAtk(boolean value)
    {
        this.canAtk = value;
    }
    
    private void Attacking()
    {
        PlayingPanel.getInstance().setUserAtkMode(false); //disable user atk
            
        try //enemyAttaking
        {
            PlayingPanel.getInstance().getEnemy().LaunchAtk("normal"); 
            //new a thread to move ball
            Thread.sleep(1000);
            PlayingPanel.getInstance().getEnemy().ToStand(); 
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(EnemyAtkThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        int nowUserHp = PlayingPanel.getInstance().getUserHp() - 10;
        PlayingPanel.getInstance().setUserHp(nowUserHp);
        PlayingPanel.getInstance().setAp("enemy");

        PlayingPanel.getInstance().setUserAtkMode(true); //enable user atk
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