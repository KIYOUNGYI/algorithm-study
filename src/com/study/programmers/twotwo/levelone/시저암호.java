package com.study.programmers.twotwo.levelone;

public class 시저암호 {

  public static String solution(String s, int n) {

//    System.out.println((int) ' ');
//    System.out.println((int) 'a');//97
//    System.out.println((int) 'z');//122
//
//    System.out.println((int) 'A');//65
//    System.out.println((int) 'Z');//90



    int[] arr = new int[s.length()];
    for(int i=0;i<s.length();i++){
      arr[i] = (int)s.charAt(i);
    }

    for (int i = 0; i < s.length(); i++) {

      if (arr[i] >= 97 && arr[i] <= 122) {
        arr[i] = (int)s.charAt(i) + n;

        if(arr[i]>=123){
          arr[i] = arr[i] - (26);
        }
      }
      else if(arr[i]>=65 && arr[i]<=90) {
        arr[i] = (int)s.charAt(i) + n;
        if(arr[i]>=91){
          arr[i] = arr[i] - (26);
        }
      }
      else if(arr[i]==32){
        arr[i] = 32;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0;i<arr.length;i++){
      sb.append((char)arr[i]);
    }

    return sb.toString();
  }

  public static void main(String[] args) {

    System.out.println(solution("Z", 1));
  }

}
