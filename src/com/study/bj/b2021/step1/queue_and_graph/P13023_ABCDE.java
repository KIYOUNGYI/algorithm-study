//package com.study.bj.b2021.step1.queue_and_graph;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class P13023_ABCDE {
//
//  static ArrayList<Edge> edges = new ArrayList<Edge>();
//  static int[][] matrix;
//  static ArrayList<Integer>[] arrList;
//
//  static int node, edge;
//
//  public static void main(String[] args) {
//
//    Scanner scan = new Scanner(System.in);
//    node = scan.nextInt();
//    edge = scan.nextInt();
//
//    arrList = new ArrayList[node];
//    for (int i = 0; i < node; i++) {
//      arrList[i] = new ArrayList<>();
//    }
//    matrix = new int[node][node];
//
//    for (int i = 1; i <= edge; i++) {
//
//      int x = scan.nextInt();
//      int y = scan.nextInt();
//      edges.add(new Edge(x, y));
//      edges.add(new Edge(y, x));
//
//      matrix[x][y] = 1;
//      matrix[y][x] = 1;
//
//      arrList[x].add(y);
//      arrList[y].add(x);
//    }
//
//    for (int i = 0; i < edge; i++) {
//      Collections.sort(arrList[i]);
//    }
//
//    printEdgeList();
//    printMatrix();
//    printArrList();
//  }
//
//  private static void printArrList() {
//    for (int i = 0; i < node; i++) {
//      System.out.println("node : " + i + " " + arrList[i].toString());
//    }
//  }
//
//  private static void printMatrix() {
//
//    for (int i = 0; i < node; i++) {
//      for (int j = 0; j < node; j++) {
//        System.out.print(matrix[i][j] + " ");
//      }
//      System.out.println();
//    }
//  }
//
//  private static void printEdgeList() {
//    for (int i = 0; i < edges.size(); i++) {
//      System.out.print(edges.get(i)+" ");
//    }
//    System.out.println();
//  }
//
//  static class Edge implements Comparable {
//
//    int from, to;
//
//    Edge(int from, int to) {
//      this.from = from;
//      this.to = to;
//    }
//
//    @Override
//    public String toString() {
//      return "Edge{" +
//          "from=" + from +
//          ", to=" + to +
//          '}';
//    }
//
//    @Override
//    public int compareTo(Object o) {
//
//
//    }
//  }
//}
