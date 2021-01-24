public class Kniffel{


    // ausführen des Würfels
public static void main(String[] args) {

    DiceCup diceCup = new DiceCup(5);

    diceCup.shake();

    for(int i= 0 ; i < 5 ; i++){

        System.out.println(diceCup.getCup()[i].getCount());
    }

    System.out.println(sheet.addOnes(diceCup));
}
       


}