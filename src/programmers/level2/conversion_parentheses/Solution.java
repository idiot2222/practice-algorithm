package programmers.level2.conversion_parentheses;

import java.util.*;

class Solution {
    public String solution(String w) {
        String answer;

        int len = w.length();

        if(len == 0) {
            return w;
        }

        int p = dividePoint(w);
        String u = w.substring(0, p);
        String v = w.substring(p, len);

        if(check(u)) {
            u += solution(v);

            answer = u;
        }
        else {
            String s = "(";
            s += solution(v);
            s += ")";
            s += convert(u);

            answer = s;
        }

        return answer;
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();

        for(int i = 0 ; i < len ; i++) {
            char now = sb.charAt(i);

            if(now == '(') {
                sb.replace(i, i+1, ")");
            }
            else {
                sb.replace(i, i+1, "(");
            }
        }

        if(len > 0) {
            sb.delete(len-1, len);
            sb.delete(0, 1);
        }

        return sb.toString();
    }

    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        stack.push(s.charAt(0));
        for(int i = 1 ; i < len ; i++) {
            char now = s.charAt(i);

            if(stack.peek() == '(' && now == ')') {
                stack.pop();
            }
            else if(stack.peek() == ')') {
                return false;
            }
            else {
                stack.push(now);
            }
        }

        return true;
    }

    private int dividePoint(String s) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        int len = s.length();
        int left = 0, right = 0;

        while(idx < len) {
            if(left != 0 && left == right) {
                return idx;
            }

            char temp = s.charAt(idx++);

            stack.push(temp);
            if(temp == '(') {
                left++;
            }
            else {
                right++;
            }
        }

        return len;
    }
}