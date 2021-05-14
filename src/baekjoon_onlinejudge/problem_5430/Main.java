package baekjoon_onlinejudge.problem_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String inst = br.readLine();
            int N = Integer.parseInt(br.readLine());

            Deque<Integer> queue = stringToDeque(N, br.readLine());
            boolean isForward = true;
            boolean isError = false;

            int len = inst.length();
            for(int i = 0 ; i < len ; i++) {
                char now = inst.charAt(i);

                if(now == 'D') {
                    if(queue.size() == 0) {
                        isError = true;
                        break;
                    }
                    if(isForward) {
                        queue.removeFirst();
                    }
                    else {
                        queue.removeLast();
                    }
                }
                else {
                    isForward = !isForward;
                }
            }

            if(isError) {
                System.out.println("error");
            }
            else {
                String result = convertResult(queue, isForward);
                System.out.println(result);
            }

        }

        br.close();
    }

    private static String convertResult(Deque<Integer> queue, boolean isForward) {
        StringBuilder sb = new StringBuilder("[");

        if(isForward) {
            while(queue.size() != 0) {
                sb.append(queue.removeFirst() + ",");
            }
        }
        else {
            while(queue.size() != 0) {
                sb.append(queue.removeLast() + ",");
            }
        }

        int len = sb.length();
        if(sb.charAt(len-1) == ',') {
            sb.delete(len - 1, len);
        }
        sb.append("]");

        return sb.toString();
    }

    private static Deque<Integer> stringToDeque(int n, String s) {
        Deque<Integer> deque = new ArrayDeque<>();

        s = s.replaceAll("\\[|\\]", "");
        String[] split = s.split(",");

        for (int i = 0 ; i < n ; i++) {
            deque.add(Integer.parseInt(split[i]));
        }

        return deque;
    }
}
