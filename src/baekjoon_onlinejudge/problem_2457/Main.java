package baekjoon_onlinejudge.problem_2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for(int i = 0 ; i < N ; i++) {
            String[] temp = br.readLine().split("\\s");

            flowers[i][0] += Integer.parseInt(temp[0]) * 100;
            flowers[i][0] += Integer.parseInt(temp[1]);
            flowers[i][1] += Integer.parseInt(temp[2]) * 100;
            flowers[i][1] += Integer.parseInt(temp[3]);
        }

        Arrays.sort(flowers, (x, y) -> {
            if(x[0] == y[0]) {
                return x[1] - y[1];
            }
            else {
                return x[0] - y[0];
            }
        });

        int startDate = 301;
        int endDate = 0;
        final int END = 1130;
        int ans = 0;

        for(int i = 0 ; i < N ; i++) {
            int nowStart = flowers[i][0];
            int nowEnd = flowers[i][1];

            if(nowStart <= startDate && endDate < nowEnd) {
                endDate = nowEnd;

                if(endDate > END) {
                    ans++;
                    break;
                }
            }
            else if(endDate < nowStart) {
                ans = 0;
                break;
            }
            else if(nowStart > startDate) {
                ans++;

                startDate = endDate;
                i--;
            }
        }

        if(endDate <= END) {
            ans = 0;
        }

        System.out.println(ans);
        br.close();
    }
}