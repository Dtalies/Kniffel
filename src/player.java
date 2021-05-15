public class Player {
    String name;
    boolean turn = false;
    DiceCup diceCup = new DiceCup(5);
    ScoreSheet scoreSheet = new ScoreSheet();

    //Gibt den Namen des Spielers aus
    public String getName(){
        return this.name;
    }

    //Deffiniert den Namen des Spielers
    public void setName(String name){
        this.name = name;
    }

    //Gibt zurück ob eine Person am zug ist
    public boolean getTurn(){
        return this.turn;
    }
    //Setzt die Variable Turn auf den Gewünschten wert
    public void setTurn(boolean turn){
        this.turn = turn;
    }
}