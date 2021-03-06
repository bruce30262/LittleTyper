/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import panel.PlayingPanel;

/**
 *
 * @author BruceChen
 */
public class Hero {
    
    private String name;
    
    private Icon stand_icon;
    
    private Icon atk_normal_icon;
    private Icon atk_special_icon;
    
    private Icon hurt_normal_icon;
    private Icon hurt_special_icon;
    
    private Icon ball_normal_flying_icon;
    private Icon ball_normal_hit_icon;
    private Icon ball_special_flying_icon;
    
    private Icon death_icon;
    private Icon deathing_icon;
    
    private Music atk_normal_sound;
    private Music atk_special_sound;
    private Music ball_hit_sound;
    private Music special_ball_hit_sound;
    private Music dead_sound;
    
    public Hero(String roleName)
    {
        this.name = roleName.toLowerCase();
        loadImage();
        loadSoundtrack();
    }
    
    public void LaunchAtk(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getIconLabel("hero").setIcon(atk_normal_icon);
            atk_normal_sound.playOnce();
        }
        else
        {
            PlayingPanel.getInstance().getIconLabel("hero").setIcon(atk_special_icon);
            atk_special_sound.playOnce();
        }
    }
    
    public void GetHurt(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getIconLabel("hero").setIcon(hurt_normal_icon);
        }
        else
        {
            PlayingPanel.getInstance().getIconLabel("hero").setIcon(hurt_special_icon);
        }
    }
    
    public void ToStand()
    {
        PlayingPanel.getInstance().getIconLabel("hero").setIcon(stand_icon);
    }
    
    public void setBallFlying(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getUserBallIconLabel().setIcon(ball_normal_flying_icon);
        }
        else
        {
            PlayingPanel.getInstance().getUserBallIconLabel().setIcon(ball_special_flying_icon);
        }
    }
    
    public void setBallHitting(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getUserBallIconLabel().setIcon(null);
            PlayingPanel.getInstance().getUserBallIconLabel().revalidate(); // **IMPORTANT** to call revalidate() to cause JLabel to resize and be repainted.
            ball_hit_sound.playOnce();
            PlayingPanel.getInstance().getEnemyBallIconLabel().setIcon(ball_normal_hit_icon);
        }
        else //special attack
        {
            special_ball_hit_sound.playOnce();
        }
    }
    
     public int AdjustY(int y)
    {
        if(name.equals("freeze"))
        {
            return y-50;
        }
        else if(name.equals("firen"))
        {
            return y-50;
        }
        else if(name.equals("davis"))
        {
            return y-25;
        }
        else if(name.equals("woody"))
        {
            return y-125;
        }
        else
        {
            return y;
        }
    }
     
    public String getName()
    {
        return this.name;
    }
    
    private void loadImage()
    {
        stand_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_"+this.name+".gif")); 
        
        atk_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
        atk_special_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/specialAttack_"+this.name+".gif")); 
                
        hurt_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalHurt_"+this.name+".gif")); 
        hurt_special_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/specialHurt_"+this.name+".gif")); 
    
        ball_normal_flying_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalBall_"+this.name+".gif")); 
        ball_normal_hit_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalBallHit_"+this.name+".gif")); 
        ball_special_flying_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/specialBall_"+this.name+".gif")); 
        
        death_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/dead_"+this.name+".png")); 
        deathing_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/dead_"+this.name+".gif")); 
    }
    
    public void PlayDeath()
    {
        PlayingPanel.getInstance().getIconLabel("hero").setIcon(deathing_icon);
        dead_sound.playOnce();
    }
    
    public void NotMoving()
    {
         PlayingPanel.getInstance().getIconLabel("hero").setIcon(death_icon);
    }
    
    private void loadSoundtrack()
    {
        atk_normal_sound = new Music("atk_normal_"+this.name+".wav");
        atk_special_sound = new Music("atk_special_"+this.name+".wav");
        ball_hit_sound = new Music("ball_hit_"+this.name+".wav");
        dead_sound = new Music("death.wav");
        
        if(name.equals("freeze"))
        {
            special_ball_hit_sound = new Music("special_ball_hit_sound1.wav");
        }
        else if(name.equals("john") || name.equals("woody"))
        {
            special_ball_hit_sound = new Music("special_ball_hit_sound2.wav");
        }
        else
        {
            special_ball_hit_sound = new Music("special_ball_hit_sound3.wav");
        }
    }
}
