package com.study.bj;


import java.util.Scanner;

/**
 * 별 찍기 3
 * https://www.acmicpc.net/problem/2440
 */
public class P2440
{
    //두개의 합이 n 미만이면 출력,아니면 break

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n) {
                    System.out.print("*");
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}
