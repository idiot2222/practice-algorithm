package kakao2018.dart_game;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int len = dartResult.length();
        int before = 0;
        int after = 0;
        for(int i = 0 ; i < len ; i++) {
            char now = dartResult.charAt(i);

            if(after == 1 && now == '0') {
                after = 10;
            }
            else if(now >= '0' && now <= '9') {
                answer += before;
                before = after;
                after = now - '0';
            }
            else if(now == 'D') {
                after *= after;
            }
            else if(now == 'T') {
                after *= after * after;
            }
            else if(now == '*') {
                after *= 2;
                before *= 2;
            }
            else if(now == '#') {
                after *= -1;
            }
        }

        answer += before;
        answer += after;

        return answer;
    }
}

