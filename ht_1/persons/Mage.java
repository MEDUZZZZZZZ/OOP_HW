package OOP_HW.ht_1.persons;
/** Маг */
public class Mage extends Wizzard_unit {


    public Mage(String name){
        super(name, "Волшебник", 100, 8, 11, 0, 2, 90, 11);
    }
    
//* Расходует всю ману и призывает скелет погибшего война или удваивает силу одного своего юнита*/
    public void miracle(Dummy target){
        if (this.mana == max_mana){
            this.mana = 0;
            if (target.hp == 0){
                target.hp = 1;
                target.max_hp = 1;
                target.dmg += 10;
            }
            else {
                target.dmg *= 2;
                target.armor *= 2;
            }
        }
        else{
            meditate();
        }
    }

    //* Снижает атаку выбранного вражеского юнита, если не хватает маны атакует */
    public void curse(Dummy target){
        if (this.mana == 50){
            this.mana -= 50;
            if (target.dmg > 3){
                target.dmg -= 3;
            }
            else{
                target.dmg = 1;
            }
        }
        else{
            attack(target);
        }
    }
}
