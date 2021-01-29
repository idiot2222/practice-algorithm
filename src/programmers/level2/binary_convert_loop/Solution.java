package programmers.level2.binary_convert_loop;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int ans = 0;

        while(!s.equals("1")) {
            ans++;

            int temp = s.length();

            s = removeZero(s);
            cnt += temp - s.length();

            s = Integer.toBinaryString(s.length());
        }

        answer[0] = ans;
        answer[1] = cnt;

        return answer;
    }

    private String removeZero(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cnt = 0;

        for(int i = 0 ; i < len ; i++) {
            if(s.charAt(i) == '1') {
                cnt++;
            }
        }

        for(int i = 0 ; i < cnt ; i++) {
            sb.append('1');
        }

        return sb.toString();

    }
}