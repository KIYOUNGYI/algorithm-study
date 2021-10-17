package com.study.bj.b2021.middleclass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10816_숫자카드2_variation3 {


  public static void main(String[] args) throws IOException {
//    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n1 = Integer.parseInt(br.readLine());
    int[] input = new int[n1];

    String temp = br.readLine();
    String[] s = temp.split(" ");
    for (int i = 0; i < n1; i++) {
      input[i] = Integer.parseInt(s[i]);
    }

    int n2 = Integer.parseInt(br.readLine());
    int[] target = new int[n2];

    String temp2 = br.readLine();
    String[] s2 = temp2.split(" ");
    for (int i = 0; i < n2; i++) {
      target[i] = Integer.parseInt(s2[i]);
    }

    Arrays.sort(input);
    for (int i = 0; i < target.length; i++) {
      int t1 = lowerBound(input, target[i]);
      int t2 = upperBound(input, target[i]);
//      System.out.println(t1);
//      System.out.println(t2);
//      System.out.println("---");
      bw.write((t2 - t1) + " ");
    }

    br.close();
    bw.close();
  }

  /**
   * 주어진 값과 같거나 큰 값이 처음 나오는 index 를 리턴
   */
  private static int lowerBound(int[] arr, int val) {

    int start = 0;
    int end = arr.length;
    while (start < end) {

      int mid = (start + end) / 2;

      if (val <= arr[mid]) {//내가 찾은 값이 타겟보다 크거나 같으면 왼쪽으로 이동
        end = mid;
      } else {//내가 찾은 값이 타겟보다 작으면 시작을 오른쪽으로 이동
        start = mid + 1;
      }

    }
    return start;
  }

  /**
   * 주어진 값보다 큰 값이 처음 나오는 index 를 리턴
   */
  private static int upperBound(int[] arr, int val) {

    int start = 0;
    int end = arr.length;

    while (start < end) {

      int mid = (start + end) / 2;

      if (val >= arr[mid]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }


}
