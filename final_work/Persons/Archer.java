package OOP_HW.final_work.Persons;

public class Archer extends rangeUnit {
    

    public Archer(String name, int x, int y){
        super(name, 8, 4, 3, 35, 5, 7, 12, x, y);
    }
    

    @Override
    public String getProf(){
        String status = "Лучник";
        return status;
    } 
}
