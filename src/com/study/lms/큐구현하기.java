package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 큐구현하기{
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      
      int n = scan.nextInt();int m = scan.nextInt();
      Queue q = new Queue(n);
    
      for(int i=1;i<=m;i++)
      {
        int x = scan.nextInt();
        if(x==1)
        {
          int z = scan.nextInt();
          int r = q.push(z);
          if(r==-1){System.out.println("Overflow");}
        }
        else if(x==2)
        {
          int r = q.pop();
          if(r==-1){System.out.println("Underflow");}
        }
        else if(x==3)
        {
          int r = q.front();
          
          if(r==-1){System.out.println("NULL");}
          else{System.out.println(r);}
        }
      }
      
      
      scan.close();
    }
}

class Queue
{
  //create
  //push(x)
  //pop()
  //front()
  int len;
  int f;int r;
  int[] arr;
  public Queue(int n)
  {
    arr = new int[n];
    len = n;
    f=0;r=0;
  }
  public int push(int x)
  {
    if(r==len){return -1;}
    arr[r]=x;r+=1;
    // System.out.println(Arrays.toString(arr)+" "+"f:"+f+" r:"+r);
    return 0;
  }
  public int pop()
  {
    if(f==r){return -1;}
    arr[f]=0;
    f+=1;
    // System.out.println(Arrays.toString(arr)+" "+"f:"+f+" r:"+r);
    return 0;
  }
  public int front()
  {
    if(f==r){return -1;}
    // System.out.println(Arrays.toString(arr)+" "+"f:"+f+" r:"+r);
    return arr[f];
  }
  
}