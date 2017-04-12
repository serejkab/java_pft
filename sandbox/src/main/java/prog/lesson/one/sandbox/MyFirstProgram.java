package prog.lesson.one.sandbox;

public class MyFirstProgram {


		public static void main(String[] args) {

			Point p1 = new Point(1, 2);

			Point p2 = new Point(3, 4);


			System.out.println("Расстояние между точками = " + distance(p1, p2));

			System.out.println("Расстояние между точками = " + p2.distance(p1));


		}

		public static double distance(Point p1, Point p2){

			return Math.sqrt(Math.pow((p1.у - p1.х),2) + Math.pow((p2.у - p2.х),2));

		}


}