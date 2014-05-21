/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;

import java.util.ArrayList;

/**
 *
 * @author BruceChen
 */
public class RankingList implements java.io.Serializable
{
    private ArrayList ranking; 
    private int newRank;
    
    public RankingList()
    {
        ranking = new ArrayList<Data>();
    }
    
    public int getSize()
    {
        return this.ranking.size();
    }
    
    public boolean checkHighEnough(int newScore)
    {
        int index = 0;
        for(index = 0 ; index < ranking.size() ; index++)
        {
            Data cur = (Data)ranking.get(index);
            
            if(newScore > cur.finalScore)
            {
                break;
            }
        }
        
        if(index < 5)
        {
            newRank = index; //newRank = 4 --> rank 5
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void InserNewUser(String u, String c, int s)
    {
        Data data = new Data(u, c, s);
        ranking.add(newRank, data);
        if(ranking.size() == 6)
        {
            ranking.remove(5);
        }
    }
}

class Data implements java.io.Serializable
{
    String userName;
    String character;
    int finalScore;
    public Data(String u, String c, int s)
    {
        this.userName = u;
        this.character = c;
        this.finalScore = s;
    }
}
