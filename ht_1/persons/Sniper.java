package OOP_HW.ht_1.persons;

/** Снайпер */
public class Sniper extends Range_unit{ 


    public Sniper(String name){
       super(name, "Снайпер", 110, 9, 15, 1, 1, 150);
    }

    /** Протирает прицел тем самым восстанавливая концентрацию */
    public void rub_eyes(){
        if (this.conc + 25 <= max_conc){
            this.conc += 25;
        }
        else{
            this.conc = max_conc;
        }
    }

    /**Улучшает винтовку и увеличивает свой урон */
    public void upgrade_gun(){
        if (this.conc >= 60){
            this.conc -= 60;
            this.dmg += 8;
        }
        else{
            rub_eyes();
        }
    }

}
