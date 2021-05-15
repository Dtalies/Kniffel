public class DiceCup {
    //Anzahl an benutzten WÜrfeln
    private Integer diceCount = 5;
    //Array aus Würfeln
    public Dice[] dices = new Dice[diceCount];
    public int timesRolled = 0;

    public DiceCup(int diceCount){
        this.diceCount = diceCount;
        for(int i = 0; i<this.diceCount ; i++){
            this.dices[i] = new Dice();
        }
    }

    public Dice[] getCup(){
        return this.dices;
    }
    //Rollt alle Würfel im Würfelbecher
    public void shake(){
        for(int i = 0; i<this.diceCount ; i++){
            if(dices[i].getRoll()){
                dices[i].rolling();
            }
        }
    }
    //Kann den würfel auf Klare zahlen Combinationen setzten
    public void mock(){
        dices[0].setCount(1);
        dices[1].setCount(1);
        dices[2].setCount(1);
        dices[3].setCount(1);
        dices[4].setCount(1);
    }
    //Setzt die Würfel auf 0 zurück, damit die Würfel im Nächsten zug nicht erneut genutzt werden können
    public void clearDiceCup(){
        dices[0].setCount(0);
        dices[1].setCount(0);
        dices[2].setCount(0);
        dices[3].setCount(0);
        dices[4].setCount(0);
    }
    //Setzt die Anzahl der Würfen einen Höher
    public void setTimesRolled(){
        this.timesRolled = timesRolled+1;
    }
    //Gibt die anzahl der schon passierten Würfe an
    public int getTimesRolled(){
        return timesRolled;
    }
    //Setzt die Anzahl der Würfe zurück auf 0
    public void clearTimesRolled(){
        this.timesRolled = 0;
    }
}