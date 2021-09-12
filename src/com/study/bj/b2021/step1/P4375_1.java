package com.study.bj.b2021.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P4375_1 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BigInteger targetValue = null;
    for (; ; ) {
      String baesu = br.readLine();
      if (baesu.isEmpty()) {
        return;
      }
      BigInteger baesuLong = new BigInteger(baesu);
      StringBuilder sb = new StringBuilder();
      if (baesu.length() == 1) {
        sb.append("11");
      } else if (baesu.length() == 2) {
        sb.append("111");
      } else if (baesu.length() == 3) {
        sb.append("1111");
      } else if (baesu.length() == 4) {
        sb.append("11111");
      }

      targetValue = new BigInteger(sb.toString());
      while (!targetValue.remainder(baesuLong).equals(new BigInteger("0"))) {
        String temp = targetValue.toString() + "1";
        targetValue = new BigInteger(temp.toString());
      }

      System.out.println((targetValue.toString().length()));

    }


  }
}
