package pkg7wonders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author o_ugw_000
 */
public class Card {
    private String cost;
    private String name;
    private int numberOfPlayers;
    private String description;
    private int age;
    private String effect;
    
    public Card()
    {
        cost="";
        name="";
        numberOfPlayers=0;
        description="";
        age=0;
        effect="";
    }
    
    public Card(String newCost, String newName, int newNumberOfPlayers, String newDescription, String newEffect)
    {
        cost=newCost;
        name=newName;
        numberOfPlayers=newNumberOfPlayers;
        description=newDescription;
        effect=newEffect;
    }
      
    public String getCost()
    {
        String copy = cost;
        return copy;
    }
    
    public String getName()
    {
        String copy=name;
        return copy;
    }
    
    public int getNumberOfPlayers()
    {
        int copy=numberOfPlayers;
        return copy;
    }
    
    public String getDescription()
    {
        String copy=description;
        return copy;
    }
    
    public int getAge()
    {
        int copy=age;
        return copy;
    }
    
    public String getEffect()
    {
        String copy=effect;
        return copy;
    }
    /*Don't modify the cost
    public void addCost(String cost)
    {
        if(this.cost==null)
        {
            this.cost=new ArrayList<String>();
        }
        this.cost.add(cost);
    }
    */
    public void setName(String newName)
    {
        name=newName;
    }
    
    public void setNumberOfPlayer(int newNumberOfPlayers)
    {
        numberOfPlayers=newNumberOfPlayers;
    }
    
    public void setDescription(String newDescription)
    {
        description=newDescription;
    }
    
    public void setAge(int newAge)
    {
        age=newAge;
    }
    
    public void setEffect(String newEffect)
    {
        effect=newEffect;
    }
    
    public String displayName()
    {
        String textName="Name: ";
        if(!(name==null || name.isEmpty()))
            return textName+=name+"\n";
        return textName+="None\n";
    }
    
    public String displayCost()
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
    
    public String displayNumberOfPlayers()
    {
        String numberOfPlayerText=Integer.toString(numberOfPlayers);
        return numberOfPlayerText+"\n";
    }
    
    public String displayAge()
    {
        String ageText=Integer.toString(age);
        return ageText+"\n";
    }
    
    public String displayDescription()
    {
        String descriptionText="Description: ";
        if(!description.equals(""))
            return descriptionText+=description+"\n";
        return descriptionText+="none\n";
    }
    
    public String displayEffect()
    {
        String effectText="Effect: ";
        if(!(effect==null || effect.isEmpty()))
            effectText+=effect+"\n";
        else
            effectText+="None";
        return effectText;
    }
    
    public String displayCard()
    {
        String text="";
        text+=displayName();
        text+=displayAge();
        text+=displayNumberOfPlayers();
        text+=displayCost();
        text+=displayDescription();
        text+=displayEffect();
        return text;
    }
}
