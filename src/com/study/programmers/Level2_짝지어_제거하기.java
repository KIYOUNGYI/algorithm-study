package com.study.programmers;

import java.util.Stack;

public class Level2_짝지어_제거하기 {

  public static int solution(String input) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {

      if (stack.isEmpty()) {
        stack.push(input.charAt(i));
      } else {
        Character peek = stack.peek();
        if (peek == input.charAt(i)) {
          stack.pop();
        } else {
          stack.push(input.charAt(i));
        }
      }
    }

    return stack.isEmpty() ? 1 : 0;
  }

  public static void main(String[] args) {
    System.out.println(solution("cdcd"));
  }
}
