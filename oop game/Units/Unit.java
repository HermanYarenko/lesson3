package Units;

import java.util.ArrayList;

import Game.Cordiante;

public abstract class Unit implements GameInterface{
    protected static String name;
    protected float maxHp, currentHp, luck, armor;
    public int speed;
    protected int attack;
    protected ArrayList<Unit> team, enemy;
    protected Cordiante cordinate;
    
    
    

    Unit(String name, float maxHp, float luck, int speed, int attack, float armor, ArrayList<Unit> team, int x, int y){
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.luck = luck;
        this.speed =speed;
        this.attack = attack;
        this.armor = armor;
        this.team = team;
        this.cordinate = new Cordiante(x, y);
    }

   
    void attack(Unit target){
        target.getDmage(attack);
        //System.out.println(this.introduce() + " атакует " + target.introduce());
    }
    void await(){

    }
    void defend(){

    }

    boolean die(){
        if (currentHp <= 0) {
            return true;
        }else{
            return false;
        }
    }

    public void getDmage(float damage){
        this.currentHp -= damage;
        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
    }

    @Override
    public String getInfo() {
        return toString() + " " + name + " \u2665:" +
        currentHp + "/" + maxHp + " \u2659:" + speed + " \u2618:" + luck + " \u2694:" + attack;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (die()) {
            return;
        }
        Unit target = findNearUnit(enemy);
        if (target.cordinate.distance(this.cordinate) < 2) {
            attack(target);
        }else {
            move(target);
        }
    }


    public Unit findNearUnit(ArrayList<Unit> team){
        Unit nearUnit = null;
        float minDist = Float.MAX_VALUE;
        for (Unit unit : team) {
            float dist = unit.cordinate.distance(this.cordinate);
            if (minDist > dist) {
                nearUnit = unit;
                minDist = dist;
            }
        }
        return nearUnit;
    }

    @Override
    public String introduce() {
        return this + " " + this.name;
    }

    public int[] getCoords() {
        return new int[]{this.cordinate.y, cordinate.x};
    }

    public float getHp() {
        return currentHp;
    }
    protected void move(Unit target){
        int dx = target.cordinate.distanceXY(this.cordinate)[0];
        int dy = target.cordinate.distanceXY(this.cordinate)[1];
        if (Math.abs(dx) < Math.abs(dy)){
            moveY(dx, dy, true);
        }else {
            moveX(dx, dy, true);
        }
    }

    private void moveX(int dx, int dy, boolean flag){
        if (dx > 0) {
            if (isEmptyPosition(this.cordinate.x-1, this.cordinate.y)) {
                this.cordinate.x--;
            }else if(flag){
                moveY(dx,dy, false);
            }
        }else {
            if (isEmptyPosition(this.cordinate.x+1, this.cordinate.y)) {
                this.cordinate.x++;
            }else if(flag){
                moveY(dx,dy, false);
            }
        }
    }
    private void moveY(int dx, int dy, boolean flag){
        if (dy > 0) {
            if (isEmptyPosition(this.cordinate.x, this.cordinate.y-1)) {
                this.cordinate.y--;
            }else if(flag){
                moveX(dx,dy, false);
            }
        }else {
            if (isEmptyPosition(this.cordinate.x, this.cordinate.y+1)) {
                this.cordinate.y++;
            }else if(flag){
                moveX(dx,dy, false);
            }
    }
    }



    protected boolean isEmptyPosition(int x, int y){
        for (Unit unit: team) {
            if (unit.cordinate.x == x && unit.cordinate.y == y) {
                if (!unit.die()) {
                    return false;
                }
            }
        }
        return true;
    }
}




