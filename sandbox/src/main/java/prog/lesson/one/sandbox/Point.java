package prog.lesson.one.sandbox;

/**
 * Created by SerejKa on 11.04.2017.
 */
public class Point {

     double x0;
     double x1;
     double y0;
     double y1;

     public Point (double x0, double x1, double y0, double y1 ){

         this.x0 = x0;
         this.x1 = x1;
         this.y0 = y0;
         this.y1 = y1;

     }

    public double distance() {

        return  Math.sqrt(Math.pow((this.x1 - this.x0),2) + Math.pow((this.y1 - this.y0),2));

    }

}
