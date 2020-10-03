package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 단어 뒤집기 2
 * https://www.acmicpc.net/problem/17413
 */
public class P17413 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    problem(input, bw);
    bw.close();
  }

  public static void problem(String input, BufferedWriter bw) throws IOException {
    Stack<Character> s = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int len = input.length();

    for (int i = 0; i < len; i++) {
      int start = i;
      if (input.charAt(i) == '<') {
        while (!s.isEmpty()) {
          sb.append(s.pop());
        }

        StringBuilder temp = new StringBuilder();
        start = i;
        for (int j = start; j < input.length(); j++) {
          temp.append(input.charAt(j));
          if (input.charAt(j) == '>') {
            i = j;
            sb.append(temp);
            break;
          }
        }
        continue;
      }

      if (input.charAt(i) != ' ') {
        s.push(input.charAt(i));
      } else {
        while (!s.isEmpty()) {
          sb.append(s.pop());
        }
        sb.append(" ");
      }
    }

    while (!s.isEmpty()) {
      sb.append(s.pop());
    }

    bw.write(sb.toString());
    bw.close();
  }
}
