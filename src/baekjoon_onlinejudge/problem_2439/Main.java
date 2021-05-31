package baekjoon_onlinejudge.problem_2439;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++) {
            int temp = N - i;
            for(int j = 0 ; j < temp ; j++) {
                sb.append(" ");
            }
            for(int j = 0 ; j < i ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}
