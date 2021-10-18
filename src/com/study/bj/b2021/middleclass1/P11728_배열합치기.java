package com.study.bj.b2021.middleclass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P11728_배열합치기 {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = br.readLine();
    String[] s = temp.split(" ");
    int size1 = Integer.parseInt(s[0]);
    int size2 = Integer.parseInt(s[1]);

    int[] arr1 = new int[size1];
    int[] arr2 = new int[size2];

    String temp1 = br.readLine();
    String[] s1 = temp1.split(" ");
    for (int i = 0; i < size1; i++) {
      arr1[i] = Integer.parseInt(s1[i]);
    }
    String temp2 = br.readLine();
    String[] s2 = temp2.split(" ");
    for (int i = 0; i < size2; i++) {
      arr2[i] = Integer.parseInt(s2[i]);
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    merge(arr1, arr2, bw);
    br.close();
  }

  private static void merge(int[] arr1, int[] arr2, BufferedWriter bw) throws IOException {
//    System.out.println("arr1 = " + Arrays.toString(arr1) + ", arr2 = " + Arrays.toString(arr2) + ", bw = " + bw);
    int len = arr1.length + arr2.length;
    int[] result = new int[len];

    int pt1 = 0;
    int pt2 = 0;
    int idx = 0;
    while (pt1 < arr1.length && pt2 < arr2.length) {

      if (arr1[pt1] < arr2[pt2]) {
        result[idx++] = arr1[pt1++];
      } else {
        result[idx++] = arr2[pt2++];
      }
    }
//    System.out.println(pt1);
//    System.out.println(pt2);
    if (pt1 == arr1.length) {
      for (int s = pt2; s < arr2.length; s = s + 1) {
        result[idx++] = arr2[s];
      }

    } else {

      for (int s = pt1; s < arr1.length; s = s + 1) {
        result[idx++] = arr1[s];
      }
    }

    for (int i = 0; i < result.length; i++) {
      bw.write(result[i] + " ");
    }
    bw.close();
  }


}
