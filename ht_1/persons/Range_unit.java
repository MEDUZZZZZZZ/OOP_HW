package OOP_HW.ht_1.persons;

/** Дальнобойный юнит */
public abstract class Range_unit extends Dummy {
    protected int conc, max_conc;

    protected Range_unit(String name, String prof, int hp, int speed, int dmg, int heal_income, int armor, int max_conc){
        super(name, prof, hp, speed, dmg, heal_income, armor);
        this.max_conc = max_conc;
        this.conc = max_conc;
    }

/** Собирает волю в кулак и если хватает концентрации совершает меткий выстрел в голову */
    public void head_shot(Dummy target){
        if (conc == max_conc){
            this.conc = 0;
            int hit = this.dmg * Dummy.cube.nextInt(2, 4);
            target.take_dmg(hit);
        }
        else{
            attack(target);
            this.conc += 10;
        }
    }

/** Выводит информацию о бойце дальнего боя */
    public String getInfo(){
        String info = String.format("%s Концентрация: %d, Максимальная концентрация: %d", super.get_info(), this.conc, this.max_conc);
        return info;
    }


    public abstract void rub_eyes();

}
