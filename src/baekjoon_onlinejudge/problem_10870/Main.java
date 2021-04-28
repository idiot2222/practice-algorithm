package baekjoon_onlinejudge.problem_10870;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = fib(N);

        System.out.println(ans);

        sc.close();
    }

    private static int fib(int n) {
        if(n <= 1) {
            return n;
        }

        return fib(n-2) + fib(n-1);
    }
}
