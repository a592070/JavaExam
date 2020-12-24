package NTHU102EECSAssignmemts;
/**輸入一個 3x3 二維陣列代表地圖，其中包含 1 和 9 以及 0，例如
 1 0 0
 0 0 0
 9 0 0
 從數字 1 的位置開始走，只能往右下左上 (R,D,L,U) 四個方向移動，目標是要走過每個位置，
 而且每個位置只能走過一次，直到走到 9 的位置為止。你的程式要輸出每次的移動方向。
 以這個例子來說，輸出會是
 *DRURDDLL
 其中 * 代表開始，D 代表先往下走，接下來 R 代表往右走，再接下來 U 代表向上走，最後走到 9。

 如果無法走到 9，就輸出
 None

 底下是其他例子
 Input:
 0 0 0
 9 1 0
 0 0 0
 Output:
 None

 如果有兩種可能的路徑，譬如底下的例子有兩種可能路徑，
 *DRUULLDD 和 *LURRDDLL，只要顯示出其中一種就行了

 Input:
 0 0 0
 0 1 0
 9 0 0
 Output:
 *DRUULLDD*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Assignment06 {
    public static void main(String[] args) {

        String[][] map = setMap(5);

        for (String[] strings : map) {
            System.out.print(Arrays.toString(strings)+"\n");
        }

        List<String> pathLog = path(map);
        System.out.println(pathLog);

        for (String[] strings : map) {
            System.out.print(Arrays.toString(strings)+"\n");
        }

    }
    private static int rnd1;   //"1"
    private static int rnd2;   //"9"
    public static String[][] setMap(int size){
        String[][] map = new String[size][size];
        rnd1 = new Random().nextInt(size*size);
        do{
            rnd2 = new Random().nextInt(size*size);
        } while(rnd1 == rnd2);
        int count1 = rnd1;
        int count2 = rnd2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(count1 == 0){
                    map[i][j] = "1";
                } else if(count2 == 0){
                    map[i][j] = "9";
                } else{
                    map[i][j] = "0";
                }
                count1--;
                count2--;
            }
        }
        return map;
    }
    private static int pathIndexBegin;
    private static int pathIndexEnd;
    private static List<String> pathLog;
    public static List<String> path(String[][] map){
        pathIndexBegin = rnd1;  //走過後的位置
        pathIndexEnd = rnd2;    //目標位置
        pathLog = new ArrayList<>();    //路徑
        int rndDir;
        int maxNum = 0; //極限次數 <1000
        while(pathIndexBegin != pathIndexEnd){
            rndDir = new Random().nextInt(4);   //隨機方向
            switch (rndDir){
                case 0:
                    map = moveRight(map);
//                    System.out.print("R");
                    break;
                case 1:
                    map = moveLeft(map);
//                    System.out.print("L");
                    break;
                case 2:
                    map = moveUp(map);
//                    System.out.print("U");
                    break;
                case 3:
                    map = moveDown(map);
//                    System.out.print("D");
                    break;
            }
            if(maxNum == 1000){
                pathLog.add("None");
                System.out.println("None");
                break;
            }
            maxNum++;
        }
        return pathLog;
    }
    public static String[][] moveRight(String[][] map){
        int count = pathIndexBegin;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //判斷 1的位置、能往右走?、右邊沒走過
                if(count==0 && pathIndexBegin%map.length < map.length-1 && map[i][j+1]!="*" ){
                    map[i][j+1] = "1";
                    map[i][j] = "*";
                    pathIndexBegin++;
                    pathLog.add("R");
                    return map;
                }
                count--;
            }
        }
        return map;
    }
    public static String[][] moveLeft(String[][] map){
        int count = pathIndexBegin;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //判斷 1的位置、能往左走?、左邊沒走過
                if(count==0 && pathIndexBegin%map.length > 0 && map[i][j-1] != "*"){
                    map[i][j-1] = "1";
                    map[i][j] = "*";
                    pathIndexBegin--;
                    pathLog.add("L");
                    return map;
                }
                count--;
            }
        }
        return map;
    }
    public static String[][] moveUp(String[][] map){
        int count = pathIndexBegin;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //判斷 1的位置、能往上走?、上面沒走過
                if(count==0 && pathIndexBegin > map.length && map[i-1][j] != "*"){
                    map[i-1][j] = "1";
                    map[i][j] = "*";
                    pathIndexBegin -= map.length;
                    pathLog.add("U");
                    return map;
                }
                count--;
            }
        }
        return map;
    }
    public static String[][] moveDown(String[][] map){
        int count = pathIndexBegin;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //判斷 1的位置、能往下走?、下面沒走過
                if(count==0 && pathIndexBegin < map.length*(map.length-1) && map[i+1][j] != "*" ){
                    map[i+1][j] = "1";
                    map[i][j] = "*";
                    pathIndexBegin +=map.length;
                    pathLog.add("D");
                    return map;
                }
                count--;
            }
        }
        return map;
    }
}
