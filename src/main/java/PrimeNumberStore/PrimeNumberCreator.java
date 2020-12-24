package PrimeNumberStore;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCreator {

    public static List primeNum(int num){
        int tmp = (int) Math.sqrt(num);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= num ; i++) {
            int j =2;
            back:
            {
                /*while (j < list.size()) {
                    if (i % list.get(j) != 0) {
                        j++;
                    } else break back;
                }*/
                while (j < i && j <= tmp) {
                    if (i % j == 0) break back;
                    j++;
                }
                list.add(i);
            }
        }
        return list;
    }
    public static List primeNum2(int num){
        // true: not prime , false: prime
        boolean[] isPrime = new boolean[num]; // default elements is false
        isPrime[0] = true;
        isPrime[1] = true;
        int i = 2;
        while(i < num){
            // every next index i is 0(False)
            if(!isPrime[i]){
                // 篩選倍數
                for (int j = i*2; j < num; j+=i) {
                    if(isPrime[j]) continue;
                    isPrime[i] = true;
                }
            }
            i++;
        }
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < isPrime.length; k++) {
            if(!isPrime[k]) list.add(k);
        }
        return list;
    }


    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        primeNum(10000000);
        System.out.println(System.currentTimeMillis()-time+"ms");

        time = System.currentTimeMillis();
        primeNum2(10000000);
        System.out.println(System.currentTimeMillis()-time+"ms");

    }
}
