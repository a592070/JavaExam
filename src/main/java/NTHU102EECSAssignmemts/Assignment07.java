package NTHU102EECSAssignmemts;

import java.util.Arrays;

/**Task A: Eight Queens

 將八個皇后放在西洋棋棋盤上 (Wikipedia)
 任兩個皇后都不能在同一直線上
 也就是說
 棋盤中任何橫列、直行、以及斜線都只能有一個皇后
 請修改範例程式
 算出所有可能的放置方式*/

public class Assignment07 {
    private static String[][] map;
    public static void main(String[] args) {
        setMap(4);
        setQueen(0,0);

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(queenMap[i]));
        }


    }
    public static void setMap(int size){
        map = new String[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                map[i][i1] = "O";
            }
        }
    }
    private static String[][] queenMap;
    private static int count;
    private static String[][] tmpMap;
    public static void setQueen(int i, int j){
        count = 0;
        tmpMap = map;

        if(count<=map.length) {
            while (i < map.length) {
                while (j < map.length) {
                    if (canSetQueen(tmpMap, i, j)) {
                        tmpMap[i][j] = "@";
                        count++;
                        break;
                    } else if(j== map.length-1) {
                        setQueen(0,1);
                    }
                    j++;
                }
                j = 0;
                i++;
            }
        }
//        if(count != map.length){
//            setQueen(0,1);
//        }
        System.out.println(count+","+i+","+j+","+map.length);
        queenMap = tmpMap;
    }
    public static boolean canSetQueen(String[][] tmpMap , int i, int j){
        //檢查上面
        for (int k = 1; k <= i; k++) {
            if(tmpMap[i-k][j] =="@"){
                return false;
            }
        }
        //檢查左上
        for (int k = 1; k <= i && k<=j; k++) {
            if(tmpMap[i-k][j-k] == "@"){
                return false;
            }
        }
        //檢查右上
        for (int k = 1; k <= i && k<tmpMap.length-j; k++) {
            if(tmpMap[i-k][j+k] == "@"){
                return false;
            }
        }
        return true;
    }
}
