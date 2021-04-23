package baekjoon_onlinejudge.problem_4153;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 0, y = 0, z = 0;

        while(true) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();

            if(x > z) {
                int temp = x;
                x = z;
                z = temp;
            }
            if(y > z) {
                int temp = y;
                y = z;
                z = temp;
            }

            if(x == 0  && y == 0 && z == 0) {
                break;
            }

            if(z*z == x*x + y*y) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
}
