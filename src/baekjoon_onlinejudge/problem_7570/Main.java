package baekjoon_onlinejudge.problem_7570;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] idx = new int[N];
        int[] cnt = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = sc.nextInt();
            idx[arr[i]-1] = i;
        }

        cnt[0] = 0;
        int max = 0;
        for(int i = 1 ; i < N ; i++) {
            if(idx[i-1] < idx[i]) {
                cnt[i] = cnt[i-1] + 1;
            }
            if(cnt[i] > max) {
                max = cnt[i];
            }
        }

        int ans = N - max - 1;

        System.out.println(ans);
        sc.close();
    }
}
