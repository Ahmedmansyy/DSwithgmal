package Assignment_4.DSwithgmal;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DS_Elgmal {
    static Scanner cin = new Scanner(System.in);
    static int prime, a;
    public static int privatexa, Ya, M, i,
            S1, invers, S2, V1, V2, y;

    public static void prime() {
        boolean flag = false, flag2;
        do {
            System.out.println("Enter the prime num ");
            prime = cin.nextInt();

            for (int i = 2; i <= prime / 2; ++i) {
                // condition for nonprime number
                if (prime % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(prime + " is a prime number.");
            else {
                System.out.println(prime + " is not a prime number.");
            }
            flag2 = flag;
            flag = false;
        } while (flag2 == true);

    }

    public static int power(int base, int exponent) {
        int result = 0;

        if (exponent == 0) {
            result = 1;
        } else if (exponent == 1) {
            result = base;
        } else if (exponent > 1) {
            // result = 2147483647;
            result = base * power(base, exponent - 1);
        }

        // if (result == 0 || result == 2147483647) {
        // calcmod(base, exponent);
        // }

        int resultTemp = result;
        result = 0;
        return resultTemp;
    }

    public static int calcmod(int base, int power) {
        y = 1;
        double pow = power / 5; // 103 /5 = 20.6 ...100/5 = 20.00
        int divi = power % 5; // 3 ... 0

        if (divi == 0) {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % prime;
                y = y * x;
            }
        } else {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % prime;
                y = y * x;
            }
            y = y * power(base, divi) % prime;
        }

        return y;
    }

    public static int calcmodinverse(int base, int power) {
        y = 1;
        double pow = power / 5; // 103 /5 = 20.6 ...100/5 = 20.00
        int divi = power % 5; // 3 ... 0

        if (divi == 0) {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % prime - 1;
                y = y * x;
            }
        } else {
            int px = prime - 1;
            for (int i = 0; i < (int) pow; i++) {

                int x = power(base, 5) % px;
                y = y * x;
            }
            y = y * power(base, divi) % px;
        }

        return y;
    }

    public static void iANDd() {
        System.out.println("Plz enter the value of a");
        a = cin.nextInt();
        System.out.println("enter the private value");
        privatexa = cin.nextInt();
        System.out.println("enter Hash number");
        M = cin.nextInt();
        System.out.println("enter Random number");
        i = cin.nextInt();
        // i = ThreadLocalRandom.current().nextInt(prime - 1);
        // System.out.println(" your random chosen number is number : " + i);

        if ((a >= 1 && a < prime - 1) && (privatexa >= 1 && privatexa < prime - 1)
                && (M >= 0 && M < prime - 1) && (i >= 0 && i < prime - 1)) {
            System.out.println("a = " + a);
            System.out.println("private = " + privatexa);
            System.out.println("Hash of M = " + M);
            System.out.println("choose i = " + i);
        } else {
            System.out.println("plz try with correct answer");
            iANDd();
        }
    }

    public static int calcpublicKry(int aas, int privatenum, int primenum) {
        Ya = calcmod(aas, privatenum) % primenum;

        return Ya;
    }

    public static int calcS1(int aas, int Random, int primenum) {
        S1 = calcmod(aas, Random) % primenum;

        return S1;
    }

    public static int clacinvares(int Random, int primenum) {
        int prr = primenum - 2;
        invers = calcmodinverse(Random, prr);

        return invers;
    }

    public static int calcS2(int invers, int M, int privateKey, int S1, int primenum) {
        int pz = primenum - 1;
        int S2_1 = invers * (M - (privateKey * S1));
        int S2_2 = S2_1 * -1;
        int S2_3 = (S2_2 / pz) + 1;
        int S2_4 = S2_3 * pz;
        S2 = S2_4 - S2_2;

        return S2;
    }

    public static boolean vari(int a, int M, int Ya, int S1, int S2, int primenum) {
        V1 = calcmod(a, M);
        V2 = (power(Ya, S1) * power(S1, S2)) % primenum;

        boolean vvaal = false;

        if (V1 == V2) {
            System.out.println("it is valid");
            vvaal = true;
        } else {
            System.out.println("it is invalied");
            vvaal = false;
        }
        return vvaal;
    }

    public static void main(String[] args) {
        prime();
        iANDd();
        System.out.println("prime Number : " + prime);
        System.out.println("public number : " + calcpublicKry(a, privatexa, prime));
        System.out.println("calculate S1 : " + calcS1(a, i, prime));
        System.out.println("calculate invers : " + clacinvares(i, prime));
        System.out.println("calculate S2 : " + calcS2(clacinvares(i, prime), M, privatexa, S1, prime));
        System.out.println(vari(a, M, Ya, S1, S2, prime));

    }
}
