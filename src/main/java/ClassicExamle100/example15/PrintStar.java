package ClassicExamle100.example15;

public class PrintStar {
    public static void main(String[] args) {
//        printStar01(5);
//        printStar02(4);
        printStar03(5);
    }

    public static void printStar01(int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void printStar02(int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < num-i; j++) {
                System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printStar03(int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
