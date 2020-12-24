package ClassicExamle100.Example01;


/**題目：有1、2、3、4個數字，能組成多少個互不相同且無重複數字的三位元數？都是多少？*/
public class Example01 {
    private static void example01(int a,int b,int c,int d){
        int[] list = new int[]{a,b,c,d};
        int num = 0;
        for (int i=0; i<list.length ; i++) {

            for(int j=0 ; j<list.length ;j++){
                if(i==j){continue;}
                for(int k =0; k<list.length; k++){
                    if(k==j||k==i){continue;}
                    num++;
                    System.out.println(list[i]*100+list[j]*10+list[k]);
                }
            }
        }
        System.out.println(num);

    }

    public static void main(String[] args) {
        example01(1,2,3,4);
    }
}
