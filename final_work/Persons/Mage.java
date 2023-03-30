package OOP_HW.final_work.Persons;

public class Mage extends wizzardUnit{
    

    public Mage(String name, int x, int y){
        super(name, 17, 9, 12, 25, -5, -5, 60, x , y);
    }

    @Override 
    public String getProf(){
        String status = "Чародей";
        return status;
    }
}
