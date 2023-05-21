package Units;

import java.util.ArrayList;

public class Crossbowman extends Shoter{
    public Crossbowman(String name, ArrayList<Unit> team,int x,int y) {
        super(name, 20, 0.5f, 4, 2, 2, 50, 0.5f, 10, team,x, y);
    }

    public String toString() {
        return "Арбалетчик";
    }

    public void step() {
        System.out.println(getClass().getName());
    }

    
    public String getInfo() {
        return super.getInfo();
    }

}