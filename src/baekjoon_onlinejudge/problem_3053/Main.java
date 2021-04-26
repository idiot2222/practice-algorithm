package baekjoon_onlinejudge.problem_3053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double PI = 3.14159265358979;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.printf("%.6f\n", PI * n * n);
        System.out.printf("%.6f", 2.0 * n * n);

        sc.close();
    }
}
