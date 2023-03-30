package OOP_HW.final_work.Core.App;
import java.util.ArrayList;
import java.util.Scanner;

import OOP_HW.final_work.Core.Model.*;
import OOP_HW.final_work.Core.ViewC.*;
import OOP_HW.final_work.Persons.*;

public class App {
    public static void startButton(){
        model game = new model();
        ArrayList<Dummy> radiant = game.radiant;
        ArrayList<Dummy> dire = game.dire;
        ArrayList<Dummy> allTeam = game.all;
        View.showInfo(radiant);
        View.showInfo(dire);
        View.startGame();

        int flag = 0;
        Scanner button_new = new Scanner(System.in);
        while (flag == 0){
            View.view(allTeam, radiant, dire);
            button_new.nextLine();
            for (Dummy hero: allTeam){
                if (radiant.contains(hero)){
                    hero.step(radiant, dire);
                    flag = game.is_finish(allTeam, radiant, dire);
                }
                else{
                    hero.step(dire, radiant);
                    flag = game.is_finish(allTeam, radiant, dire);
                }
            }
        }
        button_new.close();
        View.view(allTeam, radiant, dire);
        View.showWinner(flag);





    }
}
