package com.study.bj.week001;

import java.util.Scanner;

/**
 * 8분 걸림 (re)
 * *****
 * ****
 * ***
 * **
 * *
 */
public class P2441 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (cnt < i) {
                    cnt += 1;
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }

    }
}
