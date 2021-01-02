package programmers.level2.target_number;

class Solution {
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        return dfs(0, 0, len, numbers, target);
    }

    private int dfs(int sum, int idx, int len, int[] numbers, int target) {
        if(idx == len) {
            if(sum == target) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int result = 0;

        result += dfs(sum + numbers[idx], idx+1, len, numbers, target);
        result += dfs(sum - numbers[idx], idx+1, len, numbers, target);

        return result;
    }
}