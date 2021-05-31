package baekjoon_onlinejudge.problem_2446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(j >= i) {
                    sb.append("*");
                    if(j != N-1) {
                        sb.append("*");
                    }
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        String[] split = sb.toString().split("\n");
        for(int i = N-2 ; i >= 0 ; i--) {
            sb.append(split[i]).append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}