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
import littletyper.Music;
import littletyper.WordList;

/**
 *
 * @author BruceChen
 * 
 */
public class PlayingPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlayingPanel
     */
    
    private static PlayingPanel playSingle;
    
    private String curDiffy;
    private String[] computerEnemyName;
    private long[] computerEnemyTick;
    private String whoAmI = "";
    private int roleId;
    private int totalWordNum;
    private int totalSpecialWordNum;
    private WordList wordList;
    private WordList specialWordList;
    private Random gen;
    private boolean[] checkRepeat;
    private boolean[] checkRepeatSpecial;
    
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
    private boolean hasSpecialWord = false;
    private boolean notFull = true;
    private int specialInterrupt = 0;
    private int specialInterrupt_enemy = 0;
    
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
        
        computerEnemyTick = new long[5];
        computerEnemyTick[0] = 4500;
        computerEnemyTick[1] = 4000;
        computerEnemyTick[2] = 3500;
        computerEnemyTick[3] = 3000;
        computerEnemyTick[4] = 2500;
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
        specialWordList = new WordList("special"+d);
        this.totalWordNum = wordList.getSize();
        this.totalSpecialWordNum = specialWordList.getSize();
        this.checkRepeat = new boolean[this.totalWordNum];
        this.checkRepeatSpecial = new boolean[this.totalSpecialWordNum];
        clearRepeat();
        
        enemyHpBar.setValue(enemyFakeHp);
        enemyApBar.setValue(enemyAp);
        userHpBar.setValue(userHp);
        userApBar.setValue(userAp);
        
        stage = 5 ;
               
        heroName = ChoseCharacterPanel.getInstance().getRoleName();
        
        hero = new Hero(heroName);
        hero.ToStand();
        
        if(whoAmI.equals("single"))
        {
            enemyName = computerEnemyName[stage-1];
            atkTick = computerEnemyTick[stage-1];
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
        
        for(int i = 0 ; i < this.totalSpecialWordNum ; i++)
        {
            checkRepeatSpecial[i] = false;
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
    
    public void setApBar(String role, String flag)
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
                
                notFull = true;
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
    
    private void genNewSpecialWord()
    {
        int index = 0;
        boolean ok = false;
        
        while(!ok)
        {
            index = this.gen.nextInt(this.totalSpecialWordNum);
            
            if(checkRepeatSpecial[index]) //already has generate
            {
                continue;
            }
            else
            {
                this.realStr = specialWordList.getWord(index);
                this.leftStr = realStr;
                checkRepeatSpecial[index] = true;
                this.userCurIndex = 0;
                this.userCurStr = "";
                ok = true;
            }
        }
        hasSpecialWord = true;
        specialInterrupt = 0;
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
    
    public String getWhoAmI()
    {
        return this.whoAmI;
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
            if(specialInterrupt == 2)
            {
                genNewWord();
                specialInterrupt = 0;
            }
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
        
        if(userAp >= 100 && notFull)
        {
            setApBar("hero", "full");
            notFull = false;
        }
        if(enemyAp >= 100)
        {
            if(whoAmI.equals("single"))
            {
                if(enemyThd.checkSpecialAtking())
                {
                    return;
                }
            }
            setApBar("enemy", "full");
        }
    }
    
    public boolean isCPUEnemyApFull()
    {
        if(enemyAp >= 100) return true;
        else return false;        
    }
    
    public void HurtEnemy()
    {
        enemyFakeHp += 5;
        enemyRealHp -= 5;
        enemyHpBar.setValue(enemyFakeHp);
        setAp("hero");
        
        if(enemyThd.checkSpecialAtking())
        {
            specialInterrupt_enemy++;
            if(specialInterrupt_enemy == 2)
            {
                specialInterrupt_enemy = 0;
                enemyThd.setTick(this.atkTick);
                enemyThd.setAtkType("normal");
                enemyThd.setSpecialAtking(false);
                enemyThd.setStartTime();
                setApBar("enemy", "empty");
            }
        }
    }
    
    public void InitSpecialInterruptEnemy()
    {
        this.specialInterrupt_enemy = 0;
    }
    
    public void HurtUser()
    {
        int nowUserHp = PlayingPanel.getInstance().getUserHp() - 5;
        setUserHp(nowUserHp);
        setAp("enemy");
        
        if(hasSpecialWord)
        {
            specialInterrupt++;
            if(specialInterrupt == 2)
            {
                setApBar("hero", "empty");
                hasSpecialWord = false;
            }
        }
        
        if(this.whoAmI.equals("single"))
        {
            if(enemyThd.checkSpecialAtking())
            {
                enemyThd.setTick(this.atkTick);
                enemyThd.setAtkType("normal");
                enemyThd.setSpecialAtking(false);
                enemyThd.setStartTime();
            }
        }
    }
    
    public void genNext()
    {
        genNewWord();
        hasSpecialWord = false;            
        //enemyThd.setStartTime();
        this.typeOk = true;
        setEnemyAtkMode(true);
    }
    
    public void StartEnemyBall(String type)
    {
        userBallX = userBallLabel.getX();
        userBallY = userBallLabel.getY();
        enemyBallX = enemyBallLabel.getX();
        enemyBallY = enemyBallLabel.getY();
               
        if(type.equals("special"))
        {
            enemyBallY = enemy.AdjustY(enemyBallY);
        }
        
        BallFlyingThd ball = new BallFlyingThd("enemy", type, userBallX, userBallY, enemyBallX, enemyBallY);
        ball.start();
    }
    
    public void genEnemySpecialAtk()
    {
        boolean check = enemyThd.initSpecialAtk();
        
        if(check)
        {
            enemyApBar.setIndeterminate(false);
        }
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
                UserAtkThd attack;
                BallFlyingThd ball;
                userBallX = userBallLabel.getX();
                userBallY = userBallLabel.getY();
                enemyBallX = enemyBallLabel.getX();
                enemyBallY = enemyBallLabel.getY();
                                
                this.typeOk = false;
                setEnemyAtkMode(false);
                
                if(hasSpecialWord) //special sttack
                {
                    userBallY = hero.AdjustY(userBallY);
                    if(hero.getName().equals("freeze") || hero.getName().equals("firen"))
                    {
                        enemyBallX -= 150;
                    }
                    else if(hero.getName().equals("woody"))
                    {
                        enemyBallX -= 175;
                    }
                    else if(hero.getName().equals("john"))
                    {
                        enemyBallX -= 50;
                    }
                    
                    attack = new UserAtkThd("special");
                    ball = new BallFlyingThd("hero", "special", userBallX, userBallY, enemyBallX, enemyBallY);
                    setApBar("hero", "empty"); 
                }
                else //normal attack
                {
                    attack = new UserAtkThd("normal");
                    ball = new BallFlyingThd("hero", "normal", userBallX, userBallY, enemyBallX, enemyBallY);
                }
                
                attack.start();
                ball.start();
            }
        }   
        
        if(keyNum == KeyEvent.VK_SPACE && userAp >= 100 )
        {
            if(!hasSpecialWord)
            {
                genNewSpecialWord();
                userApBar.setIndeterminate(false);
            }
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
    long tempEndTime;
    volatile boolean canAtk;
    volatile boolean atking;
    volatile boolean atking_special;
    String atkType;
    Random gen;
    
    public ComputerAtkThread(long tk)
    {
        this.terminate = false;
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
        this.tick = tk;
        this.canAtk = true;
        this.atkType = "normal";
        this.atking= false;
        this.atking_special = false;
        gen = new Random();
    }
    
    public void run() 
    {
        while(!terminate)
        {
            while( (endTime - startTime) < this.tick)
            {
                //System.out.println((endTime - startTime));
                if(!terminate)
                {
                    if(this.canAtk && !this.atking)
                    {
                        endTime = System.currentTimeMillis();
                    }
                    else
                    {
                        startTime = System.currentTimeMillis() - (endTime - startTime);
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
    
     public void setTick(long value)
    {
        this.tick = value;
    }
    
    public boolean checkSpecialAtking()
    {
        return this.atking_special;
    }
    
    public void setSpecialAtking(boolean v)
    {
        this.atking_special = v;
    }
    
    public boolean initSpecialAtk()
    {
        if(!this.atking_special) //can generate special attack
        {
            boolean yes = gen.nextBoolean();
            if(yes) //generate special attack
            {
                this.tick += 2000;
                this.atkType = "special";
                this.atking_special = true;
                startTime = System.currentTimeMillis();
                endTime = System.currentTimeMillis();
                
                return true;
            }
            else return false;
        } 
        else return false;
    }    
    
    private void Attacking()
    {
        if(!this.canAtk) return;
        
        PlayingPanel.getInstance().setUserAtkMode(false); //disable user atk
        
        turnAttacking();
        PlayingPanel.getInstance().StartEnemyBall(this.atkType);
        
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
                PlayingPanel.getInstance().getEnemy().LaunchAtk(atkType);
                
                if(atkType.equals("special"))
                {
                    PlayingPanel.getInstance().InitSpecialInterruptEnemy();
                    PlayingPanel.getInstance().setApBar("enemy", "empty");
                }
            }
        });
    }
    
    private void turnStanding()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
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
            else //enemy attack
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
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getHero().setBallHitting(atkType);
                    PlayingPanel.getInstance().getEnemy().GetHurt(atkType);
                    
                    if(atkType.equals("special"))
                    {
                        KeepFlyingThread fly = new KeepFlyingThread("hero", ux, uy, ex, ey);
                        fly.start();
                    }
                    else
                    {
                        BallHitThread hit = new BallHitThread("hero");
                        hit.start();
                    }
                    
                    HurtingThread hurt = new HurtingThread("enemy");
                    hurt.start();
                }
                else
                {
                    PlayingPanel.getInstance().getEnemy().setBallHitting(atkType);
                    PlayingPanel.getInstance().getHero().GetHurt(atkType);
                    
                    if(atkType.equals("special"))
                    {
                        KeepFlyingThread fly = new KeepFlyingThread("enemy", ux, uy, ex, ey);
                        fly.start();
                    }
                    else
                    {
                        BallHitThread hit = new BallHitThread("enemy");
                        hit.start();
                    }
                    
                    HurtingThread hurt = new HurtingThread("hero");
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
                PlayingPanel.getInstance().HurtEnemy();
            }
        });
    }
    
    private void hurtUser()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                PlayingPanel.getInstance().HurtUser();
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
                String id = PlayingPanel.getInstance().getWhoAmI();
                if(id.equals("single"))
                {
                    if(PlayingPanel.getInstance().isCPUEnemyApFull())
                    {
                        PlayingPanel.getInstance().genEnemySpecialAtk();
                    }
                }
                
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

class KeepFlyingThread extends Thread
{
    String role;
    int ux;
    int ex;
    int uy;
    int ey;
    
    public KeepFlyingThread(String r, int x1, int y1, int x2, int y2)
    {
        this.role = r;
        this.ux = x1;
        this.ex = x2;
        this.uy = y1;
        this.ey = y2;
    }
    
    public void run()
    {
        if(role.equals("hero"))
        {
            while(ux <= 800)
            {
                flying();
                
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BallFlyingThd.class.getName()).log(Level.SEVERE, null, ex);
                }

                ux += 10;
            }
        }
        else
        {
            while(ex >= -200)
            {
                flying();
                
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BallFlyingThd.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ex -= 10;
            }
        }
        clear();
    }
    
    private void flying()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
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
    
    private void clear()
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                if(role.equals("hero"))
                {
                    PlayingPanel.getInstance().getUserBallIconLabel().setIcon(null);
                    PlayingPanel.getInstance().getUserBallIconLabel().revalidate();
                }
                else
                {
                    PlayingPanel.getInstance().getEnemyBallIconLabel().setIcon(null);
                    PlayingPanel.getInstance().getEnemyBallIconLabel().revalidate();
                }
            }
        });
    }
}