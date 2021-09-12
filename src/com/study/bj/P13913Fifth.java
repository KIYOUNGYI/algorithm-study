package com.study.bj;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13913Fifth {

  static final int limit = 100_001;
  static int n, k;
  static int[] parent = new int[limit];
  static int[] score = new int[limit];
  static boolean[] visit = new boolean[limit];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static Queue<Integer> q = new LinkedList<>();
  static ArrayList<Integer> ans = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    String[] temp = br.readLine().split(" ");
    n = Integer.parseInt(temp[0]);
    k = Integer.parseInt(temp[1]);
    if (n >= k) {
      bw.write(n - k + "\n");
      for (int i = n; i >= k; i--) {
        bw.write(i + " ");
      }
      bw.write("\n");
      bw.close();
      return;
    }
    bfs(n);
    scan.close();
  }

  public static void bfs(int x) throws IOException {
    q.add(x);
    visit[x] = true;
    score[x] = 0;
    while (!q.isEmpty()) {
      int t = q.poll();
      int s = score[t];
      if (t == k) {
        bw.write(score[k] + "\n");//4
        bw.close();
        return;
      }

      if (t - 1 >= 0 && visit[t - 1] == false) {
        parent[t - 1] = t;
        visit[t - 1] = true;
        score[t - 1] = s + 1;
        q.add(t - 1);

      }
      if (t + 1 <= 100_000 && visit[t + 1] == false) {
        parent[t + 1] = t;
        visit[t + 1] = true;
        score[t + 1] = s + 1;
        q.add(t + 1);

      }
      if (t * 2 <= 100_000 && visit[t * 2] == false) {
        parent[t * 2] = t;
        visit[t * 2] = true;
        score[t * 2] = s;
        q.add(t * 2);
      }
    }
    bw.close();
//    System.out.println(score[k]);
  }
}