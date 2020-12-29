package programmers.level2.lifeboat;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        int len = people.length;
        Arrays.sort(people);
        boolean[] isDone = new boolean[len];

        int idx = 0;
        for(int i = len-1 ; i >= idx ; i--) {
            if(isDone[i]) {
                continue;
            }

            int weight = 0;
            weight += people[i];
            answer++;
            isDone[i] = true;

            for(int j = idx ; j < i ; j++) {
                if(isDone[j]) {
                   continue;
                }
                if(weight + people[j] <= limit) {
                    weight += people[j];
                    isDone[j] = true;
                    idx++;
                }
                else {
                    break;
                }
            }
        }

        return answer;
    }
}