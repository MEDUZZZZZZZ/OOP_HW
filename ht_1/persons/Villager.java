package OOP_HW.ht_1.persons;
/** Деревенщина */
public class Villager extends Melee_unit {
    private int dogs;


    public Villager(String name, int dogs){
        super(name, "Деревенщина", 50, 1, 2, 5, 0, 30);
        this.dogs = dogs;
    }
/** Приносит собак в жертву, если собак не осталось копит силы */
    public void victim(){
        if (this.dogs > 1){
            this.dogs -= 1;
            this.fury += max_fury;
        }
        else if (this.dogs == 1) {
            this.dogs = 0;
            this.dmg += 7;
        }
        else{
            this.dmg += 2;
        }
    }

    /** Спускает собак, которые игнорируют броню, если собак не осталось, атакует сам*/
    public void let_the_dogs_out(Dummy target){
        if (this.dogs >= 1 && this.fury == this.max_fury){
            this.fury = 0;
            int damage = dogs * 2;
            target.take_dmg(damage);
        }
        else if (this.dogs > 1 && this.fury < this.max_fury){
            victim();
        }
        else{
            attack(target);
        }
    }


    public String getInfo(){
        String info = String.format("%s, Количество собак: %d", super.getInfo(), dogs);
        return info;
    }
}
