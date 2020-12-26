package programmers.level2.coloring_book;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] pic = new int[m][n]; // 이상하게 통과가 안돼서 다른 분들 풀이를 봤더니
                                     // picture 배열을 직접 쓰지말고 복사해서 쓰면
                                     // 통과가 된다고 하더라~
        for(int i = 0 ; i < m ; i++) {
            if (n >= 0) System.arraycopy(picture[i], 0, pic[i], 0, n);
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                int now = pic[i][j];
                if(now != 0) {
                    int temp = erase(i, j, pic, now, m, n);

                    if(temp > maxSizeOfOneArea) {
                        maxSizeOfOneArea = temp;
                    }
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int erase(int x, int y, int[][] pic, int color, int m, int n) {
        pic[x][y] = 0;
        int ans = 1;

        int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
        for(int i = 0 ; i < 4 ; i++) {
            int X = x+dx[i], Y = y+dy[i];

            while(X >= 0 && X < m && Y >= 0 && Y < n && pic[X][Y] == color) {
                ans += erase(X, Y, pic, color, m, n);
            }
        }

        return ans;
    }
}