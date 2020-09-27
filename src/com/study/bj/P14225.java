package com.study.bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/14225
 * 수열 S가 주어졌을 때, 수열 S의 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 프로그램을 작성하시오.
 *
 * 예를 들어, S = [5, 1, 2]인 경우에 1, 2, 3(=1+2), 5, 6(=1+5), 7(=2+5), 8(=1+2+5)을 만들 수 있다.
 * 하지만, 4는 만들 수 없기 때문에 정답은 4이다.
 *
 * [입력]
 * 첫째 줄에 수열 S의 크기 N이 주어진다. (1 ≤ N ≤ 20)
 * 둘째 줄에는 수열 S가 주어진다. S를 이루고있는 수는 100,000보다 작거나 같은 자연수이다.
 *
 */
public class P14225
{
  static boolean[] temp;
  static boolean[] visit=new boolean[100020*20];
  static int N;
  static int[] arr;
  static ArrayList<Integer> arrList = new ArrayList<>();
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arr = new int[N];
    temp = new boolean[N];
    for(int i=0;i<N;i++)arr[i]=scan.nextInt();
    for(int lim=1;lim<=N;lim++)
    {
      recursive2(0,0,lim);
    }

    for(int i=1;i<100020*20;i++)
    {
      if(visit[i]==false)
      {
        System.out.println(i);
        return;
      }
    }
  }


  public static void recursive2(int depth,int v,int lim)
  {
    if(depth==lim)
    {
//      System.out.println(arrList.toString());
      sum();
      return;
    }
    if(v==N)
    {
      return;
    }
    arrList.add(arr[v]);
    recursive2(depth+1,v+1,lim);
    int len = arrList.size();
    arrList.remove(len-1);
    recursive2(depth,v+1,lim);
  }

  public static void sum()
  {
    int total=0;
    for(int i=0;i<arrList.size();i++)
    {
      total+=arrList.get(i);
    }
    if(visit[total]==false)
    {
      visit[total]=true;
    }
  }

}
