import java.util.Arrays;

public class Sheet {
    public static int[] sort(DiceCup diceCup){        
        int[] tempDices = new int[5];
        for(int i = 0; i<diceCup.dices.length ; i++){
            tempDices[i] = diceCup.dices[i].getCount();
        }
        Arrays.sort(tempDices);
        return tempDices;
    }

    public static int adding(int addnumber , DiceCup diceCup){        
        int[] tempDices = new int[5];
        for(int i = 0; i<diceCup.dices.length ; i++){
            tempDices[i] = diceCup.dices[i].getCount();
        }
        Arrays.sort(tempDices);        
        int sum = 0 ;
        for(int i = 0; i< tempDices.length ; i++){
            if( tempDices[i] == addnumber){
                sum += addnumber;
            }
        }
        return sum;
    }

    //TODO: Die nächsten Funktionen können durch eine Funktion mittels Switch ersetzt werden.

    public static int addOnes(DiceCup diceCup){
        int sumOnes = 0;
        sumOnes = adding(1 ,diceCup);
        return sumOnes;
    }

    public static int addTwos(DiceCup diceCup){
        int sumTwos = 0;
        sumTwos = adding(2 ,diceCup);
        return sumTwos;
    }

    public static int addThrees(DiceCup diceCup){
        int sumThrees = 0;
        sumThrees = adding(3 ,diceCup);
        return sumThrees;
    }

    public static int addFours(DiceCup diceCup){
        int sumFours = 0;
        sumFours = adding(4 ,diceCup);
        return sumFours;
    }

    public static int addFives(DiceCup diceCup){
        int sumFives = 0;
        sumFives = adding(5 ,diceCup);
        return sumFives;
    }

    public static int addSixes(DiceCup diceCup){
        int sumSixes = 0;
        sumSixes = adding(6 ,diceCup);
        return sumSixes;
    }

    public static int kniffel(DiceCup diceCup){
        int[] sorted = Sheet.sort(diceCup);
        int kniffel = 0;
        for (int i=1; i < diceCup.dices.length; i++){
            if(sorted[i] == sorted[0]){
                kniffel = 50;
            } else {
                kniffel = 0;
            }
        }
        return kniffel;
    }

    public static int fullHouse(DiceCup diceCup){
        int[] sorted = Sheet.sort(diceCup);
        int fullHouse = 0;
        if(sorted[0] == sorted[1] && sorted[0] == sorted[2] && sorted[3] == sorted[4]){
            fullHouse = 25 ;
        }
        if (sorted[0] == sorted[1] && sorted[2] == sorted[3] && sorted[2] == sorted[4]){
            fullHouse = 25;
        }
        return fullHouse;
    }

    public static int shortStreet(DiceCup diceCup){
        int shortStreet = 0;
        int[] sorted = Sheet.sort(diceCup);        
        if(sorted[0]+1== sorted[1] && sorted[1]+1 == sorted[2] && sorted[2]+1 == sorted[3]){
            shortStreet = 30;
        }
        if (sorted[1]+1== sorted[2] && sorted[2]+1 == sorted[3] && sorted[3]+1 == sorted[4]){
            shortStreet = 30;
        }
        return shortStreet;
    }

    public static int longStreet(DiceCup diceCup){
        int longStreet = 0;
        int[] sorted = Sheet.sort(diceCup);        
        if(sorted[0]+1== sorted[1] && sorted[1]+1 == sorted[2] && sorted[2]+1 == sorted[3] && sorted [3]+1== sorted[4]){
            longStreet = 40;
        }
        return longStreet;
    }

    public static int chance(DiceCup diceCup){        
        return diceCup.dices[0].getCount()+ diceCup.dices[1].getCount()+ diceCup.dices[2].getCount()+ diceCup.dices[3].getCount()+ diceCup.dices[4].getCount();
    }

    public static int rowOfThree(DiceCup diceCup){
        int rowOfThree = 0;
        int[] sorted =Sheet.sort(diceCup);
        if(sorted[0] ==sorted[1] && sorted[0] == sorted[2]) rowOfThree = sorted[0]+sorted[1]+sorted[2];
        if(sorted[1] ==sorted[2] && sorted[1] == sorted[3]) rowOfThree = sorted[1]+sorted[2]+sorted[3];
        if(sorted[2] ==sorted[3] && sorted[2] == sorted[4]) rowOfThree = sorted[2]+sorted[3]+sorted[4];
        return rowOfThree;
    }

    public static int rowOfFour(DiceCup diceCup){
        int rowOfFour = 0;
        int[] sorted = Sheet.sort(diceCup);
        if(sorted[0] ==sorted[1] && sorted[0] == sorted[2] && sorted[0] == sorted[3]) rowOfFour = sorted[0]+sorted[1]+sorted[2]+sorted[3];
        if(sorted[1] ==sorted[2] && sorted[1] == sorted[3] && sorted[1] == sorted[4]) rowOfFour = sorted[1]+sorted[2]+sorted[3]+sorted[4];
        return rowOfFour;
    }
}