package programmers.level2.camouflage;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for(String[] clothe : clothes) {
            if(!map.containsKey(clothe[1])) {
                map.put(clothe[1], 2);
            }
            else {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            }
        }

        for(Integer value : map.values()) {
            answer *= value;
        }

        return answer-1;
    }
}