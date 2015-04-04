/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7wonders;
import java.util.ArrayList;
import java.util.Scanner;
public class Simulation 
{
    int players;
    ArrayList<Player> participant = new ArrayList();
    int[] raffle;
        ArrayList<Card> listCard;
        ArrayList<Civilizations> listCiv;
        ArrayList<Card> hand1;   
        ArrayList<Card> hand2; 
        ArrayList<Card> hand3;
public Simulation()
{
    
    Scanner input = new Scanner(System.in);
    players = 3;    
    
    raffle = shuffleDeck(players);
    listCard = initializeCards();
    listCiv = initializeCiv();
    hand1 = new ArrayList();   
    hand2 = new ArrayList(); 
    hand3 = new ArrayList();
    distributeCards();
    raffle = shuffleCiv(players);
    System.out.println("Hand 1:"+listCiv.get(raffle[0]).getName());
    System.out.print(displayHand(hand1));
    System.out.println("Hand 2:"+listCiv.get(raffle[1]).getName());
    System.out.print(displayHand(hand2));
    System.out.println("Hand 3:"+listCiv.get(raffle[2]).getName());
    System.out.print(displayHand(hand3));
    
    Inventory inventory=new Inventory();
    inventory.addResource(listCiv.get(raffle[0]).getStrtResource());
    Player playerOne=new Player(listCiv.get(raffle[0]), hand1, inventory);
    participant.add(playerOne);
    
    inventory = new Inventory();
    inventory.addResource(listCiv.get(raffle[1]).getStrtResource());
    Player playerTwo=new Player(listCiv.get(raffle[1]),hand2,inventory);
    participant.add(playerTwo);
    
    inventory = new Inventory();
    inventory.addResource(listCiv.get(raffle[2]).getStrtResource());
    Player playerThree=new Player(listCiv.get(raffle[2]),hand3,inventory);
    participant.add(playerThree);
    
    ArrayList<Card> discard = new ArrayList();
    
    //Turn 1;
    int[] choice = new int[players];
    for(int x:choice)
        choice[x]=0;
    
    for(int x=0;x<players;x++)
    {
        
        displayHand(participant.get(x).getHand());
        System.out.print("Choose Card:");
        choice[x] = input.nextInt();
    }
}
    public void selectCard(){
    
    }
    public void distributeCards(){
           for(int k=0;k<players*7;k++)
        {
            if(k%players == 0)
                hand1.add(listCard.get(raffle[k]));
            else if(k%players == 1)
                hand2.add(listCard.get(raffle[k]));
            else
                hand3.add(listCard.get(raffle[k]));
        }
    }
    public ArrayList initializeCiv()
    {
        //Initalize the list of Civilizations
        ArrayList<Civilizations> storageCiv = new ArrayList();
        ArrayList<Wonder> wonder = new ArrayList();
        //RHODOS(angel)
        ArrayList<Wonder> wonder1 = new ArrayList();
        wonder1.add(new Wonder("!12",1,"VP3"));
        wonder1.add(new Wonder("!23",2,"MT2"));
        wonder1.add(new Wonder("!34",3,"VP7"));
        storageCiv.add(new Civilizations("RHODOS",'A',3,wonder1));
        
        //GIZAH(angel)
        ArrayList<Wonder> wonder2 = new ArrayList();
        wonder2.add(new Wonder("!02",1,"VP3"));
        wonder2.add(new Wonder("!13",2,"VP5"));
        wonder2.add(new Wonder("!04",3,"VP7"));
        storageCiv.add(new Civilizations("GIZAH",'A',0,wonder2));
        
        //EPHESOS(angel)
        ArrayList<Wonder> wonder3 = new ArrayList();
        wonder3.add(new Wonder("!02",1,"VP3"));
        wonder3.add(new Wonder("!12",2,"RE79"));
        wonder3.add(new Wonder("!62",3,"VP7"));
        storageCiv.add(new Civilizations("EPHESOS",'A',6,wonder3));
        return storageCiv;
    }
    
    public ArrayList initializeCards()
    {
       //Initalize the list of Cards
        ArrayList<Card> storageCard = new ArrayList();
        //Green
        storageCard.add(new Card("!41","WORKSHOP",3,"Disc","SC2"));
        storageCard.add(new Card("!51","APOTHECARY",3,"Disc","SC0"));
        storageCard.add(new Card("!61","SCRIPTORIUM",3,"Disc","SC1"));
        //Blue
        storageCard.add(new Card("","ALTAR",3,"Disc","VP2"));
        storageCard.add(new Card("","THEATER",3,"Disc","VP2"));
        storageCard.add(new Card("!01","BATHS",3,"Disc","VP3"));
        //Gray
        storageCard.add(new Card("","GLASSWORKS",3,"Disc","RE41"));
        storageCard.add(new Card("","PRESS",3,"Disc","RE61"));
        storageCard.add(new Card("","LOOM",3,"Disc","RE51"));
        //Brown
        storageCard.add(new Card("","CLAY POOL",3,"Disc","RE21"));
        storageCard.add(new Card("","LUMBER YARD",3,"Disc","RE11"));
        storageCard.add(new Card("","STONE PIT",3,"Disc","RE01"));
        storageCard.add(new Card("","ORE VEIN",3,"Disc","RE31"));
        storageCard.add(new Card("!71","CLAY PIT",3,"Disc","RE22"));
        storageCard.add(new Card("!71","TIMBER YARD",3,"Disc","RE12"));
        //Red
        storageCard.add(new Card("!11","STOCKADE",3,"Disc","MT1"));
        storageCard.add(new Card("!31","BARRACKS",3,"Disc","MT1"));
        storageCard.add(new Card("!21","GUARD TOWER",3,"Disc","MT1"));
        //Yellow-Orange
        storageCard.add(new Card("","MARKETPLACE",3,"Disc","PC"));
        storageCard.add(new Card("","WEST TRADING POST",3,"Disc","LG"));
        storageCard.add(new Card("","EAST TRADING POST",3,"Disc","RG")); 
        return storageCard;
    }
    
    public int[] shuffleDeck(int players)
        {
            final int x = 7*players;
            int[] raffle = new int[x];
            for(int k=0;k<x;k++)
                raffle[k]=k;

            int count=0;
            int r1,r2,temp;
            while(count<1000)
            {
                r1 = (int) (Math.random() * (x-1));
                r2 = (int) (Math.random() * (x-1));
                temp = raffle[r1];
                raffle[r1] = raffle[r2];
                raffle[r2] = temp;
                count++;
            }
            return raffle;
        }
    public int[] shuffleCiv(int players)
    {
        int[] raffle = new int[players];
        for(int k=0;k<players;k++)
            raffle[k]=k;
        
        int count=0;
        int r1,r2,temp;
        while(count<10)
        {
            r1 = (int) (Math.random() * (players-1));
            r2 = (int) (Math.random() * (players-1));
            temp = raffle[r1];
            raffle[r1] = raffle[r2];
            raffle[r2] = temp;
            count++;
        }
        return raffle;
    }
    public String displayHand(ArrayList<Card> whatHand){
        String aggregateHand="";
        for(Card x: whatHand)
            aggregateHand+=x.getName()+"\n";
        return aggregateHand;
    }
 
} 