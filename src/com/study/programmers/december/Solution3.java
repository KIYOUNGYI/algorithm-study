package com.study.programmers.december;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

  static char[][] keyboard = {
      {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o'},
      {'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k'},
      {'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '0'}
  };
  static Map<String, Integer> myMap = new HashMap<>();

  public static int solution(String s) {

    int seroKeyboard = keyboard.length;
    int garoKeyboard = keyboard[0].length;
    int sum = 0;
    for (int size = 2; size <= s.length(); size++) {

      for (int start = 0; start + size - 1 < s.length(); start = start + 1) {
//        System.out.println("s: " + start + " e:" + (start + size - 1));

        int pivot1 = start;
        int pivot2 = (start + size - 1);

        for (int k = pivot1; k < pivot2; k++) {
//          System.out.println("\t" + k + " " + (k + 1));

          char c = s.charAt(k);
          char c1 = s.charAt(k + 1);
//          System.out.println("c = " + c + " c1:" + c1);

          StringBuilder sb = new StringBuilder();
          sb.append(c);
          sb.append(c1);
          String key = sb.toString();

          if (myMap.containsKey(key)) {
            sum += myMap.get(key);
          } else {

            int firstX = 0;
            int firstY = 0;
            int secondX = 0;
            int secondY = 0;

            for (int i = 0; i < seroKeyboard; i++) {
              for (int j = 0; j < garoKeyboard; j++) {
                if (c == keyboard[i][j]) {
                  firstX = i;
                  firstY = j;
                }
                if (c1 == keyboard[i][j]) {
                  secondX = i;
                  secondY = j;
                }
              }
            }

            int val = Math.abs(secondX - firstX) + Math.abs(secondY - firstY);
            myMap.put(key, val);
            sum = (sum + val) % (1000000000 + 7);
          }

        }

//        for (int i = 0; i < s.length(); i++) {
//
//        }

      }
//      System.out.println("-----");

    }

    return sum;
  }

  public static void main(String[] args) {

//    System.out.println(solution("abcc"));
//    System.out.println(solution("tooth"));
    System.out.println(solution("zzz"));
  }
}
