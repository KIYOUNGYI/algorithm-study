package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 2진수 8진수
 * https://www.acmicpc.net/problem/1373
 * 아직 못품.
 * 기억이 희미해지면 다시 풀자.
 * 이 문제는 문자열 문제에 가깝다.
 */
public class P1373 {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("000", "0");
        map.put("001", "1");
        map.put("010", "2");
        map.put("011", "3");
        map.put("100", "4");
        map.put("101", "5");
        map.put("110", "6");
        map.put("111", "7");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(input.equals("0")){
          System.out.println("0");return;
        }

        StringBuilder ans = new StringBuilder();
        int idx = 0;
        if (input.length() % 3 == 1) {
            ans.append("1");
            idx = 1;
        } else if (input.length() % 3 == 2) {
            if (input.charAt(0) == '1' && input.charAt(1) == '0') {
                ans.append("2");
            } else if (input.charAt(0) == '1' && input.charAt(1) == '1') {
                ans.append("3");
            }
            idx = 2;
        } else {
            idx = 0;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = idx; i < input.length(); i = i + 3) {
            temp.append(input.charAt(i));
            temp.append(input.charAt(i + 1));
            temp.append(input.charAt(i + 2));
            String v = map.get(temp.toString());
            ans.append(v);
            temp.setLength(0);
        }
        System.out.println(ans);
    }
}
