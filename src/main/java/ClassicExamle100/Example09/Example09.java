package ClassicExamle100.Example09;
/**題目：要求輸出國際象棋棋盤。西洋棋盤*/
public class Example09 {
    public static void main(String[] args) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i%2!=0 && j%2==0){
                    System.out.print(" 0");
                }
                else if(i%2==0 && j%2!=0){
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("█");
    }
}
