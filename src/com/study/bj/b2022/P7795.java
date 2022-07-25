package com.study.bj.b2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P7795 {

  static int tc;
  static int aLen;
  static int bLen;

  static int[] arr;
  static int[] brr;

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    String temp1 = br.readLine();
    String[] s = temp1.split(" ");
    tc = Integer.parseInt(s[0]);
    for (int i = 0; i < tc; i++) {
      String temp2 = br.readLine();
      String[] s2 = temp2.split(" ");
      aLen = Integer.parseInt(s2[0]);
      bLen = Integer.parseInt(s2[1]);

      arr = new int[aLen];
      brr = new int[bLen];

      String temp3 = br.readLine();
      String[] s3 = temp3.split(" ");
      String temp4 = br.readLine();
      String[] s4 = temp4.split(" ");

      for (int j = 0; j < s3.length; j++) {
        arr[j] = Integer.parseInt(s3[j]);
      }

      for (int k = 0; k < s4.length; k++) {
        brr[k] = Integer.parseInt(s4[k]);
      }

      Arrays.sort(arr);
      Arrays.sort(brr);

      System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
      System.out.println("Arrays.toString(brr) = " + Arrays.toString(brr));

      for (int x=0;x<arr.length;x++) {

        int target = arr[x];

        int t2 = binarySearch(0, brr.length, target);


      }
    }
  }

  private static int binarySearch(int s, int e, int target){




    return 0;
  }
}
