package NTHU102EECSAssignmemts;
/**這個程式會透過呼叫函數的方式，讓使用者輸入三次，每次都是輸入一組兩個整數，
 函數會傳回兩個數目的乘積。程式會把乘積累加，最後會輸出總合。
 底下是執行的範例，紅色是使用者輸入的數字，藍色是程式輸出的字串：

 Input two numbers: 1 4
 Input two numbers: 2 5
 Input two numbers: 3 6
 ------------------------------
 Total: 32
 */
import java.util.Scanner;

public class Assignment01 {
    public static void main(String[] args) {
        int z = 0;
        z += input();
        z += input();
        z += input();
        System.out.println(z);
    }
    public static int input(){
        int a = 0;
        int b = 0;
        boolean f = true;
        while(f) {
            try {
                Scanner scanner = new Scanner(System.in);
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println(a + " * " + b + " = " + a * b);
                f = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a*b;
    }
}
