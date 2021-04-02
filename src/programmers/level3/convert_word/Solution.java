package programmers.level3.convert_word;

public class Solution {

    public int solution(String begin, String target, String[] words) {
        boolean[] b = new boolean[words.length];

        int answer = dfs(0, begin, target, words, b);

        if(answer == 2147483647) {
            answer = 0;
        }
        return answer;
    }

    private int dfs(int cnt, String now, String target, String[] words, boolean[] b) {
        if(now.equals(target)) {
            return cnt;
        }

        int result = 2147483647;
        int len = words.length;
        for (int i = 0 ; i < len ; i++) {
            if (b[i] || !isPossible(now, words[i])) {
                continue;
            }

            b[i] = true;
            result = Math.min(dfs(cnt+1, words[i], target, words, b), result);
            b[i] = false;
        }

        return result;
    }

    private boolean isPossible(String now, String word) {
        int cnt = 0;
        int len = now.length();

        for(int i = 0 ; i < len ; i++) {
            if(now.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }

        return cnt == 1;
    }
}
