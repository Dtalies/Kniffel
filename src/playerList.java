import java.util.*;

public class playerList {
    
    List<player> players = new ArrayList<>();

    public void add(player p)
    {
        players.add(p);
    }

    public String getContent()
    {
        String result ="";
        for(int i = 0; i<players.size() ; i++)
        {
            result += players.get(i).getName();
        }
        return result;
    }
}


