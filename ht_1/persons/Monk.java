package OOP_HW.ht_1.persons;
/** Монах */
public class Monk extends Wizzard_unit {


    public Monk(String name){
        super(name, "Монах", 130, 1, 10, 0, 5, 100, 20);
    }
    
/** Воскрешает союзника или лечит его в двойном объеме */
    public void miracle(Dummy target){
        if (this.mana == max_mana){
            this.mana = 0;
            if (target.hp == 0){
                target.hp = 10;
            }
            else {
                int tmp = this.heal_pow;
                this.heal_pow *= 2;
                heal(target);
                this.heal_pow = tmp;
            }
        }
        else{
            meditate();
        }

    }
/** Увеличивает броню и хп союзнику */
    public void blessing(Dummy target){
        if (this.mana == 60){
            this.mana -= 60;
            target.armor += 2;
            target.max_hp += 10;
            target.hp += 10;
        }
        else{
            meditate();
        }
    }
}
