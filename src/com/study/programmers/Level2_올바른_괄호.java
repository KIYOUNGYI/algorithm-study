package com.study.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_올바른_괄호 {

  static boolean solution(String s) {

    if (s.length() % 2 == 1) {
      return false;
    }

    Queue<Character> q = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);
      if (c == '(') {
        q.add('(');
      } else if (c == ')') {

        if(q.isEmpty()){
          return false;
        }

        Character poll = q.poll();
        if (poll != '(') {
          return false;
        }
      }
    }

    if(!q.isEmpty()){
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(solution("()()"));
  }
}
