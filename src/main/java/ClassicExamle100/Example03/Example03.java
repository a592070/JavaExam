package ClassicExamle100.Example03;
/**題目：一個整數，它加上100後是一個完全平方數，再加上168又是一個完全平方數，請問該數是多少？*/
public class Example03 {
    public static void method(){
        int x=0;
        int y=0;
        for(int i=0; i<10000 ;i++){
            x = (int)Math.sqrt(i+100);
            y = (int)Math.sqrt(i+268);

            if((x*x == i+100) && (y*y == i+268)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        method();
    }
}
