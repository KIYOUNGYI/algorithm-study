package com.study.bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1339OtherSolution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    int[] arr = new int[26];
    for(int i = 0; i < len; i++) {
      char[] inp = br.readLine().toCharArray();
      for(int k = 0; k < inp.length; k++)
        arr[inp[k]-65] += Math.pow(10, inp.length - k - 1);
    }
    Arrays.sort(arr);
    int sum = 0;
    int i = 25;
    int num = 9;
    while(arr[i] != 0)
      sum += arr[i--] * num--;
    System.out.println(sum);
  }

}

