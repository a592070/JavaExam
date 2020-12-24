package ClassicExamle100.Example04;

import java.util.Scanner;

/**題目：輸入某年某月某日，判斷這一天是這一年的第幾天？*/
public class Example04 {
    /**計算月份天數*/
    private static int counterMonth(int month){
        int num=0;
        switch(month){
            case 1:num=0;
                break;
            case 2:num=31;        //+31
                break;
            case 3:num=59;        //+28
                break;
            case 4:num=90;        //+31
                break;
            case 5:num=120;       //+30
                break;
            case 6:num=151;       //+31
                break;
            case 7:num=181;       //+30
                break;
            case 8:num=212;       //+31
                break;
            case 9:num=243;       //+31
                break;
            case 10:num=273;      //+30
                break;
            case 11:num=304;      //+31
                break;
            case 12:num=334;      //+30
                break;
        }
        return num;
    }
    /**判斷閏年*/
    private static boolean counterYears(int years){
        if((years%400==0) || ((years%4==0) && (years%100)!=0)) {
            return true;
        }else return false;
    }
    /**檢查輸入月份*/
    private static int inputMonth(){
        System.out.println("Enter month = ");
        Scanner inputMonth = new Scanner(System.in);
        int month = inputMonth.nextInt();
        while(month>12||month<1){
            System.out.println("Enter correct month = ");
            inputMonth = new Scanner(System.in);
            month = inputMonth.nextInt();
        }
        return month;
    }
    /**檢查輸入日期*/
    private static int inputDay(){
        System.out.println("Enter day = ");
        Scanner inputDay = new Scanner(System.in);
        int day = inputDay.nextInt();
        while(day>31||day<1){
            System.out.println("Enter correct day = ");
            inputDay = new Scanner(System.in);
            day = inputDay.nextInt();
        }
        return day;
    }
    public static void main(String[] args) {

        int month = inputMonth();
        int day = inputDay();

        System.out.println("Enter Years = ");
        Scanner inputYears = new Scanner(System.in);
        int years = inputYears.nextInt();

        if(counterYears(years) && month>2){
            day+=1;
        }

        System.out.println(counterMonth(month)+day);
    }
}
