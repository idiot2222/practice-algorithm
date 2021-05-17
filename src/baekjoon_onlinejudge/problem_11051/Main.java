package baekjoon_onlinejudge.problem_11051;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        BigInteger ans = BigInteger.ONE;

        for(int i = 1 ; i <= K ; i++) {
            ans = ans.multiply(BigInteger.valueOf(N--));
            ans = ans.divide(BigInteger.valueOf(i));
        }

        System.out.println(ans.mod(BigInteger.valueOf(10007)));
    }
}
