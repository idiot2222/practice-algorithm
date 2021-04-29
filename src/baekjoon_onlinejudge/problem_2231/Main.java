package baekjoon_onlinejudge.problem_2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;

        for(int i = 1 ; i < N ; i++) {
            int temp = cal(i);

            if(temp == N) {
                ans = i;

                break;
            }
        }

        System.out.println(ans);
    }

    private static int cal(int num) {
        int ans = num;

        while(num != 0) {
            ans += num % 10;

            num /= 10;
        }

        return ans;
    }
}
