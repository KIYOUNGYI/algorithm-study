package com.study.bj.b2021.step1.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P16926_배열돌리기1_v4_풀이답습_스핀오프 {

  static Scanner sc = new Scanner(System.in);
  static int n, m, r;
  static int[][] a;

  public static void main(String[] args) {

    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);
    arrayList.add(6);
    arrayList.add(7);
    arrayList.add(8);
    arrayList.add(9);
    arrayList.add(10);

//    int[] temp = new int[10];
//    int len = arrayList.size();
//    int idx = shift % len;
//    System.out.println(idx);
//    System.out.println("what the heck?");
//    for (int i = 0; i < 10; i++, idx = (idx + 1) % len) {
//      System.out.println("idx : " + idx + " value : " + arrayList.get(idx));
//      temp[i] = arrayList.get(idx);
//    }

//    System.out.println(Arrays.toString(temp));
    int[] arr = new int[10];
    int shift = 2;

    for (int i = 0; i < 10; i++) {

//      int std = (i + shift)%10;//left -> right
//      temp3[std] = arrayList.get(i);
      arr[i] = arrayList.get((i + shift) % arr.length);//right -> left

    }

    System.out.println(Arrays.toString(arr));


  }

}
