package baekjoon_onlinejudge.problem_1439;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int len = s.length();

        int ans = 0;

        char c = s.charAt(0);
        boolean b = false;
        for(int i = 1 ; i < len ; i++) {
            char now = s.charAt(i);

            if(now != c) {
                b = true;

                continue;
            }

            if(b) {
                b = false;

                ans++;
            }
        }

        if(b) {
            ans++;
        }

        System.out.println(ans);
    }
}