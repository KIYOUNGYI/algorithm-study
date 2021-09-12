package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P11047TimeExceed {

  static int[] s;
  static int n, total;
  static int[] arr;
  static boolean[] check = new boolean[100_000_020];
  static int[] check2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] temp = br.readLine().split(" ");
    n = Integer.parseInt(temp[0]);
    total = Integer.parseInt(temp[1]);
    arr = new int[n];
    s = new int[total + 1];
    check2 = new int[total+1];for(int i=0;i<check2.length;i++)check2[i]=Integer.MAX_VALUE;
    for (int i = 0; i < s.length; i++) {
      s[i] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      check[arr[i]] = true;
    }
    optimize1();


//    Arrays.sort(arr);
//    System.out.println(Arrays.toString(arr));
    coin();
    System.out.println(s[total]);
  }

  private static void optimize1()
  {
    for(int i=0;i<arr.length;i++)
    {
      int pivot = arr[i];
      for(int j=1;j<=total;j++)
      {
        int t = j/pivot;
        if(check2[t]>t){check2[t]=t;}
      }
    }
    for(int i=1;i<check2.length;i++)
    {
      System.out.println(" check2["+i+"] : "+check2[i]);
    }
  }

  public static void coin() {
    s[arr[0]] = 1;
    for (int i = 1; i <= total; i++) {
//      System.out.println("i:"+i);
      if (check2[i]!=0) {
        s[i] = check2[i];
      } else {
//        int temp=0;
        for (int j = 1; j <= i / 2; j++) {
          int temp = s[j] + s[i - j];
//          System.out.println(j+" "+(i-j)+" "+(s[j]+s[i-j]));
          if (temp < s[i]) {
            s[i] = temp;
          }
        }

      }
//      System.out.println("s["+i+"]:"+s[i]);
    }
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }
}
