package codility.exam104;

import java.util.HashSet;
import java.util.Set;

/**
 * There are N bulbs, numbered  from 1 to N, arranged in a row.
 * The first bulb is plugged into the power socket and each successive bulb is connected to the previous one(the second bulb to the first, the third bulb to the second, etc.).
 * Initially, all the bulbs are turned off. At moment K ( for K from 0 to N-1), we turn on the A[K]-th bulb.
 * A bulb shines if it is on and all the previous bulbs are turned on too.
 */
public class Exam02 {

    /**
     * Example01
     *      Given A=[2,1,3,5,4], should return 3.
     *      At 0th moment only 2nd bulb is turn on, but it does not shine because the previous one is not on.
     *      At 1th moment 2 bulbs are turned on (1st, 2nd) and both of them shine.
     *      At 2th moment 3 bulbs are turned on (1st, 2nd, 3rd) and all of them shine.
     *      At 3th moment 4 bulbs are turned on (1st, 2nd, 3rd, 5th), but 5th bulb does not shine because the previous one(4th) is not turn on.
     *      At 4th moment 5 bulbs are turned on and all shine.
     *
     *      there are 3 moments(1th, 2th, 4th) when every turned on bulb shines.
     *
     * Example02
     *      Given A=[2,3,4,1,5], should return 2. (3, 4 moments)
     *
     * Example03
     *      Given A=[1,3,4,2,5], should return 3 (0, 3, 4 moments)
     *
     * @param ints  different integers from 1 to N
     * @return      the number of moments for which every turned on bulb shines
     */
    public int solution(int... ints){
        Set<Integer> shineBulbs = new HashSet<>();
        Set<Integer> turnOnBulbs = new HashSet<>();
        Set<Integer> shineMoments = new HashSet<>();
        for (int i = 0; i < ints.length; i++) {
            turnOnBulbs.add(ints[i]);
            for (Integer turnOnBulb : turnOnBulbs) {
                if(isShine(turnOnBulb, turnOnBulbs)){
                    shineBulbs.add(turnOnBulb);
                }
            }
            if(shineBulbs.size() == turnOnBulbs.size()) {
                shineMoments.add(i);
            }
        }
        System.out.println(shineMoments);
        return shineMoments.size();
    }
    private boolean isShine(int nth, Set<Integer> turnedOnBulbs){
        int previous = nth-1;
        if(nth == 1){
            return turnedOnBulbs.contains(nth);
        }else {
            return turnedOnBulbs.contains(previous) && isShine(previous, turnedOnBulbs);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Exam02().solution(2,1,3,5,4));
    }
}
