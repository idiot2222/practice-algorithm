package baekjoon_onlinejudge.problem_1010;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt(); // 15
            int M = sc.nextInt(); // 29
            BigInteger ans = BigInteger.ONE;

            int temp = M-N; // 14
            for(int i = M ; i > temp ; i--) {
                ans = ans.multiply(BigInteger.valueOf(i));
            }
            for(int i = N ; i > 1 ; i--) {
                ans = ans.divide(BigInteger.valueOf(i));
            }

            System.out.println(ans);
        }
    }
}
