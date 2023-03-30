package OOP_HW.final_work.Persons;

public class Sniper extends rangeUnit {
    

    public Sniper(String name, int x, int y){
        super(name, 12, 9, 10, 25, 6, 8, 10, x, y);
    }

    
    @Override
    public String getProf(){
        String status = "Снайпер";
        return status;
    }

    
}
