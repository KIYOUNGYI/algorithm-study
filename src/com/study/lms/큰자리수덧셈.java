package com.study.lms;
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    
    // 두 문자열 입력 받어
    // 긴거 찾아
    // 만약 길이가 같으면 둘다 toCharArray()
    // answer[] -> 긴거 + 1
    // 만약 1쪽이 길면 그건 -> toCharArray()
    // 긴거만큼의 배열 생성
    // 짧은거는 뒤에서부터 앞으로 할당.
    // answer[] -> 긴거 + 1
    // 더하기 함수호출
    // 보수 로직(머리속에 있음)
    public static int[] ans;
    public static char[] bigger;
    public static char[] shorter;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String x = scan.nextLine();
      String y = scan.nextLine();
      
      if(x.equals("0") && y.equals("0"))
      {
        System.out.println(0);return;
      }
      
      if(x.length()==y.length())
      {
        bigger = x.toCharArray();
        shorter = y.toCharArray();
        ans = new int[bigger.length+1];
        // System.out.println(Arrays.toString(bigger));
        // System.out.println(Arrays.toString(shorter));
        // System.out.println(ans.length);
        calculate(bigger,shorter);
      }
      if(x.length()>y.length())
      {
        bigger = x.toCharArray();
        shorter = new char[bigger.length];
        ans = new int[bigger.length+1];
        int idx=0;
        for(int i=x.length()-y.length();i<x.length();i++)
        {
          shorter[i]=y.charAt(idx++);
        }
        for(int i=0;i<x.length()-y.length();i++)
        {
          shorter[i]='0';
        }
        // System.out.println(Arrays.toString(shorter));
        calculate(bigger,shorter);
      }
      else if(x.length()<y.length())
      {
        bigger = y.toCharArray();
        shorter = new char[bigger.length];
        ans = new int[bigger.length+1];
        int idx=0;
        for(int i=y.length()-x.length();i<y.length();i++)
        {
          shorter[i]=x.charAt(idx++);
        }
        for(int i=0;i<y.length()-x.length();i++)
        {
          shorter[i]='0';
        }
        calculate(bigger,shorter);
      }
      
      scan.close();
    }
    
   
    
    public static void calculate(char[] bigger,char[] shorter)
    {
      int ansLastIdx = ans.length-1;
      int bosu = 0; 
      for(int i=bigger.length-1;i>=0;i--)
      {
        
        int x = (int)(bigger[i]-(int)'0') +(int)(shorter[i]-(int)'0') +bosu;
        if(x>=10){ans[ansLastIdx] =x-10; bosu=1;}
        else{ans[ansLastIdx] =x;bosu=0;}
        ansLastIdx=ansLastIdx-1;
      }
      if(bosu==1)ans[0]=1;
      // System.out.println(Arrays.toString(ans));      
      printResult();
    }
    public static void printResult()
    {
      boolean flag=false;
      for(int i=0;i<ans.length;i++)
      {
        if(flag==true && ans[i]==0){System.out.print(ans[i]);}
        if(ans[i]!=0){flag=true;System.out.print(ans[i]);}
      }
    }
}