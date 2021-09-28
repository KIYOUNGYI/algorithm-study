package com.study.bj;

import java.util.Scanner;

public class P10870 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[22];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 22; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n]);
    }
}
