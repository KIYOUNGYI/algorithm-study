package com.study.programmers;

import java.util.Arrays;

public class Level1_2_Pass {

  public static void main(String[] args) {
//    int[] ans = {1, 2, 3, 4, 5,6,7,8,9,1};

    System.out.println(Arrays.toString(solution(2, 5)));
  }

  public static int[] solution(int n, int m) {

    int t1 = n > m ? n : m;
    int t2 = n > m ? m : n;

    int x = gcd(t1, t2);
    System.out.println(x);
    int y = (t1 / x) * (t2 / x) * x;
    int[] ans = {x, y};
    return ans;
  }

  private static int gcd(int t1, int t2) {

    //a b 몫 나머지
    //b 나머지
    int r = -1;
    while (r != 0) {
      r = t1 % t2;
      if (r == 0) {
        break;
      }
      t1 = t2;
      t2 = r;
    }

    return t2;
  }


  public static int[] solution(int[] lottos, int[] win_nums) {

    int zeroCnt = 0;
    int matchCnt = 0;

    for (int i = 0; i < lottos.length; i++) {
      if (lottos[i] != 0) {
        for (int j = 0; j < win_nums.length; j++) {
          if (lottos[i] == win_nums[j]) {
            matchCnt += 1;
          }
        }
      } else {
        zeroCnt += 1;
      }
    }

//    System.out.println(zeroCnt);
//    System.out.println(matchCnt);
    int max = matchCnt + zeroCnt;
    int min = matchCnt;

    int[] s = {6, 6, 5, 4, 3, 2, 1};

    int[] answer = {s[max], s[min]};
    return answer;
  }
}
