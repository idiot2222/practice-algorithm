package programmers.level2.find_prime;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(String numbers) {
        int answer;

        String[] nums = numbers.split("");
        int max = findMax(nums);
        int min = findMin(nums);

        int len = nums.length;
        boolean[] isUsed = new boolean[len+1];
        boolean[] isChecked = new boolean[max+1];
        boolean[] isNotPrime = new boolean[max+1];
        checkNotPrime(isNotPrime);

        go(new StringBuilder(), len, nums, isUsed, isChecked, isNotPrime);

        answer = count(isChecked);
        return answer;
    }

    private int count(boolean[] bools) {
        int cnt = 0;

        for(Boolean b : bools) {
            if(b) {
                cnt++;
            }
        }

        return cnt;
    }

    private void go(StringBuilder now, int len, String[] nums, boolean[] isUsed, boolean[] isChecked, boolean[] isNotPrime) {

        if(now.length() > 0) {
            int temp = Integer.parseInt(now.toString());

            if(!isNotPrime[temp]) {
                isChecked[temp] = true;
            }
        }

        for(int i = 0 ; i < len ; i++) {
            if(isUsed[i]) {
                continue;
            }

            now.append(nums[i]);
            isUsed[i] = true;

            go(now, len, nums, isUsed, isChecked, isNotPrime);

            isUsed[i] = false;
            int leng = now.length();
            now.delete(leng-1, leng);
        }
    }

    private void checkNotPrime(boolean[] b) {
        int len = b.length;
        b[0] = b[1] = true;

        for(int i = 2 ; i <= len/2; i++) {
            for(int j = i*2 ; j < len ; j+=i) {
                b[j] = true;
            }
        }
    }

    private int findMax(String[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(String s : arr) {
            sb.append(s);
        }

        return Integer.parseInt(sb.toString());
    }

    private int findMin(String[] arr) {
        String min = "9";

        for (String s : arr) {
            if(min.compareTo(s) > 0) {
                min = s;
            }
        }

        int result = Integer.parseInt(min);
        if(result < 2) {
            result = 2;
        }

        return result;
    }
}