package OOP_HW.final_work.Persons;
import java.util.ArrayList;
public class meleeUnit extends Dummy {
    

protected meleeUnit(String name, int atk, int speed, int def, int maxHP, int minDMG, int maxDMG, int x, int y){
    super(name, atk, speed, def, maxHP, minDMG, maxDMG, x, y);
}


@Override
public int step(ArrayList<Dummy> allies, ArrayList<Dummy> enemy){
    if (!this.cond.equals("Dead")){
        Dummy target = closestUnit(enemy);
        if (this.cords.findDist(target.cords) < 2){
            target.interaction(dmgFormula(target));
        }
        else{
            Point2D walk = this.cords.pointtoWalk(target.cords);
            if (Math.abs(walk.x) > Math.abs(walk.y)){
                if (walk.x < 0){
                    this.cords.x += 1;
                }
                else {
                    this.cords.x -= 1;
                }
            }
            else{
                if (walk.y < 0){
                    this.cords.y += 1;
                }
                else{
                    this.cords.y -= 1;
                }
            }
        }
        return 1;
    }
    else{
        return 0;
    }
}
}
