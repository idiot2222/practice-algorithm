package programmers.level3.network;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] b = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            if(b[i]) {
                continue;
            }

            dfs(i, n, computers, b);
            answer++;
        }

        return answer;
    }

    private void dfs(int now, int n, int[][] computers, boolean[] b) {
        b[now] = true;

        for(int i = 0 ; i < n ; i++) {
            if(computers[now][i] == 1 && !b[i]) {
                dfs(i, n, computers, b);
            }
        }
    }
}