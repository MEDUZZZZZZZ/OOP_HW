package OOP_HW.ht_1.persons;
/** Лучник */
public class Archer extends Range_unit {
    

    public Archer(String name){
        super(name, "Лучник", 125, 10, 10, 2, 5, 110);
    }

/** Протирает глаза тем самым восстанавливая концентрацию */
    public void rub_eyes(){
        if (this.conc + 30 <= max_conc){
            this.conc += 30;
        }
        else{
            this.conc = max_conc;
        }
    }

/** Бросает грязью в противника и снижает его скорость навсегда */
    public void dirt_ball(Dummy target){
        if (this.conc >= 40){
            this.conc -= 40;
            if (target.speed > 3){
                target.speed -= 2;
            }
            else{
                target.speed = 1;
            }
        }
        else{
            rub_eyes();
        }
    }
}
