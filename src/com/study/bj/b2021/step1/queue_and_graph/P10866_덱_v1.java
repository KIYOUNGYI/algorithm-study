package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P10866_덱_v1 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String t1 = br.readLine();
    int tc = Integer.parseInt(t1);

    MyDeck myDeck = new DeckImpl();

    for (int i = 0; i < tc; i++) {
      String temp = br.readLine();
//      System.out.println(temp);
      String[] input = temp.split(" ");

      if (input[0].equals("push_front")) {
        int v = Integer.parseInt(input[1]);

        myDeck.push_front(v);
      }
      if (input[0].equals("push_back")) {
        int v = Integer.parseInt(input[1]);
        myDeck.push_back(v);


      }
      if (input[0].equals("pop_front")) {
        int pf = myDeck.pop_front();
        bw.write(pf + "\n");
      }
      if (input[0].equals("pop_back")) {
        int pb = myDeck.pop_back();
        bw.write(pb + "\n");
      }
      if (input[0].equals("front")) {
        int front = myDeck.front();
        bw.write(front + "\n");

      }
      if (input[0].equals("back")) {
        int back = myDeck.back();
        bw.write(back + "\n");
      }
      if (input[0].equals("size")) {
        int size = myDeck.size();
        bw.write(size + "\n");
      }
      if (input[0].equals("empty")) {
        int empty = myDeck.isEmpty();
        bw.write(empty + "\n");
      }

    }
    bw.flush();
    bw.close();

  }

  static class DeckImpl implements MyDeck {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    @Override
    public void push_front(int x) {
      arrayList.add(0, x);
    }

    @Override
    public void push_back(int x) {
      int s = arrayList.size();
      arrayList.add(s, x);
    }

    @Override
    public int pop_front() {

      if (size() <= 0) {
        return -1;
      }

      int t = arrayList.get(0);
      arrayList.remove(0);
      return t;
    }

    @Override
    public int pop_back() {

      if (size() <= 0) {
        return -1;
      }
      int t = arrayList.get(size() - 1);
      arrayList.remove(size() - 1);

      return t;
    }

    @Override
    public int size() {

      return arrayList.size();
    }

    @Override
    public int isEmpty() {
      if (size() <= 0) {
        return 1;
      }
      return 0;
    }

    @Override
    public int front() {
      if (size() <= 0) {
        return -1;
      }
      return arrayList.get(0);
    }

    @Override
    public int back() {
      if (size() <= 0) {
        return -1;
      }
      int t = arrayList.get(size() - 1);
      return t;
    }
  }

  interface MyDeck {

    void push_front(int x);

    void push_back(int x);

    int pop_front();

    int pop_back();

    int size();

    int isEmpty();

    int front();

    int back();
  }
}
//2
//1
//2
//0
//2
//1
//-1
//-1<----
//1
//-1
//0
//
//3