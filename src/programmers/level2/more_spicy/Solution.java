package programmers.level2.more_spicy;

import java.util.*;

class Solution {
    public int solution(int[] scv, int K) {
        int answer = 0;
        int len = scv.length;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : scv) {
            heap.add(i);
        }

        while(true) {
            if(heap.size() == 1 && heap.peek() < K) {
                answer = -1;
                break;
            }
            if(heap.peek() < K) {
                heap.add(heap.remove() + heap.remove() * 2);
                answer++;
            }
            else {
                break;
            }
        }

        return answer;
    }
}