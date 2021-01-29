package baekjoon_onlinejudge.problem_11726;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] D = new int[N+1];
        D[0] = D[1] = 1;

        for(int i = 2 ; i <= N ; i++) {
            D[i] = (D[i-1] + D[i-2])%10007;
        }

        System.out.println(D[N]);

        sc.close();
    }
}
