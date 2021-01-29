package programmers.level2.ponketmon;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        int n = nums.length / 2;

        for(int num : nums) {
            set.add(num);
        }

        answer = Math.min(set.size(), n);

        return answer;
    }
}