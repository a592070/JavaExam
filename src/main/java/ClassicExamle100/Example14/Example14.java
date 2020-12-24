package ClassicExamle100.Example14;

import java.util.ArrayList;

/**題目：將一個正整數分解質因數。例如：輸入90,列印出90=2*3*3*5。*/
public class Example14 {
    private static ArrayList primeArray = new ArrayList();     //儲存質數的 array
    private static void numDivided(int num){
        //先 讓創建的primeArray 儲存 num/2 的所有質數 因為不需要超過(num/2)的質數 減少運算
        primeNum(num/2);

        ////處理例外狀況: 如果 num 本身就是質數
        int numIsPrime = num;

        System.out.println(num + " = ");

        //從 num/2 的質數中去找質因數
        tag1 :
        for (int i = 0; i<primeArray.size(); i++){
            int dividedValue =  (int)primeArray.get(i);

            while(num != 1){
                if(num%dividedValue == 0){
                    //最後一個質因數打印出來不要有 *
                    if(num == dividedValue){
                        System.out.println(dividedValue);
                        break tag1;
                    }
                    //打印質因數
                    System.out.print(dividedValue + " * ");
                    num = num/dividedValue;
                }else break;
            }

            //處理例外狀況: 如果 num 本身就是質數
            if(numIsPrime == num){
                System.out.println(num + " is prime number");
                break;
            }

        }
    }
    private static void primeNum(int num){
        int tmp = (int)Math.sqrt(num);

        for (int i = 2; i <= num; i++) {
            int j =2;
            back :
            {
                while (j < i && j <= tmp) {
                    if (i % j == 0) break back;
                    j++;
                }
                primeArray.add(i);
            }
        }
    }

    public static void main(String[] args) {
        numDivided(199);
        numDivided(3600);
    }
}
