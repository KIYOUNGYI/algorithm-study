package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13913_OtherSolution {

  public static int N;
  public static int K;

  public static int[] isVisited = new int[100001];
  public static int[] parents = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer token = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(token.nextToken());
    K = Integer.parseInt(token.nextToken());

    findFastRoute();
    printRoute();
  }

  public static void findFastRoute() {

    Queue<Integer> route = new LinkedList<>();
    route.add(N);
    isVisited[N] = 1;       // 시작점

    while (!route.isEmpty()) {
      int X = route.poll();

      if (X == K) {
        return;
      }

            /*
                case 1. (X-1)
                case 2. (X+1)
                case 3. 2X
            */
      if (isBoundary(X - 1) && isVisited[X - 1] == 0) {           // Case 1
        route.add(X - 1);
        isVisited[X - 1] = isVisited[X] + 1;
        parents[X - 1] = X;
      }

      if (isBoundary(X + 1) && isVisited[X + 1] == 0) {           // Case 2
        route.add(X + 1);
        isVisited[X + 1] = isVisited[X] + 1;
        parents[X + 1] = X;
      }
      if (isBoundary(X * 2) && isVisited[X * 2] == 0) {             // Case 3
        route.add(2 * X);
        isVisited[2 * X] = isVisited[X] + 1;
        parents[2 * X] = X;
      }
    }
  }

  public static boolean isBoundary(int num) {
    if (num < 0 || num > 100000) {
      return false;
    }
    return true;
  }

  public static void printRoute() {
    StringBuilder route = new StringBuilder();

    route.append(isVisited[K] - 1 + "\n");

    Stack<Integer> reverse = new Stack<>();

    reverse.push(K);
    int parent = K;
    while (parent != N) {
      reverse.push(parents[parent]);
      parent = parents[parent];
    }

    while (!reverse.isEmpty()) {
      route.append(reverse.pop() + " ");
    }
    System.out.println(route.toString());
  }

}
