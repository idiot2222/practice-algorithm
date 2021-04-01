package programmers.level3.integer_triangle;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int len = triangle.length;
        int[][] arr = new int[len][len];
        arr[0][0] = triangle[0][0];

        for(int i = 1 ; i < len ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                int left = 0;
                int right = 0;

                if(j != 0) {
                    left = arr[i-1][j-1];
                }
                if(j != i) {
                    right = arr[i-1][j];
                }

                arr[i][j] = Math.max(left, right) + triangle[i][j];

                if(i == len-1) {
                    answer = Math.max(answer, arr[i][j]);
                }
            }
        }


        return answer;
    }
}