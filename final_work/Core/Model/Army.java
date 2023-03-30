package OOP_HW.final_work.Core.Model;
import OOP_HW.final_work.Persons.*;
import java.util.Random;
import java.util.ArrayList;


public class Army {
    private String[] nickname = {"Arthas", "Anduin", "Fenris", "Kilrogg", "Khadgar", "Ner’zhul", "Grommash", "Durotan",
                                 "Tyrande", "Rexxar", "Gul’dan", "Malfurion", "Jaina", "Sylvanas", "Garrosh", "Vol’jin",
                                 "Thrall", "Illidan", "Chen", "Bolvar", "Katrana", "Shaohao", "Maraad", "Akama", "Hakkar",
                                 "Velen", " Archimonde", "Malygos", "Nozdormu", "Muradin", "Magni", "Garr", "Valeera",
                                 "Alleria", "Maiev", "Mordent", " Varo'then", "Cenarius", "Malorne", "Niuzao", "Y'shaarj",
                                 "Ragnaros", "C'thun", "Yogg-Saron", "N'Zoth", "Neptulon", "Sargeras", "Eonar", "Freya"};
    
    public Army(){
    }



    public String genName(){
        Random cube = new Random();
        String res = nickname[cube.nextInt(0, nickname.length)];
        return res;
    }

    public ArrayList<Dummy> randomteamGen(String armyTitle, int count, int add, int x){
        ArrayList<Dummy> result = new ArrayList<Dummy>();
        Random cube = new Random();
        for (int i = 1; i <= count; i++){
            int facet = cube.nextInt(0, 4);
            result.add(chooserDummy(armyTitle, facet, add, x, i));
        }
        return result;
    }


    public ArrayList<Dummy> allArmyGen(ArrayList<Dummy> radiant, ArrayList<Dummy> dire){
        ArrayList<Dummy> allArmy = new ArrayList<Dummy>();
        allArmy.addAll(radiant);
        allArmy.addAll(dire);
        allArmy.sort(new DummySpeedComparator());
        return allArmy;
    }


    private Dummy chooserDummy(String armyTitle, int classId, int add, int x, int y){
        Dummy rookie = null;
        String name = genName();
        switch (classId + add){
            case 0:
                rookie = new Rogue(name, x, y); // придумать что с координами
                break;
            case 1:
                rookie = new Sniper(name, x, y);
                break;
            case 2:
                rookie = new Mage(name, x, y);
                break;
            case 3:
                rookie = new Villager(name, x, y);
                break;
            case 4:
                rookie = new Monk(name, x, y);
                break;
            case 5:
                rookie = new Spearman(name, x, y);
                break;
            case 6:
                rookie = new Archer(name, x, y);
                break;
        } 
        rookie.setarmyName(armyTitle);
        return rookie;    
    }


    public int is_finish(ArrayList<Dummy> team){ //значение возвращается в флаг
        int count = 1;
        for (Dummy person: team){
            if (person.getCond().equals("Dead")){
                count +=1 ;
            }
        }
        if (count == team.size()){
            return 0;
        }
        else{
            return 1;
        }
    }
}
