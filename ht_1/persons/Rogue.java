package OOP_HW.ht_1.persons;
/** Разбойник */
public class Rogue extends Melee_unit {
    

    public Rogue(String name){
        super(name, "Разбойник", 90, 15, 14, -1, 3, 50);
    }

/** Наносит себе урон и восстанавливает ярость */
    public void victim(){
        if (this.hp > 20){
            this.hp -= 19;
            this.fury = max_fury;
        }
        else if (this.hp > 5 && this.fury <= 10) {
            this.hp -= 5;
            this.fury += max_fury/2;
        }
        else{
            this.fury += 10;
        }
    }

/** Уменьшает броню противника */
    public void undress(Dummy target){
        if (this.fury >= 30){
            this.fury -= 30;
            target.armor -= 2;
        }
        else{
            victim();
        }
    }
}
