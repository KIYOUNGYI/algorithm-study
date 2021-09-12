package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

public class P14499_주사위_굴리기 {

  static int[] dice = new int[7];
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int[][] map;
  static int sero, garo, startX, startY, command;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    sero = scan.nextInt();
    garo = scan.nextInt();
    startX = scan.nextInt();
    startY = scan.nextInt();
    command = scan.nextInt();

    map = new int[sero][garo];

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        map[i][j] = scan.nextInt();
      }
    }

    int tx = startX;
    int ty = startY;

    for (int i = 0; i < command; i++) {
      int t = scan.nextInt();
      t = t - 1;

      int backupX = tx;
      int backupY = ty;

      tx = tx + dx[t];
      ty = ty + dy[t];

      if (tx >= 0 && ty >= 0 && tx < sero && ty < garo) {

//        System.out.println("command:" + (t + 1) + " tx:" + tx + " ty:" + ty);

        if (t == 0) {//동
          int[] temp = new int[7];

          temp[1] = dice[4];//
          temp[2] = dice[2];
          temp[3] = dice[1];//
          temp[4] = dice[6];//
          temp[5] = dice[5];
          temp[6] = dice[3];//

          for (int j = 1; j < 7; j++) {
            dice[j] = temp[j];
          }

//          if (dice[6] == 0) {
//            dice[6] = map[tx][ty];
//            map[tx][ty] = 0;
//          } else {
//            map[tx][ty] = dice[6];
//            dice[6] = 0;
//          }
          if (map[tx][ty] == 0) {
            map[tx][ty] = dice[6];
          } else {
            dice[6] = map[tx][ty];
            map[tx][ty] = 0;
          }

        } else if (t == 1) {//서

          int[] temp = new int[7];

          temp[1] = dice[3];//
          temp[2] = dice[2];
          temp[3] = dice[6];//
          temp[4] = dice[1];//
          temp[5] = dice[5];
          temp[6] = dice[4];//

          for (int j = 1; j < 7; j++) {
            dice[j] = temp[j];
          }

          if (map[tx][ty] == 0) {
            map[tx][ty] = dice[6];
          } else {
            dice[6] = map[tx][ty];
            map[tx][ty] = 0;
          }

        } else if (t == 2) {//북

          int[] temp = new int[7];

          temp[1] = dice[5];//
          temp[2] = dice[1];//
          temp[3] = dice[3];
          temp[4] = dice[4];
          temp[5] = dice[6];//
          temp[6] = dice[2];//

          for (int j = 1; j < 7; j++) {
            dice[j] = temp[j];
          }

          if (map[tx][ty] == 0) {
            map[tx][ty] = dice[6];
          } else {
            dice[6] = map[tx][ty];
            map[tx][ty] = 0;
          }


        } else if (t == 3) {//남

          int[] temp = new int[7];

          temp[1] = dice[2];//
          temp[2] = dice[6];//
          temp[3] = dice[3];
          temp[4] = dice[4];
          temp[5] = dice[1];//
          temp[6] = dice[5];//

          for (int j = 1; j < 7; j++) {
            dice[j] = temp[j];
          }

          if (map[tx][ty] == 0) {
            map[tx][ty] = dice[6];
          } else {
            dice[6] = map[tx][ty];
            map[tx][ty] = 0;
          }

        }

        System.out.println(dice[1]);
      } else {
//        System.out.println("command:" + (t + 1) + " ignored");
        tx = backupX;
        ty = backupY;


      }


    }


  }

  private static void printArr() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }


}
