package com.study.bj.b2021.middleclass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10816_숫자카드2 {

  //탐색 대상 배열을 입력받는다
  //정렬한다
  //answer 배열을 입력받는다
  //한개 한개 binary search 를 한다
  //탐색해서 있으면 원소가 다를때까지 뒤로 탐색, 앞으로 탐색 하면서 개수를 센다.
//  static int[] input;
//  static int[] target;

  public static void main(String[] args) throws IOException {
//    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//    int n1 = scan.nextInt();
    int n1 = Integer.parseInt(br.readLine());
    int[] input = new int[n1];

//    for (int i = 0; i < n1; i++) {
//      input[i] = scan.nextInt();
//    }
    String temp = br.readLine();
    String[] s = temp.split(" ");
    for (int i = 0; i < n1; i++) {
      input[i] = Integer.parseInt(s[i]);
    }
//    System.out.println("Arrays.toString(input) = " + Arrays.toString(input));

    int n2 = Integer.parseInt(br.readLine());
//    System.out.println("n2:"+n2);
    int[] target = new int[n2];

    String temp2 = br.readLine();
    String[] s2 = temp2.split(" ");
//    System.out.println(Arrays.toString(s2));
    for (int i = 0; i < n2; i++) {
      target[i] = Integer.parseInt(s2[i]);
    }

    Arrays.sort(input);
    for (int i = 0; i < target.length; i++) {
      int t = binarySearch(target[i], 0, input.length - 1, input, target);
      bw.write(t + " ");
    }

    br.close();
    bw.close();
  }

  private static int binarySearch(int val, int s, int e, int[] input, int[] target) {

    if (s > e) {
      return 0;
    }

    if (input[s] == val) {
      return countRight(s, val, input);
    }
    if (input[e] == val) {
      return countLeft(e, val, input);
    }

    int mid = (s + e) / 2;

    if (input[mid] == val) {
      int t1 = countRight(mid, val, input);
      int t2 = countLeft(mid, val, input);

      return t1 + t2 - 1;
    } else if (input[mid] < val) { // 중앙값이 내가 찾으려는 값보다 밑에 있으면
      return binarySearch(val, mid + 1, e, input, target);
    } else {
      return binarySearch(val, s, mid - 1, input, target);
    }

//    return 0;
  }

  private static int countRight(int startIdx, int val, int[] input) {
    int cnt = 0;
    for (int t = startIdx; t < input.length; t = t + 1) {
      if (input[t] == val) {
        cnt += 1;
      }
    }
    return cnt;
  }

  private static int countLeft(int startIdx, int val, int[] input) {
    int cnt = 0;
    for (int t = startIdx; t >= 0; t = t - 1) {
      if (input[t] == val) {
        cnt += 1;
      }
    }
    return cnt;
  }


}
