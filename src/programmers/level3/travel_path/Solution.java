package programmers.level3.travel_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        boolean[] b = new boolean[len];
        Arrays.sort(tickets, Comparator.comparing((String[] x) -> x[0]).thenComparing(x -> x[1]));
        List<String> list = new ArrayList<>();
        list.add("ICN");

        dfs("ICN", 0, len, tickets, b, list);

        return list.toArray(new String[0]);
    }

    private boolean dfs(String now, int idx, int len, String[][] tickets, boolean[] b, List<String> list) {
        if(idx == len) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            if(b[i] || !ticket[0].equals(now)) {
                continue;
            }

            b[i] = true;
            list.add(ticket[1]);
            if(dfs(ticket[1], idx+1, len, tickets, b, list)) {
                return true;
            }
            list.remove(idx+1);
            b[i] = false;

            if(idx == len-1) {
                break;
            }
        }

        return false;
    }
}