/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;

import javax.swing.Icon;
import panel.PlayingPanel;

/**
 *
 * @author BruceChen
 */
public class Enemy {
    
    private String name;
    
    private Icon stand_icon;
    
    private Icon atk_normal_icon;
    private Icon atk_special_icon;
    
    private Icon hurt_normal_icon;
    private Icon hurt_special_icon;
    
    private Icon ball_normal_flying_icon;
    private Icon ball_normal_hit_icon;
    private Icon ball_special_flying_icon;
        
    private Music atk_normal_sound;
    private Music atk_special_sound;
    private Music ball_hit_sound;
    
    public Enemy(String roleName)
    {
        this.name = roleName.toLowerCase();
        loadImage();
        loadSoundtrack();
    }
    
    public void LaunchAtk(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getIconLabel("enemy").setIcon(atk_normal_icon);
            atk_normal_sound.playOnce();
        }
        else
        {
            PlayingPanel.getInstance().getIconLabel("enemy").setIcon(atk_special_icon);
            atk_special_sound.playOnce();
        }
    }
    
    public void GetHurt(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getIconLabel("enemy").setIcon(hurt_normal_icon);
        }
        else
        {
            PlayingPanel.getInstance().getIconLabel("enemy").setIcon(hurt_special_icon);
        }
    }
    
    public void ToStand()
    {
        PlayingPanel.getInstance().getIconLabel("enemy").setIcon(stand_icon);
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
    
    public void setBallHitting()
    {
        PlayingPanel.getInstance().getUserBallIconLabel().setIcon(ball_normal_flying_icon);
    }
    
    private void loadImage()
    {
        stand_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_"+this.name+"_reverse.gif")); 
        
        atk_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+"_reverse.gif")); 
        atk_special_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/specialAttack_"+this.name+"_reverse.gif")); 
                
        hurt_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalHurt_"+this.name+"_reverse.gif")); 
        hurt_special_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/specialHurt_"+this.name+"_reverse.gif")); 
    
        ball_normal_flying_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalBall_"+this.name+"_reverse.gif")); 
        ball_normal_hit_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalBallHit_"+this.name+"_reverse.gif")); 
        ball_special_flying_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/specialBall_"+this.name+"_reverse.gif")); 
    }
    
    private void loadSoundtrack()
    {
        atk_normal_sound = new Music("atk_normal_"+this.name+".wav");
        atk_special_sound = new Music("atk_special_"+this.name+".wav");
        ball_hit_sound = new Music("ball_hit_"+this.name+".wav");
    }
    
}
