package codility.exam104;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a String S, consisting of N digits, that represents a number.
 * You can change at most one digit in the string to any other digit.
 * How many different numbers divisible by 3 can be obtained in this way?
 */
public class Exam03 {

    /**
     * Example01
     *      Given S = "23", should return 7. All numbers divisible by 3 that can be obtained after at most one change are (03, 21, 24, 27, 33, 63, 93).
     * Example02
     *      Given S = "0081" should return 11. (0021, 0051, 0081, 0084, 0087, 0381, 0681, 0981, 3081, 6081, 9081)
     * Example03
     *      Given S = "022" should return 9. (012, 021, 024, 027, 042, 072, 222, 522, 822)
     *
     * @param str   Given number string
     * @return      numbers divisible by 3 can be obtained
     */
    public int solution(String str){
        int length = str.toCharArray().length;
        Set<String> nums = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char[] changeDigit = str.toCharArray();
            for (int j = 0; j < 10; j++) {
                changeDigit[i] = Character.forDigit(j, 10);

                double tmp = sumDigitNum(changeDigit) % 3;
                if(tmp == 0){
                    nums.add(String.valueOf(changeDigit));
                }
            }
        }
        System.out.println(nums);
        return nums.size();
    }
    private int sumDigitNum(char[] chars){
        int sum = 0;
        for (char c : chars) {
            sum += (c-48);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Exam03().solution("0081"));
    }
}
