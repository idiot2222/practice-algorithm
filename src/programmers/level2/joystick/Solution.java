package programmers.level2.joystick;

class Solution {
    public int solution(String name) {
        int answer;

        int len = name.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < len ; i++) {
            sb.append("A");
        }

        answer = go(sb, name, 0, len);

        return answer;
    }

    private int go(StringBuilder sb, String name, int idx, int len) {
        int cnt;

        char now = sb.charAt(idx);
        char target = name.charAt(idx);

        cnt = Math.min(Math.abs(now - target), Math.abs('Z' - target)+1);
        sb.replace(idx, idx+1, String.valueOf(target));
        if(sb.toString().equals(name)) {
            return cnt;
        }

        int right = findNextRight(sb.toString(), name, idx, len);
        int left = findNextLeft(sb.toString(), name, idx, len);

        if(right <= left) {
            cnt += right;
            idx = (idx+right) % len;

            return cnt + go(sb, name, idx, len);
        } else {
            cnt += left;
            idx = (idx-left);
            if(idx < 0) {
                idx = len + idx;
            }

            return cnt + go(sb, name, idx, len);
        }
    }

    private int findNextRight(String now, String target, int idx, int len) {
        int cnt = 0;
        for(int i = 0 ; i < len ; i++) {
            idx++;
            cnt++;
            if(idx >= len) {
                idx %= len;
            }

            if(now.charAt(idx) != target.charAt(idx)) {
                break;
            }
        }

        return cnt;
    }

    private int findNextLeft(String now, String target, int idx, int len) {
        int cnt = 0;
        for(int i = 0 ; i < len ; i++) {
            idx--;
            cnt++;
            if(idx < 0) {
                idx = len - 1;
            }

            if(now.charAt(idx) != target.charAt(idx)) {
                break;
            }
        }

        return cnt;
    }
}