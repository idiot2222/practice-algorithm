package programmers.level2.find_biggest_square;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int height = board.length;
        int width = board[0].length;
        int len = (int)Math.max(height, width);

        for(int i = 0 ; i < height ; i++) {
            for(int j = 0 ; j < width ; j++) {
                for(int k = 1 ; k < len ; k++) {
                    if(k+i >= height || k+j >= width) {
                        continue;
                    }

                    boolean temp = check(i, j, board, k);

                    if(!temp) {
                        break;
                    }
                    else {
                        if(answer < k) {
                            answer = k;
                        }
                    }
                }
            }
        }
        answer++;

        return answer*answer;
    }

    private boolean check(int x, int y, int[][] board, int n) {
        int num = board[x][y];

        for(int i = x ; i <= x+n ; i++) {
            for(int j = y ; j <= y+n ; j++) {

                int now = board[i][j];

                if(now != num) {
                    return false;
                }
            }
        }

        return true;
    }
}

