package com.study.programmers.twotwo.levelone;

public class 핸드폰_번호_가리기 {

  public static String solution(String phone_number) {

    StringBuilder sb = new StringBuilder();

    for(int i = 0 ; i < phone_number.length() - 4 ; i++){
      sb.append("*");
    }

    for(int i = phone_number.length()-4 ; i <phone_number.length(); i++){
      sb.append(phone_number.charAt(i));
    }

    return sb.toString();
  }

  public static void main(String[] args) {

  }
}
