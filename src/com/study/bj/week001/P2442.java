package com.study.bj.week001;

import java.util.Scanner;

public class P2442 {
    /**
     * 5분
     * n=5
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int cnt = 2 * n - 1;
        for (int i = 1; i <= n; i++) {
            int limit = 2 * i - 1;
            int cnt1 = 0;
            for (int j = 1; j <= cnt; j++) {

                if (i + j <= n) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                    cnt1 += 1;
                }
                if (cnt1 == limit) break;
            }
            System.out.println();
        }


        scan.close();
    }
}
