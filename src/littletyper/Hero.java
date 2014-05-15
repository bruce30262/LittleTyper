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
        
    private Music atk_normal_sound;
    private Music atk_special_sound;
    private Music ball_hit_sound;
    
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
    
    private void loadImage()
    {
        stand_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_"+this.name+".gif")); 
        
        atk_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
        //atk_special_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
                
        hurt_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalHurt_"+this.name+".gif")); 
        //hurt_special_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
    
        //ball_normal_flying_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
        //ball_normal_hit_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
        //ball_special_flying_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/normalAttack_"+this.name+".gif")); 
    }
    
    private void loadSoundtrack()
    {
        atk_normal_sound = new Music("atk_normal_"+this.name+".wav");
        //atk_special_sound = new Music("");
        ball_hit_sound = new Music("ball_hit_"+this.name+".wav");
    }
    
}
