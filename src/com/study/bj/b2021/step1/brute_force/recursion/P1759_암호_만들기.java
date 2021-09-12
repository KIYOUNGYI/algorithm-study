package com.study.bj.b2021.step1.brute_force.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1759_암호_만들기 {

  static int n, r;
  static int[] visit;
  static int[] arr;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    inputAndInit(br);

    Arrays.sort(arr);

    dfs(0, 0);

    bw.flush();
    bw.close();
  }

  private static void dfs(int depth, int cnt) throws IOException {

    if (cnt == n) {
      print();
      return;
    }

    if (depth == r) {
      return;
    }

    visit[depth] = 1;
    dfs(depth + 1, cnt + 1);
    visit[depth] = 0;
    dfs(depth + 1, cnt);

  }

  private static void print() throws IOException {

    StringBuilder sb = new StringBuilder();

    int jCnt = 0;
    int mCnt = 0;

    for (int i = 0; i < r; i++) {
      if (visit[i] == 1) {
        sb.append((char) arr[i]);
        if ((char) arr[i] == 'a' || (char) arr[i] == 'e' || (char) arr[i] == 'i' || (char) arr[i] == 'o' || (char) arr[i] == 'u') {
          jCnt += 1;
        }
        if (
            (char) arr[i] == 'b' ||
                (char) arr[i] == 'c' ||
                (char) arr[i] == 'd' ||
                (char) arr[i] == 'f' ||
                (char) arr[i] == 'g' ||
                (char) arr[i] == 'h' ||
                (char) arr[i] == 'j' ||
                (char) arr[i] == 'k' ||
                (char) arr[i] == 'l' ||
                (char) arr[i] == 'm' ||
                (char) arr[i] == 'n' ||
                (char) arr[i] == 'p' ||
                (char) arr[i] == 'q' ||
                (char) arr[i] == 'r' ||
                (char) arr[i] == 's' ||
                (char) arr[i] == 't' ||
                (char) arr[i] == 'v' ||
                (char) arr[i] == 'w' ||
                (char) arr[i] == 'x' ||
                (char) arr[i] == 'y' ||
                (char) arr[i] == 'z') {
          mCnt += 1;
        }

      }
    }

    if (jCnt >= 1 && mCnt >= 2) {
      System.out.println(sb.toString());
    }
  }


  private static void inputAndInit(BufferedReader br) throws IOException {

    String nAndr = br.readLine();

    String[] nAndrArr = nAndr.split(" ");
    n = Integer.parseInt(nAndrArr[0]);
    r = Integer.parseInt(nAndrArr[1]);

    String alphabets = br.readLine();

    String[] alphabetsArr = alphabets.split(" ");

    arr = new int[alphabetsArr.length];
    for (int i = 0; i < alphabetsArr.length; i++) {
      arr[i] = (int) alphabetsArr[i].charAt(0);
    }

    visit = new int[r];
  }


}
