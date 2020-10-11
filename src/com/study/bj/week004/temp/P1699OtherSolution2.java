package com.study.bj.week004.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1699OtherSolution2 {

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int dp[] = new int[N + 1]; dp[1] = 1;
    for(int i = 2; i <= N; i++) {	 // dp 2부터 채우기 시작
      dp[i] = i; // 우선 자기자신으로 초기화 해둔다.
      for(int j = 1; j * j <= i; j++) { // j는 1부터 제곱 수가 i보다 작을 경우 반복한다.
        dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]); // 최소항의 개수를 찾기 위해서 저장 된 값과 점화식값을 비교하여 최솟값을 취한다.
      }
    }
    System.out.println(dp[N]);
  }
}
