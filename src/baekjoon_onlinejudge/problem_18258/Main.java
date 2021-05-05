package baekjoon_onlinejudge.problem_18258;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new LinkedList<>();

        while(N-- > 0) {
            String[] arr = br.readLine().split(" ");
            String inst = arr[0];

            if(inst.equals("push")) {
                queue.add(Integer.parseInt(arr[1]));
            }
            else if(inst.equals("pop")) {
                if(queue.size() == 0) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(queue.remove(0)+"\n");
                }
            }
            else if(inst.equals("size")) {
                bw.write(queue.size()+"\n");
            }
            else if(inst.equals("empty")) {
                bw.write((queue.size() == 0 ? 1 : 0) + "\n");
            }
            else if(inst.equals("front")) {
                if(queue.size() == 0) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(queue.get(0)+"\n");
                }
            }
            else if(inst.equals("back")) {
                if(queue.size() == 0) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(queue.get(queue.size()-1) + "\n");
                }
            }
        }

        bw.flush();
    }
}
