package com.study.codility.stack_queue;

import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty; S has the form "(U)" where U is a properly nested string; S has the form "VW" where V and W are properly nested strings. For example, string "(()(())())" is properly nested but string
 * "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000]; string S consists only of the characters "(" and/or ")".
 * <p>
 * https://app.codility.com/demo/results/trainingSK2UYS-GQD/
 */
public class Nesting {


  public static int solution(String input) {

    if (input.length() % 2 == 1) {
      return 0;
    }

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {

      if (input.charAt(i) == '(') {
        stack.push(input.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return 0;
        } else {
          if (stack.peek() == '(') {
            stack.pop();
          } else {
            return 0;
          }
        }
      }
    }

    if (!stack.isEmpty()) {
      return 0;
    }

    return 1;
  }

  public static void main(String[] args) {

    System.out.println(solution(")("));
  }
}
