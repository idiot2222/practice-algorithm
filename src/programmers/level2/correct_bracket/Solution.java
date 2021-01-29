package programmers.level2.correct_bracket;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        int len = s.length();

        for(int i = 0 ; i < len ; i++) {
            char now = s.charAt(i);

            if(now == '(') {
                stack.push(now);
            }
            else if(now == ')') {
                if(stack.size() == 0) {
                    answer = false;
                    break;
                }

                char top = stack.peek();

                if(top == '(') {
                    stack.pop();
                }
                else {
                    answer = false;
                    break;
                }
            }
        }
        if(stack.size() != 0) {
            answer = false;
        }

        return answer;
    }
}
