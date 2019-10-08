package com.study.lms;

import java.util.Scanner;
public class fmttalpha{
    
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int a = scan.nextInt();
      int b = scan.nextInt();
      
      if((b-a)==2){System.out.println(2);return;}
      if((b-a)==1){System.out.println(1);return;}
      if((b-a)==0){System.out.println(1);return;}
      
      int given = b-a;
      
      int idx=3;int cnt=2;int value=3;
    
      while(true)
      {
        for(int i=0;i<cnt;i++)
        {
          if(idx==given){System.out.println(value);return;}
          idx+=1;
        }
        value+=1;
        
        for(int i=0;i<cnt;i++)
        {
         
          if(idx==given){System.out.println(value);return;}
           idx+=1;
        }
        value+=1;
        
        cnt+=1;
      }
      
     
    }
}