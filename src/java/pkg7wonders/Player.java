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
public class Player 
{
    String name;
    private Civilizations playerCiv;
    private ArrayList<Card> hand;
    private Inventory playerInv;
    Player(Civilizations playerCivArg, ArrayList<Card> handArg, Inventory playerInvArg){
        playerCiv=playerCivArg;
        hand=handArg;
        playerInv=playerInvArg;
    }
    public Civilizations getPlayerCiv()
    {
        return playerCiv;
        
    }
    public void setPlayerCiv(Civilizations playerCivp)
    {
        playerCiv=playerCivp;
    }
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    public void setHand(ArrayList<Card> handp)
    {
        hand=handp;
    }
    public Inventory getInventory()
    {
        return playerInv;
    }
    
    public void setInventory(Inventory playerInvp)
    {
        playerInv=playerInvp;
    }
    
}
