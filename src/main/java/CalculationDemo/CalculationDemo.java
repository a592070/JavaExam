package CalculationDemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculationDemo {
    private static Scanner sc;
    public static void main(String[] args) {
//        String str = "11.1 +0.9";
//        String[] arr = str.split("[\\p{Punct}&&[^.]]");
//        String[] arr1 = str.split("\\d+.\\d+");
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr1));

        input();
        System.out.println(list);
        double tmp1 = Double.valueOf(list.get(0));
        double tmp2 = Double.valueOf(list.get(1));

        if(list.get(2).equals("+")){
            BigDecimal tmp = BigDecimal.valueOf(tmp1).add(BigDecimal.valueOf(tmp2));
            System.out.println(tmp);
        } else if(list.get(2).equals("-")){
            BigDecimal tmp = BigDecimal.valueOf(tmp1).subtract(BigDecimal.valueOf(tmp2));
            System.out.println(tmp);
        } else if(list.get(2).equals("*")){
            BigDecimal tmp = BigDecimal.valueOf(tmp1).multiply(BigDecimal.valueOf(tmp2));
            System.out.println(tmp);
        } else if(list.get(2).equals("/")){
            BigDecimal tmp = BigDecimal.valueOf(tmp1).divide(BigDecimal.valueOf(tmp2));
            System.out.println(tmp);
        } else{
            System.out.println("no support");
        }


    }
    private static ArrayList<String> list = new ArrayList<>();
    public static List<String> input(){
        System.out.print("輸入運算(+ - * /) : ");
        sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("[\\p{Punct}&&[^.]]");


        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i].trim());
        }
        for (int i = 0; i < str.length(); i++) {
            if(Character.toString(str.charAt(i)).matches("[\\p{Punct}&&[^.]]")){
                list.add(Character.toString(str.charAt(i)));
            }
        }
        return list;
    }
}
