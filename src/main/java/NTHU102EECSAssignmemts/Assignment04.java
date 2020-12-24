package NTHU102EECSAssignmemts;

public class Assignment04 {
    public static void main(String[] args) {
        showMap(setMap());

        String[][] car = setCar();

        showMap(putCarOnMap(car,5,6));

        car = rotateCarRight(car);

        showMap(putCarOnMap(car,6,7));

        car = rotateCarRight(car);

        showMap(putCarOnMap(car,7,8));

        car = rotateCarLeft(car);

        showMap(putCarOnMap(car,8,9));

    }
    public static String[][] setMap(){
        String[][] map = new String[12][12];
        for (int i = 0; i < map.length; i++) {
            if(i==0 || i==map.length-1) {
                for (int i1 = 0; i1 < map[i].length; i1++) {
                    map[i][i1] = "-";
                }
            }else{
                for (int i1 = 0; i1 < map[i].length; i1++) {
                    if(i1==0 || i1==map[i].length-1) {
                        map[i][i1] = "|";
                    }else{
                        map[i][i1] = ".";
                    }
                }
            }
        }
        return map;
    }
    public static void showMap(String[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                System.out.print(map[i][i1]);
            }
            System.out.println();
        }
    }
    public static String[][] setCar(){
        String[][] car = new String[3][3];
        for (int i = 0; i < car.length; i++) {
            for (int i1 = 0; i1 < car[i].length; i1++) {
                if((i==0||i==car.length-1) && i1==car[i].length-1){
                    car[i][i1] = "@";
                } else{
                    car[i][i1] = "#";
                }
            }
        }
        return car;
    }
    //放car 到map上
    public static String[][] putCarOnMap(String[][] car,int row, int col){
        String[][] map = setMap();

        //防止超過map邊界
        if(row > map.length - car.length){
            if(col > map.length - car.length){
                row = map.length - car.length;
                col = map.length - car.length;
            }else{
                row = map.length - car.length;
            }
        }else if(col > map.length - car.length){
            col = map.length - car.length;
        }else if(row < 0){
            if(col < 0){
                row = 0;
                col = 0;
            }else {
                row = 0;
            }
        }else if(col < 0){
            row = 0;
            col = 0;
        }

        for (int i = row; i < row + car.length; i++) {
            for (int i1 = col; i1 < col + car.length; i1++) {
                map[i][i1] = car[i - row][i1 - col];
            }
        }

        return map;
    }
    //將參數car向右轉
    public static String[][] rotateCarRight(String[][] car){
        int size = car.length;
        String[][] rotateCar = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int i1 = 0; i1 < size; i1++) {
                rotateCar[i][i1] = car[size-i1-1][i];
            }
        }
        
        return rotateCar;
    }
    //將參數car向左轉
    public static String[][] rotateCarLeft(String[][] car){
        int size = car.length;
        String[][] rotateCar = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int i1 = 0; i1 < size; i1++) {
                rotateCar[i][i1] = car[i1][size-i-1];
            }
        }

        return rotateCar;
    }
}
