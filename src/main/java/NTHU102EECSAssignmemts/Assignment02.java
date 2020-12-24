package NTHU102EECSAssignmemts;
/**Task A
 輸入資料是兩個二進位正整數值
 每個數的長度都是 4 bits

 計算兩個數值的總和
 並且用二進位表示法輸出
 輸出的時候
 用英文字母 'I' 代表 1
 英文字母 'O' 代表 0

 ex.輸入:
 The first binary number: 1011
 The second binary number: 1101
 輸出:
 IOII + IIOI = IIOOO



 Task B
 進一步修改程式
 讓程式能夠做到輸入兩個二進位正整數值
 輸出兩數的乘積
 輸出的格式也是用二進位表示 (用 'I' 和 'O' 表示 1 和 0)
 執行過程如下

 輸入:
 The first binary number: 1001
 The second binary number: 0100
 輸出:
      IOOI
 *    OIOO
 ----------
 OOIO OIOO*/
import java.util.Scanner;

public class Assignment02 {
    public static void main(String[] args) {
        inputBinaryMultiply();

    }
    public static String inputBinarySum(){
        int a;
        int b;
        String sum = null;
        boolean f = true;
        while(f){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("input first binary number :");
                a = input.nextInt(2);
                System.out.println("input second binary number :");
                b = input.nextInt(2);
                System.out.println(a+"\t"+b);

                int tmp = a+b;
                sum = Integer.toBinaryString(tmp);

                System.out.println(binaryToString(Integer.toBinaryString(a))+" + "+binaryToString(Integer.toBinaryString(b))+" = ");

                System.out.print(binaryToString(sum)+"\n");

                f=false;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sum;
    }
    public static String binaryToString(String num){
        char[] binary = {'O','I'};
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '0'){
                str.append(binary[0]);
            }else if(num.charAt(i) == '1'){
                str.append(binary[1]);
            }
        }
        return str.toString();
    }
    public static String inputBinaryMultiply(){
        int a;
        int b;
        String sum = null;
        boolean f = true;
        while(f){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("input first binary number :");
                a = input.nextInt(2);
                System.out.println("input second binary number :");
                b = input.nextInt(2);
                System.out.println(a+"\t"+b);

                int tmp = a*b;
                sum = Integer.toBinaryString(tmp);

                System.out.println("\t"+binaryToString(Integer.toBinaryString(a))+"\n * \t"+binaryToString(Integer.toBinaryString(b)));

                System.out.println("--------------------------");
                System.out.print(binaryToString(sum)+"\n");

                f=false;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sum;
    }
}
