import java.util.Arrays;

public class Sheet {

    //Erzeugt ein Temporäres Array , welches Sortiert wird , damit andere Methoden einfacher mit diesem Arbeiten können
    public static int[] sort(DiceCup diceCup){        
        int[] tempDices = new int[5];
        for(int i = 0; i<diceCup.dices.length ; i++){
            tempDices[i] = diceCup.dices[i].getCount();
        }
        Arrays.sort(tempDices);
        return tempDices;
    }
    //Methode zur Addierung von gleichen Zahlen welche gewürfelt wurden und gibt die Summe zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
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
    //Prüft ob das gesammte Temporäre Array aus gleichen Zahlen besteht und gibt den wert 50 zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
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
    //Prüft auf die verschiedenen Combinationen für ein FullHouse und gibt den Wert 25 zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
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
    //Prüft auf die verschiedenen Combinationen für eine Kleine Straße und gibt den wert 30 zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
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
    //Prüft auf die verschiedenen Combinationen für eine Große Straße und gibt den wert 40 zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
    public static int longStreet(DiceCup diceCup){
        int longStreet = 0;
        int[] sorted = Sheet.sort(diceCup);        
        if(sorted[0]+1== sorted[1] && sorted[1]+1 == sorted[2] && sorted[2]+1 == sorted[3] && sorted [3]+1== sorted[4]){
            longStreet = 40;
        }
        return longStreet;
    }
        //Addiert das gesammte Array zusammen
    public static int chance(DiceCup diceCup){        
        return diceCup.dices[0].getCount()+ diceCup.dices[1].getCount()+ diceCup.dices[2].getCount()+ diceCup.dices[3].getCount()+ diceCup.dices[4].getCount();
    }
    //Prüft auf die verschiedenen Combinationen für eine einen 3er Pash und addiert den 3er Pash zusammen und gibt diesen Wert zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
    public static int rowOfThree(DiceCup diceCup){
        int rowOfThree = 0;
        int[] sorted =Sheet.sort(diceCup);
        if(sorted[0] ==sorted[1] && sorted[0] == sorted[2]) rowOfThree = sorted[0]+sorted[1]+sorted[2];
        if(sorted[1] ==sorted[2] && sorted[1] == sorted[3]) rowOfThree = sorted[1]+sorted[2]+sorted[3];
        if(sorted[2] ==sorted[3] && sorted[2] == sorted[4]) rowOfThree = sorted[2]+sorted[3]+sorted[4];
        return rowOfThree;
    }
        //Prüft auf die verschiedenen Combinationen für eine 4er Pash und addiert den 4er Pash zusammen und gibt diesen Wert zurück(Wenn es nicht zutrifft wird 0 zurück gegeben(streichen))
    public static int rowOfFour(DiceCup diceCup){
        int rowOfFour = 0;
        int[] sorted = Sheet.sort(diceCup);
        if(sorted[0] ==sorted[1] && sorted[0] == sorted[2] && sorted[0] == sorted[3]) rowOfFour = sorted[0]+sorted[1]+sorted[2]+sorted[3];
        if(sorted[1] ==sorted[2] && sorted[1] == sorted[3] && sorted[1] == sorted[4]) rowOfFour = sorted[1]+sorted[2]+sorted[3]+sorted[4];
        return rowOfFour;
    }
}
