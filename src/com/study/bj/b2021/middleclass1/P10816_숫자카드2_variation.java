package com.study.bj.b2021.middleclass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class P10816_숫자카드2_variation {


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n1 = Integer.parseInt(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();

    String temp = br.readLine();
    String[] s = temp.split(" ");
    for (int i = 0; i < n1; i++) {
      int x = Integer.parseInt(s[i]);
      if (!map.containsKey(x)) {
        map.put(x, 1);
      } else {
        int y = map.get(x);
        map.put(x, y + 1);
      }

    }

    int n2 = Integer.parseInt(br.readLine());

    String temp2 = br.readLine();
    String[] s2 = temp2.split(" ");

    for (int i = 0; i < n2; i++) {
      Integer t1 = map.get(Integer.parseInt(s2[i]));
      if (t1 == null) {
        t1 = 0;
      }
      bw.write(t1 + " ");
    }

    br.close();
    bw.close();
  }


}
