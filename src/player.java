public class Player {
    String name;
    boolean turn = false;
    DiceCup diceCup = new DiceCup(5);
    ScoreSheet scoreSheet = new ScoreSheet();

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getTurn(){
        return this.turn;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }
}