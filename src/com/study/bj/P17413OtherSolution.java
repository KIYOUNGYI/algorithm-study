package com.study.bj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17413OtherSolution {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    Stack<Character> st = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char tmp = s.charAt(i);

      if (tmp == '<') {
        while (!st.empty()) {
          System.out.print(st.pop());
        }
        System.out.print('<');

        i++;
        while (s.charAt(i) != '>') {
          System.out.print(s.charAt(i));
          i++;
        }
        System.out.print('>');
      } else if (tmp == ' ') {
        while (!st.empty()) {
          System.out.print(st.pop());
        }
        System.out.print(" ");
      } else {
        st.add(tmp);
      }
    }
    while (!st.empty()) {
      System.out.print(st.pop());
    }
  }

}
