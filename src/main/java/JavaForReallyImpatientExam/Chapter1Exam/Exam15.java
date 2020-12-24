package JavaForReallyImpatientExam.Chapter1Exam;

import java.util.ArrayList;

/**Write a program that stores Pascal's triangle up to a given n in an
 ArrayList<ArrayList<Integer>>*/
public class Exam15 {
    public static void main(String[] args) {
        pascalTriangle(5);
        System.out.println(average(1.1,2.2,3.3,4.4,5.5));
    }
    static void pascalTriangle(int n){
        ArrayList<ArrayList<Integer>> arrOut = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrIn = new ArrayList<>();
            arrOut.add(arrIn);
            arrIn.add(1);
            for (int j = 1; j < i+1; j++) {
                arrIn.add(arrOut.get(i-1).get(j-1)+arrOut.get(i-1).get(j));
            }
            arrIn.add(1);

        }
        System.out.println(arrOut);
    }
    static double average(Double... values){
        double sum = 0;
        for (Double value : values) {
            sum += value;
        }
        return values.length == 0? 0:sum/values.length;
    }

}
