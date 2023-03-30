package OOP_HW.final_work.Persons;

public class Rogue extends meleeUnit {
    

public Rogue(String name, int x, int y){
    super(name, 8, 6, 3, 60, 8, 10, x, y);
}

@Override
    public String getProf(){
        String status = "Разбойник";
        return status;
    }
}
