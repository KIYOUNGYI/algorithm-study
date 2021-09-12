package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Arrays;
import java.util.Scanner;

//폭파
public class P1248_맞춰봐 {

  static boolean flag = false;
  static String input;
  static int[] ans;
  static boolean[] pv = new boolean[11];
  static boolean[] nv = new boolean[11];
  static boolean[] zv = new boolean[1];
  static int n;
  static String[][] s;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    ans = new int[n + 1];
    s = new String[n + 1][n + 1];
    input = scan.next();
    int idx = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        s[i][j] = String.valueOf(input.charAt(idx++));
      }
    }

//    if (String.valueOf(input.charAt(0)).equals("+")) {
//      pv[10] = true;
//      ans[1] = 10;
//    }
    for(int x=10;x>=1;x--) {
      if (String.valueOf(input.charAt(0)).equals("-")) {
        nv[x] = true;
        ans[1] = -x;
        recursion(1);
        nv[x] = false;
      }
    }
//    if (String.valueOf(input.charAt(0)).equals("0")) {
//      zv[0] = true;
//      ans[1] = 0;
//    }


  }

  private static void recursion(int depth) {

    System.out.println("depth = " + depth + " giho : " + String.valueOf(input.charAt(depth)) + " ans: " + Arrays.toString(ans));

    if (flag) {
      return;
    }

    if (!check(depth)) {
      System.out.println("!!!");
      return;
    }

    if (depth == n+1) {
      System.out.println("end");
      System.out.println(Arrays.toString(ans));
      flag = true;
      return;
    }
    if(depth<=3) {
      if (String.valueOf(s[depth + 1][depth + 1]).equals("+")) {
        for (int i = 10; i >= 1; i--) {
          if (!pv[i]) {
            pv[i] = true;
            ans[depth + 1] = i;
            recursion(depth + 1);
            pv[i] = false;
          }
        }
      }
      if (String.valueOf(s[depth + 1][depth + 1]).equals("-")) {
        for (int i = 10; i >= 1; i--) {
          if (!nv[i]) {
            nv[i] = true;
            ans[depth + 1] = -i;
            recursion(depth + 1);
            nv[i] = false;
          }
        }
      } else {
        System.out.println("zero");
        int tempSum = 0;
        for (int i = 1; i <= depth; i++) {
          tempSum += ans[i];
        }
        System.out.println("tempSum:" + tempSum);
        int tempVal = -tempSum;

        if (tempVal == 0 && !zv[0]) {
          ans[depth + 1] = 0;
          zv[0] = true;
          recursion(depth + 1);
          zv[0] = false;
        }
        if (tempVal != 0) {
          if (tempVal > 0 && !pv[tempVal]) {
            pv[tempVal] = true;
            ans[depth + 1] = tempVal;
            recursion(depth + 1);
            pv[tempVal] = false;
          }
          if (tempVal < 0 && !nv[tempVal]) {
            nv[tempVal] = true;
            ans[depth + 1] = tempVal;
            recursion(depth + 1);
            nv[tempVal] = false;
          }
        }
      }
    }
  }

  private static boolean check(int depth) {
    System.out.println("s["+depth+"]["+depth+"]");
    for(int i=1;i<=depth;i++){
      for(int j=i;j<=depth;j++){
        System.out.println("["+i+"]["+depth+"]");

        int start = i;
        int end = depth;
        int tempSum = 0;
        for(int k=start;k<=end;k++){
          tempSum+=ans[k];
        }
//        if(tempSum>0 && !s[depth][depth].equals("+")){
//          return false;
//        }
//        if(tempSum<0 && !s[depth][depth].equals("-")){
//          return false;
//        }
//        if(tempSum==0 && !s[depth][depth].equals("0")){
//          return false;
//        }
      }
    }
    System.out.println("---");
    return true;
  }



  private static void printSrr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(s[i][j] + " ");
      }
      System.out.println();
    }

  }

}

// private static boolean check(int depth) {
//    String tempGiho = s[depth][depth];
//
//    for (int i = 1; i <= depth; i++) {
//
//      int start = i;
//      int end = depth;
//
//      int tempSum = 0;
//      for (int j = start; j <= end; j++) {
//        tempSum += ans[j];
//      }
//      System.out.println("start:" + start + " end:" + end + " tempSum:" + tempSum);
//      if (tempGiho.equals("+")) {
//      }
//      if (tempGiho.equals("-")) {
//
//      }
//      if (tempGiho.equals("0")) {
//
//      }
//    }
//  }
//
//    System.out.println("true");
//    return true;
//}