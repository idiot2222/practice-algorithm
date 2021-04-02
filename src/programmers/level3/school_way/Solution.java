package programmers.level3.school_way;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] map = new int[n][m];
        map[0][0] = 1;

        draw(map, puddles);

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(map[i][j] == -1 || i == 0 && j == 0) {
                    continue;
                }

                int temp = 0;
                if(j != 0 && map[i][j-1] != -1) {
                    temp += map[i][j-1] % MOD;
                }
                if(i != 0 && map[i-1][j] != -1) {
                    temp += map[i-1][j] % MOD;
                }

                map[i][j] = temp % MOD;
            }
        }

        return map[n-1][m-1];
    }

    public void draw(int[][] map, int[][] puddles) {
        for(int[] puddle : puddles) {
            int y = puddle[0]-1;
            int x = puddle[1]-1;

            map[x][y] = -1;
        }
    }
}