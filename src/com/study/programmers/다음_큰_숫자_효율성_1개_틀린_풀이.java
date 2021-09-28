package com.study.programmers;

/**
 * 시간복잡도 계산 안하고 잘못한건 잘못
 * 95/100
 * (피곤)
 * 정신 말끔할 때 다시 설계 제대로 해봅시다.
 */
public class 다음_큰_숫자_효율성_1개_틀린_풀이 {

  public static int solution(int n) {

    Object[] objects1 = toBin(n);

    int countOne = (int) objects1[1];

    for (int i = n + 1; ; i++) {

      Object[] objects = toBin(i);

      int cnt = (int) objects[1];
      if (cnt == countOne) {
        return i;
      }
    }

  }

  static Object[] toBin(int n) {

    StringBuilder sb = new StringBuilder();

    while (n != 0) {
      sb.append(n % 2);
      n = n / 2;
    }
    int cnt = 0;

    String temp = sb.toString();

    StringBuilder sb2 = new StringBuilder();
    for (int i = temp.length() - 1; i >= 0; i--) {
      sb2.append(temp.charAt(i));
      if (temp.charAt(i) == '1') {
        cnt += 1;
      }
    }

    System.out.println("->"+temp.toString());

    Object[] objArr = new Object[2];
    objArr[0] = sb2.toString();
    objArr[1] = cnt;
    return objArr;
  }


  public static void main(String[] args) {

    System.out.println(solution(1000000));
  }


}
