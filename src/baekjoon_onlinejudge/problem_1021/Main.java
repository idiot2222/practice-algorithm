package baekjoon_onlinejudge.problem_1021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        List<Integer> queue = new ArrayList<>();
        int idx = 0;
        int ans = 0;

        for(int i = 0 ; i < M ; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 1 ; i <= N ; i++) {
            queue.add(i);
        }

        for (int target : arr) {
            int len = queue.size();
            int temp = cal(target, idx, queue);

            ans += Math.abs(temp);
            idx += temp;

            if(idx < 0) {
                idx += len;
            }
            if(idx >= len) {
                idx %= len;
            }

            queue.remove(idx);

            if(idx == queue.size()) {
                idx = 0;
            }
        }

        System.out.println(ans);
        sc.close();
    }

    private static int cal(int target, int idx, List<Integer> queue) {
        int tIdx = queue.indexOf(target);
        if(tIdx == idx) {
            return 0;
        }

        int right = Math.abs(tIdx - idx);
        int left = Math.abs(queue.size() - right);

        if(tIdx < idx) {
            int temp = right;
            right = left;
            left = temp;
        }

        return right < left ? right : -left;
    }
}
