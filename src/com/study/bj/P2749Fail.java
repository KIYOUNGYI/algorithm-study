package com.study.bj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class P2749Fail
{
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger temp;
        if (n == 0) {
            bw.write(a + "\n");
            bw.close();
        } else {
            for (int i = 1; i < n; i++) {
                temp = b;
                b = a.add(b);
                a = temp;
            }
            bw.write(b.mod(BigInteger.valueOf(1_000_000)) + "\n");
            bw.close();
        }
    }
}
