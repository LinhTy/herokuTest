package pkg7wonders;


import java.util.ArrayList;

/*
 * Holds player information and the cards they hold
 */

public class Inventory
{
    private String civilization;
    private ArrayList<String> CardsPlayed = new ArrayList();
    private int military;
    private int VP;
    private int[] resources = new int[8];
    private int[] sciences = new int[3];
    private int leftPriceGather = 2;
    private int rightPriceGather = 2;
    private int priceCrafted = 2;

    public void Inventory()
    {
        civilization = "";
        military = 0;
        VP = 0;
        for(int k=0;k<7;k++)
            resources[k]=0;
        resources[7] = 3;
        for(int k=0;k<3;k++)
            sciences[k]=0;
    }

    public void Inventroy(String civ, ArrayList<String> CardP, int mil, int v, int[] r, int[] s, int LPG, int RPG, int PC)
    {
        civilization = civ;
        CardsPlayed = CardP;
        military = mil;
        VP = v;
        resources = r;//assume r is made correctly
        sciences = s;
        leftPriceGather = LPG;
        rightPriceGather = RPG;
        priceCrafted = PC;
    }

    public void readEffects(String effect)
    {
        //take effect and call functions
        int x=0;
        int y=0;
        int length=effect.length();
        if(length==3)
        {
            x=(int)(effect.charAt(2))-48;
        }
        if(length==4)
        {
            y=(int)(effect.charAt(3))-48;
        }
        switch(effect.substring(0,2))
        {
            case ("VP"):
                addVP(x);
                break;
            case ("RE"):
                addResource(x,y);
                break;
            case ("MT"):
                addMilitary(x);
                break;
            case ("SC"):
                addScience(x);
                break;
            case ("LG"):
                discountLeftGather();
                break;
            case ("RG"):
                discountRightGather();
                break;
            case ("PC"):
                discountCraft();
                break;
            default:
                System.out.println("This Player is Cheating");
        }
    }

    public void setCiv(String civ)
    {
        civilization = civ;
    }

    public void addResource(int x,int y)
    {
        resources[x] += y;
    }
    public void addResource(int x)
    {
        resources[x] += 1;
    }

    public void addScience(int x)
    {
        sciences[x] += 1;
    }

    public void addVP(int y)
    {
        VP+=y;
    }

    public void addMilitary(int y)
    {
        military+=y;
    }

    public void playField(String y)
    {
        CardsPlayed.add(y);
        //System.out.println(player+" has played the card "+y);
    }

    public void discountLeftGather()
    {
        leftPriceGather = 1;
    }

    public void discountRightGather()
    {
        rightPriceGather = 1;
    }

    public void discountCraft()
    {
        priceCrafted = 1;
    }


//get methods
    public String getCiv()
    {
        return civilization;
    }

    public void printCardsPlayed()
    {
        if(CardsPlayed.isEmpty())
        {
            System.out.println("No Cards Played");
        }
        else
        {
            for (String Card : CardsPlayed) {
                System.out.println(Card);
            }
        }
    }

    public int getMilitary()
    {
        return military; 
    }
    
    public int getVP()
    {
        return VP;
    }
    
    public int getResources(int x)
    {
        return resources[x];
    }
    public int getScience(int x)
    {
        return sciences[x];
    }
    public int getScienceVP()
    {
        int points=0;
        for(int k=0;k<3;k++)
        {
            points += (int)Math.pow(sciences[k],2);
        }
        
        if(sciences[0] <= sciences[1] && sciences[0] <= sciences[2])
            points += sciences[0] * 7;
        else if(sciences[1] <= sciences[0] && sciences[1] <= sciences[2])
            points += sciences[1] * 7;
        else
        {
            points += sciences[2] * 7;
        }
        return points;
    }
    
    public int getLeftGather()
    {
        return leftPriceGather;
    }
    public int getRightGather()
    {
        return rightPriceGather;
    }
    public int getCraft()
    {
        return priceCrafted;
    }
}


