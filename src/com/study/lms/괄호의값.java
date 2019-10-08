package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class 괄호의값{
    // 문자열 s를 입력받는다.
    // 스택을 만든다.
    // answer arraylist 만든다.
    // 문자열 길이가 홀수면 0 출력하고 종료한다.
    // for(i 0~n)
    //  a[i]=( 이면 push,cur=cur*2;
    //  a[i]=[ 이면 push,cur=cur*3;
    //  a[i]=) 인데 비어있음 0,peek ( 아니면 0 종료 a[i-1] 이면 ans.add(cur);
    //  a[i]=] 인데 비어있음 0,peek ] 아니면 0 종료 a[i-1] 이면 ans.add(cur);
    // arraylist 안의 숫자 합 더하고 출력한다.
    
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      Stack<Character> stack = new Stack();
      ArrayList<Integer> ans = new ArrayList();
      String input = scan.nextLine();
      char[] s = input.toCharArray();
      // for(int i=0;i<s.length;i++){System.out.print(s[i]);}System.out.println();
      int cur=1;
      if(s.length%2==1){System.out.println(0);return;}
      
      for(int i=0;i<s.length;i++)
      {
        // System.out.println(ans.toString());
        
        if(s[i]=='(')
        {
          // System.out.println("!!!");
          stack.push(s[i]);
          cur=cur*2;
        }
        else if(s[i]=='[')
        {
          stack.push(s[i]);
          cur=cur*3;
        }
        else if(s[i]==')')
        {
          if(stack.isEmpty()){System.out.println(0);return;}
          if(stack.peek()!='('){System.out.println(0);return;}
          
          if(s[i-1]=='('){ans.add(cur);}
          stack.pop();
          cur = cur/2;          
        }
        else if(s[i]==']')
        {
          if(stack.isEmpty()){System.out.println(0);return;}
          if(stack.peek()!='['){System.out.println(0);return;}
          
          if(s[i-1]=='['){ans.add(cur);}
          stack.pop();
          cur = cur/3;       
        }
        
      }
      // System.out.println(ans.toString());
      int sum=0;
      for(int i=0;i<ans.size();i++)
      {
        sum+=ans.get(i);
      }
      System.out.println(sum);
      scan.close();
    }
}