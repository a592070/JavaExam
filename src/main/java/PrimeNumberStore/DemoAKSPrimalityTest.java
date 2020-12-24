package PrimeNumberStore;

import java.math.BigInteger;
import java.util.Random;

public class DemoAKSPrimalityTest {


    public static void checkPrime(BigInteger bigNum){
        /**1.若存在整數a > 0 且b > 1 ，令 n = a^b ；則輸出合數*/
        int logBNum = (int)logBigNum(bigNum);
        if(determinePowerOf(bigNum)){
            System.out.println(bigNum+" is composite");
            return;
        }

        /**2.找出最小的 r 令 ord_r(n) > log_2(n)*/
        // ord_r(n) mean is: n^k = 1(mod r), for smallest k>0, k is integer
        BigInteger k =BigInteger.ONE;
        BigInteger r =BigInteger.ONE;

        do {
            r = r.add(BigInteger.ONE);
            k = multiplicativeOrder(bigNum,r);
        }while(k.doubleValue() < Math.pow(logBigNum(bigNum),logBigNum(bigNum)));

        /**3. If 1 < gcd(a,n) < n for some a <= r, output COMPOSITE*/
        for(BigInteger i= BigInteger.valueOf(2); i.compareTo(r)<=0; i=i.add(BigInteger.ONE)){
            BigInteger gcd = bigNum.gcd(i);
            if(gcd.compareTo(BigInteger.ONE) >0 && gcd.compareTo(bigNum) <0){
                System.out.println(bigNum+" is composite");
                return;
            }
        }

        /**4. If n <= r, output PRIME*/
        if(bigNum.compareTo(r) <=0){
            System.out.println(bigNum+" is prime");
            return;
        }

        /**5. For i = 1 to sqrt(totient)log(n) do
         if (X+i)^n <> X^n + i (mod X^r - 1,n), output composite;*/
        int limit = (int)(Math.sqrt(totient(r).doubleValue())*logBNum);
        // X^r - 1
        Poly modPoly = new Poly(BigInteger.ONE, r.intValue()).minus(new Poly(BigInteger.ZERO, 0));
        // X^n (mod X^r - 1, n)
        Poly partialOutcome = new Poly(BigInteger.ONE, 1).modPow(bigNum, modPoly, bigNum);
        for (int i = 1; i < limit; i++) {
            Poly polyI = new Poly(BigInteger.valueOf(i),0);
            // X^n + i (mod X^r - 1, n)
            Poly outcome = partialOutcome.plus(polyI);
            Poly p = new Poly(BigInteger.ONE, 1).plus(polyI).modPow(bigNum, modPoly, bigNum);
            if( !outcome.equals(p)){
                System.out.println(bigNum+" is prime");
                return;
            }
        }
        System.out.println(bigNum+" is prime");

    }
    //找log
    public static double logBigNum(BigInteger bigNum){
        String str;
        int len;
        double num1,num2;
        str = "."+bigNum.toString();        // .xxxxx   .11
        len = str.length()-1;               // 5        2

        num1 = Double.parseDouble(str);     // 0.xxxxx = xxxxx*(10^-5)      0.11 = 11*(10^-2)
        num2 = Math.log10(num1) + len;      // (-5+log(xxxxx))+5            -2+log(11) +2
        return num2/Math.log10(2);          // log2(n) = log10(n)/log10(2)
    }

    /**1.若存在整數a > 0 且b > 1 ，令 n = a^b ；則輸出合數*/
    //function given a BigNumber n, determine that a^b = n  <=> 0 = a^b (mod n)
    // true: n is composite
    // false: next step
    public static boolean determinePowerOf(BigInteger bigNum){
        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(2);
        while(a.compareTo(bigNum.sqrt()) <= 0){
            while(b.compareTo(bigNum.sqrt()) <= 0) {
                // a^b (mod n)
                if (a.modPow(b, bigNum).equals(BigInteger.valueOf(0))) {
                    return true;
                }
                b = b.add(BigInteger.ONE);
            }
            a = a.add(BigInteger.ONE);
            b = BigInteger.valueOf(2);
        }

        return false;
    }

    /**2.找出最小的 r 令 ord_r(n) > log_2(n)*/
    // ord_r(n) mean is: n^k = 1(mod r), for smallest k>0, k is integer
    /*public static BigInteger findOrder(BigInteger bigNum){
        BigInteger k =BigInteger.ONE;
        BigInteger r =BigInteger.ONE;

        do {
            r = r.add(BigInteger.ONE);
            k = multiplicativeOrder(bigNum,r);
        }while(k.doubleValue() < Math.pow(logBigNum(bigNum),logBigNum(bigNum)));

        return r;
    }*/
    public static BigInteger multiplicativeOrder(BigInteger bigNum, BigInteger r){
        BigInteger k = BigInteger.ZERO;
        BigInteger result;

        do {
            k = k.add(BigInteger.ONE);          // k++
            result = bigNum.modPow(k, r);       // n^k (mod r)
        }
        while(result.compareTo(BigInteger.ONE) != 0 && r.compareTo(k)>0);

        if(r.compareTo(k)<=0) return BigInteger.ONE.negate();
        else{
            return k;
        }
    }

    /**Calculate the totient of a BigInteger r
     * totient(r) is number of coprime wuth r*/
    public static BigInteger totient(BigInteger bigNum){
        BigInteger result = bigNum;
        for(BigInteger i=BigInteger.valueOf(2); bigNum.compareTo(i.multiply(i)) >0; i = i.add(BigInteger.ONE)){
            if(bigNum.mod(i).compareTo(BigInteger.ZERO) == 0){
                result = result.subtract(result.divide(i));
            }
            while (bigNum.mod(i).compareTo(BigInteger.ZERO) == 0){
                bigNum = bigNum.divide(i);
            }
        }
        if(bigNum.compareTo(BigInteger.ONE) >0){
            result = result.subtract(result.divide(bigNum));
        }
        return result;
    }

    public static void main(String[] args) {
        /*BigInteger bigNum = new BigInteger(10,new Random());
        System.out.println(bigNum);
        System.out.println(bigNum.bitLength());
        double tmp;
        tmp = logBigNum(bigNum);
        System.out.println(tmp);*/

        BigInteger test = BigInteger.valueOf(101);
        BigInteger prime = BigInteger.probablePrime(10000,new Random());
        System.out.println(prime);


        /*System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Math.ceil(0.1));
        System.out.println(Math.floor(0.1));*/


//        System.out.println(BigMath.logBigInteger(bigNum));


    }


}
