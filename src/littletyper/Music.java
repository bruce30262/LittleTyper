/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;

import java.io.*;
import java.net.URI; 
import javax.sound.sampled.*;

/**
 *
 * @author BruceChen
 */
public class Music {
    
    private Clip clip;
    private File musicFile;
    private String path;
        
    public Music(String fileName)
    {
        path = "music" + File.separator + fileName;
        try
        {
            musicFile = new File(path);
            AudioInputStream sound = AudioSystem.getAudioInputStream(musicFile);
             // load the sound into memory (a Clip)
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void playOnce()
    {
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }
    
    public void playLoop()
    {
        clip.setFramePosition(0);  // Must always rewind!
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop()
    {
        clip.stop();
    }
    
}
