/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import littletyper.Enemy;
import littletyper.Hero;
import littletyper.WordList;

/**
 *
 * @author BruceChen
 * 
 * TODO:
 * 1. judging special attack (interrupt twice then launch failed)
 *    special attack's icon need to be adjust y coordinate
 * 2. judging death (0 hp, death pose)
 * 3. switch between different stage
 * 4. judge single or network player
 * 
 */
public class PlayingPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlayingPanel
     */
    
    private static PlayingPanel playSingle;
    
    private String curDiffy;
    private String[] computerEnemyName;
    private String whoAmI = "";
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
   
    private ComputerAtkThread enemyThd;
    private long atkTick;
    private int stage;
    
    private boolean typeOk = true;
    private boolean inSpecial = false;
    
    private Hero hero;
    private String heroName = "";
    
    private Enemy enemy;
    private String enemyName = "";
    
    private int userBallX;
    private int userBallY;
    private int enemyBallX;
    private int enemyBallY;
    
    private PlayingPanel() {
        gen = new Random();
        initComponents();
        setBarUI();
        
        computerEnemyName = new String[5];
        computerEnemyName[0] = "Hunter";
        computerEnemyName[1] = "Jack";
        computerEnemyName[2] = "Sorcerer";
        computerEnemyName[3] = "Frizen";
        computerEnemyName[4] = "Julian";
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
        this.whoAmI = ChoseCharacterPanel.getInstance().getMode();
        wordList = new WordList(d);
        this.totalWordNum = wordList.getSize();
        this.checkRepeat = new boolean[this.totalWordNum];
        clearRepeat();
        
        enemyHpBar.setValue(enemyFakeHp);
        enemyApBar.setValue(enemyAp);
        userHpBar.setValue(userHp);
        userApBar.setValue(userAp);
        
        stage = 1;
        atkTick = 3000;
        
        heroName = ChoseCharacterPanel.getInstance().getRoleName();
        
        hero = new Hero(heroName);
        hero.ToStand();
        
        if(whoAmI.equals("single"))
        {
            enemyName = computerEnemyName[stage-1];
        }
        enemy = new Enemy(enemyName);
        enemy.ToStand();
        
        genNewWord();
        if(whoAmI.equals("single"))
        {
            enemyThd = new ComputerAtkThread(atkTick);
            enemyThd.start();
        }
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
    
    private void setApBar(String role, String flag)
    {
        if(flag.equals("full"))
        {
            if(role.equals("hero"))
            {
                userAp = 100;
                userApBar.setForeground(Color.YELLOW);
                userApBar.setBackground(Color.BLUE);
                userApBar.setIndeterminate(true);
            }
            else
            {
                enemyAp = 100;
                enemyApBar.setForeground(Color.YELLOW);
                enemyApBar.setBackground(Color.BLUE);
                enemyApBar.setIndeterminate(true);
            }
        }
        else //empty
        {
            if(role.equals("hero"))
            {
                userAp = 0;
                userApBar.setForeground(Color.BLUE);
                userApBar.setBackground(null);
                userApBar.setIndeterminate(false);
                userApBar.setValue(userAp);
                
                inSpecial = false;
            }
            else
            {
                enemyAp = 0;
                enemyApBar.setForeground(Color.BLUE);
                enemyApBar.setBackground(null);
                enemyApBar.setIndeterminate(false);
                enemyApBar.setValue(enemyAp);
            }
        }
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
    
    public JLabel getUserBallIconLabel()
    {
        return this.userBallLabel;
    }
    
    public JLabel getEnemyBallIconLabel()
    {
        return this.enemyBallLabel;
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
    
    public void setEnemyAtking(boolean value)
    {
        enemyThd.setAtking(value);
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
        
        if(userAp >= 100) setApBar("hero", "full");
        if(enemyAp >= 100) setApBar("enemy", "full");
    }
    
    public void HurtEnemy()
    {
        enemyFakeHp += 5;
        enemyRealHp -= 5;
        enemyHpBar.setValue(enemyFakeHp);
        setAp("hero");
    }
    
    public void genNext()
    {
        genNewWord();
        enemyThd.setStartTime();
        this.typeOk = true;
        setEnemyAtkMode(true);
    }
    
    public void StartEnemyBall()
    {
        userBallX = userBallLabel.getX();
        userBallY = userBallLabel.getY();
        enemyBallX = enemyBallLabel.getX();
        enemyBallY = enemyBallLabel.getY();
        BallFlyingThd ball = new BallFlyingThd("enemy", "normal", userBallX, userBallY, enemyBallX, enemyBallY);
        ball.start();
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
        userBallLabel = new javax.swing.JLabel();
        enemyBallLabel = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userWordLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        userWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userWordLabel.setText("   ");
        add(userWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 314, 151, 35));

        enemyHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        enemyHpBar.setFocusable(false);
        enemyHpBar.setRequestFocusEnabled(false);
        add(enemyHpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 55, 256, 47));

        userHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        userHpBar.setFocusable(false);
        userHpBar.setRequestFocusEnabled(false);
        add(userHpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 55, 256, 47));

        userApBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        userApBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        userApBar.setDoubleBuffered(true);
        userApBar.setFocusable(false);
        userApBar.setRequestFocusEnabled(false);
        userApBar.setString("");
        userApBar.setStringPainted(true);
        add(userApBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 137, 35, 85));

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_freeze.gif"))); // NOI18N
        add(userIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 358, -1, -1));

        enemyApBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        enemyApBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        enemyApBar.setDoubleBuffered(true);
        enemyApBar.setFocusable(false);
        enemyApBar.setRequestFocusEnabled(false);
        enemyApBar.setString("");
        enemyApBar.setStringPainted(true);
        add(enemyApBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 137, 35, 85));

        enemyIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_freeze_reverse.gif"))); // NOI18N
        add(enemyIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 358, -1, -1));

        userBallLabel.setText("   ");
        userBallLabel.setFocusable(false);
        userBallLabel.setRequestFocusEnabled(false);
        add(userBallLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 380, -1, -1));

        enemyBallLabel.setText("   ");
        enemyBallLabel.setDoubleBuffered(true);
        add(enemyBallLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        if(!this.typeOk) return;
        
        char key = evt.getKeyChar();
        int keyNum = evt.getKeyCode();
        
        if(key == leftStr.charAt(0))
        {
            this.userCurIndex++;
            this.userCurStr = this.realStr.substring(0, this.userCurIndex);
            this.leftStr = this.realStr.substring(userCurIndex);
            setTextColor();
            
            if( userCurIndex == realStr.length() ) //next one
            {
                userBallX = userBallLabel.getX();
                userBallY = userBallLabel.getY();
                enemyBallX = enemyBallLabel.getX();
                enemyBallY = enemyBallLabel.getY();
                this.typeOk = false;
                setEnemyAtkMode(false);
                               
                UserAtkThd attack = new UserAtkThd("normal");
                BallFlyingThd ball = new BallFlyingThd("hero", "normal", userBallX, userBallY, enemyBallX, enemyBallY);
               //  Icon test = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_freeze.gif"));
                //PlayingPanel.getInstance().getIconLabel("hero").setIcon(test);
                
                //System.out.println(userBallX +" "+ userBallY +" "+ enemyBallX +" "+ enemyBallY);
                attack.start();
                ball.start();
            }
        }   
        
        if(keyNum == KeyEvent.VK_SPACE && userAp >= 100 && !inSpecial)
        {
            inSpecial = true;
            setApBar("hero", "empty");
        }
    }//GEN-LAST:event_formKeyPressed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar enemyApBar;
    private javax.swing.JLabel enemyBallLabel;
    private javax.swing.JProgressBar enemyHpBar;
    private javax.swing.JLabel enemyIconLabel;
    private javax.swing.JProgressBar userApBar;
    private javax.swing.JLabel userBallLabel;
    private javax.swing.JProgressBar userHpBar;
    private javax.swing.JLabel userIconLabel;
    private javax.swing.JLabel userWordLabel;
    // End of variables declaration//GEN-END:variables
}

