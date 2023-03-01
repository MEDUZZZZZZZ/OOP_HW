package OOP_HW.ht_1.persons;
/** Юнит ближнего боя */
public abstract class Melee_unit extends Dummy {
    protected int fury, max_fury;


    protected Melee_unit(String name, String prof, int hp, int speed, int dmg, int heal_income, int armor, int max_fury){
        super(name, prof, hp, speed, dmg, heal_income, armor);
        this.max_fury = max_fury;
        this.fury = max_fury;
    }

/** Накопленная ярость переходит в урон */
    public void got_insane(){
        if (this.fury >= 50){
            this.fury -= 50;
            this.dmg += 5;
        }
        else {
            victim();
        }
        }


    public abstract void victim();
    
/** Возвращает информацию о юните */
    public String getInfo(){
        String info = String.format("%s Ярость: %d, Максимальная ярость: %d", super.get_info(), this.fury, this.max_fury);
        return info;
    }
}
