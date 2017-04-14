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

      double dx = this.х - х;
      double dy = this.у - у;

      return Math.sqrt(dx*dx + dy*dy);

    }

  public  double distance(Point p) {


        return distance(p.х, p.у);

    }
 }

