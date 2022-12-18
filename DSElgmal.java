package Assignment_4.DSwithgmal;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DSElgmal {
    static Scanner cin = new Scanner(System.in);
    static int prime, Alpha, d, Beta, Mass,
            Ke, r, s, t, y, i, invers, V1, t2;

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

    public static int calcmod(int base, int power, int primee) {
        y = 1;
        double pow = power / 5; // 103 /5 = 20.6 ...100/5 = 20.00
        int divi = power % 5; // 3 ... 0

        if (divi == 0) {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % primee;
                y = (y * x) % primee;
            }
        } else {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % primee;
                y = (y * x) % primee;
            }
            y = y * power(base, divi) % primee;
        }
        y = y % primee;
        return y;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static void iANDd() {
        System.out.println("Plz enter the value of Alpha");
        Alpha = cin.nextInt();
        System.out.println("enter the d value");
        d = cin.nextInt();
        System.out.println("enter Massage number");
        Mass = cin.nextInt();
        // System.out.println("enter Ke number");
        // Ke = cin.nextInt();
        Ke = ThreadLocalRandom.current().nextInt(prime - 1);
        System.out.println(" your random chosen number is number : " + Ke);

        int px = prime - 1;
        while (gcd(Ke, px) != 1) {
            Ke = ThreadLocalRandom.current().nextInt(prime - 1);

        }
        System.out.println(" your random chosen number is number : " + Ke);

        if ((Alpha >= 1 && Alpha < prime - 1) && (d >= 2 && d < prime - 2)
                && (Ke >= 0 && Ke < prime - 2)) {
            System.out.println("Alpha = " + Alpha);
            System.out.println("private d = " + d);
            System.out.println("Hash of Massage = " + Mass);
            System.out.println("choose Ke = " + Ke);
        } else {
            System.out.println("plz try with correct answer");
            iANDd();
        }
    }

    public static int BETA(int aas, int privatenum, int primenum) {
        Beta = calcmod(Alpha, d, primenum);
        return Beta;
    }

    public static int R(int aas, int Random, int primenum) {
        r = calcmod(aas, Random, primenum);
        return r;
    }

    public static int clacinvares(int Random, int primenum) {
        int prr = primenum - 1;
        invers = calcmod(Random, primenum, prr);

        return invers;
    }

    public static int S(int invers, int Mass, int d, int r, int primenum) {
        int prr = primenum - 1;
        int multi = (d * r);
        int soo = (Mass - multi);
        int fs = (soo * invers) % prr;
        if (fs < 0) {
            s = prr + fs;
        }
        return s;
    }

    public static boolean vari(int Beta, int M, int r, int S, int Alpha, int primenum) {
        t2 = calcmod(Beta, r, primenum) * calcmod(r, s, primenum) % primenum;

        V1 = calcmod(Alpha, M, primenum);

        boolean vvaal = false;

        if (V1 == t2) {
            System.out.println("it is valid");
            vvaal = true;
        } else {
            System.out.println("it is invalied");
            vvaal = false;
        }
        return vvaal;
    }

    public static void main(String[] args) {

        // System.out.println(power(10, 5));
        // System.out.println(calcmod(10, 50, 43));

        prime();
        iANDd();
        System.out.println("prime Number : " + prime);
        System.out.println("Beta: " + BETA(Alpha, d, prime));
        System.out.println("calculate r : " + R(Alpha, Ke, prime));
        System.out.println("calculate invers : " + clacinvares(Ke, prime));
        System.out.println("calculate S : " + S(invers, Mass, d, r, prime));
        System.out.println("calculate varify : " + vari(Beta, Mass, r, s, Alpha, prime));
        System.out.println("t2 is " + t2 + " v1 is " + V1);

        // System.out.println(power(10, 10));

        // System.out.println(gcd(5, 28));
    }
}
