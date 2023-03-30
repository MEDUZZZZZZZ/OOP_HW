package OOP_HW.final_work.Persons;
import java.util.ArrayList;


public abstract class rangeUnit extends Dummy{
    protected int  ammo;


    protected rangeUnit(String name, int atk, int speed, int def, int maxHP, int minDMG, int maxDMG, int ammo, int x, int y){
        super(name, atk, speed, def, maxHP, minDMG, maxDMG, x, y);
        this.ammo = ammo;
    }


    @Override
    public int step(ArrayList<Dummy> allies, ArrayList<Dummy> enemy){
        if (!this.cond.equals("Dead")){
            if (ammo > 0){
                Dummy target = closestUnit(enemy);
                target.interaction(dmgFormula(target));
                this.ammo -= 1;
            }
            for (Dummy allie : allies){
                if (allie.getProf().equals("Фермер") && (!allie.cond.equals("Dead") || !allie.cond.equals("Busy"))){
                    allie.cond = "Busy";
                    this.ammo += 1;
                    break; // можно и не делать
                }
            }
        return 1;
        }
        else {return 0;}
    }

    @Override
    public String getInfo(){
        return String.format("%s %s %d", super.getInfo(), "Ammo:", ammo);
    }
}
