package ClassicExamle100.Example10;
/**題目：古典問題：有一對兔子，從出生後第3個月起每個月都生一對兔子，小兔子長到第三個月
 　　　後每個月又生一對兔子，假如兔子都不死，問每個月的兔子總數為多少？
 1,1,2,3,5,8,13,....

 */
public class Example10 {
    private static int fibSequence(int num){
        if(num<=1) return num;
        return fibSequence(num-1)+fibSequence(num-2);
    }

    public static void main(String[] args) {
        System.out.println(fibSequence(30));
    }
}
