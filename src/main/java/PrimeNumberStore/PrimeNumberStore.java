package PrimeNumberStore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class PrimeNumberStore {
    public static void main(String[] args) {
        List<Integer> list = PrimeNumberCreator.primeNum(100000);
        BufferedWriter bufferedWriter = null;
        try {

            //創造一個FileWriter 寫入對象
            bufferedWriter = new BufferedWriter(new FileWriter("src/PrimeNumberStore.txt"));

            //寫入 PrimeNumberCreator.primeNum
            bufferedWriter.write(list.toString());

            //刷新後關閉
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