class ComputerAtkThread extends Thread
{
    volatile boolean terminate;
    long startTime;
    long endTime;
    long tick;
    volatile boolean canAtk;
    volatile boolean atking;
    String atkType;
    
    public ComputerAtkThread(long tk)
    {
        this.terminate = false;
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
        this.tick = tk;
        this.canAtk = true;
        this.atkType = "normal";
        this.atking= false;
    }
    
    public void run() 
    {
        while(!terminate)
        {
            while( (endTime - startTime) < this.tick)
            {
                if(!terminate)
                {
                    if(this.canAtk && !this.atking)
                    {
                        endTime = System.currentTimeMillis();
                    }
                    else
                    {
                        startTime = System.currentTimeMillis();
                        endTime = System.currentTimeMillis();
                    }
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
                atking = true;
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
    
    public void setAtkType(String t)
    {
        this.atkType = t;
    }
    
    public void setStartTime()
    {
        this.startTime =  System.currentTimeMillis();
    }
    
    public void setCanAtk(boolean value)
    {
        this.canAtk = value;
    }
    
    public void setAtking(boolean value)
    {
        this.atking = value;
    }
    
    private void Attacking()
    {
        if(!this.canAtk) return;
        
        PlayingPanel.getInstance().setUserAtkMode(false); //disable user atk
        
        turnAttacking();
        PlayingPanel.getInstance().StartEnemyBall();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComputerAtkThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        turnStanding();
    }
    
    private void turnAttacking()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                PlayingPanel.getInstance().getEnemy().LaunchAtk(atkType); 
            }
        });
    }
    
