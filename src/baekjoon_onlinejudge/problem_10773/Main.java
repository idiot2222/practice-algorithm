package baekjoon_onlinejudge.problem_10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        while(K-- > 0) {
            int temp = sc.nextInt();

            if(temp == 0 && stack.size() > 0) {
                stack.pop();
            }
            else {
                stack.push(temp);
            }
        }

        int ans = 0;
        for (Integer integer : stack) {
            ans += integer;
        }

        System.out.println(ans);
    }
}
