package OOP_HW.ht_1.persons;

public abstract class Wizzard_unit extends Dummy {
    protected int mana, max_mana, heal_pow;
    

    protected Wizzard_unit(String name, String prof, int hp, int speed, int dmg, int heal_income, int armor, int max_mana, int heal_pow){
        super(name, prof, hp, speed, dmg, heal_income, armor);
        this.max_mana = max_mana;
        this.mana = max_mana;
        this.heal_pow = heal_pow;
    }

    /**Лечит юнита на велечину своего врачевания */
    public void heal(Dummy target){
        if (this.mana > 50){
            this.mana -= 50;
            int real_heal = heal_pow + this.heal_income;
            target.get_heal(real_heal);
        }
        else{
            meditate();
        }
    }


    public String getInfo(){
        String info = String.format("%s Мана: %d, Лимит маны: %d, Врачевание %d", super.get_info(), this.mana, this.max_mana, this.heal_pow);
        return info;
    }

    /**Восстанавливает себе ману в процессе медитации */
    public void meditate(){
        if (this.mana + 20 <= max_mana){
            this.mana += 20;
        }
        else {
            this.mana = max_mana;
        }
    }

    /** Особый скил юнита */
    public abstract void miracle(Dummy target);
}
