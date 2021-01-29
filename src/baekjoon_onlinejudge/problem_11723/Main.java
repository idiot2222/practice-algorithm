package baekjoon_onlinejudge.problem_11723;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        while(M-- > 0) {
            int n = 0;
            String line = br.readLine();
            String[] arr = line.split(" ");
            String s = arr[0];
            if(arr.length > 1) {
                n = Integer.parseInt(arr[1]);
            }

            switch (s) {
                case "add" :
                    set.add(n);
                    break;

                case "remove" :
                    set.remove(n);
                    break;

                case "check" :
                    boolean b = set.contains(n);

                    if(b) {
                        bw.write('1');
                    }
                    else {
                        bw.write('0');
                    }
                    bw.newLine();
                    break;

                case "toggle" :
                    if(set.contains(n)) {
                        set.remove(n);
                    }
                    else {
                        set.add(n);
                    }
                    break;

                case "all" :
                    for(int i = 1 ; i <= 20 ; i++) {
                        set.add(i);
                    }
                    break;

                case "empty" :
                    set.clear();
                    break;
            }
        }

        bw.flush();
        br.close();
    }
}
