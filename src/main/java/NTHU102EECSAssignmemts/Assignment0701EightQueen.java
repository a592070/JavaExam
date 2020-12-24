package NTHU102EECSAssignmemts;

public class Assignment0701EightQueen {
    public static void main(String[] args) {
        num = 8;
        sol = new int[num];
        backTrack(0);

    }
    private static int num;     //n queen
    private static int[] sol;   //solution
    private static int countN;  //num of solution
    //判斷第t位置的皇后 能不能放在i位置
    public static boolean place(int t){
        boolean ok = true;
        for (int i = 0; i < t; i++) {
            //位置不能同一排 也不能相鄰 ex. 目前在1 下一個不能放在 0,1,2
            if(sol[t]==sol[i] || t-i == Math.abs(sol[t]-sol[i]) ){
                ok = false;
                break;
            }
        }
        return ok;
    }
    public static void backTrack(int t){
        if(t>=num){
            countN++;
            for (int i = 0; i <num ; i++) {
                System.out.print(sol[i]);
            }
            System.out.println(" num of sol : "+countN);

        } else{
            for (int i = 0; i < num; i++) {
                sol[t] = i;     //在 t 位置放 i。決定queen放在第t層的i位置
                if(place(t)){
                    backTrack(t+1);
                }
            }
        }
    }
}
