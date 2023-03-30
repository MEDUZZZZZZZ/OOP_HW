package OOP_HW.final_work.Persons;

public class Point2D {
protected int x, y;
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    

    public int getY(){
        return this.y;
    }


    public double findDist(Point2D enemyUnit){
        double distance = Math.sqrt((Math.pow(this.x - enemyUnit.x , 2) + (Math.pow(this.y - enemyUnit.y, 2))));
        return distance;

    }


    public Point2D pointtoWalk(Point2D enemyUnit){
        Point2D res = new Point2D(this.x - enemyUnit.x, this.y - enemyUnit.y);
        return res;
    }
}
