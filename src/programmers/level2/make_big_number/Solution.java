package programmers.level2.make_big_number;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        int len = sb.length();

        for(int i = 0 ; i < len - 1 ; i++) {
            char now = sb.charAt(i);
            char next = sb.charAt(i+1);

            while(k > 0 && now < next) {
                sb.delete(i, i+1);
                k--;
                i--;
                len--;

                if(i >= 0) {
                    now = sb.charAt(i);
                    next = sb.charAt(i+1);
                }
                else {
                    break;
                }
            }
        }

        if(k > 0) {
            sb.delete(len-k, len);
        }

        return sb.toString();
    }
}