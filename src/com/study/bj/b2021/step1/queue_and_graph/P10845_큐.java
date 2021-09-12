package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P10845_큐 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String x = br.readLine();
      String[] input = x.split(" ");

      solve(input);

    }
  }

  private static void solve(String[] input) {

    MyQueue q = new MyQueue();
//    System.out.println("command : " + Arrays.toString(input));
    if (input[0].equals("push")) {

      q.push(Integer.parseInt(input[1]));

    } else if (input[0].equals("pop")) {

      System.out.println(q.pop());

    } else if (input[0].equals("front")) {

      System.out.println(q.front());

    } else if (input[0].equals("back")) {

      System.out.println(q.back());

    } else if (input[0].equals("size")) {

      System.out.println(q.size());

    } else if (input[0].equals("empty")) {

      System.out.println(q.isEmpty());

    }

  }

  public static class MyQueue implements CustomQueue {

    static List<Integer> arrList = new ArrayList<Integer>();

    @Override
    public void push(int element) {
      arrList.add(element);
    }

    @Override
    public int front() {
      return size() > 0 ? arrList.get(0) : -1;
    }

    @Override
    public int back() {

      int size = size();

      return size > 0 ? arrList.get(size - 1) : -1;
    }

    @Override
    public int isEmpty() {
      return size() > 0 ? 0 : 1;
    }

    @Override
    public int size() {
      return arrList.size();
    }

    @Override
    public int pop() {
      if (size() > 0) {
        return arrList.remove(0);
      } else {
        return -1;
      }
    }
  }

  interface CustomQueue {

    void push(int element);

    int front();

    int back();

    int isEmpty();

    int size();

    int pop();
  }

}
