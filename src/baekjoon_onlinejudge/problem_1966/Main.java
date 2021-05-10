package baekjoon_onlinejudge.problem_1966;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            List<Integer> list = new LinkedList<>();

            for(int i = 0 ; i < N ; i++) {
                list.add(sc.nextInt());
            }

            int target = list.get(M);
            List<Integer> queue = new LinkedList<>(list);
            Collections.sort(queue, Collections.reverseOrder());
            int cnt = 0;

            while(true) {
                int lHead = list.get(0);
                int qHead = queue.get(0);

                M--;
                if(lHead == qHead) {
                    list.remove(0);
                    queue.remove(0);
                    cnt++;

                    if(M < 0) {
                        System.out.println(cnt);
                        break;
                    }
                }
                else {
                    list.add(list.remove(0));
                }

                if(M < 0) {
                    M = list.size() - 1;
                }
            }

        }
    }
}
