public class Player {
    String name;
    boolean turn = false;
    DiceCup diceCup = new DiceCup(5);
    ScoreSheet scoresheet = new ScoreSheet();

    public String getName(){
        return this.name;
    }

    public void setName(String pName){
        this.name = pName;
    }

    public boolean getTurn(){
        return this.turn;
    }

    public void setTurn(boolean pTurn){
        this.turn = pTurn;
    }
}