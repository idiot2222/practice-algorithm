package samsung.p_11688;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 1 ; i <= T ; i++) {
            String str = sc.nextLine();
            int len = str.length();

            int a = 1, b = 1;
            for(int j = 0 ; j < len ; j++) {
                char now = str.charAt(j);

                if(now == 'L') {
                    b = a + b;
                }
                else {
                    a = a + b;
                }
            }

            System.out.println("#"+i+" "+a+" "+b);
        }
    }
}
