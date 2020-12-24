package PrimeNumberStore;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 1. get 2 random prime number(p,q) in TestBufferReader.textGetIntArray which is return int[]
 * 2. r = (p-1)*(q-1) , N = p*q
 * 3. choose a number "e" such that gcd(e,r)==1, just choose a random prime again
 * 4. find a "d" s.t. (d*e)%r ==1
 * 5. (N,e) is public key, (N,d) is prime key
 *
 * if a message "m" be send by A to B
 * encode c = (m^e)%N
 *
 * then, B get code c
 * decode m = (c^d)%N
 *
 * */
public class RSACodeDemo {

    static final long P = getPrime();
    static final long Q = getPrime();
    static long N = P*Q;
    static long r = (P-1)*(Q-1);
    static long E = getE();
    static long d = getD();

    public static void main(String[] args) {
        System.out.println("P is " + P + "\tQ is " + Q + "\tN is " + N + "\tr is " + r + "\tE is " + E + "\td is " + d);
        System.out.print("Enter a string: ");
        String input = new Scanner(System.in).nextLine();

        //input: 輸入的String
        //arr: 儲存input轉為ASCII後的ArrayList
        //arrEncode: 儲存arr每個元素Encode後的BigInteger
        //arrDecode: 儲存arrEncode每個元素Decode後的Integer
        //str: arrDecode透過ASCIIToString轉為String
        ArrayList<Integer> arr = StringToASCII.StringToASCII(input);
        ArrayList<BigInteger> arrEncode = new ArrayList<>();
        ArrayList<Integer> arrDecode = new ArrayList<>();

        arr.forEach(num->{
            arrEncode.add(publicCode(num));
        });
        System.out.println("Public code is ("+ N+" , "+E+")\nEncode : " + arrEncode);

        arrEncode.forEach(num->{
            int tmp = privateCode(num).intValue();

            arrDecode.add(tmp);
        });
        System.out.println("Private code is ("+ N+" , "+d+")\nDecode : "+arrDecode);

        String str = StringToASCII.ASCIIToString(arrDecode);
        System.out.println(str);



    }
    //從TestBufferReaderDemo讀已經寫好的prime
    static long getPrime() {
        long primeNum;

        int[] primeInt = new TestBufferReaderDemo().textGetIntArray();
        primeNum = primeInt[new Random().nextInt(primeInt.length)];
        return primeNum;


    }
    //從質數中找，與 r=(p-1)(q-1) 互質
    static long getE(){
        int[] primeInt = new TestBufferReaderDemo().textGetIntArray();
        int num = 0;
        for (int i = 0; i < primeInt.length; i++) {
            if(r%primeInt[i] != 0){
                num = primeInt[i];
                break;
            }
        }
        return num;
    }

    // d*e =1 mod(r)
    static long getD(){
        long i = 1;
        while((i * E)%r != 1){
            ++i;
        }
        return i;
    }
    //用 BigInteger 避免益位
    // c = m^e (mod N)
    // m = c^d (mod N)
    static BigInteger publicCode(int m){
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigE = BigInteger.valueOf(E);
        BigInteger bigN = BigInteger.valueOf(N);
        return bigM.modPow(bigE,bigN);
    }
    static BigInteger privateCode(BigInteger c){

        BigInteger bigD = BigInteger.valueOf(d);
        BigInteger bigN = BigInteger.valueOf(N);
        return c.modPow(bigD,bigN);
    }

}

