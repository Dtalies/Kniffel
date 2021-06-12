import java.util.*;

public class PlayerList {    
    public List<Player> players = new ArrayList<>();

        //fügt Spieler Hinzu
    public void add(Player player){
        players.add(player);
    }
    //Gibt die Namen der Spieler Zurück
    public String getContent(){
        String result ="";
        for(int i = 0; i<players.size() ; i++){
            result += players.get(i).getName();
        }
        return result;
    }
    //Gibt die Länge des Arrays zurück
    public int getSize(){
        return players.size();
    }
}


