package com.study.bj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 다음 순열
 * https://www.acmicpc.net/problem/10972
 */
public class P10972
{
  static boolean[] v;
  static int[] arr;
  static int N;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arr = new int[N+1];
    v = new boolean[N+1];
    for(int i=1;i<=N;i++)
    {
      arr[i]=scan.nextInt();
      v[i]=true;
    }
    recursive(N);
    v[arr[N]]=false;
    recursive(N);
    System.out.println(Arrays.toString(arr));
    scan.close();
  }

  public static void recursive(int depth)
  {
    if(depth==N)
    {
      return;
    }

    for(int i=1;i<=N;i++)
    {
      if(!v[i])
      {
        v[i]=true;
        arr[depth]=i;
        recursive(depth+1);
        v[i]=false;
      }
    }
  }
}
