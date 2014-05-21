/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package littletyper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BruceChen
 */
public class RankingList implements java.io.Serializable
{
    private List<Data> ranking; 
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
    
    public void InserNewUser(String u, int c, int s)
    {
        Data data = new Data(u, c, s);
        ranking.add(newRank, data);
        if(ranking.size() == 4)
        {
            ranking.remove(3);
        }
    }
}

class Data implements java.io.Serializable
{
    String userName;
    int heroId;
    int finalScore;
    public Data(String u, int c, int s)
    {
        this.userName = u;
        this.heroId = c;
        this.finalScore = s;
    }
}
