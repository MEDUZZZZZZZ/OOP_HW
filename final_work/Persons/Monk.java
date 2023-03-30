package OOP_HW.final_work.Persons;

public class Monk extends wizzardUnit {
    
    public Monk(String name, int x, int y){
        super(name, 12, 5, 7, 30, -4, -4, 50, x, y);
    }

    @Override 
    public String getProf(){
        String status = "Монах";
        return status;
    }
}
