package OOP_HW.final_work.Persons;
import java.util.ArrayList;

public abstract class Dummy implements gameinterface {
    protected String name, armyName, cond;
    protected int atk, def, speed, maxHP, hp, minDMG, maxDMG;
    protected Point2D cords;
    
    
    protected Dummy(String name, int atk, int speed, int def, int maxHP, int minDMG, int maxDMG, int x, int y) {
        this.name = name;
        this.cond = "Alive";
        this.atk = atk;
        this.speed = speed;
        this.def = def;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.minDMG = minDMG;
        this.maxDMG = maxDMG;
        this.armyName = "Without";
        cords = new Point2D(x, y);
    }


    public void setName(String name){
        this.name = name;
    }

    
    public String getName(){
        return this.name;
    }


    public Point2D getCords(){
        return this.cords;
    }

    public int getSpeed(){
        return this.speed;
    }


    public int getHp(){
        return this.hp;
    }


    public int getAtk(){
        return this.atk;
    }

    public String getCond(){
        return this.cond;
    }

    public void setCond(String newCond){
        this.cond = newCond;
    }


    public void setarmyName(String armyName){
        this.armyName = armyName;
    }

    public String getarmyName(){
        return this.armyName;
    }
    

    protected Dummy closestUnit(ArrayList<Dummy> enemyList){
        double min = Double.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < enemyList.size(); i++) {
            if (min > cords.findDist(enemyList.get(i).cords) && !enemyList.get(i).cond.equals("Dead") ){
                idx = i;
                min = cords.findDist(enemyList.get(i).cords);
            }
        }
        return enemyList.get(idx);
    }

    protected void interaction(int dmg){
        this.hp -= dmg;
        if (this.hp<=0){
            this.hp = 0;
            this.cond = "Dead";
        }
        if (this.hp > this.maxHP){
            this.hp = this.maxHP;
        }
    }

    protected int dmgFormula(Dummy enemy){
        if (enemy.def > this.atk) {return this.minDMG;}
        else if (enemy.def < this.atk) {return this.maxDMG;}
        else {return Math.round((this.minDMG + this.maxDMG)/2);}
    }

    @Override
    public String getProf(){
        String basename = "Человек";
        return basename;
    }


    @Override 
    public String getInfo(){
        return String.format("%s %s %s %d %s %d %s %d %s %d ", name, cond, "HP:", hp, "A:", atk, "D:", def, "DMG:", maxDMG);
    }


    @Override
    public int step(ArrayList<Dummy> allies, ArrayList<Dummy> enemy){
        return 0;
    }
}
