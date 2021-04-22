package baekjoon_onlinejudge.problem_9020;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean[] b = new boolean[10001];
        b[0] = b[1] = true;

        for(int i = 2 ; i <= 10000 ; i++) {
            if(b[i]) {
                continue;
            }

            for(int j = i*2 ; j <= 10000 ; j += i) {
                b[j] = true;
            }
        }

        while(T-- > 0) {
            int n = sc.nextInt();
            int small = 0, big = 0;

            for(int i = n/2 ; i >= 2 ; i--) {
                if(!b[i] && !b[n - i]) {
                    small = Math.min(i, n-i);
                    big = Math.max(i, n-i);

                    break;
                }
            }

            System.out.println(small + " " + big);
        }
    }
}
