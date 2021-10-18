package com.study.programmers;

public class 숫자_문자열과_영단어_시간초과 {

  public static int solution(String s) {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); ) {
      if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7'
          || s.charAt(i) == '8' || s.charAt(i) == '9') {
        sb.append(s.charAt(i));
        i = i + 1;
      } else {
        if (s.charAt(i) == 'o') {
          sb.append('1');
          i = i + 3;
        } else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'w') {
          sb.append('2');
          i = i + 3;
        } else if (s.charAt(i) == 't' && s.charAt(i + 1) == 'h') {
          sb.append('3');
          i = i + 5;
        } else if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'o') {
          sb.append('4');
          i = i + 4;
        } else if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'i') {
          sb.append('5');
          i = i + 5;
        } else if (s.charAt(i) == 's' && s.charAt(i + 1) == 'i') {
          sb.append('6');
          i = i + 3;
        } else if (s.charAt(i) == 's' && s.charAt(i + 1) == 'e') {
          sb.append('7');
          i = i + 5;//seven
        } else if (s.charAt(i) == 'e' && s.charAt(i + 1) == 'i') {
          sb.append('8');
          i = i + 5;//eight
        } else if (s.charAt(i) == 'n') {
          sb.append('9');
          i = i + 4;//nine
        } else if (s.charAt(i) == 'z') {
          sb.append('0');
          i = i + 4;//zero
        }

        if (i >= s.length()) {
          break;
        }

      }
    }

    return Integer.parseInt(sb.toString());
  }

  public static void main(String[] args) {

    System.out.println(solution("one4seveneight"));
    System.out.println(solution("23four5six7"));
    System.out.println(solution("2three45sixseven"));
    System.out.println(solution("123"));
  }

}
