package kakao2018.secret_map;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0 ; i < n ; i++) {
            int temp = arr1[i] | arr2[i];

            answer[i] = binaryToString(temp, n);
        }

        return answer;
    }

    private String binaryToString(int temp, int n) {
        StringBuilder sb = new StringBuilder();


        for(int i = 0 ; i < n ; i++) {
            if(temp % 2 == 1) {
                sb.append('#');
            }
            else {
                sb.append(' ');
            }

            temp /= 2;
        }

        sb.reverse();

        return sb.toString();
    }
}