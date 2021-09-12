package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14426_이모티콘 {


  static int target;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    target = scan.nextInt();
    bfs();

  }

  public static void bfs() {
    boolean[] v = new boolean[1001];
    String startA = "a";
    Queue<Point> q = new LinkedList<>();
    v[1] = true;
    Point pt1 = new Point("copy", "a", 1, startA);
    q.add(pt1);

    while (!q.isEmpty()) {

      Point pt = q.poll();

      System.out.println("pt : " + pt.toString());
      String type = pt.getType();//copy
      String clip = pt.getClipBoard();//클립보
      String currentStr = pt.getCurrentStr();//현재문자열
      int time = pt.getTime();
      int tempLen = currentStr.length();
      if (currentStr.length() == target) {
        System.out.println(pt.getTime());
        return;
      }

//      if (!v[currentStr.length()]) {

        String clip2 = currentStr;
        String currentStr2 = currentStr;
        int time2 = pt.getTime() + 1;
        Point pt2 = new Point("copy", clip2, time2, currentStr2);
//      if (!v[currentStr2.length()]) {
        v[currentStr2.length()] = true;
        q.add(pt2);
//      }

        String clip3 = clip;
        String currentStr3 = clip + currentStr;
        int time3 = pt.getTime() + 1;
        Point pt3 = new Point("paste", clip3, time3, currentStr3);
//      if (!v[currentStr3.length()]) {
        v[currentStr3.length()] = true;
        q.add(pt3);
//      }

        int l = currentStr.length();
        if (l >= 1) {
          String temp = currentStr.substring(0, l - 1);
          String clip4 = clip;
          int time4 = pt.getTime() + 1;
          Point pt4 = new Point("del", clip4, time4, temp);
//        if (!v[temp.length()]) {
//          v[temp.length()] = true;
          q.add(pt4);
//        }
        }
//      }

//      v[currentStr.length()] = true;

    }
//    }

//    }

  }

  static class Point {

    String type;//copy,paste,del
    String clipBoard;
    int time;
    String currentStr;

    public String getType() {
      return type;
    }

    public String getClipBoard() {
      return clipBoard;
    }

    public int getTime() {
      return time;
    }

    public String getCurrentStr() {
      return currentStr;
    }

    public Point(String type, String clipBoard, int time, String currentStr) {
      this.type = type;
      this.clipBoard = clipBoard;
      this.time = time;
      this.currentStr = currentStr;
    }

    @Override
    public String toString() {
      return "Point{" +
          "type='" + type + '\'' +
          ", clipBoard='" + clipBoard + '\'' +
          ", time=" + time +
          ", currentStr='" + currentStr + '\'' +
          '}';
    }
  }
}
