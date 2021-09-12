package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P15662_톱니바퀴_2_v2 {

  static int T;
  static int[][] arr;
  static int[] r;//rotation
  static int commandCnt;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());

    arr = new int[T + 1][8];
    r = new int[T + 1];

    for (int j = 0; j < T; j++) {
      String temp = br.readLine();
      String[] x = temp.split("");

      for (int k = 0; k < x.length; k++) {
        arr[j + 1][k] = Integer.parseInt(x[k]);
      }
    }

    commandCnt = Integer.parseInt(br.readLine());
    for (int j = 0; j < commandCnt; j++) {
      String temp = br.readLine();
      String[] x = temp.split(" ");
      int firstGear = Integer.parseInt(x[0]);
      int direction = Integer.parseInt(x[1]);// (1) -> right_shift, (-1) -> left_shift

      solution(firstGear, direction);
      System.out.println(Arrays.toString(r));
      r = new int[T + 1];
    }

    printArr();
    answer();
    bw.flush();
  }

  private static void solution(int firstGear, int curDirection) throws IOException {

    //rotate myself
    r[firstGear] = curDirection;
    shift(firstGear);
    System.out.println("최초");
    printArr();
    System.out.println("---");
    for (int s = firstGear; s <= T - 1; s++) {

      System.out.println("arr[" + s + "][2]:" + arr[s][2] + " arr[" + (s + 1) + "][6]:" + arr[s + 1][6]);

    }
    System.out.println("---------");
    for (int s = firstGear; s >= 2; s--) {
      System.out.println("!!!!" + s);
      System.out.println("arr[" + s + "][6]:" + arr[s][6] + " arr[" + (s - 1) + "][2]:" + arr[s - 1][2]);
      if (arr[s][6] != arr[s - 1][2]) {
        r[s - 1] = -r[s];
        System.out.println("r["+(s)+"] : "+ r[s]+" r["+(s-1)+"]:"+ r[s-1]);
        //r[2] = -r[3]
        shift(s - 1);
        printArr();
        System.out.println("---");
      } else {
        System.out.println("b");
        break;
      }
    }

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
        System.out.print(arr[i][j] + "");
      }
      System.out.println();

    }
  }

  static void shift(int t) {
    System.out.println("shift : " + t);

    int[] temp = new int[8];
    //시계방향 (array right shift)
    if (r[t] == 1) {

      for (int i = 0; i < 8; i++) {
        temp[(i + 1) % 8] = arr[t][i];
      }

    } else if(r[t]==-1){//시계 반대 방향(array left shift)

      for (int i = 0; i < 8; i++) {
        temp[i] = arr[t][(i + 1) % 8];
        //      temp[i] = arr[(i + cnt) % arr.length];
      }
    }
    for (int i = 0; i < 8; i++) {
      arr[t][i] = temp[i];
    }
  }


}

//4
//11010111
//01111101
//11001110
//10000000
//1
//1 1