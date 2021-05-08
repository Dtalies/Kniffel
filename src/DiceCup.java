public class DiceCup {

    //Anzahl an benutzten WÜrfeln
    private Integer diceCount = 5;

    //Array aus Würfeln
    public Dice[] dices = new Dice[diceCount];

    public int timesrolled = 0;


    public DiceCup(int pDiceCount){

        this.diceCount = pDiceCount;
    
        for(int i = 0; i<this.diceCount ; i++){

            this.dices[i] = new Dice();
        }
    }


    public Dice[] getCup(){

        return this.dices;
    }
    
    public void shake(){

        for(int i = 0; i<this.diceCount ; i++){

            if(dices[i].getRoll() == true){

                dices[i].rolling();

            }


    }

}
public void mock()
{
    dices[0].setCount(1);
    dices[1].setCount(1);
    dices[2].setCount(1);
    dices[3].setCount(1);
    dices[4].setCount(1);

}

public void setTimesRolled()
{
    this.timesrolled = timesrolled+1;
}
public int getTimesRolled()
{
    return timesrolled;
}
public void clearTimesRolled()
{
    this.timesrolled = 0;
}
}


