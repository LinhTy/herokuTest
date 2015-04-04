/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg7wonders;
import java.util.ArrayList;
/**
 *
 * @author Paul
 */
public class Civilizations 
{
    private String name;
    private char side;
    private int strtResource;
    private ArrayList<Wonder> wonders;    
    public String getName()
    {
        return  name;
    }
    public void setName(String namep)
    {
        name=namep;
    }
    public char getSide()
    {
        return side;
    }
    public void setSide(char sidep)
    {
        side=sidep;
    }
    public void setResource(int strtResourcep)
    {
        strtResource=strtResourcep;
    }
    public int getStrtResource()
    {
        return strtResource;
    }
    public ArrayList getWonders()
    {
        return wonders;
    }
    public void setWonders(ArrayList<Wonder> wondersp)
    {
    wonders=wondersp;
    }
    public Civilizations(String namep, char sidep, int strtResourcep, ArrayList<Wonder> wondersp)
    {
        name=namep;
        side=sidep;
        strtResource=strtResourcep;
        wonders=wondersp;
    }
    public String toString()
    {
        String output="Civ Name= "+name+"\n";
        output+="side= "+ side+ "\n";
        output+="Starting Resource= "+strtResource+"\n";
        output+=dispWonders();
        return output;
    }
    public String dispWonders()
    {
        String output="";
        for(int x=0; x<wonders.size(); x++)
        {
            output+="wonder"+wonders.get(x).getHeight()+ "\ncost= "+wonders.get(x).dispCost()+" ";
            output+="\n";
            output+="wonder @ height "+ wonders.get(x).getHeight()+ " effect= "+wonders.get(x).getEffect()+"\n";
        }
        return output;
    }
    public void createWonderList(int height)
    {
        for (int x=1; x<= height; x++)
        {
            
        }
    }
}

