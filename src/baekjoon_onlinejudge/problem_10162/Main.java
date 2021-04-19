package baekjoon_onlinejudge.problem_10162;

import java.util.Scanner;

public class Main {
    final static int A = 300;
    final static int B = 60;
    final static int C = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int a = 0, b = 0, c = 0;

        if(T % C != 0) {
            System.out.println(-1);
        }
        else {
            while(T >= A) {
                T -= A;
                a++;
            }
            while(T >= B) {
                T -= B;
                b++;
            }
            while(T >= C) {
                T -= C;
                c++;
            }

            System.out.println(a+" "+b+" "+c);
        }
    }
}
