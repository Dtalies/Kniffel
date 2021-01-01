public class DiceCup {

    //Anzahl an benutzten WÜrfeln
    private Integer diceCount = 5;

    //Array aus Würfeln
    private Dice[] dices = new Dice[diceCount];


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

            if(dices[i].getRoll()){

                dices[i].rolling();

            }


    }

}
}


