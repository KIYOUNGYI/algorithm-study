package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15662_톱니바퀴_2 {

  static int T;
  static int[][] arr;
  static int[] r;//rotation
  static int commandCnt;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());

    arr = new int[T + 1][8];
    r = new int[T+1];

    for (int j = 0; j < T; j++) {
      String temp = br.readLine();
      String[] x = temp.split("");

      for (int k = 0; k < x.length; k++) {
        arr[j + 1][k] = Integer.parseInt(x[k]);
      }
    }

//    printArr();

    commandCnt = Integer.parseInt(br.readLine());
    for (int j = 0; j < commandCnt; j++) {
      String temp = br.readLine();
      String[] x = temp.split(" ");
      int firstGear = Integer.parseInt(x[0]);
      int direction = Integer.parseInt(x[1]);// (1) -> right_shift, (-1) -> left_shift

      solution(firstGear, direction);

    }

//    printArr();

    answer();
    bw.flush();
  }

  private static void solution(int firstGear, int curDirection) {

    //rotate myself


  }


  private static void answer() {
    int cnt = 0;
    for (int i = 1; i <= T; i++) {
      if (arr[i][0] == 1) {
        cnt += 1;
      }
    }
    System.out.println("cnt:" + cnt);
  }

  private static void printArr() throws IOException {

    for (int i = 1; i <= T; i++) {

      for (int j = 0; j < 8; j++) {
        bw.write(arr[i][j] + " ");
      }
      bw.write("\n");

    }
  }

  static void shiftLeft(int t) {


    int[] temp = new int[8];

    for (int i = 0; i < 8; i++) {
      temp[i] = arr[t][(i + 1) % temp.length];
      //      temp[i] = arr[(i + cnt) % arr.length];
    }

    for (int i = 0; i < 8; i++) {
      arr[t][i] = temp[i];
    }
  }


  static int shiftRightAndReturnNextDir(int t) {

    int[] temp = new int[8];

    for (int i = 0; i < 8; i++) {
      temp[(i + 1) % 8] = arr[t][i];
    }

    for (int i = 0; i < 8; i++) {
      arr[t][i] = temp[i];
    }
    return -1;
  }

  static int shiftLeftAndReturnNextDir(int t) {

    int[] temp = new int[8];

    for (int i = 0; i < 8; i++) {
      temp[i] = arr[t][(i + 1) % temp.length];
      //      temp[i] = arr[(i + cnt) % arr.length];
    }

    for (int i = 0; i < 8; i++) {
      arr[t][i] = temp[i];
    }
    return 1;
  }


  static void shiftRight(int t) {

    int[] temp = new int[8];

    for (int i = 0; i < 8; i++) {
      temp[(i + 1) % 8] = arr[t][i];
    }

    for (int i = 0; i < 8; i++) {
      arr[t][i] = temp[i];
    }
  }

  public static int rotate(int cur) {
    if (cur == 1) {
      return -1;
    } else {
      return 1;
    }
  }


  private static void solutionTemp(int firstGear, int direction) {
//    System.out.println("firstGear = " + firstGear + ", direction = " + direction);

    int tempDir = direction;

    if (tempDir == 1) {
      shiftRight(firstGear);
    } else {
      shiftLeft(firstGear);
    }

    int std1 = arr[firstGear][2];
    int curDir = direction;

    int std2 = arr[firstGear][6];
    int curDir2 = direction;

    //gear -> right
    for (int start = firstGear + 1; start <= T - 1; start++) {
      if (std1 != arr[start][6]) {
        //반대방향으로 회전
        int x = rotate(curDir);

        if (x == 1) {
          shiftRight(start);
        } else {
          shiftLeft(start);
        }
      } else {
        break;
      }

    }

    for (int start = firstGear - 1; start >= 1; start--) {

      if (std2 != arr[start][2]) {
        //반대방향으로 회전
        int x = rotate(curDir2);

        if (x == 1) {
          shiftRight(start);
        } else {
          shiftLeft(start);
        }
      } else {
        break;
      }

    }

  }


}
