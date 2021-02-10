package baekjoon_onlinejudge.problem_1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N ; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (x, y) -> {
            if(x[1] == y[1]) {
                return Integer.compare(x[0], y[0]);
            }
            else {
                return Integer.compare(x[1], y[1]);
            }
        });

        int endTime = -1;

        for(int i = 0; i < N ; i++) {
            if(arr[i][0] >= endTime) {
                endTime = arr[i][1];
                answer++;
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
