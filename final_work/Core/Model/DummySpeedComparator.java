package OOP_HW.final_work.Core.Model;
import java.util.Comparator;
import OOP_HW.final_work.Persons.*;


public class DummySpeedComparator implements Comparator<Dummy>{
    
    
    @Override
    public int compare(Dummy hero_1, Dummy hero_2){
        if (hero_1.getSpeed() == hero_2.getSpeed()){
            return hero_2.getAtk() - hero_1.getAtk();
        }
        else{
            return hero_2.getSpeed() - hero_1.getSpeed();
        }
    }
    
}
