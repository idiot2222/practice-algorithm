package baekjoon_onlinejudge.problem_4796;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = 0;
        int P = 0;
        int V = 0;
        int cnt = 0;

        while (true) {
            L = sc.nextInt();
            P = sc.nextInt();
            V = sc.nextInt();

            if(L == 0 && P == 0 && V == 0) {
                break;
            }

            int temp = Math.min(V % P, L);
            int ans = (V / P) * L + temp;

            System.out.println("Case "+(++cnt)+": "+ans);
        }

        sc.close();
    }
}
