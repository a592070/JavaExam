package ClassicExamle100.Example02;
/**題目：企業發放的獎金根據利潤提成。
 * 利潤(I)低於或等於10萬元時，獎金可提10%；
 利潤高于10萬元，低於20萬元時，低於10萬元的部分按10%提成，高於10萬元的部分，可哥提成7.5%；
 20萬到40萬之間時，高於20萬元的部分，可提成5%；
 40萬到60萬之間時高於40萬元的部分，可提成3%；
 60萬到100萬之間時，高於60萬元的部分，可提成1.5%，
 高於100萬元時，超過100萬元的部分按1%提成，從鍵盤輸入當月利潤I，求應發放獎金總數？*/
public class Example02 {
    private static double example02(int num){
        double profit=0;
        double profit02 = 100000*0.075+10000;       //<40w basis
        double profit03 = 200000*0.05+profit02;     //<60w basis
        double profit04 = 200000*0.03+profit03;     //<100w basis
        double profit05 = 400000*0.015+profit04;    //>100w basis
        if(num<=100000) return num*0.1;

        /**10000,
         * 10000+7500 ,
         *  +10000 = 27500,
         *  +6000 = 33500,
         *  +6000 = 39500 */
        if(num<=200000){
            profit = (num-100000)*0.075+10000;
        }else if(num <=400000){
            profit = profit02 + (num-200000)*0.05;
        }else if(num<=600000){
            profit = profit03 + (num-400000)*0.03;
        }else if(num<=1000000){
            profit = profit04 + (num-600000)*0.015;
        }else if(num>1000000){
            profit = profit05 + (num-1000000)*0.01;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(example02(100000));
        System.out.println(example02(200000));
        System.out.println(example02(400000));
        System.out.println(example02(600000));
        System.out.println(example02(1000000));
        System.out.println(example02(1050000));


    }
}
