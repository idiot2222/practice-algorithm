package baekjoon_onlinejudge.problem_2581;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int ans = 0;
        int min = 2147483647;

        boolean[] b = new boolean[N + 1];
        b[1] = true;

        for (int i = 2; i <= N; i++) {
            if (b[i]) {
                continue;
            }

            if (i >= M) {
                ans += i;

                if (min > i) {
                    min = i;
                }
            }
            for (int j = i * 2; j <= N; j += i) {
                b[j] = true;
            }
        }

        if (ans == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
            System.out.println(min);
        }
    }
}
