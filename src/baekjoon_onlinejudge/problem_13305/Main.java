package baekjoon_onlinejudge.problem_13305;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] distance = new int[N-1];
        int[] price = new int[N];

        for(int i = 0 ; i < N-1 ; i++) {
            distance[i] = sc.nextInt();
        }
        for(int i = 0 ; i < N ; i++) {
            price[i] = sc.nextInt();
        }

        long min = price[0];
        long ans = 0;

        for(int i = 0 ; i < N-1 ; i++) {
            int j = i+1;

            ans += min * distance[i];
            min = Math.min(min, price[j]);
        }

        System.out.println(ans);
    }
}
