import java.util.Arrays;

import javax.lang.model.util.ElementScanner14;


public class sheet {

    public static   int[]  sort(DiceCup diceCup){
        
        int[] tempDices = new int[5];

        for(int i = 0; i<diceCup.dices.length ; i++){
            tempDices[i] = diceCup.dices[i].getCount();
        }
        Arrays.sort(tempDices);

        return tempDices;
    }
    public static int adding(int addnumber , DiceCup diceCup) 
    {
        
        int[] tempDices = new int[5];

        for(int i = 0; i<diceCup.dices.length ; i++){
            tempDices[i] = diceCup.dices[i].getCount();
        }
        Arrays.sort(tempDices);
        
        int sum = 0 ;

        for(int i = 0; i< tempDices.length ; i++)
        {

            if( tempDices[i] == addnumber)
            {

                sum += addnumber;
            }
        }
        return sum;
    }
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

    public static int sumNoBonus(int sumSixes , int sumFives , int sumFours, int sumThrees, int sumTwos, int sumOnes)
    {
        int sumNoBonus = 0;
        sumNoBonus = sumSixes + sumFives + sumFours + sumThrees + sumTwos + sumOnes ;
        return sumNoBonus;
    }
    public static int bonusPoints(int sumNoBonus)
    {
        int sumTop = 0;
        if(sumNoBonus >= 63)
        {
            sumTop = sumNoBonus + 35;
        }
        else{
            sumTop = sumNoBonus;
        }
        return sumTop;
    }

    public static boolean all(DiceCup diceCup)
    {
        int[] sorted = sheet.sort(diceCup);

        boolean all = false;
        for (int i=1; i < diceCup.dices.length; i++) 
        
        {
            if(sorted[i] == sorted[0])
            {
                all = true;
            }
            else{
                all = false;
            }

        }
        return all;
    }

    public static boolean fullHouse(DiceCup diceCup)
    {
        int[] sorted = sheet.sort(diceCup);

        boolean fullHouse = false;
        // for (int i=0; i < diceCup.dices.length; i++)

            if(sorted[0] == sorted[1] && sorted[0] == sorted[2] && sorted[3] == sorted[4])
            {
                fullHouse = true ;
            }
            else{
                if (sorted[0] == sorted[1] && sorted[2] == sorted[3] && sorted[2] == sorted[4])
                {
                    fullHouse = true;
                }
            }
             
        // }
        return fullHouse;
    }
    public static boolean shortstreet(DiceCup diceCup)
    {
        boolean shortstreet = false;
        int[] sorted = sheet.sort(diceCup);
        //for(int i=0; i < diceCup.dices.length; i++){

        if(sorted[0]+1== sorted[1] && sorted[1]+1 == sorted[2] && sorted[2]+1 == sorted[3] && sorted [3]+1== sorted[4])
        {
            shortstreet = true;
        }
        else
        {
            shortstreet = false;
        }
        if (sorted[1]+1== sorted[2] && sorted[2]+1 == sorted[3] && sorted[3]+1 == sorted[4]){
            shortstreet = true;
        }
        
    //}
    return shortstreet;
    }
    public static boolean longstreet
}
    

