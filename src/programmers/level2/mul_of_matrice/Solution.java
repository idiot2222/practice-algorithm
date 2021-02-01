package programmers.level2.mul_of_matrice;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length; //
        int row2 = arr2.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length; //
        int[][] answer = new int[row1][col2];

        for(int i = 0 ; i < row1 ; i++) {
            for(int j = 0 ; j < col2 ; j++) {
                answer[i][j] = cal(i, j, row2, arr1, arr2);
            }
        }

        return answer;
    }

    private int cal(int x, int y, int row, int[][] arr1, int[][] arr2) {
        int sum = 0;

        for(int i = 0 ; i < row ; i++) {
            sum += arr1[x][i] * arr2[i][y];
        }

        return sum;
    }
}