import java.util.*;

public class PlayerList {    
    List<Player> players = new ArrayList<>();

    public void add(Player player){
        players.add(player);
    }

    public String getContent(){
        String result ="";
        for(int i = 0; i<players.size() ; i++){
            result += players.get(i).getName();
        }
        return result;
    }

    public int getSize(){
        return players.size();
    }
}


