package com.study.programmers;

import java.util.Arrays;

/**
 * 완전탐색으로 풀면 망하지
 * 탐욕법 공부해야 한다
 */
public class 큰수만들기 {

  static String pivot;
  static String[] ans;
  static boolean[] v;
  static int limit;
  static int result = -1;

  public static String solution(String number, int k) {

    pivot = number;
    ans = new String[k];
    v = new boolean[number.length()];
    limit = k;

    recursion(0);

    String answer = String.valueOf(result);
    return answer;
  }

  private static void recursion(int depth) {

    if (depth == limit) {
      System.out.println(Arrays.toString(ans));
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<ans.length;i++){
        sb.append(ans[i]);
      }
      int t = Integer.parseInt(sb.toString());
      if(result<t){
        result = t;
      }
      return;
    }

    for (int i = 0; i < pivot.length(); i++) {

      if (!v[i]) {
        v[i] = true;
        ans[depth] = String.valueOf(pivot.charAt(i));
        recursion(depth + 1);
        v[i] = false;
      }

    }

  }

  public static void main(String[] args) {

    System.out.println(solution("1231234", 3));
  }


}
