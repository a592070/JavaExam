package JavaForReallyImpatientExam.Chapter1Exam;
/**Write a program that reads an integer and prints it in binary, octal, and hexadecimal.
 * Print the reciprocal as a hexadecimal floating-point number*/
import java.math.BigDecimal;
import java.math.MathContext;

public class Exam01 {
    public static void main(String[] args) {
        System.out.println(toBinary(10));
        System.out.println(toOctal(16));
        System.out.println(toHexadecimal(218));

        System.out.println(multiplyInverse(99));
    }
    //10 -> 2
    static String toBinary(int num){
        if(num == 0) return "0";
        StringBuilder toBinary = new StringBuilder();
        while(num>0){
            toBinary.insert(0,num%2);
            num /= 2;
        }
        return toBinary.toString();
    }
    //10 -> 8
    static String toOctal(int num){
        if(num == 0) return "0";
        StringBuilder toBinary = new StringBuilder();
        while(num>0){
            toBinary.insert(0,num%8);
            num /= 8;
        }
        return toBinary.toString();
    }
    //10 -> 16
    static String toHexadecimal(int num){
        if(num == 0) return "0";
        StringBuilder toBinary = new StringBuilder();
        while(num>0){
            int tmp = num%16;
            switch (tmp){
                case 10:
                    toBinary.insert(0,"A");
                    break;
                case 11:
                    toBinary.insert(0,"B");
                    break;
                case 12:
                    toBinary.insert(0,"C");
                    break;
                case 13:
                    toBinary.insert(0,"D");
                    break;
                case 14:
                    toBinary.insert(0,"E");
                    break;
                case 15:
                    toBinary.insert(0,"F");
                    break;
                default:
                    toBinary.insert(0,tmp);
                    break;
            }
            num /= 16;
        }
        return toBinary.toString();
    }
    static double multiplyInverse(int num){
        if(num == 0){
            System.out.println("Multiply Inverse is infinite");
            return 0;
        }
//        BigDecimal bigDecimal = new BigDecimal(1/num);
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal2 = new BigDecimal(num);
        double tmp = bigDecimal.divide(bigDecimal2, MathContext.DECIMAL64).doubleValue();
        System.out.println(bigDecimal2.scale());
        return tmp;
    }
}
