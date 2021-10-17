package com.study.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level2_모음_사전 {

  static char[] mo = {'A', 'E', 'I', 'O', 'U'};
  static List<String> arrayList = new ArrayList<>();

  public static int solution(String word) {

    makeDictionary();

    int ans = 0;
    for (int i = 0; i < arrayList.size(); i++) {
      if (word.equals(arrayList.get(i))) {
        ans = i + 1;
        break;
      }
    }

    return ans;
  }

  private static void makeDictionary() {

    //[1]
    arrayList.add("A");
    arrayList.add("E");
    arrayList.add("I");
    arrayList.add("O");
    arrayList.add("U");

    //[2]

    makeTwoWords();

    //[3]
    makeThreeWords();
//
    //[4]
    makeFourWords();

    makeFiveWords();

    Collections.sort(arrayList);

//    System.out.println(arrayList.toString());
  }

  private static void makeTwoWords() {
    char[] temp2 = new char[2];
    for (int i = 0; i < mo.length; i++) {
      temp2[0] = mo[i];
      for (int j = 0; j < mo.length; j++) {
        temp2[1] = mo[j];

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 2; k++) {
          sb.append(temp2[k]);
        }
        arrayList.add(sb.toString());
      }
    }
  }

  private static void makeThreeWords() {
    char[] temp3 = new char[3];
    for (int i = 0; i < mo.length; i++) {
      temp3[0] = mo[i];
      for (int j = 0; j < mo.length; j++) {
        temp3[1] = mo[j];

        for (int k = 0; k < mo.length; k++) {
          temp3[2] = mo[k];
          StringBuilder sb = new StringBuilder();
          for (int l = 0; l < 3; l++) {
            sb.append(temp3[l]);
          }
          arrayList.add(sb.toString());
        }
      }
    }
  }

  private static void makeFourWords() {

    char[] temp4 = new char[4];

    for (int i = 0; i < mo.length; i++) {

      temp4[0] = mo[i];

      for (int j = 0; j < mo.length; j++) {

        temp4[1] = mo[j];

        for (int k = 0; k < mo.length; k++) {
          temp4[2] = mo[k];

          for (int l = 0; l < mo.length; l++) {
            temp4[3] = mo[l];
            StringBuilder sb = new StringBuilder();
            for (int m = 0; m < 4; m++) {
              sb.append(temp4[m]);
            }
            arrayList.add(sb.toString());
          }


        }
      }
    }
  }

  private static void makeFiveWords() {

    char[] temp5 = new char[5];

    for (int i = 0; i < mo.length; i++) {

      temp5[0] = mo[i];

      for (int j = 0; j < mo.length; j++) {

        temp5[1] = mo[j];

        for (int k = 0; k < mo.length; k++) {
          temp5[2] = mo[k];

          for (int l = 0; l < mo.length; l++) {
            temp5[3] = mo[l];

            for (int m = 0; m < mo.length; m++) {
              temp5[4] = mo[m];

              StringBuilder sb = new StringBuilder();
              for (int n = 0; n < 5; n++) {
                sb.append(temp5[n]);
              }
              arrayList.add(sb.toString());
            }


          }


        }
      }
    }
  }

  public static void main(String[] args) {
//    String[] x ={"1","11","11111","11112","2","21"};
//    Arrays.sort(x);
//    System.out.println("x = " + Arrays.toString(x));
    System.out.println(solution("AAAAE"));
  }

//  static class StringCompare implements Comparator<String> {
//
//    @Override
//    public int compare(String s1, String s2) {
//      // 단어 길이가 같을 경우
//      if (s1.length() == s2.length()) {
//        return s1.compareTo(s2);  // 사전 순 정렬
//      }
//      // 그 외의 경우
//      else {
//        return s1.length() - s2.length();
//      }
//    }
//  }
}
