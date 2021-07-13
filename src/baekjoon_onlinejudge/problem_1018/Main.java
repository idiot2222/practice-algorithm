package baekjoon_onlinejudge.problem_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        char[][] arr = new char[N][M];
        int ans = 2147483647;

        for(int i = 0 ; i < N ; i++) {
            String temp = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(N-i < 8 || M-j < 8) {
                    continue;
                }

                int temp = count(i, j, arr, ans);

                ans = Math.min(ans, temp);
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static int count(int x, int y, char[][] arr, int min) {
        int cnt1 = 0;
        int cnt2 = 0;
        char next = 'W';

        int X = x + 8;
        int Y = y + 8;

        for(int i = x ; i < X ; i++) {
            for(int j = y ; j < Y ; j++) {
                char now = arr[i][j];

                if(now != next) {
                    cnt1++;

                    if(cnt1 >= min) {
                        break;
                    }
                }

                next = reverse(next);
            }
            next = reverse(next);
        }

        next = 'B';
        for(int i = x ; i < X ; i++) {
            for(int j = y ; j < Y ; j++) {
                char now = arr[i][j];

                if(now != next) {
                    cnt2++;

                    if(cnt2 >= min) {
                        break;
                    }
                }

                next = reverse(next);
            }
            next = reverse(next);
        }

        return Math.min(cnt1, cnt2);
    }

    private static char reverse(char next) {
        if(next == 'W') {
            return 'B';
        }
        else {
            return 'W';
        }
    }
}
