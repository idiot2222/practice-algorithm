package baekjoon_onlinejudge.problem_1374;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main { // boj 1374
    static int ans = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][3];

        for(int i = 0 ; i < N ; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.comparing(x -> x[1]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));

        for (int[] ints : arr) {
            if(queue.size() == 0) {
                queue.add(ints);
                continue;
            }

            removeAll(queue, ints);
        }

        System.out.println(ans);
        sc.close();
    }

    private static void removeAll(PriorityQueue<int[]> queue, int[] ints) {
        int[] now = queue.peek();
        if(now == null) {
            return;
        }
        int start = ints[1];

        if(now[2] <= start) {
            queue.remove();

            removeAll(queue, ints);
        }
        else {
            queue.add(ints);

            check(queue.size());
        }
    }

    private static void check(int size) {
        if(ans < size) {
            ans = size;
        }
    }
}
