import java.util.Random;

public class Dice {
    private boolean roll;
    private Integer count;
    private Random r = new Random();

    //Konstruktor des Würfels
     public Dice(){
         this.roll= true;
         this.count = 0;
     }

     // Rückgaben der Augenzahl des Würfels
     public int getCount(){
        return this.count;
     }

     public void setCount(int count){
          this.count = count;
     }

     // Rückgabe ob der würfel gewürfelt wird
     public boolean getRoll(){
        return this.roll;
     }

     // Update ob der Wüfel gewürfelt werden oll
     public void setRoll(boolean roll){
        this.roll = roll;
     }

    public void rolling(){            
        // generate random numbers within 1 to 6 
        this.count = r.nextInt(6) + 1;     
    }
}