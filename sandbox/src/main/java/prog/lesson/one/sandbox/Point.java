package prog.lesson.one.sandbox;

/**
 * Created by SerejKa on 11.04.2017.
 */


class Point {
    double х, у;

   public Point(double х, double у) {

       this.х = х;
       this.у = у;

    }

  public   double distance(double х, double у) {

       this.х = х;
       this.у = у;

        return Math.sqrt(Math.pow((х - у),2) + Math.pow((х - у),2));

    }

  public  double distance(Point p) {


        return distance(p.х, p.у);

    }
 }

