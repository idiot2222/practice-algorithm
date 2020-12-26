package programmers.level2.biggest_number;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        int len = numbers.length;
        String[] num = new String[len];

        for(int i = 0 ; i < len ; i++) {
            num[i] = new String(new char[5]).replace("\0", String.valueOf(numbers[i]));
        }

        Arrays.sort(num, Comparator.reverseOrder());

        for(String string : num) {
            string = compress(string);

            answer.append(string);
        }

        deleteZero(answer);
        return answer.toString();
    }

    private void deleteZero(StringBuilder sb) {
        while(true) {
            if(sb.length() != 1 && sb.charAt(0) == '0') {
                sb.delete(0, 1);
            }
            else {
                break;
            }
        }
    }

    private String compress(String s) {
        int len = s.length();

        return s.substring(0, len/5);
    }
}
