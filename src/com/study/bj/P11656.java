package com.study.bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * for,for 접미사 배열 https://www.acmicpc.net/problem/11656
 */
public class P11656 {

  //이중루프로 해결한다.
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    String x = scan.nextLine();
    for (int i = 0; i < x.length(); i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < x.length(); j++) {
        sb.append(x.charAt(j));
      }
      arrayList.add(sb.toString());
    }
    Collections.sort(arrayList);
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }

    scan.close();
  }
}
