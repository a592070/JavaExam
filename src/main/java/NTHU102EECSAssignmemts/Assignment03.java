package NTHU102EECSAssignmemts;
/**Task A
 Reverse Index

 輸入:
 5
 10 30 90 200 500
 3 1 5 4 2

 第一個輸入的數目 5 代表總共 5 筆整數資料
 接下來就是 5 個整數值
 讀取之後用陣列 A 儲存
 再接下來 5 個數代表資料的位置的搬動方式
 以 3 1 5 4 2 為例
 第 1 筆資料要移到第 3 個位置
 第 2 筆資料要移到第 1 個位置
 第 3 筆資料要移到第 5 個位置
 第 4 筆資料要移到第 4 個位置
 第 5 筆資料要移到第 2 個位置
 將搬動的方式儲存在另一個陣列 B

 依據上列的搬動方式
 把原本儲存在陣列 A 中的資料
 放到一個新的陣列 C 中
 同時也把反向的搬動方式記錄在另一個陣列 D
 最後將全部的資訊
 用下面的形式顯示出來

 輸出:
 10 ~ 3    <-->     30 ~ 2
 30 ~ 1    <-->    500 ~ 5
 90 ~ 5    <-->     10 ~ 1
 200 ~ 4    <-->    200 ~ 4
 500 ~ 2    <-->     90 ~ 3*/

import java.util.Arrays;
import java.util.Scanner;

public class Assignment03 {
    public static void main(String[] args) {
        int size = inputSize();
        int[][] arr = new int[2][size];
        int[][] exchangeArr;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = inputArr(size);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        exchangeArr = reverseIndex(arr);

        for (int[] ints : exchangeArr) {
            System.out.println(Arrays.toString(ints));
        }

        
    }
    //檢查輸入size
    public static int inputSize(){
        int num = 0;
        Scanner input;
        boolean f = true;
        while(f){
            try{
                input = new Scanner(System.in);
                num = input.nextInt();
                f = false;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return num;
    }
    //檢查輸入arr
    public static int[] inputArr(int size) {
        int [] arr = new int[size];
        Scanner input;
        boolean f = true;
        while (f) {
            try {
                input = new Scanner(System.in);
                for(int i =0; i<size; i++){
                    arr[i] = input.nextInt();
                }

                f = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
    //進行交換
    public static int[][] reverseIndex(int[][] arr){
        int size = arr[0].length;
        int[] exchangeIndex = arr[1];
        int[][] exchangeArr = new int[2][size];

        for (int i = 0; i < size; i++) {
            int index = exchangeIndex[i]-1;
            //用新的數組 根據輸入的交換順序 儲存元素
            exchangeArr[0][index] = arr[0][i];
            exchangeArr[1][index] = i+1;
        }

        return exchangeArr;
    }
}
