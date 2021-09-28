package com.study.bj.week003;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P2739 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scan.nextInt();
        for (int i = 1; i <= 9; i++) {
            bw.write(n + " * " + i + " = " + (n * i) + "\n");
        }
        bw.close();
    }
}
