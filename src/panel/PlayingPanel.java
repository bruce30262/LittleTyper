/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package panel;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
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
    
    private int userBallX;
    private int userBallY;
    private int enemyBallX;
    private int enemyBallY;
    
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
        
        enemy = new Enemy("Frizen");
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
    
    public JLabel getUserBallIconLabel()
    {
        return this.userBallLabel;
    }
    
    public JLabel getEnemyBallIconLabel()
    {
        return this.userBallLabel;
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
        add(userBallLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        enemyBallLabel.setText("   ");
        enemyBallLabel.setDoubleBuffered(true);
        add(enemyBallLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));
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
                userBallX = userBallLabel.getX();
                userBallY = userBallLabel.getY();
                enemyBallX = enemyBallLabel.getX();
                enemyBallY = enemyBallLabel.getY();
                this.typeOk = false;
                setEnemyAtkMode(false);
                               
                UserAtkThd attack = new UserAtkThd();
                BallFlyingThd ball = new BallFlyingThd("hero", userBallX, userBallY, enemyBallX, enemyBallY);
               //  Icon test = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_freeze.gif"));
                //PlayingPanel.getInstance().getIconLabel("hero").setIcon(test);
                
                //System.out.println(userBallX +" "+ userBallY +" "+ enemyBallX +" "+ enemyBallY);
                attack.execute();
                ball.execute();
            }
        }    
    }//GEN-LAST:event_formKeyPressed
    
    public void genNext()
    {
        //hero.ToStand();
        enemyFakeHp += 5;
        enemyRealHp -= 5;
        enemyHpBar.setValue(enemyFakeHp);
        setAp("hero");
               
        genNewWord();
        enemyThd.setStartTime();
        userBallLabel.setIcon(null);

        // **IMPORTANT** to call revalidate() to cause JLabel to resize and be repainted.
        userBallLabel.revalidate();
        this.typeOk = true;
        setEnemyAtkMode(true);
    }

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

class EnemyAtkThread extends Thread
{
    volatile boolean terminate;
    long startTime;
    long endTime;
    long tick;
    volatile boolean canAtk;
    
    public EnemyAtkThread(long tk)
    {
        this.terminate = false;
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
        this.tick = tk;
        this.canAtk = true;
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
        if(!this.canAtk) return;
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

class UserAtkThd extends SwingWorker<Integer, Integer>
{
    //check this: http://www.javamex.com/tutorials/threads/invokelater.shtml
    @Override
    protected Integer doInBackground() throws Exception
    {
        publish(0);
         try {
            System.out.println("in sleep");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(UserAtkThd.class.getName()).log(Level.SEVERE, null, ex);
        }
         publish(1);
        return 100;
    }

    Icon test = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_freeze.gif"));
    protected void done()
    {
        System.out.println("in done");
        /*try {
            get();
        } catch (InterruptedException ex) {
            Logger.getLogger(UserAtkThd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(UserAtkThd.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        PlayingPanel.getInstance().getHero().ToStand();
    }
    
    @Override
    protected void process(List<Integer> chunks) 
    {
        for(Integer curValue : chunks)
        {
            if(curValue == 0)
            {
                 System.out.println("to stand");
                 PlayingPanel.getInstance().getHero().ToStand();
                //PlayingPanel.getInstance().getHero().LaunchAtk("normal");
                /*try {
                    System.out.println("in process");
                    PlayingPanel.getInstance().getIconLabel("hero").setIcon(test);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserAtkThd.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
            else
            {
                 System.out.println("in process");
                 PlayingPanel.getInstance().getIconLabel("hero").setIcon(test);
                //PlayingPanel.getInstance().getHero().LaunchAtk("normal");
                /*try {
                    System.out.println("in process");
                    PlayingPanel.getInstance().getIconLabel("hero").setIcon(test);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserAtkThd.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        }
    }
}

class BallFlyingThd extends SwingWorker<Integer, Integer>
{
    String role;
    int ux, uy, ex, ey;
    
    public BallFlyingThd(String man, int x1, int y1, int x2, int y2)
    {
        this.role = man;
        this.ux = x1;
        this.uy = y1;
        this.ex = x2;
        this.ey = y2;
    }

    @Override
    protected Integer doInBackground() throws Exception
    {
        // Do a time-consuming task.
        try
        {
            Thread.sleep(800);
            int cnt = 1;
            if(this.role.equals("hero"))
            {
                //PlayingPanel.getInstance().getHero().setBallFlying("normal");
                publish(0);

                int a = 100;
                while(a > 0)
                {
                    
                    //PlayingPanel.getInstance().getUserBallIconLabel().setLocation(ux, uy);
                    a--;
                    publish(ux);
                    //System.out.println(ux + " " + uy);
                    Thread.sleep(25);
                    ux += 10;
                }
                //PlayingPanel.getInstance().genNext();
            }
            else
            {
                
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 100;
    }

    protected void done()
    {
       PlayingPanel.getInstance().genNext();
    }
    
    @Override
    protected void process(List<Integer> chunks) 
    {
        for(Integer curValue : chunks)
        {
            //System.out.println(curValue);
            if(curValue == 0)
            {
                PlayingPanel.getInstance().getHero().setBallFlying("normal");
                //System.out.println(ux+" vfuytftyu");
            }
            else
            {
                PlayingPanel.getInstance().getUserBallIconLabel().setLocation(curValue, uy);
            }
        }
    }
}