    private void turnStanding()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                PlayingPanel.getInstance().getEnemy().ToStand();
            }
        });
    }
}

class UserAtkThd extends Thread
{
    private String atkType;
    
    public UserAtkThd(String type)
    {
        this.atkType = type;
    }
    
    public void run()
    {
        turnAttacking();
         try {
            //System.out.println("in sleep");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(UserAtkThd.class.getName()).log(Level.SEVERE, null, ex);
        }
        turnStanding();       
    }

    private void turnAttacking()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                PlayingPanel.getInstance().getHero().LaunchAtk(atkType);
            }
        });
    }
    
    private void turnStanding()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                PlayingPanel.getInstance().getHero().ToStand();
            }
        });
    }
}

class BallFlyingThd extends Thread
{
    String role;
    String atkType;
    int ux, uy, ex, ey;
      
    public BallFlyingThd(String man, String type, int x1, int y1, int x2, int y2)
    {
        this.role = man;
        this.atkType = type;
        this.ux = x1;
        this.uy = y1;
        this.ex = x2;
        this.ey = y2;
    }

    public void run()
    {
        try
        {
            Thread.sleep(800);
            
            if(this.role.equals("hero"))
            {
                startBall();

                while(ux <= ex)
                {
                    makeBallFly();
                    Thread.sleep(25);
                    ux += 10;
                }
                
                BallHit();
                hurtEnemy();
            }
            else
            {
                startBall();
                
                while(ex >= ux)
                {
                    makeBallFly();
                    Thread.sleep(25);
                    ex -= 10;
                }
                
                BallHit();
                hurtUser();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void startBall()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getHero().setBallFlying(atkType);
                }
                else
                {
                    PlayingPanel.getInstance().getEnemy().setBallFlying(atkType);
                }
            }
        });
    }
    
    private void makeBallFly()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getUserBallIconLabel().setLocation(ux, uy);
                }
                else
                {
                    PlayingPanel.getInstance().getEnemyBallIconLabel().setLocation(ex, ey);
                }
            }
        });
    }
    
    private void BallHit()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getHero().setBallHitting();
                    PlayingPanel.getInstance().getEnemy().GetHurt(atkType);
                    
                    BallHitThread hit = new BallHitThread("hero");
                    HurtingThread hurt = new HurtingThread("enemy");
                    
                    hit.start();
                    hurt.start();
                }
                else
                {
                    PlayingPanel.getInstance().getEnemy().setBallHitting();
                    PlayingPanel.getInstance().getHero().GetHurt(atkType);
                    
                    BallHitThread hit = new BallHitThread("enemy");
                    HurtingThread hurt = new HurtingThread("hero");
                    
                    hit.start();
                    hurt.start();
                }
            }
        });
    }
    
    private void hurtEnemy()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                PlayingPanel.getInstance().HurtEnemy();
            }
        });
    }
    
    private void hurtUser()
    {
        int nowUserHp = PlayingPanel.getInstance().getUserHp() - 5;
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                
                PlayingPanel.getInstance().setUserHp(nowUserHp);
                PlayingPanel.getInstance().setAp("enemy");
            }
        });
    }
}

class BallHitThread extends Thread
{
    String role;
    public BallHitThread(String r)
    {
        this.role = r;
    }
    public void run()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(BallHitThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        stopBallHit();
    }
    
    private void stopBallHit()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getEnemyBallIconLabel().setIcon(null);
                    PlayingPanel.getInstance().getEnemyBallIconLabel().revalidate(); // **IMPORTANT** to call revalidate() to cause JLabel to resize and be repainted.
                }
                else
                {
                    PlayingPanel.getInstance().getUserBallIconLabel().setIcon(null);
                    PlayingPanel.getInstance().getUserBallIconLabel().revalidate(); // **IMPORTANT** to call revalidate() to cause JLabel to resize and be repainted.
                }
            }
        });
    }
}

class HurtingThread extends Thread
{
    String role;
    public HurtingThread(String r)
    {
        this.role = r;
    }
    
    public void run()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BallHitThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        stopHurting();
    }
    
    private void stopHurting()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                // Here, we can safely update the GUI
                // because we'll be called from the
                // event dispatch thread
                
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getHero().ToStand();
                    PlayingPanel.getInstance().setUserAtkMode(true); //re-enable attack mode
                    PlayingPanel.getInstance().setEnemyAtkMode(true); //re-enable attack mode
                    PlayingPanel.getInstance().setEnemyAtking(false); 
                }
                else
                {
                    PlayingPanel.getInstance().getEnemy().ToStand();
                    PlayingPanel.getInstance().genNext(); //gen new word, re-enable attack mode
                }
            }
        });
    }
}