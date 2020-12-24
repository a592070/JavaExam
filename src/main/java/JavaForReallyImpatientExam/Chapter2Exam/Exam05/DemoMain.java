package JavaForReallyImpatientExam.Chapter2Exam.Exam05;

public class DemoMain {
    public static void main(String[] args) {
        Point pointOrigin = new Point();
        Point point = new Point(3,4);
        System.out.println(pointOrigin);
        System.out.println(point);
        System.out.println(point.getX()+" "+point.getY());

        System.out.println(point.translate(2,8));
        System.out.println(point.translate(2,8).scale(0.5));

        System.out.println(point);

    }
}
