package OOP_HW.ht_1.persons;
import java.util.Random;


public abstract class Dummy{
    protected String name, prof;
    protected int speed, dmg, armor, hp, max_hp, heal_income;
    protected static Random cube;

    
    protected Dummy(String name, String prof, int hp, int speed, int dmg, int heal_income, int armor) {
        this.name = name;
        this.prof = prof;
        this.hp = hp;
        this.max_hp = hp;
        this.speed = speed;
        this.heal_income = heal_income;
        this.armor = armor;
        this.dmg = dmg;
    }


    public String get_info() {
       String info = String.format("Имя: %s, Класс: %s, Здоровье: %d, Скорость: %d, Урон: %d, Броня: %d, Получаемое исцеление: %d", name, prof, hp, speed, dmg, heal_income, armor);
       return info;
    }


    public void attack(Dummy targetDummy) {
        int hit = Dummy.cube.nextInt(this.dmg-2, this.dmg + 2);
        if (hit > targetDummy.armor){
            int damage = hit - targetDummy.armor;
            targetDummy.take_dmg(damage);
        }
        else{
            System.out.printf("Броня %s не пробита", targetDummy.name);
        }
    }    

    public void take_dmg(int damage) {
        if (this.hp > damage) {
            this.hp -= damage;
        }
        else {
            this.hp = 0;
            System.out.printf("%s умер", this.name); //временно
        }
    }

    public void get_heal(int heal) {
        if (heal + this.hp <= max_hp) {
            this.hp += heal;
        }
        else {
            this.hp = max_hp;
        }
    }

}
