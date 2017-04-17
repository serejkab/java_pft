package prog.lesson.one.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by SerejKa on 17.04.2017.
 */
public class PointTests {


    @Test
    public void testDistance() {


        Point p1 = new Point(2, 6);
        Point p2 = new Point(3, 10);

        Assert.assertEquals(p1.distance(p2), 4.123105625617661);

        Assert.assertEquals(MyFirstProgram.distance(p1, p2), 4.123105625617661);

    }

    @Test
    public void testFunctionDistance(){

        Point p1 = new Point(2, 6);
        Point p2 = new Point(3, 10);


        Assert.assertEquals(MyFirstProgram.distance(p1,p2), 4.123105625617661);
    }

}
