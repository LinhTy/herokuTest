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
public class Wonder 
{
    private String cost;
    private int height;
    private String effect;
    boolean inUse;
    public String getEffect()
    {
        return effect;
    }
    public void setEffect(String effectp)
    {
        effect=effectp;
    }
    public String getCost()
    {
        return cost;
    }
    public void setCost(String costp)
    {
        cost=costp;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int heightp)
    {
        height=heightp;
    }
    public Wonder(String costp, int heightp, String effectp)
    {
        effect=effectp;
        cost=costp;
        height=heightp;
        inUse=false;
    }
    /*public String print()
    {
        String output="Cost=";
        output+=dispArrayList(cost)+"\n";
        output+="height="+height+"\n";
        output+="effect="+effect+"\n";
        return output;
    }*/
    public String dispCost()
    {
        String ret = "";
        if(cost.charAt(0) == '!')
        {
            for(int k=1;k<cost.length();k+=2)
            {
                switch(cost.charAt(k))
                {
                    case('0'):
                        ret+="\nStone: "+cost.charAt(k+1);
                        break;
                    case('1'):
                        ret+="\nWood: "+cost.charAt(k+1);
                        break;
                    case('2'):
                        ret+="\nClay: "+cost.charAt(k+1);
                        break;
                    case('3'):
                        ret+="\nSOre: "+cost.charAt(k+1);
                        break;
                    case('4'):
                        ret+="\nGlass: "+cost.charAt(k+1);
                        break;
                    case('5'):
                        ret+="\nCloth: "+cost.charAt(k+1);
                        break;
                    case('6'):
                        ret+="\nParchment: "+cost.charAt(k+1);
                        break;
                    case('7'):
                        ret+="\nGold: "+cost.charAt(k+1);
                        break;
                }
            }
        }
        else
        {
            System.out.println("ERROR COST SAVED WRONG");
        }
        return ret;
    }
    
    
}
