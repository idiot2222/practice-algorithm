package baekjoon_onlinejudge.problem_1037;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = 2147483647;
        int max = 0;

        for(int i = 0 ; i < N ; i++) {
            int temp = sc.nextInt();

            if(temp < min) {
                min = temp;
            }
            if(temp > max) {
                max = temp;
            }
        }

        System.out.println(min * max);
        sc.close();
    }
}
