package JavaForReallyImpatientExam.Chapter1Exam;
/**Write a program that reads an integer angle (which may be positive or negative)
 * and normalizes it to	a value between 0 and 359 degrees.
 * Try it first with the % operator, then with floorMod*/

public class Exam02 {
    public static void main(String[] args) {
        angle(-15.5);
    }
    static void angle(double num){
        if(num>=0){
            System.out.printf("%.5f%s",num%360,"degree");
        }
        if(num<0){
            System.out.printf("%.5f%s",(360+num%360),"degree");
        }
    }
}
