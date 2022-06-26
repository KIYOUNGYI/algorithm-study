package com.study.programmers.twotwo.levelone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열_내림차순으로_배치하기 {

  public static String solution(String s) {

//    System.out.println((int)'a');
//    System.out.println((int)'z');
//    System.out.println((int)'A');
//    System.out.println((int)'Z');

    List<Integer> lower = new ArrayList<>();
    List<Integer> upper = new ArrayList<>();


    for(int i=0;i<s.length();i++){

      if(s.charAt(i)>=97 && s.charAt(i)<=122)//소문자
      {
        lower.add((int)s.charAt(i));
      }
      else{
        upper.add((int)s.charAt(i));
      }
    }

    Collections.sort(lower,Collections.reverseOrder());
    Collections.sort(upper,Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();

    for (int l : lower) {
      sb.append((char)l);
    }

    for (int u : upper) {
      sb.append((char)u);
    }


    return sb.toString();
  }


  public static void main(String[] args) {

    System.out.println(solution("Zbcdefg"));
  }

}
