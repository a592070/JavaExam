package JavaForReallyImpatientExam.Chapter2Exam.Exam05;

import java.util.Arrays;

public class Point {
    private final double x;
    private final double y;

    public Point translate(double a, double b){
        Point pointTranslate = new Point(this.x+a, this.y+b);
        return pointTranslate;
    }
    public Point scale(double value){
        Point pointScale = new Point(this.x*value, this.y*value);
        return pointScale;
    }

    @Override
    public String toString() {
        double[] corrdinate = {x,y};
        return Arrays.toString(corrdinate);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }
}
