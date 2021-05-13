public class ScoreSheet{
    private  int[] score=  {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

    private boolean set(int i,int value){
        if(score[i]== -1){
            score[i] = value;
            return true;
        }
        return false;
    }

    public int getlength(){
        return score.length;
    }
    
    public String getTitle(int i){
        String title = "";
        switch (i) {
            case 0: title = "Einer";            break;
            case 1: title = "Zweier";           break;
            case 2: title = "Dreier";           break;
            case 3: title = "Vierer";           break;
            case 4: title = "Fuenfer";          break;
            case 5: title = "Sechser";          break;
            case 6: title = "noBonus";          break;
            case 7: title = "Bonus";            break;
            case 8: title = "3er";              break;
            case 9: title = "4er";              break;
            case 10: title ="Fullhouse";        break;
            case 11: title ="Kleine Strasse";   break;
            case 12: title ="Grosse Strasse";   break;
            case 13: title ="Kniffel";          break;
            case 14: title ="Chance";           break;
            case 15: title ="Unten";            break;
            case 16: title ="Insgesamt";        break;
            default:                            break;     
        }
        return title;
    }

    public boolean setScore(int i, int value){
        boolean worked = false;
        switch (i) {
            case 0: //"Einer"
                worked = set(i, value); break;
            case 1: //"Zweier"
                worked = set(i, value); break;
            case 2: //"Dreier"
                worked = set(i, value); break;
            case 3: //"Vierer"
                worked = set(i, value); break;
            case 4: //"Fuenfer"
                worked = set(i, value); break;
            case 5: //"Sechser"
                worked = set(i, value); break;
            case 6: //"noBonus"
                worked = set(i, sumNoBonus()); break;
            case 7: //"Bonus"
                worked = set(i, bonusPoints()); break;
            case 8: //"3er"
                worked = set(i, value); break;
            case 9: //4er"
                worked = set(i, value); break;
            case 10: //"Fullhouse"
                worked = set(i, value); break;
            case 11: //"Kleine Strasse"
                worked = set(i, value); break;
            case 12: //"Grosse Strasse"
                worked = set(i, value); break;
            case 13: //"Kniffel"
                worked = set(i, value); break;
            case 14: //"Chance"
                worked = set(i, value); break;
            case 15: //"Unten"
                worked = set(i, sumUnten()); break;
            case 16: //"Insgesamt":
                worked = set(i, sumInsgesamt()); break;
            default: break;     
        }
        return worked;
    }

    public int getValue(String typ) {
        int value = 0;
        switch(typ) {
            case "Einer":           value =score[0];  break;
            case "Zweier":          value =score[1];  break;
            case "Dreier":          value =score[2];  break;
            case "Vierer":          value =score[3];  break;
            case "Fuenfer":         value =score[4];  break;
            case "Sechser":         value =score[5];  break;
            case "noBonus":         value =score[6];  break;
            case "Bonus":           value =score[7];  break;
            case "3er":             value =score[8];  break;
            case "4er":             value =score[9];  break;
            case "Fullhouse":       value =score[10]; break;
            case "Kleine Strasse":  value =score[11]; break;
            case "Grosse Strasse":  value =score[12]; break;
            case "Kniffel":         value =score[13]; break;
            case "Chance":          value =score[14]; break;
            case "Unten":           value =score[15]; break;
            case "Insgesamt":       value =score[16]; break;
            default:                value = -1;       break;
        }
        return value;
    }

    public int sumNoBonus(){
        int sumNoBonus = 0;
        for (int i = 0; i < 5; i++)   
            sumNoBonus += score[i];
        return sumNoBonus;
    }

    public int bonusPoints(){
        int sumTop = this.getValue("noBonus");
        if(sumTop >= 63){
            sumTop = sumTop + 35;
        }
        return sumTop;
    }

    public int sumUnten(){
        int sumUnten = 0;
        for (int i = 8; i < 15; i++){
            sumUnten += score[i];
        }
        return sumUnten;
    }

    public int sumInsgesamt() {
        return this.getValue("Unten")+this.getValue("Bonus");
    }
}