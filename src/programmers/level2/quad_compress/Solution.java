package programmers.level2.quad_compress;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};

        int len = arr.length;

        go(answer, arr, 0, len, 0, len);

        return answer;
    }

    private void go(int[] ans, int[][] arr, int rowStart, int rowEnd, int colStart, int colEnd) {
        int n = arr[rowStart][colStart];

        for(int i = rowStart; i < rowEnd; i++) {
            for(int j = colStart; j < colEnd; j++) {
                int now = arr[i][j];

                if(n != now) {
                    go(ans, arr, rowStart, (rowStart+rowEnd)/2, colStart, (colStart+colEnd)/2);
                    go(ans, arr, (rowStart+rowEnd)/2, rowEnd, colStart, (colStart+colEnd)/2);
                    go(ans, arr, rowStart, (rowStart+rowEnd)/2, (colStart+colEnd)/2, colEnd);
                    go(ans, arr, (rowStart+rowEnd)/2, rowEnd, (colStart+colEnd)/2, colEnd);

                    return;
                }
            }
        }

        ans[n]++;
    }
}