package Units;

import java.util.ArrayList;

public class Spearman extends Unit {

    public Spearman(String name, ArrayList<Unit> team,int x,int y){
            super(name, 30, 0.6f, 3, 4, 30, team,x,y);
        }
    
    
    public String toString() {
        return "Копейщик";
    }

    
    public void step() {
       System.out.println("spearman");
    }


    public String getInfo() { 
        return super.getInfo();
    }

}
