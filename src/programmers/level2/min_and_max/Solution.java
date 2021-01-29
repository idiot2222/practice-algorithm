package programmers.level2.min_and_max;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        Integer[] arr = convert(s);
        int len = arr.length;

        Arrays.sort(arr);

        answer += arr[0]+" "+arr[len-1];

        return answer;
    }

    private Integer[] convert(String s) {
        String[] str = s.split(" ");
        int len = str.length;
        Integer[] arr = new Integer[len];

        for(int i = 0 ; i < len ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        return arr;
    }
}