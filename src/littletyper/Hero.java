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
    private Icon hurt_normal_icon;
    private Icon atk_special_icon;
    private Icon hurt_special_icon;
    private Icon ball_normal_flying_icon;
    private Icon ball_normal_hit_icon;
    private Icon ball_special_flying_icon;
    private Icon ball_special_hit_icon;
    private Icon getup_icon;
    
    private Music launch_normal_atk;
    private Music launch_special_atk;
    private Music ball_hit;
    
    public Hero(String roleName)
    {
        this.name = roleName.toLowerCase();
        
        if(name.equals("freeze"))
        {
            stand_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/stand_freeze.gif"));  
            atk_normal_icon = new javax.swing.ImageIcon(getClass().getResource("/panel/image/attack_freeze.gif")); 
            launch_normal_atk = new Music("ice_ball.wav");
            ball_hit = new Music("ice_ball.wav");
        }
    }
    
    public void LaunchAtk(String type)
    {
        if(type.equals("normal"))
        {
            PlayingPanel.getInstance().getIconLabel("hero").setIcon(atk_normal_icon);
            launch_normal_atk.playOnce();
        }
        else
        {
            PlayingPanel.getInstance().getIconLabel("hero").setIcon(atk_special_icon);
            launch_special_atk.playOnce();
        }
    }
    
    public void BackToStand()
    {
        PlayingPanel.getInstance().getIconLabel("hero").setIcon(stand_icon);
    }
    
}
