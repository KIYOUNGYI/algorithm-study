package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class P13913Second {

  static final int limit = 100_001;
  static int n, k;
  static int[] parent = new int[limit];
  static int[] visit = new int[limit];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    StringTokenizer token = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(token.nextToken());
    k = Integer.parseInt(token.nextToken());

    bfs(n);
    printAnswer();
    scan.close();
  }

  public static void printAnswer() throws IOException {
    int d = parent[k];
    StringBuilder route = new StringBuilder();
    route.append(visit[k] - 1 + "\n");

    Stack<Integer> reverse = new Stack<>();
    reverse.push(k);
    int par = k;
    while (par != n) {
      reverse.push(parent[par]);
      par = parent[par];
    }
    while (!reverse.isEmpty()) {
      route.append(reverse.pop() + " ");
    }
    System.out.println(route.toString());

    return;
  }

  public static void bfs(int x) throws IOException {
    q.add(x);
    visit[x] = 1;
    while (!q.isEmpty()) {
      int t = q.poll();

      if (t == k) {
        return;
      }

      if (t - 1 >= 0 && visit[t - 1] == 0) {
        parent[t - 1] = t;
        visit[t - 1] = visit[t] + 1;
        q.add(t - 1);

      }
      if (t + 1 <= 100_000 && visit[t + 1] == 0) {
        parent[t + 1] = t;
        visit[t + 1] = visit[t] + 1;

        q.add(t + 1);

      }
      if (t * 2 <= 100_000 && visit[t * 2] == 0) {
        parent[t * 2] = t;
        visit[t * 2] = visit[t] + 1;
        q.add(t * 2);

      }
    }
    bw.close();
//    System.out.println(score[k]);
  }
}
