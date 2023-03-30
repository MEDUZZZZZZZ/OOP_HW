package OOP_HW.final_work.Persons;

public class Spearman extends meleeUnit {
    

    public Spearman(String name, int x, int y){
        super(name, 5, 4, 5, 65, 7, 9, x , y);
    }


    @Override
    public String getProf(){
        String status = "Копейщик";
        return status;
    }
}
