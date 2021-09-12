package com.study.bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15658V2 {

  static int MAX = Integer.MIN_VALUE;
  static int MIN = Integer.MAX_VALUE;
  static int t;
  static int[] giho,gihoInput,arr;
  static ArrayList<Integer> temp = new ArrayList<>();
  static boolean[] v;
  static int cnt=0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    int a = scan.nextInt();//add
    int b = scan.nextInt();//sub
    int c = scan.nextInt();//mul
    int d = scan.nextInt();//div

    t = n - 1;
    giho = new int[t];
    gihoInput = new int[t];
    v = new boolean[t];
    for (int w = 0; w <= a; w++) {
      for (int x = 0; x <= b; x++) {
        for (int y = 0; y <= c; y++) {
          for (int z = 0; z <= d; z++) {
            if(w+x+y+z==t)
            {
              System.out.println("+ : "+w+" - : "+x+" * : "+y+" / : "+z);
              int idx=0;
              for(int i=0;i<w;i++) { giho[idx++]=1; }
              for(int i=0;i<x;i++) { giho[idx++]=2; }
              for(int i=0;i<y;i++) { giho[idx++]=3; }
              for(int i=0;i<z;i++) { giho[idx++]=4; }
//              System.out.println(Arrays.toString(giho));
//              johab(0);

//              for(int depth=0;depth<t;depth++)
//              {

//              }
//              f(0,0);
            }
          }
        }
      }
    }
//    System.out.println("cnt:"+cnt);
    System.out.println(MAX);
    System.out.println(MIN);
  }

//  private static void f(int depth, int v) {
//    if(depth==t-1)
//    {
//      System.out.println(temp.toString());
//      cnt+=1;
//      return;
//    }
//    else if(v==7){return;}
//    temp.add(v);
//    f(depth+1,giho[depth+1]);
//    int len = temp.size();
//    temp.remove(len-1);
//    f(depth,giho[depth+1]);
//  }

  public static void calculate() {
    int total = arr[0];
    for (int i = 0; i < gihoInput.length; i++) {
      if (gihoInput[i] == 1) {
        total = total + arr[i + 1];
      } else if (gihoInput[i] == 2) {
        total = total - arr[i + 1];
      } else if (gihoInput[i] == 3) {
        total = total * arr[i + 1];
      } else if (gihoInput[i] == 4) {
        total = total / arr[i + 1];
      }
    }
    if (MAX < total) {
      MAX = total;
    }
    if (MIN > total) {
      MIN = total;
    }
  }

  //  public static void johab(int depth)
//  {
//    if(depth==t)
//    {
//      cnt+=1;
////      System.out.println(Arrays.toString(gihoInput));
//      calculate();
//      return;
//    }
//
//    for(int i=0;i<t;i++)
//    {
//      if(!v[i])
//      {
//        v[i]=true;
//        gihoInput[depth]=giho[i];
//        johab(depth+1);
//        v[i]=false;
//      }
//    }
//  }

}
