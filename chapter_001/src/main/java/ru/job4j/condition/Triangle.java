package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double distance(Point left, Point right) {
        double result;
        result = Math.sqrt( ( (right.getX()-left.getX())^2 ) + ( (right.getY()-left.getY())^2 )  );
        return result;
    }

    public double period(double ab, double ac, double bc) {
        double result;
        result = (this.distance(this.a,this.b) + this.distance(this.a,this.c) + this.distance(this.b,this.c)) / 2;
        return result;
    }

    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            //√ p *(p - ab) * (p - ac) * (p - bc)
            rsl = Math.sqrt( p*(p-ab) *(p-ac)* (p-bc) );
        }
        return rsl;
    }

    private boolean exist(double ab, double ac, double bc) {
        double sum1 = ab + ac; // > bc
        double sum2 = ab + bc;  // > ac
        double sum3 = ac + bc; // > ab


        if (sum1 < bc | sum2 < ac | sum3 < ab | ab <= 0 | ac <= 0 | bc <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
