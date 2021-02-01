package programmers.level2.fibonacci;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] N = new int[n+1];
        N[1] = 1;

        for(int i = 2 ; i < n+1 ; i++) {
            N[i] = (N[i-1] + N[i-2]) % 1234567;
        }

        answer = N[n];
        return answer;
    }
}