package baekjoon_onlinejudge.problem_11866;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++) {
            list.add(i);
        }

        System.out.print("<");

        int cnt = 0;
        while (list.size() != 0) {
            cnt++;

            if (cnt % K == 0) {
                System.out.print(list.remove(0));
                if(list.size() != 0) {
                    System.out.print(", ");
                }
            }
            else {
                list.add(list.remove(0));
            }
        }
        System.out.print(">");

        sc.close();
    }
}
