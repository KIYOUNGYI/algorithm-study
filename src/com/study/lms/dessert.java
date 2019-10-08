package com.study.lms;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class dessert{
    //n
    //long a[n+1] -> 인덱스에 맞게 초기화
    //int g[n] -> 2,1,0 내림차순 정렬
    
    // [1] 나열한다.
    // [2] 계산한다.
    // [3] 0이면 출력,카운트 세기(0 출력개수 20개까지)
    
    // [2] 계산파트
    //     ArrayList arrList
    //     for(i 1~<n)
    //      g[i]==0 이면 
    //        a[i],a[i+1] 자리수 구하기 x,y
    //        뒷자리수가 자리수가 1개이냐 x10 , 2개면 x100
    //        a[i+1] 갱신, a[i] 초기화
    //      
    //      다시 배열 돌면서 0이 아닌 값들 arrList에 삽입
    //     첫번째값 sum으로 설정, idx=1;
    //     for(i 0~<n)
    //        기호 g[i]=2이면 sum = sum+arrList(idx++);
    //        기호 g[i]=1이면 sum = sum-arrList(idx++);
    //      sum 0 이면 출력, 카운트 증가
    
    public static int n;
    public static long[] a;
    public static int[] g;
    public static int cnt=0;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      a = new long[n+1]; g = new int[n];
      initA();
      // System.out.println(Arrays.toString(g));
      // System.out.println(Arrays.toString(a));
      f(1);
      System.out.println(cnt);
      scan.close();
    }
    public static void initA()
    {
      for(int i=0;i<n+1;i++)
      {
        a[i]=i;
      }
    }
    
    public static long jarisu(long x)
    {
      long cnt=0;
      while(x!=0)
      {
        x=x/10;
        cnt+=1;
      }
      return cnt;
    }
    
    public static void dessert()
    {
      ArrayList<Long> arrList = new ArrayList();
      //보정
      for(int i=0;i<n;i++)
      {
        if(g[i]==0)
        {
          long x = jarisu(a[i]);
          long y = jarisu(a[i+1]);
          if(y==1)
          {
            a[i+1] = 10*a[i]+a[i+1];
            a[i]=0;
          }
          if(y==2)
          {
            a[i+1] = 100*a[i]+a[i+1];
            a[i]=0;
          }
        }
      }
      for(int i=0;i<=n;i++)
      {
        if(a[i]!=0)arrList.add(a[i]);
      }
      // System.out.println("->"+arrList.toString());
      long sum = arrList.get(0);
      int idx=1;
      for(int i=0;i<n;i++)
      {
        if(g[i]==2)
        {
          sum=sum+arrList.get(idx++);
        }
        if(g[i]==1)
        {
          sum=sum-arrList.get(idx++);
        }
      }
      
      if(sum==0)
      {
        if(cnt<20)
        {
          printResult();
        }
        cnt+=1;
      }
      initA();
      arrList.clear();
    }
    
    public static void printResult()
    {
      System.out.print(1);
      for(int i=1;i<n;i++)
      {
        if(g[i]==2){System.out.print(" + ");}
        else if(g[i]==1){System.out.print(" - ");}
        else if(g[i]==0){System.out.print(" . ");}
        System.out.print((i+1));
      }
      System.out.println();
    }
        
    public static void f(int depth)
    {
      if(depth==n)
      {
        // System.out.println(Arrays.toString(g));
        dessert();
        return;
      }
      for(int i=2;i>=0;i--)
      {
        g[depth]=i;
        f(depth+1);
      }
    }
}