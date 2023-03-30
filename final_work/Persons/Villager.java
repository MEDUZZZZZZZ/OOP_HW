package OOP_HW.final_work.Persons;
import java.util.ArrayList;
public class Villager extends Dummy {
    protected int income;


    public Villager(String name, int x, int y){
        super(name, 1, 3, 1, 10, 1, 1, x , y);
        this.income = 1;
    }

    public void giveAmmo(rangeUnit shooterAlly){
        if (shooterAlly.ammo == 0) {shooterAlly.ammo = 1;}
    }


    @Override
    public int step(ArrayList<Dummy> allies, ArrayList<Dummy> enemy){
        if (!this.cond.equals("Dead")){
            if (this.cond.equals("Busy")){
                this.cond = "Alive";
            }
            return 1;
        }
        else{return 0;}
    }

    @Override
    public String getProf(){
        String status = "Фермер";
        return status;
    }
}
