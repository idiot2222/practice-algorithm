package programmers.level2.max_value;

import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;

        String[] numbers = expression.split("[-+*]");
        String[] operators = expression.split("[0-9]{1,3}");

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(operators));
        System.out.println(operators.length);

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("200-200+300*100"));
    }
}
