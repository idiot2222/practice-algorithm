package baekjoon_onlinejudge.problem_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[9][9];
        boolean[][] bools = new boolean[9][10];

        int x = -1, y = -1;
        for(int i = 0 ; i < 9 ; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            for(int j = 0 ; j < 9 ; j++) {
                int idx = (i / 3) * 3 + (j / 3);
                int now = Integer.parseInt(arr[j]);
                if(x == -1 && y == -1 && now == 0) {
                    x = i;
                    y = j;
                }
                board[i][j] = now;
                bools[idx][now] = true;
            }
        }

        br.close();

        go(x, y, board, bools);

        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean go(int x, int y, int[][] board, boolean[][] bools) {
        if(x == -1 || y == -1) {
            return true;
        }
        boolean b = false;
        int idx = (x / 3) * 3 + (y / 3);

        int nextX = -1, nextY = -1; // 다음 0의 좌표
        loop:
        for(int i = x ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                if(i == x && j == y) {
                    continue;
                }

                int n = board[i][j];

                if(n == 0) {
                    nextX = i;
                    nextY = j;
                    break loop;
                }
            }
        }

        for(int i = 1 ; i <= 9 ; i++) {
            if(checkBox(bools[idx], i) && checkRow(board[x], i) && checkColumn(board, y, i)) {
                board[x][y] = i;
                bools[idx][i] = true;

                b = go(nextX, nextY, board, bools);

                if(!b) {
                    board[x][y] = 0;
                    bools[idx][i] = false;
                }
            }
        }

        return b;
    }

    private static boolean checkColumn(int[][] board, int y, int n) {
        for(int i = 0 ; i < 9 ; i++) {
            if(board[i][y] == n) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkRow(int[] row, int n) {
        for(int i = 0 ; i < 9 ; i++) {
            if(row[i] == n) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkBox(boolean[] box, int n) {
        return !box[n];
    }
}
