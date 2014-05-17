/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;
import java.io.*;
import java.util.*;

/**
 *
 * @author BruceChen
 */
public class WordList {
    
    private FileReader fr;
    private String diffy;
    private List<String> allWord;
    
    public WordList(String d)
    {
        this.diffy = d.toLowerCase();
        this.allWord = new ArrayList<String>();
        String path = "";
        
        if(this.diffy.equals("easy"))
        {
            path = "dic" + File.separator + "easyDic.txt";
            getFile(path);
        }
        else if(this.diffy.equals("medium"))
        {
            path = "dic" + File.separator + "midDic.txt";
            getFile(path);
        }
        else if(this.diffy.equals("expert"))
        {
            path = "dic" + File.separator + "hardDic.txt";
            getFile(path);
        }
        else if(this.diffy.equals("specialeasy"))
        {
            path = "dic" + File.separator + "special_easy.txt";
            getFile(path);
        }
        else if(this.diffy.equals("specialmedium"))
        {
            path = "dic" + File.separator + "special_mid.txt";
            getFile(path);
        }
        else if(this.diffy.equals("specialexpert"))
        {
            path = "dic" + File.separator + "special_hard.txt";
            getFile(path);
        }
    }
    
    private void getFile(String fileName)
    {
        try
        {
            this.fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String singleWord = "";
            while ( (singleWord = br.readLine()) != null )
            {
                this.allWord.add(singleWord);
            }
            this.fr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String getWord(int index)
    {
        return this.allWord.get(index);
    }
    
    public int getSize()
    {
        return this.allWord.size();
    }
}
