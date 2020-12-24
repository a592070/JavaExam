package JavaForReallyImpatientExam.Chapter1Exam;

import java.util.Arrays;

/**Write a program that reads a two-dimensional array of integers and determines whether it is a magic square
 * (that is, whether the sum of all rows, all columns, and the diagonals is the same).
 * Accept lines of input that you break up into individual integers, and stop when the user enters a blank line*/
public class Exam14 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3},
                {3,2,3},
                {2,2,3}};
        determineMagiSquare(arr);
    }
    static void determineMagiSquare(int[][] arr){
//        int sumRow = 0;
//        int sumColumn = 0;
        int sumDiagonals = 0;
        int[] sumRowArr = new int[arr.length];
        int[] sumColumnArr = new int[arr.length];
        int i = 0;
        int j = 0;
        while(i<arr.length){
            int sumRow = 0;
            int sumColumn = 0;
            for (j= 0; j < arr[i].length; j++) {
                sumRow += arr[i][j];
                sumColumn += arr[j][i];
            }
            sumRowArr[i] = sumRow;
            sumColumnArr[i] = sumColumn;
            i++;
        }
        System.out.println(Arrays.toString(sumRowArr));
        System.out.println(Arrays.toString(sumColumnArr));

    }
}
