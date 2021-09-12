package com.study.bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class P1339OtherSolution2 {
  private static String[] words;
  private static HashMap<Character, Integer> pair;
  private static ArrayList<Character> keys;
  private static int MAX;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    pair = new HashMap<>();

    words = new String[N];
    for (int i = 0; i < N; i++) {
      words[i] = br.readLine();
      for (char c : words[i].toCharArray()) {
        pair.put(c, -1);
      }
    }

    keys = new ArrayList<>(pair.keySet());
    MAX = Integer.MIN_VALUE;

    char key = keys.get(0);
    for (int i = 0; i <= 9; i++) {
      pair.replace(key, i);
      DFS(1);
      pair.replace(key, -1);
    }

    System.out.println(MAX);
  }

  private static void DFS(int count) {
    if (count == keys.size()) {
      int total = 0;

      for (String word : words) {
        int value = 0;

        for (char c : word.toCharArray()) {
          value *= 10;
          value += pair.get(c);
        }

        total += value;
      }

      if (total > MAX) {
        MAX = total;
      }

      return;
    }

    char key = keys.get(count);
    for (int i = 0; i <= 9; i++) {
      if (pair.containsValue(i)) continue;

      pair.replace(key, i);
      DFS(count + 1);
      pair.replace(key, -1);
    }
  }
}



