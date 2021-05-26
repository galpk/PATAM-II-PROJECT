package test;

import java.util.List;
import java.util.Vector;

public class Welzl  implements  TimeSeriesAnomalyDetector{
    class Circle
    {
      Point C;
      double Radius;
    };

    @Override
    public void learnNormal(TimeSeries ts) {


    }
    public double dist(final Point a ,final Point b)
    {
        return Math.sqrt(Math.pow(a.x - b.x,2)+Math.pow(a.y - b.y,2));
    }
    boolean is_inside_the_circle(final Circle c, final Point p )
    {
        return dist(c.C , p) <=c.Radius;
    }
    Circle smallest_circle (Circle circle ,final Point A , final Point B){
        Point cir = new Point((A.x + B.y)/2,(A.y+B.y)/2);
       circle.C =cir;
       circle.Radius = dist(A, B)/2;

       return circle;
    }
    boolean valid_circle(final Circle c , final Vector<Point> P)
    {
        for (final Point p :P)
        {
            if(!valid_circle(c,P))
                return false;
        }
        return true;
    }
    Circle welzl (Vector<Point> P1 , Vector<Point>P2  ,int n)
    {
        if(n==0|| P2.size() ==3)
        {
            return  bar or;
        }
    }

    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {
        return null;
    }
}
