package baekjoon_onlinejudge.problem_11050;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 1;

        for(int i = 1 ; i <= K ; i++) {
            ans *= N--;
            ans /= i;
        }

        System.out.println(ans);
    }
}
