package JavaForReallyImpatientExam.Chapter1Exam;
/**Write a program that computes the factorial n! = 1 × 2 × ... × n, using BigInteger.
 * Compute the factorial of 1000*/
import java.math.BigDecimal;

public class Exam06 {
    public static void main(String[] args) {
        System.out.println(counter(100));
    }
    static BigDecimal counter(int num){
        BigDecimal totalNum = new BigDecimal(1);
        if(num == 0) return totalNum;
        int tmp = 2;
        while(num >= tmp){
            totalNum = totalNum.multiply(new BigDecimal(tmp));
            tmp++;
        }
        return totalNum;
    }
}
