package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_Fail {

  public static void main(String[] args) {
//    int[] ans = {1, 2, 3, 4, 5,6,7,8,9,1};
    int[] ans2 = {1, 3, 2, 4, 2, 3, 2, 4, 2, 5, 1, 2, 4, 1, 5, 3};

    System.out.println(Arrays.toString(solution(ans2)));
  }

  public static int[] solution(int[] answers) {

    int[] one = {1, 2, 3, 4, 5};
    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[] a = new int[10_001];
    int[] b = new int[10_001];
    int[] c = new int[10_001];

    int temp = 0;
    int idx = 0;
    while (idx < 10_000) {
      a[idx] = one[temp % 5];
      b[idx] = two[temp % 8];
      c[idx] = three[temp % 10];
      temp += 1;
      idx += 1;
    }
    System.out.println(Arrays.toString(c));
    int x = 0;
    int y = 0;
    int z = 0;

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == a[i]) {
        x += 1;
      }
      if (answers[i] == b[i]) {
        y += 1;
      }
      if (answers[i] == c[i]) {
        z += 1;
      }
    }
    int[] t = {x, y, z};
    System.out.println(Arrays.toString(t));
    int max = -1;

    for (int i = 0; i < 3; i++) {
      if (max < t[i]) {
        max = t[i];
      }
    }

    boolean[] check = new boolean[3];
    List<Integer> arrList = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      if (t[i] == max) {
        check[i] = true;
        arrList.add(i+1);
      }
    }
   int[] temp2 = new int[arrList.size()];
    for(int i=0;i<arrList.size();i++){
      temp2[i] = arrList.get(i);
    }

    return temp2;
  }
}
