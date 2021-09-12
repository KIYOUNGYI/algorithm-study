package com.study.programmers;

import java.util.HashMap;
import java.util.Map;

public class Level2 {

  //https://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/

  public static void main(String[] args) {

    System.out.println((int) 'A');
    System.out.println((int) 'Z');
//    initMap();
    solution("TOBEORNOTTOBEORTOBEORNOT");
  }

  static Map<String, Integer> map = new HashMap<>();

  public static int[] solution2(String msg) {
    initMap();
    int len = msg.length();
    char[] msgArr = msg.toCharArray();
    int idx = 27;

    for(int i=0;i<len;i++){

      String currentKey = Character.toString(msgArr[i]);

      String possibleKey = currentKey;
      for(int j=i+1;j<len;j++){
        if(!map.containsKey(possibleKey+Character.toString(msgArr[j]))){
          map.put(possibleKey+Character.toString(msgArr[j]),idx++);
          System.out.println(possibleKey);
          break;
        }else{
          possibleKey = possibleKey+Character.toString(msgArr[j]);
        }
      }

    }

    int[] answer = {};
    return answer;
  }


  public static int[] solution(String msg) {
    initMap();
    int len = msg.length();
    char[] msgArr = msg.toCharArray();
    int idx = 27;

    for(int i=0;i<len;i++){

      String x = Character.toString(msgArr[i]);

      String temp = x;
      for(int j=i+1;j<len;j++){
        String backup = temp;
        String y = Character.toString(msgArr[j]);
        temp = temp+y;
//        System.out.println("temp:"+temp);
        if(!map.containsKey(temp)){
          //map에 등록
          map.put(temp,idx);
          idx+=1;
          System.out.println("print:"+backup);
          break;
        }else{
          //증
        }
      }

    }

    int[] answer = {};
    return answer;
  }

  private static void initMap() {
    int idx = 1;
    for (int i = 65; i <= 90; i++) {
      char t = (char) i;
      String s = Character.toString(t);
      map.put(s, idx);
      idx += 1;
    }
    System.out.println(map.toString());
  }

  public static int solutionProblem1(int n) {

    int[] a = new int[n + 1];
    a[0] = 0;
    a[1] = 1;
    a[2] = 1;
    if (n >= 0 && n <= 2) {
      return a[n];
    }
    for (int i = 3; i <= n; i++) {
      a[i] = (a[i - 1] + a[i - 2]) % 1_234_567;
    }

    return a[n];
  }
}
