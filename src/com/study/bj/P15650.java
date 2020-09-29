package com.study.bj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * N과 M (2)
 * https://www.acmicpc.net/problem/15650
 */
public class P15650
{
  static int N,M;
  static ArrayList<Integer> arrayList = new ArrayList<>();
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    M = scan.nextInt();
    recursive(0,1);
  }
  public static void recursive(int depth,int v)
  {
    if(depth==M)
    {
      for(int i=0;i<arrayList.size();i++)
      {
        System.out.print(arrayList.get(i)+" ");
      }
      System.out.println();
      return;
    }
    if(v==N+1)return;


    arrayList.add(v);
    recursive(depth+1,v+1);
    int len = arrayList.size()-1;
    arrayList.remove(len);
    recursive(depth,v+1);

  }
}
