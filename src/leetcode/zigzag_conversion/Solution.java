package leetcode.zigzag_conversion;

class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        StringBuilder answer = new StringBuilder();

        boolean isAscending = true;
        int len = s.length();
        int idx = 0;

        if(numRows == 1) {
            return s;
        }

        for(int i = 0 ; i < numRows ; i++) {
            sb[i] = new StringBuilder();
        }

        for(int i = 0 ; i < len ; i++) {
            sb[idx].append(s.charAt(i));

            if(isAscending) {
                idx++;
            }
            else {
                idx--;
            }

            if(idx == numRows) {
                idx-=2;
                isAscending = false;
            }
            else if(idx == -1) {
                idx+=2;
                isAscending = true;
            }
        }

        for(int i = 0 ; i < numRows ; i++) {
            answer.append(sb[i].toString());
        }

        return answer.toString();
    }
}