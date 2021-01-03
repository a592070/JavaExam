package codility.exam104;

import java.util.HashSet;
import java.util.Set;

/**
 * There are N empty glasses with a capacity of 1,2,...,N liters(there is exactly one glass of each unique capacity)
 * You want to pour exactly K liters of water into glasses.
 * Each glass may be either full or empty(a glass cannot be partially filled).
 * What is the minimum number of glasses that you need to contain K liters of water?
 *
 */
public class Exam01 {

    /**
     * Example1
     *      Given N=5, K=8, should return 2.You can use 2 glasses with capacity 3,5 to hold 8 liters of water
     * Example2
     *      Given N=4, K=10, should return 4. (1,2,3,4)
     * Example3
     *      Given N=1, K=2, should return -1.
     * Example4
     *      Given N=10, K=5, should return 1. (5)
     *
     * @param N empty glasses with a capacity of 1,2,...,N liters
     * @param K K liters of water
     * @return  return the minimum number of glasses that are needed to contain exactly K liters of water.
     *          If it is not possible to pour exactly K liters of water into glasses then the function should return -1.
     */

    public int solution(int N, int K){

        if(N >= K) return 1;
        int sumN = N*(N+1)/2;
        if(sumN < K){
            return -1;
        }else if(sumN == K){
            return N;
        }else{
            int water = N;
            int maxCapacity = K;
            Set<Integer> usedGlasses = new HashSet<>();
            while(maxCapacity > 0){
                int toFill = Math.min(water, maxCapacity);
                for (int i = toFill; i > 0; i--) {
                    if(!usedGlasses.contains(i)){
                        usedGlasses.add(i);
                        maxCapacity -= i;
                        break;
                    }
                }
            }
            System.out.println(usedGlasses);
            return usedGlasses.size();
        }
    }
    public static void main(String[] args) {
        System.out.println(new Exam01().solution(5, 10));
    }

}
