package baekjoon_onlinejudge.problem_1080;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] base = new int[N][M];
        int[][] target = new int[N][M];

        int ans = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                base[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                target[i][j] = s.charAt(j) - '0';
            }
        }

        boolean isEqual = false;
        while(!isEqual) {
            int max = 0;
            int x = -1, y = -1;

            for(int i = 1 ; i < N-1 ; i++) {
                for(int j = 1 ; j < M-1 ; j++) {
                    int temp = count(i, j, base, target, N, M);

                    if(temp > max) {
                        max = temp;
                        x = i;
                        y = j;
                    }
                }
            }

            isEqual = reverseAndCheck(x, y, base, target, N, M);
            ans++;
        }

        System.out.println(ans);
        sc.close();
    }

    private static boolean reverseAndCheck(int x, int y, int[][] base, int[][] target, int N , int M) {
        boolean check = true;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(i >= x-1 && i <= x+1 && j >= y-1 && j <= y+1) {
                    if(base[i][j] == 0) {
                        base[i][j] = 1;
                    }
                    else {
                        base[i][j] = 0;
                    }
                }

                if(check && base[i][j] != target[i][j]) {
                    check = false;
                }
            }
        }

        return check;
    }

    private static int count(int x, int y, int[][] base, int[][] target, int N, int M) {
        int cnt = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(base[x+i][y+j] != target[x+i][y+j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
