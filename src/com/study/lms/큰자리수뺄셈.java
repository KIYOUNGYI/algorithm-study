package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 큰자리수뺄셈{
    
    //큰거,작은거 분류
    //자리수 같으면 앞자리부터 비교,앞에 큰게 큰거.
    // 첫번째 입력이 큰거면 + , 두번째 입력이 큰 거면 -
    //두개가 같으면 0
    
    //첫번째 입력이 긴거면+ / 긴거 문자열배열로,짧은거 보정
    //                      
    //두번째 입력이 긴거면- /
    //subtract(긴거,짧은거)
    //보수 로직,flag고려 (+/-), 앞의 0 고려
    public static String x;
    public static String y;
    public static String big;
    public static String small;
    public static boolean flag;
    public static int[] answer;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        x = scan.nextLine();
        y = scan.nextLine();
        
        if(x.equals(y)){System.out.println(0);return;}
        if(x.length()==y.length())
        {
          for(int i=0;i<x.length();i++)
          {
            if((int)x.charAt(i)<(int)y.charAt(i)){big=y;small=x;flag=false;break;}
            if((int)x.charAt(i)>(int)y.charAt(i)){big=x;small=y;flag=true;break;}
          }
          subtract(big,small);
        }
        if(x.length()>y.length())
        {
          flag=true;
          big = x;small=y;
          subtract(big,small);
        }
        if(x.length()<y.length())
        {
          flag=false;
          big = y;small=x;
          subtract(big,small);
        }
        scan.close();
    }
    public static void subtract(String big,String small)
    {
      char[] b = big.toCharArray();
      char[] s = new char[b.length];
      
      int idx=0;
      for(int i=big.length()-small.length();i<big.length();i++)
      {
        s[i]=small.charAt(idx);
        idx+=1;
      }
      // System.out.println("s->"+small.length());
      for(int i=0;i<big.length()-small.length();i++)
      {
        s[i]='0';
      }
      // System.out.println(Arrays.toString(s));
      
      answer = new int[b.length];
      int bosu = 0;
      for(int i=big.length()-1;i>=0;i--)
      {
        // System.out.println((int)b[i]+" ");
        if((int)b[i]-(int)s[i]-bosu<0)
        {
          int x = 10+(int)b[i]-(int)s[i]-bosu;
          answer[i]=x;
          bosu=1;
        }
        else
        {
          int x = (int)b[i]-(int)s[i]-bosu;
          answer[i]=x;
          bosu=0;
        }
       
      } 
      print();
    }
    public static void print()
    {
      if(flag==false)System.out.print("-");
      boolean temp=false;
      for(int i=0;i<answer.length;i++)
      {
        if(temp==true && answer[i]==0){System.out.print(0);}
        if(answer[i]!=0){temp=true;System.out.print(answer[i]);}
      }
    }
}