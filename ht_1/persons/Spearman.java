package OOP_HW.ht_1.persons;
/** Копейщик */
public class Spearman extends Melee_unit {
    

    public Spearman(String name){
        super(name, "Копейщик", 110, 5, 13, 1, 7, 70);
    }

/** Пронзает юнита копьем игнорируя броню */
    public void pierce(Dummy target){
        if (this.fury >= 60){
            this.fury -= 60;
            target.take_dmg(dmg);
        }
        else{
            victim();
        }
    }

/** Наносит себе урон и восстанавливает ярость */
    public void victim(){
        if (this.hp > 25){
            this.hp -= 24;
            this.fury = max_fury;
        }
        else if (this.hp > 5 && this.fury <= 20) {
            this.hp -= 5;
            this.fury += max_fury/2;
        }
        else{
            this.fury += 15;
        }
    }
}
