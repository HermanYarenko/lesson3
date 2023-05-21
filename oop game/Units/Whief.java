package Units;

import java.util.ArrayList;

public class Whief extends Unit {

   public Whief(String name, ArrayList<Unit> team,int x,int y) {
        super(name, 20, 0.8f, 3, 2, 10, team,x,y);
    }

    @Override
    public String toString() {
        return "Разбойник";
    }

    void dodge() {

    }

    void stealth() {

    }

    public void step() {
        
    }

    
    public String getInfo() {
        return super.getInfo();
    }
}