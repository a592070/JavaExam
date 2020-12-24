package ClassicExamle100.Example11;


import java.util.ArrayList;

/**題目：判斷101-200之間有多少個素數，並輸出所有素數。*/
public class Example11 {
    private static ArrayList<Integer> primeNum(int num){
        int tmp = (int)Math.sqrt(num);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

        for (int i = 3; i <= num; i++) {
            int j =2;
            back :
            {
                while (j < i && j <= tmp) {
                    if (i % j == 0) break back;
                    j++;
                }
                /*while(list.get(j) < i){
                    if(i% list.get(j) != 0){
                        if(list.size()-1==j){
                            list.add(i);
                            break back;
                        }else j++;
                    }else break back;
                }*/
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(primeNum(1000000));
        System.out.println(System.currentTimeMillis()-time+"ms");


    }
}
