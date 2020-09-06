package com.study.bj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
    /**
     * https://www.acmicpc.net/problem/2178
     * dfs는 개뿔
     */
    static int minScore=Integer.MAX_VALUE;
    static boolean[][] visited;
    static int n, m;
    static int[][] arr, score;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n + 1][m + 1];
        score = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        scan.nextLine();
        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            for (int j = 0; j < input.length(); j++) {
                int t = (int) input.charAt(j) - 48;
                arr[i][j + 1] = t;
            }
        }

        System.out.println(minScore);
        scan.close();
    }

}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
