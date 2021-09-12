package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15657
{
  static ArrayList<Integer> arrayList = new ArrayList<>();
  static int n,r;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner scan = new Scanner(System.in);
    String[] dummy = br.readLine().split(" ");
    n = Integer.parseInt(dummy[0]);
    r = Integer.parseInt(dummy[1]);

    String[] dummy2 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(dummy2[i]);
    }
    Arrays.sort(arr);
//    recursive(0,);
  }
  public static void recursive(int depth)
  {
//    arrayList.add();
//    recursive(depth+1,);
//    int len = arrayList.size()-1;
//    arrayList.remove(len);
//    recursive(depth,);
  }
}
