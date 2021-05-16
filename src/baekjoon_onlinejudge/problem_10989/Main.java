package baekjoon_onlinejudge.problem_10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for(int i = 0 ; i < N ; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            int now = arr[i];

            if (now == 0) {
                continue;
            }

            for (int j = 0; j < now; j++) {
                bw.write(i + "\n");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
