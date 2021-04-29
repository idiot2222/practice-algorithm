package baekjoon_onlinejudge.problem_2798;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int ans = 0;

        for(int i = 0 ; i < N ; i++) {
            arr[i] = sc.nextInt();
        }

        loop:
        for(int i = 0 ; i < N ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                for(int k = j+1 ; k < N ; k++) {
                    int temp = arr[i] + arr[j] + arr[k];

                    if(temp <= M && temp > ans) {
                        ans = temp;
                    }
                    if(ans == M) {
                        break loop;
                    }
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
