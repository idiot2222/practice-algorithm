package programmers.weekly_challenge.p1;

class Solution {
    public long solution(int price, int money, int count) {
        long answer;

        long totalPrice = calTotalPrice(price, count);

        if(money > totalPrice) {
            return 0;
        }

        answer = totalPrice - money;

        return answer;
    }

    private long calTotalPrice(int price, int count) {
        long result = price;
        int cnt = calCount(count);

        result *= cnt;

        return result;
    }

    private int calCount(int count) {
        int temp = 1 + count;
        int result;

        result = count / 2 * temp;

        if(count % 2 != 0) {
            result += temp / 2;
        }

        return result;
    }
}