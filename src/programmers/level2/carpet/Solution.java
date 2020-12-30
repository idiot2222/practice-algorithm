package programmers.level2.carpet;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for(int i = total/3 ; i >= 3 ; i--) {
            int j = total / i;

            if(i * j == total) {
                int cnt = count(i, j);

                if(cnt == brown) {
                    answer[0] = i;
                    answer[1] = j;

                    break;
                }
            }
        }

        return answer;
    }

    private int count(int x, int y) {
        int sum = 2 * x;
        sum += y * 2 - 4;

        return sum;
    }
}