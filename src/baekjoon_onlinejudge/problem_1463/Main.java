package baekjoon_onlinejudge.problem_1463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] D = new int[N+1];

        D[1] = 0;
        for(int i = 2 ; i <= N ; i++) {
            int min = 100001;
            int temp = 0;

            if(i % 3 == 0) {
                temp = D[i/3];
                min = Math.min(min, temp);
            }
            if(i % 2 == 0) {
                temp = D[i/2];
                min = Math.min(min, temp);
            }
            temp = D[i-1];
            min = Math.min(min, temp);

            D[i] = min+1;
        }

        System.out.println(D[N]);
    }
}
