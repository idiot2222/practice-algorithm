package baekjoon_onlinejudge.problem_4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        while(!line.equals(".")) {
            int len = line.length();
            String ans = "yes";
            stack.clear();

            for(int i = 0 ; i < len ; i++) {
                char now = line.charAt(i);

                if(now == '(' || now == '[') {
                    stack.push(now);
                }
                else if(now == ')') {
                    if(stack.size() == 0) {
                        ans = "no";
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        ans = "no";
                        break;
                    }
                }
                else if(now == ']') {
                    if(stack.size() == 0) {
                        ans = "no";
                        break;
                    }
                    if(stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        ans = "no";
                        break;
                    }
                }
            }

            if(stack.size() != 0) {
                ans = "no";
            }

            line = sc.nextLine();
            System.out.println(ans);
        }
    }
}
