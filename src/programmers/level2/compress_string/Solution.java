package programmers.level2.compress_string;

class Solution {
    public int solution(String s) {
        int answer = 1001;

        int len = s.length();
        int maxLeng = len / 2;

        if(len < 2) {
            answer = len;
        }

        for(int i = 1 ; i <= maxLeng ; i++) {
            int cnt = len;
            String before = "";
            int contiCnt = 0;

            for(int j = 0 ; j < len ; j+=i) {
                if(j+i > len) {
                    break;
                }

                String now = s.substring(j, j+i);

                if(now.equals(before)) {
                    cnt -= i;
                    contiCnt++;
                }
                else {
                    before = now;

                    if(contiCnt > 0) {
                        cnt += cnt(contiCnt+1);
                        contiCnt = 0;
                    }
                }
            }

            if(contiCnt > 0) {
                cnt += cnt(contiCnt+1);
            }
            if(cnt < answer) {
                answer = cnt;
            }
        }

        return answer;
    }

    private int cnt(int n) {
        int ans = 0;

        while(n > 0) {
            n /= 10;
            ans++;
        }

        return ans;
    }
}
