package com.study.bj;

import java.util.Scanner;

public class P14681 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a > 0 && b > 0) {
            System.out.println(1);
        } else if (a > 0 && b < 0) {
            System.out.println(4);
        } else if (a < 0 && b > 0) {
            System.out.println(2);
        } else if (a < 0 && b < 0) {
            System.out.println(3);
        }
        scan.close();
    }
}
