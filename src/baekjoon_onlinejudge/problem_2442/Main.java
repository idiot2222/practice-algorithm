package baekjoon_onlinejudge.problem_2442;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = N-1 ; i >= 0 ; i--) {
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

        System.out.println(sb);

        sc.close();
    }
}