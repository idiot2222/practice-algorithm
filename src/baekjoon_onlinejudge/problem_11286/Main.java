package baekjoon_onlinejudge.problem_11286;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            if(Math.abs(x) < Math.abs(y)) {
                return -1;
            }
            else if(Math.abs(x) == Math.abs(y)) {
                return x > y ? 1 : -1;
            }
            else {
                return 1;
            }
        });

        for(int i = 0 ; i < N ; i++) {
            int now = Integer.parseInt(br.readLine());

            if(now == 0) {
                if(queue.size() == 0) {
                    bw.write(0+"\n");
                }
                else {
                    bw.write(queue.remove()+"\n");
                }
            }
            else {
                queue.add(now);
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
