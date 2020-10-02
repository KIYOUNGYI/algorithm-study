package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 덱
 * https://www.acmicpc.net/problem/10866
 */
public class P10866 {

  static int N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Deque<Integer> d = new LinkedList<>();
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
//      System.out.println(Arrays.toString(temp));
      if (temp[0].equals("push_back")) {
        int t = Integer.parseInt(temp[1]);
//        System.out.println("t:"+t);
//        System.out.println(t);
        d.addLast(t);
//        System.out.println(d.toString());
      } else if (temp[0].equals("push_front")) {
        int t = Integer.parseInt(temp[1]);
        d.addFirst(t);
      } else if (temp[0].equals("front")) {
        if (d.isEmpty()) {
          bw.write(-1 + "" + "\n");
        } else {
          bw.write(d.getFirst() + "\n");
        }
      } else if (temp[0].equals("back")) {
        if (d.isEmpty()) {
          bw.write(-1 + "" + "\n");
        } else {
          bw.write(d.getLast() + "\n");
        }
      } else if (temp[0].equals("size")) {
        bw.write(d.size() + "\n");
      } else if (temp[0].equals("empty")) {
        if (d.isEmpty()) {
          bw.write("1" + "\n");
        } else {
          bw.write("0" + "\n");
        }
      } else if (temp[0].equals("pop_back")) {
        if (d.isEmpty()) {
          bw.write("-1" + "\n");
        } else {
          bw.write(d.pollLast() + "\n");
        }

      } else if (temp[0].equals("pop_front")) {
        if (d.isEmpty()) {
          bw.write("-1" + "\n");
        } else {
          bw.write(d.pollFirst() + "\n");
        }
      }
//      System.out.println(d.toString());
    }
    bw.close();
  }
}
