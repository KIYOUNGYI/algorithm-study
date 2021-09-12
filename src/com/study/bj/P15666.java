package com.study.bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P15666 {

  static ArrayList<Integer> answer = new ArrayList<>();
  static int n,lim;
  static int[] arr;
  static ArrayList<Integer> arrayList = new ArrayList<>();
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    lim = scan.nextInt();
    arr = new int[lim];
    for(int i=0;i<n;i++)
    {
      int t = scan.nextInt();
      if(!arrayList.contains(t)) {
        arrayList.add(t);
      }
    }
    Collections.sort(arrayList);
    recursive(0);
    scan.close();
  }

  public static void recursive(int depth)
  {
    if(depth==lim)
    {
      for(int i=0;i<arr.length;i++)
      {
        System.out.print(arr[i]+" ");
      }
      System.out.println();
      return;
    }
    for(int i=0;i<arrayList.size();i++)
    {
      arr[depth]=arrayList.get(i);
      recursive(depth+1);
    }
  }

  public static void recursive2(int depth,int val)
  {
    //arrayList.add(a)
  }


}
