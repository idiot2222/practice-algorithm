package baekjoon_onlinejudge.problem_4948;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] b = new boolean[246913];

        for(int i = 2 ; i <= 246912 ; i++) {
            if(b[i]) {
                continue;
            }

            for(int j = i+i ; j <= 246912 ; j+=i) {
                b[j] = true;
            }
        }

        while(true) {
            int now = sc.nextInt();

            if(now == 0) {
                break;
            }

            int cnt = 0;
            for(int i = now+1 ; i <= now * 2 ; i++) {
                if(!b[i]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
