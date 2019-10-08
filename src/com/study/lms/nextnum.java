package com.study.lms;

import java.util.Scanner;
public class nextnum{

    
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      
      int a=scan.nextInt();
      int b=scan.nextInt();
      int c=scan.nextInt();
      
      if(a==0 && b==0 && c==0)return;
      
      int sub;
      int mul;
      while(true)
      {
        if(b-a == c-b && c-b!=0)
        {
          sub = b-a;
          System.out.println("AP"+" "+(c+sub));
        }
        else if(b/a == c/b)
        {
          mul = c/b;
          System.out.println("GP"+" "+(c*mul));
        }
        
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        if(a==0 && b==0 && c==0)break;
      }
      
      
      scan.close();
    }
}