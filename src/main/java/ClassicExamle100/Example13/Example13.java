package ClassicExamle100.Example13;
/**題目：列印出所有的“水仙花數”，所謂“水仙花數”是指一個三位元數，其各位數字立方和等於該數
 　　　本身。例如：153是一個“水仙花數”，因為153=1的三次方＋5的三次方＋3的三次方。*/
public class Example13 {
    private static void method(int num){
        int numFirst;
        int numSecond;
        int numThird;
        double tmp;
        for (int i = 100; i <= num; i++) {
            numFirst = (int)(i/100);
            numSecond = (int)(i/10%10);
            numThird = (int)(i%10);
            tmp = Math.pow(numFirst,3)+Math.pow(numSecond,3)+Math.pow(numThird,3);
            if(i == (int)tmp){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        method(999);
    }
}
