package programmers.level2.land_game;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int len = land.length;
        int[][] N = new int[len][4];

        for(int i = 0 ; i < 4 ; i++) {
            N[0][i] = land[0][i];
        }

        for(int i = 1 ; i < len ; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                int max = 0;

                for(int k = 0 ; k < 4; k++) {
                    if(j == k) {
                        continue;
                    }

                    if(max < N[i-1][k]) {
                        max = N[i-1][k];
                    }
                }
                N[i][j] = max+land[i][j];
            }
        }

        for(int i = 0 ; i < 4 ; i++) {
            int now = N[len-1][i];

            if(now > answer) {
                answer = now;
            }
        }

        return answer;
    }
}