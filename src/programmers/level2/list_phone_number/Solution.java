package programmers.level2.list_phone_number;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        int len = phone_book.length;
        String[] strings = new String[len];
        for(int i = 0 ; i < len ; i++) {
            strings[i] = phone_book[i].replaceAll(" ", "");
        }

        loop:
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                if(i == j) {
                    continue;
                }

                String now = strings[i];
                String target = strings[j];
                int nowLen = now.length();
                int tarLen = target.length();

                if(nowLen > tarLen) {
                    continue;
                }

                target = target.substring(0, nowLen);

                if(now.equals(target)) {
                    answer = false;
                    break loop;
                }
            }
        }

        return answer;
    }
}