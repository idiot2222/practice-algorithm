package programmers.level3.connect_island;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = n-1;

        Arrays.sort(costs, Comparator.comparing(x -> x[2]));

        int[] cycleArr = new int[n];
        for(int i = 1 ; i < n ; i++) {
            cycleArr[i] = i;
        }

        for(int[] cost : costs) {
            int a = cycleArr[cost[0]];
            int b = cycleArr[cost[1]];

            int start = Math.min(a, b);
            int end = Math.max(a, b);
            int value = cost[2];

            if(start == end) {
                continue;
            }

            draw(cycleArr, start, end, n);
            answer += value;
            cnt--;

            if(cnt == 0) {
                break;
            }
        }


        return answer;
    }

    private void draw(int[] cycleArr, int dest, int targ, int n) {

        for(int i = targ ; i < n ; i++) {
            if(cycleArr[i] == targ) {
                cycleArr[i] = dest;
            }
        }
    }
}