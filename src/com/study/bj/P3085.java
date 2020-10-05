package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 사탕게임
 * https://www.acmicpc.net/problem/3085
 */
public class P3085 {

  static int loopCnt = 0;

  static int MAX = Integer.MIN_VALUE;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int N;
  static char[][] arr;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];
    visit = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String temp = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = temp.charAt(j);
      }
    }
    candyGame();
    bw.write(MAX + "\n");
    bw.close();
  }

  public static void traverseAndPick(int x, int y) {
    char temp = ' ';
    for (int i = 0; i < 4; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      if (tx >= 0 && ty >= 0 && tx < N && ty < N && arr[x][y] != arr[tx][ty]) {
//        System.out.println("[기준 x,y:"+x+","+y+" 대상 tx,ty:"+tx+" "+ty+"] 루프 수:"+loopCnt++);
        swap(x, y, tx, ty);
//        System.out.println("swap");
//        printArr();
        calculate(tx, ty);
        visit = new boolean[N][N];
        swap(x, y, tx, ty);//recover
//        System.out.println("recover");
//        printArr();
      }
    }
  }

  public static void calculate(int tx, int ty) {

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int ax = i;
        int ay = j;
        if (visit[ax][ay] == false) {
          move(ax, ay);
        }
      }
    }

  }

  public static void move(int tx, int ty) {
    int cnt1 = 0;
    int cnt2 = 0;
//    System.out.println("from tx:ty ["+tx+","+ty+"]");
    char pivot = arr[tx][ty];
    int localMax = 0;
    for (int i = tx - 1; i >= 0; i--) {
      loopCnt++;
      if (arr[i][ty] != pivot) {
        break;
      }
      visit[i][ty] = true;
      cnt1 += 1;
//      System.out.println("[x:"+i+" y:"+ty+"]");
    }
    for (int i = tx + 1; i < N; i++) {
      loopCnt++;
      if (arr[i][ty] != pivot) {
        break;
      }
      visit[i][ty] = true;
      cnt1 += 1;
//      System.out.println("[x:"+i+" y:"+ty+"]");
    }
    cnt1 += 1;

    for (int i = ty - 1; i >= 0; i--) {
      loopCnt++;
      if (arr[tx][i] != pivot) {
        break;
      }
      visit[tx][i] = true;
      cnt2 += 1;
    }
    for (int i = ty + 1; i < N; i++) {
      loopCnt++;
      if (arr[tx][i] != pivot) {
        break;
      }
      visit[tx][i] = true;
      cnt2 += 1;
    }
    cnt2 += 1;
    localMax = max(cnt1, cnt2);
//    System.out.println("local max:"+localMax);
    if (MAX < localMax) {
      MAX = localMax;
    }
  }


  private static int max(int cnt1, int cnt2) {
    return cnt1 >= cnt2 ? cnt1 : cnt2;
  }

  public static void swap(int x, int y, int tx, int ty) {
    char temp = arr[tx][ty];
    arr[tx][ty] = arr[x][y];
    arr[x][y] = temp;
  }


  public static void candyGame() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        traverseAndPick(i, j);
      }
    }
  }

  public static void printArr() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
}
