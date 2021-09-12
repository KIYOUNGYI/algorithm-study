package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P16935_배열_돌리기_3_v2 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static Scanner scan = new Scanner(System.in);
  static int n, m, calculationCount;
  static int type;
  static int[][] arr;
  static int[][] temp;
  static int[][] visit;
  static int[][] arr2;
  static int[][] temp2;

  static ArrayList<Integer>[] inputArr;


  public static void main(String[] args) throws IOException {

    input2();
    calculate();

  }

  private static void calculate() {

    if (type == 1) {

      arrListTo2ndDimensionArr();

      if (calculationCount % 2 == 0) {
        printArr();
        return;
      }
      type1();

    } else if (type == 2) {

      arrListTo2ndDimensionArr();
      type2();


    } else if (type == 3) {
      type3();
    } else if (type == 4) {
      type4();
    } else if (type == 5) {
      type5();
    } else if (type == 6) {
      type6();
    }

  }

  private static void type6() {

  }

  private static void type5() {

    arrListTo2ndDimensionArr();

    int i = n / 2;
    int j = m / 2;
    int[][] t = new int[150][150];
    if (calculationCount % 4 == 1) {

      for (int a = i + 1; a <= n; a++) {
        for (int b = j + 1; b <= m; b++) {
          t[a][b - j] = arr[a][b];
        }
      }

      for (int a = i + 1; a <= n; a++) {
        for (int b = 1; b <= j; b++) {
          t[a - i][b] = arr[a][b];
        }
      }

      for (int a = 1; a <= i; a++) {
        for (int b = 1; b <= j; b++) {
          t[a][b + j] = arr[a][b];
        }
      }
      for (int a = 1; a <= i; a++) {
        for (int b = j + 1; b <= m; b++) {
          t[a + i][b] = arr[a][b];
        }
      }

      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= m; b++) {
          System.out.print(t[a][b] + " ");
        }
        System.out.println();
      }

    } else if (calculationCount % 4 == 2) {

      for (int a = i + 1; a <= n; a++) {
        for (int b = j + 1; b <= m; b++) {
          t[a - i][b - j] = arr[a][b];
        }
      }
      //4,1 4,2
      for (int a = i + 1; a <= n; a++) {
        for (int b = 1; b <= j; b++) {
          t[a - i][b + j] = arr[a][b];
        }
      }

      for (int a = 1; a <= i; a++) {
        for (int b = 1; b <= j; b++) {
          t[a + i][b + j] = arr[a][b];
        }
      }
      for (int a = 1; a <= i; a++) {
        for (int b = j + 1; b <= m; b++) {
          t[a + i][b - j] = arr[a][b];
        }
      }

      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= m; b++) {
          System.out.print(t[a][b] + " ");
        }
        System.out.println();
      }


    } else if (calculationCount % 4 == 3) {

      for (int a = i + 1; a <= n; a++) {
        for (int b = j + 1; b <= m; b++) {
          t[a - i][b] = arr[a][b];
        }
      }
      for (int a = i + 1; a <= n; a++) {
        for (int b = 1; b <= j; b++) {
          t[a][b + j] = arr[a][b];
        }
      }

      for (int a = 1; a <= i; a++) {
        for (int b = 1; b <= j; b++) {
          t[a + i][b] = arr[a][b];
        }
      }
      for (int a = 1; a <= i; a++) {
        for (int b = j + 1; b <= m; b++) {
          t[a][b - j] = arr[a][b];
        }
      }

      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= m; b++) {
          System.out.print(t[a][b] + " ");
        }
        System.out.println();
      }

    } else if (calculationCount % 4 == 0) {
      //skip
      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= m; b++) {
          System.out.print(arr[a][b] + " ");
        }
        System.out.println();
      }
    }
  }


  private static void type2() {
    for (int i = 1; i <= calculationCount; i++) {
      leftRight();
      copyAndInit();
    }
    printArr();
  }

  private static void arrListTo2ndDimensionArr() {
    for (int i = 1; i <= n; i++) {
      int idx = 0;
      ArrayList<Integer> arrayList = inputArr[i];
      for (int j = 1; j <= m; j++) {
        arr[i][j] = arrayList.get(idx++);
      }
    }
  }

  private static void type1() {

    for (int i = 1; i <= calculationCount; i++) {
      topBottom();
      copyAndInit();
    }
    printArr();
  }

  private static void type4() {

    if (calculationCount % 4 == 1) {
      for (int j = 1; j <= n; j++) {
        int idx = 0;
        ArrayList<Integer> arrayList = inputArr[j];

        for (int k = m; k >= 1; k--) {
          arr[k][j] = arrayList.get(idx++);
        }
      }
      printArr2();
    } else if (calculationCount % 4 == 2) {
      int t = n;
      for (int j = 1; j <= n; j++) {

        ArrayList<Integer> arrayList = inputArr[j];
        int idx = 0;
        for (int k = m; k >= 1; k--) {
          arr[t][k] = arrayList.get(idx++);
        }
        t = t - 1;
      }
      printArr();
    } else if (calculationCount % 4 == 3) {
      int a = n;

      for (int j = 1; j <= n; j++) {
        ArrayList<Integer> arrayList = inputArr[j];
        int idx = 0;
        for (int k = 1; k <= m; k++) {
          arr[k][a] = arrayList.get(idx++);
        }
        a = a - 1;
      }
      printArr2();
    } else if (calculationCount % 4 == 0) {
      for (int j = 1; j <= n; j++) {
        int idx = 0;
        ArrayList<Integer> arrayList = inputArr[j];
        for (int k = 1; k <= m; k++) {
          arr[j][k] = arrayList.get(idx++);
        }
      }
      printArr();
    }
  }


  private static void type3() {
    if (calculationCount % 4 == 0) {

      for (int j = 1; j <= n; j++) {
        int idx = 0;
        ArrayList<Integer> arrayList = inputArr[j];
        for (int k = 1; k <= m; k++) {
          arr[j][k] = arrayList.get(idx++);
        }
      }
      printArr();

    } else if (calculationCount % 4 == 1) {

      int a = n;

      for (int j = 1; j <= n; j++) {
        ArrayList<Integer> arrayList = inputArr[j];
        int idx = 0;
        for (int k = 1; k <= m; k++) {
          arr[k][a] = arrayList.get(idx++);
        }
        a = a - 1;
      }
      printArr2();
    } else if (calculationCount % 4 == 2) {

      int t = n;
      for (int j = 1; j <= n; j++) {

        ArrayList<Integer> arrayList = inputArr[j];
        int idx = 0;
        for (int k = m; k >= 1; k--) {
          arr[t][k] = arrayList.get(idx++);
        }
        t = t - 1;
      }
      printArr();
    } else if (calculationCount % 4 == 3) {

      for (int j = 1; j <= n; j++) {
        int idx = 0;
        ArrayList<Integer> arrayList = inputArr[j];

        for (int k = m; k >= 1; k--) {
          arr[k][j] = arrayList.get(idx++);
        }
      }
      printArr2();

    }
  }

  private static void printArr2(int[][] p) {

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(p[i][j] + " ");
      }
      System.out.println();
    }
  }


  private static void topBottom() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        temp[n - i + 1][j] = arr[i][j];
      }
    }
  }

  private static void leftRight() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        temp[i][m - j + 1] = arr[i][j];
      }
    }
  }

  private static void ninetyRight() {
    //[1,1],[1,2],[1,3],[1,4],[1,5],[1,6] -> [6,1],[6,2],[6,3],[6,4],[6,5],[6,6]
    //[2,1],[2,2],[2,3],[2,4],[2,5],[2,6] -> [5,1],[5,2],[5,3],[5,4],[5,5],[5,6]
    //[3,1],[3,2],[3,3],[3,4],[3,5],[3,6] -> [4,1],[4,2],[4,3],[4,4],[4,5],[4,6]

    for (int i = 1; i <= m; i++) {
      int t = n;
      for (int j = 1; j <= n; j++) {
        arr2[i][j] = temp2[i][t--];
      }
    }


  }

  private static void input2() throws IOException {

    String input1 = br.readLine();
    String[] s = input1.split(" ");
    n = Integer.parseInt(s[0]);
    m = Integer.parseInt(s[1]);
    calculationCount = Integer.parseInt(s[2]);

    arr = new int[150][150];
    temp = new int[150][150];

    inputArr = new ArrayList[n + 1];//
    for (int i = 0; i <= n; i++) {
      inputArr[i] = new ArrayList<>();
    }

    for (int i = 1; i <= n; i++) {
      String input2 = br.readLine();
      String[] s2 = input2.split(" ");
      for (int j = 0; j < s2.length; j++) {
        inputArr[i].add(Integer.parseInt(s2[j]));
      }
    }

    String input3 = br.readLine();
    type = Integer.parseInt(input3);

  }

  private static void input() throws IOException {
//    n = scan.nextInt();
//    m = scan.nextInt();
//    calculationCount = scan.nextInt();

    String input1 = br.readLine();
    String[] s = input1.split(" ");
    n = Integer.parseInt(s[0]);
    m = Integer.parseInt(s[1]);
    calculationCount = Integer.parseInt(s[2]);

    arr = new int[n + 2][m + 2];
    temp = new int[n + 2][m + 2];
    for (int i = 1; i <= n; i++) {

      String input2 = br.readLine();
      String[] s2 = input2.split(" ");
      for (int j = 0; j < s2.length; j++) {
        arr[i][j + 1] = Integer.parseInt(s2[j]);
      }

    }
    String input3 = br.readLine();
    type = Integer.parseInt(input3);
  }

  private static void printTemp() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printArr2() {

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void copyAndInit() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        arr[i][j] = temp[i][j];
      }
    }
    temp = new int[n + 2][m + 2];
  }
}
