package OOP_HW.final_work.Persons;
import java.util.ArrayList;

public abstract class wizzardUnit extends Dummy {
    protected int maxMana, mana;

    protected wizzardUnit(String name, int atk, int speed, int def, int maxHP, int minDMG, int maxDMG, int maxMana, int x, int y){
        super(name, atk, def, speed, maxHP, minDMG, maxDMG, x, y);
        this.maxMana = maxMana;
        this.mana = maxMana;
    }


    public void manaRegen(){ //продумать и добавить в степ
        this.mana = maxMana;
    }

    @Override
    public Dummy closestUnit(ArrayList<Dummy> allyList){
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < allyList.size(); i++) { 
            if (max < allyList.get(i).maxHP - allyList.get(i).hp && !allyList.get(i).cond.equals("Dead")){
                idx = i;
                max = allyList.get(i).maxHP - allyList.get(i).hp;
            }
        }
        return allyList.get(idx);
    }

    @Override
    public int step(ArrayList<Dummy> allies, ArrayList<Dummy> enemy){
        if (!this.cond.equals("Dead")){
            if (this.mana > 30){
                Dummy target = closestUnit(allies);
                target.interaction(maxDMG);
                this.mana -= 30;
            }
            else{
                manaRegen();
            }
            return 1;
        }
        else{
            return 0;
        }

    }

    
    @Override
    public String getInfo(){
        return String.format("%s %s %d", super.getInfo(), "MP:", mana);
    }
}
