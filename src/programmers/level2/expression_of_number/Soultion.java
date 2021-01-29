package programmers.level2.expression_of_number;

class Solution {
    public int solution(int n) {
        int answer = 1;

        int len = n/2;
        for(int i = 1 ; i <= len ; i++) {
            int num = n;
            int temp = i;

            while(num >= 0) {
                if(num == 0) {
                    answer++;
                }

                num -= temp;
                temp++;
            }
        }

        return answer;
    }
}