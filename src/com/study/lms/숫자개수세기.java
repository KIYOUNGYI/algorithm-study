package com.study.lms;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 숫자개수세기{
    
    public static int n;
    public static int q;
    public static ArrayList<Integer> arr = new ArrayList();
    public static int[] questions;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      q = scan.nextInt();
      for(int i=0;i<n;i++) 
      {
    	  int x = scan.nextInt();
    	  arr.add(x);
      }
      questions = new int[q];
      for(int i=0;i<q;i++)questions[i]=scan.nextInt();
      
      Collections.sort(arr);
      
      for(int i=0;i<q;i++)
      {
        bSearch(0,n-1,questions[i]);
        // bSearchNonRecursive(questions[i]);
      }
      scan.close();
    }
    
    public static int count(int idx,int value)
    {
      int cnt = 1;
      int temp = idx;
      if(idx>=1)
      {
        for(int i=temp-1;i>=0;i--)
        {
          if(arr.get(i)==value){cnt++;}else{break;}
        }
      }
      temp = idx;
      
      if(idx<n-1)
      {
        for(int i=temp+1;i<n;i++)
        {
          if(arr.get(i)==value){cnt++;}else{break;}
        }
      }
      return cnt;
    }
    
    public static void bSearchNonRecursive(int target) 
    {
    	int s = 0;
    	int e = n-1;
    	
    	if(arr.get(s)==target) 
    	{
    		int cnt = count(s, target);
			System.out.println(cnt);
			return;
    	}
    	if(arr.get(e)==target) 
    	{
    		int cnt = count(s, target);
			System.out.println(cnt);
			return;
    	}
    	
    	if(arr.get(s)>target || arr.get(e)<target) {System.out.println(0);return;}
    	
    	
    	while(s+1<e) 
    	{
    		int m = (s+e)/2;
    		if(arr.get(m)==target) 
    		{
    			int cnt = count(m, target);
    			System.out.println(cnt);
    			return;
    		}
    		else if(arr.get(m)<target) 
    		{
    			s=m;
    		}
    		else 
    		{
    			e=m;
    		}
    	}
    	System.out.println(0);
    }
    
    public static void bSearch(int s,int e,int target)
    {
      if(s>e){System.out.println("0");return;}
      
      if(s==e)//1개인 경우
      {
        if(arr.get(s)==target)
        {
          int cnt = count(s,arr.get(s));
          System.out.println(cnt);
          return;
        }
        else 
        {
          System.out.println("0");
          return;
        }
      }
      
      int mid = (s+e)/2;
      if(arr.get(mid)==target)
      {
        int cnt = count(mid,arr.get(mid));
        System.out.println(cnt);
      }
      else if(arr.get(mid)<target) // 4(mid)    7(target)
        bSearch(mid+1,e,target);
      else if(arr.get(mid)>target)//  2(target)  4(mid)        
        bSearch(s,mid-1,target);
    }
   
}