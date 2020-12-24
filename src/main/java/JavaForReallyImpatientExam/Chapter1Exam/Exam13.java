package JavaForReallyImpatientExam.Chapter1Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**Write a program that prints a lottery combination, picking six distinct numbers between 1 and 49.	*/
public class Exam13 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = randomLottery();
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
    }
    static ArrayList<Integer> randomLottery(){
        ArrayList<Integer> arr = new ArrayList<>();
        int tmp;
        while(arr.size()<6){
            tmp = new Random().nextInt(49)+1;
            if(!arr.contains(tmp)){
                arr.add(tmp);
            }
        }
        return arr;
    }
}
