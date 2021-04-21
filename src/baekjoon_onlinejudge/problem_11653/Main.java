package baekjoon_onlinejudge.problem_11653;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int now = 2;

        while(N > 1) {
            if(N % now != 0) {
                now++;
                continue;
            }

            N /= now;
            System.out.println(now);
        }


        sc.close();
    }
}
