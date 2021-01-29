package kakao2018.four_blocks;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        boolean[][] b = new boolean[m][n];
        char[][] c = new char[m][n];

        // c 배열에 복사
        for(int i = 0 ; i < m ; i++) {
            String s = board[i];

            for(int j = 0 ; j < n ; j++) {
                char now = s.charAt(j);

                c[i][j] = now;
            }
        }

        while(true) {
            for(int i = 0 ; i < m-1 ; i++) {
                for(int j = 0 ; j < n-1 ; j++) {
                    if(c[i][j] == ' ') {
                        continue;
                    }
                    check(i, j, b, c);
                }
            }

            int temp = erase(b, c, m, n);

            if(temp == 0) {
                break;
            }
            else {
                answer += temp;
            }

            if(!down(c, m, n)) {
                break;
            }
        }

        return answer;
    }

    private boolean down(char[][] c, int m, int n) {
        boolean bool = false;

        for(int i = m-2 ; i >= 0 ; i--) {
            for(int j = 0 ; j < n ; j++) {
                char now = c[i][j];
                if(now == ' ') {
                    continue;
                }

                int idx = findIdx(c, i, j, m);
                if(idx == -1) {
                    continue;
                }
                else {
                    swap(c, i, j, idx);
                    bool = true;
                }
            }
        }

        return bool;
    }

    private void swap(char[][] c, int i, int j, int idx) {
        char temp = c[i][j];
        c[i][j] = c[idx][j];
        c[idx][j] = temp;
    }

    private int findIdx(char[][] c, int i, int j, int m) {
        int idx = -1;

        for(int k = i+1 ; k < m ; k++) {
            if(c[k][j] == ' ') {
                idx = k;
            }
            else {
                break;
            }
        }

        return idx;
    }

    private int erase(boolean[][] b, char[][] c, int m, int n) {
        int cnt = 0;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(b[i][j]) {
                    b[i][j] = false;
                    c[i][j] = ' ';
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void check(int x, int y, boolean[][] b, char[][] c) {
        char now = c[x][y];

        if(now == c[x+1][y] && now == c[x+1][y+1] && now == c[x][y+1]) {
            b[x][y] = b[x+1][y] = b[x+1][y+1] = b[x][y+1] = true;
        }
    }
}