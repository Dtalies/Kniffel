import java.util.Arrays;

import jdk.javadoc.internal.doclets.formats.html.resources.standard_zh_CN;

public class sheet {

    
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
    
}
