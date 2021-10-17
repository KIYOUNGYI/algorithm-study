package com.study.codility.stack_queue;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string; S has the form "VW" where V and W are properly nested strings. For example, the string "{[()()]}" is properly
 * nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000]; string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * <p>
 * <p>
 * [100]
 * <p>
 * https://app.codility.com/demo/results/training5XEBKD-K82/
 * <p>
 * <p>
 * [45]
 * <p>
 * https://app.codility.com/demo/results/trainingQV63XV-7WU/
 */
public class Bracket {


  public static int solution(String S) {

    if (S.length() % 2 == 1) {
      return 0;
    }

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < S.length(); i++) {

      if (S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '[') {

        stack.push(S.charAt(i));

      } else {

        if (stack.isEmpty()) {
          return 0;
        }

        if (S.charAt(i) == ')') {

          Character peek = stack.peek();
          if (peek == '(') {
            stack.pop();
          } else {
            return 0;
          }
        } else if (S.charAt(i) == '}') {
          Character peek = stack.peek();
          if (peek == '{') {
            stack.pop();
          } else {
            return 0;
          }
        } else if (S.charAt(i) == ']') {
          Character peek = stack.peek();
          if (peek == '[') {
            stack.pop();
          } else {
            return 0;
          }
        }

      }

    }

    return stack.isEmpty() ? 1 : 0;
  }

  public static void main(String[] args) {

//    System.out.println(solution("{[()()]}"));
//
//    System.out.println(solution("([)()]"));

    System.out.println(solution(")("));
  }
}
