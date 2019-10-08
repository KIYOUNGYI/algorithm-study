package com.study.lms;
import java.util.Scanner;
import java.util.Arrays;

public class 공통조상찾기{
    public static int n,first,second;
    public static int[] arr;
    public static boolean[] av;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      getAnswer();
      scan.close();
    }
    
    public static void getAnswer()
    {
      int temp = first;
      
      while(true)
      {
        temp = arr[temp];//올라가고
        av[temp]=true;//칠하고
        if(temp==0)break;
      }
      // System.out.println(Arrays.toString(av));
      temp = second;
      while(true)
      {
        //올라가고 체크하고
        temp = arr[temp];
        if(av[temp]){System.out.println(temp);return;}
      }
    }
    public static void input(Scanner scan)
    {
      n = scan.nextInt();first = scan.nextInt();second = scan.nextInt();
      arr = new int[n];av = new boolean[n];
      for(int i=0;i<n-1;i++)
      {
        int a = scan.nextInt();
        int b = scan.nextInt();
        arr[b]=a;
      }
      // System.out.println(Arrays.toString(arr));
    }
}