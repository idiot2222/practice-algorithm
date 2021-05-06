package baekjoon_onlinejudge.problem_2164;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++) {
            list.add(i);
        }

        for(int i = 1 ; i <= N ; i++) {
            if(i == N) {
                System.out.println(list.get(0));
            }
            else {
                list.remove(0);
                list.add(list.remove(0));
            }
        }

        sc.close();
    }
}
