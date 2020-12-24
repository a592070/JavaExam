package PrimeNumberStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

public class TestBufferReaderDemo {
    /*public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/PrimeNumberIn1000K.txt"));

//        String primeString = bufferedReader.readLine();
        StringBuilder primeString = new StringBuilder(bufferedReader.readLine());
        //去掉首尾的 [ ]
        primeString.deleteCharAt(0);
        primeString.deleteCharAt(primeString.length()-1);

        String[] arrayString = primeString.toString().split("\\,\\ ");

        //String[] -> int[]
        int[] arrayInt = StringArrayToIntArray(arrayString);

        ArrayList<String> list = new ArrayList<>();

        bufferedReader.close();
        //test
//        System.out.println(primeString);
//        System.out.println(Arrays.toString(arrayString));
//        System.out.println(arrayString[1]);
        System.out.println(Arrays.toString(arrayInt));

    }*/
    static int[] textGetIntArray() {
        BufferedReader bufferedReader = null;
        StringBuilder primeString = null;

        //讀取PrimeNumberStore生成的檔案，用primeString儲存字串
        try{
            bufferedReader = new BufferedReader(new FileReader("src/PrimeNumberStore.txt"));
            primeString = new StringBuilder(bufferedReader.readLine());

            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        //格式[2, 3, 5, ...] ，刪除[] 後用正則分割
        primeString.deleteCharAt(0);
        primeString.deleteCharAt(primeString.length()-1);

        String[] arrayString = primeString.toString().split("\\,\\ ");


        return StringArrayToIntArray(arrayString);
    }
    //將String[] 轉為 int[]
    static int[] StringArrayToIntArray(String[] stringArray)
    {
        return Stream.of(stringArray).mapToInt(Integer::parseInt).toArray();
    }
}
