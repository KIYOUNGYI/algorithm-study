package com.study.bj;

import java.util.Scanner;

/**
 * ABC
 * https://www.acmicpc.net/problem/3047
 */
public class P3047 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[68];

    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    if (a > b && b > c) {
      arr[67] = a;
      arr[66] = b;
      arr[65] = c;
    } else if (a > c && a > b) {
      arr[67] = a;
      arr[66] = c;
      arr[65] = b;
    } else if (b > a && a > c) {
      arr[67] = b;
      arr[66] = a;
      arr[65] = c;
    } else if (b > c && c > a) {
      arr[67] = b;
      arr[66] = c;
      arr[65] = a;
    } else if (c > a && a > b) {
      arr[67] = c;
      arr[66] = a;
      arr[65] = b;
    } else if (c > b && b > a) {
      arr[67] = c;
      arr[66] = b;
      arr[65] = a;
    }
    scan.nextLine();
    String temp = scan.nextLine();
    System.out.println(arr[temp.charAt(0)] + " " + arr[temp.charAt(1)] + " " + arr[temp.charAt(2)]);

  }
}
