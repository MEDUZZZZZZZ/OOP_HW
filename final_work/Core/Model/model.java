package OOP_HW.final_work.Core.Model;
import java.util.ArrayList;
import OOP_HW.final_work.Persons.*;

public class model {
    public ArrayList<Dummy> radiant, dire, all;
    private Army tmp = new Army();
    
    public model(){
        this.radiant = tmp.randomteamGen("Radiant", 10, 0, 1);
        this.dire = tmp.randomteamGen("Dire", 10, 3, 10);
        this.all = tmp.allArmyGen(radiant, dire);
    }


    public int is_finish(ArrayList<Dummy> allTeam, ArrayList<Dummy> radiant, ArrayList<Dummy> dire){ //значение возвращается в флаг
        int rad_count = 0;
        int dire_count = 0;
        for (Dummy person: allTeam){
            if (person.getCond().equals("Dead") && person.getarmyName().equals("Radiant")){
                rad_count +=1;
            }
            else if (person.getCond().equals("Dead") && person.getarmyName().equals("Dire")){
                dire_count +=1;
            }
        }
        if (rad_count == radiant.size()) {return 1;}
        else if (dire_count == dire.size()) {return 2;}
        else {return 0;}
    }  
}
