package com.study.bj;

import java.util.Scanner;

/**
 * ROT13 https://www.acmicpc.net/problem/11655 (int)x.charAt(i), (int)'a',(int)'z'
 */
public class P11655 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String x = scan.nextLine();
    for (int i = 0; i < x.length(); i++) {
      if ((int) x.charAt(i) >= (int) 'a' && (int) x.charAt(i) <= (int) 'm') {
        System.out.print((char) ((int) x.charAt(i) + 13));
      } else if ((int) x.charAt(i) >= (int) 'n' && (int) x.charAt(i) <= (int) 'z') {
        System.out.print((char) ((int) x.charAt(i) + 13 - 26));
      } else if ((int) x.charAt(i) >= (int) 'A' && (int) x.charAt(i) <= (int) 'M') {
        System.out.print((char) ((int) x.charAt(i) + 13));
      } else if ((int) x.charAt(i) >= (int) 'N' && (int) x.charAt(i) <= (int) 'Z') {
        System.out.print((char) ((int) x.charAt(i) + 13 - 26));
      } else if ((int) x.charAt(i) == (int) ' ') {
        System.out.print(" ");
      } else {
        System.out.print(x.charAt(i));
      }
    }
  }
}


