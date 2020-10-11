package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P17087V2 {
    static int n, s;
    static int[] arr, brr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        s = Integer.parseInt(temp[1]);
        arr = new int[n];
        brr = new int[n];
        String[] temp2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp2[i]);

        if (n == 1) {
            System.out.println(abs(arr[0] - s));
            return;
        }

        for (int i = 0; i < n; i++) {
            brr[i] = abs(s - arr[i]);
        }
        int t = brr[0];
        for (int i = 1; i < n; i++) {
            t = gcd(t, brr[i]);
        }
        System.out.println(t);
    }

    public static int gcd(int a, int b) {
        int big, small;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        int r = 1;
        while (true) {
            r = big % small;
            if (r == 0) break;
            big = small;
            small = r;
        }
//        int gcd = small;
        return small;
    }

    public static int abs(int x) {
        return x > 0 ? x : -x;
    }
}
