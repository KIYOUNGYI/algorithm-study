package com.study.bj;
import java.util.Scanner;

public class P11052 {
    static long max = Long.MIN_VALUE;
    static int[] score;
    static int len;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        len = scan.nextInt();
        arr = new int[len];
        score = new int[len];
        for (int i = 0; i < len; i++) {
            score[i] = scan.nextInt();
        }
        recursive(0, 0);
        System.out.println(max);
    }

    public static void calculate() {
        long t = 0;
        for (int i = 0; i < len; i++) {
            t += score[i] * arr[i];
        }
        if (max < t) max = t;
    }


    public static void recursive(int depth, int sum) {
        if (sum == len) {
            calculate();
            return;
        }
        if (depth == len) {
            return;
        }

        for (int i = 0; i <= len; i++) {
            if (sum + (depth + 1) * i <= len) {
                arr[depth] = i;
                recursive(depth + 1, sum + (depth + 1) * i);
                arr[depth] = 0;
            }
        }
    }

}
