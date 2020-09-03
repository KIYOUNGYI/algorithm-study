package com.study.bj.week001;

import java.util.Scanner;

public class P2444 {
    /**
     * 5분
     * n=5
     * diamond
     */
    static int n;
    static int[][] map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        map = new int[2 * n + 5][2 * n + 5];

        int cnt = 2 * n - 1;
        for (int i = 1; i <= n; i++) {
            int limit = 2 * i - 1;
            int cnt1 = 0;
            for (int j = 1; j <= cnt; j++) {
                if (i + j <= n) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                    cnt1 += 1;
                }
                if (cnt1 == limit) break;
            }
        }

        for (int i = n + 1; i <= 2 * n; i++) {
            for (int j = 1; j <= 2 * n; j++) {
                map[i][j] = map[2 * n - i][j];
            }
        }
        print();
    }

    public static void print() {
        for (int i = 1; i < 2 * n; i++) {
            for (int j = 1; j < 2 * n; j++) {
                if (map[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}

/**
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 *         *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 */
