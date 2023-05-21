package Game;

public class Cordiante {
    public int x, y;

    public Cordiante(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    public float distance(Cordiante coordinate){
        float dx = coordinate.x - this.x;
        float dy = coordinate.y - this.y;
        return (float) Math.sqrt(dx*dx+dy*dy);
    }
    public  int[] distanceXY(Cordiante cordinate){
        int[] result = new int[2];
        result[0] = cordinate.x - this.x;
        result[1] = cordinate.y - this.y;
        return result;
    }
}
