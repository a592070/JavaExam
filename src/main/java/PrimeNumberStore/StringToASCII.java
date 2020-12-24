package PrimeNumberStore;


import java.util.ArrayList;


public class StringToASCII {

    //將輸入的String 轉為 ArrayList
    public static ArrayList<Integer> StringToASCII(String str){
        char[] ch = str.toCharArray();
        ArrayList<Integer> arrASCII = new ArrayList<>();
        for (char c : ch) {
            arrASCII.add((int)c);
        }
        return arrASCII;
    }
    //將輸入的ArrayList轉為String
    public static String ASCIIToString(ArrayList<Integer> arr){
        StringBuilder stringBuilder = new StringBuilder();
        arr.forEach( num ->{
            int numASCII = num;
            char ch = (char)numASCII;
            stringBuilder.append(ch);
        });

        return stringBuilder.toString();
    }
}
