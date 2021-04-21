package baekjoon_onlinejudge.problem_1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] b = new boolean[1001];
        b[1] = true;

        for(int i = 2 ; i <= 1000 ; i++) {
            if(b[i]) {
                continue;
            }

            for(int j = i*2 ; j <= 1000 ; j+=i) {
                b[j] = true;
            }
        }

        int ans = 0;
        for (int i = 0 ; i < N ; i++) {
            if(!b[sc.nextInt()]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}

