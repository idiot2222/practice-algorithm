package baekjoon_onlinejudge.problem_15649;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] b = new boolean[N+1];
        int[] arr = new int[M];
        go(0, N, M, arr, b);
    }

    private static void go(int idx, int N, int M, int[] arr, boolean[] b) {
        if(idx >= M) {
            print(arr);
            return;
        }

        for(int i = 1 ; i <= N ; i++) {
            if(b[i]) {
                continue;
            }

            b[i] = true;
            arr[idx] = i;
            go(idx+1, N, M, arr, b);
            b[i] = false;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
