package com.study.programmers;

/**
 * 다른 분 풀이
 * https://programmers.co.kr/learn/courses/30/lessons/43163/solution_groups?language=java
 */
public class Level3_단어_변환 {


  static boolean[] visit;
  static String[] staticWords;
  static String staticTargetStr;
  static int minCnt = Integer.MAX_VALUE;
  static int maxLen;


  public static int solution(String begin, String target, String[] words) {

    maxLen = words.length;
    visit = new boolean[maxLen];
    staticWords = new String[maxLen];

    for (int i = 0; i < maxLen; i++) {
      staticWords[i] = words[i];
    }

    staticTargetStr = target;

    for (int i = 0; i < maxLen; i++) {
      if (!visit[i]) {
        if (check(begin, staticWords[i])) {
          visit[i] = true;
          dfs(words[i], 1);
          visit[i] = false;
        }
      }
    }

    if (minCnt == Integer.MAX_VALUE) {
      minCnt = 0;
    }

    return minCnt;
  }

  private static void dfs(String word, int depth) {

    if (word.equals(staticTargetStr)) {
//      System.out.println("depth->"+depth);
      if (depth < minCnt) {
        minCnt = depth;
      }
      return;
    }

    if (depth == maxLen) {
      return;
    }

    for (int i = 0; i < visit.length; i++) {

      if (!visit[i]) {
        if (check(word, staticWords[i])) {
          visit[i] = true;
          dfs(staticWords[i], depth + 1);
          visit[i] = false;
        }
      }
    }


  }

  private static boolean check(String begin, String word) {

    int len = begin.length();
    int cnt = 0;

    for (int i = 0; i < len; i++) {
      if (begin.charAt(i) == word.charAt(i)) {
        cnt += 1;
      }
    }
    if (len - cnt == 1) {
      System.out.println("begin = " + begin + ", word = " + word + " true");
      return true;
    } else {
      System.out.println("begin = " + begin + ", word = " + word + " false");
      return false;
    }

  }


  public static void main(String[] args) {

//    String begin1 = "hit";
//    String end1 = "cog";
//    String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
//    System.out.println(solution(begin1, end1, words1));

//    String begin2 = "hit";
//    String end2 = "cog";
//    String[] words2 = {"hot", "dot", "dog", "lot", "log"};
//    System.out.println(solution(begin2, end2, words2));

  }
}
