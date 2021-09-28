package com.study.bj;

import java.io.*;

public class P11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[10001];
        arr[0] = "0";
        arr[1] = "1";

        for (int i = 2; i <= n; i++) {
            arr[i] = sum(arr[i - 1], arr[i - 2]);

        }


        bw.write(arr[n] + "\n");
        bw.close();
    }

    public static String sum(String input1, String input2) {
        StringBuilder ans = new StringBuilder();
        String s1, s2;
        if (input1.length() == input2.length()) {
            s1 = reverse(input1);
            s2 = reverse(input2);
        } else {
            s1 = reverse(input1);
            s2 = reverseAndAppendZero(input2);
        }
        int bosu = 0;
        for (int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i) - '0';
            int y = s2.charAt(i) - '0';
//            System.out.println("i : "+i+" x : "+x+" y : "+y);
            if (x + y + bosu >= 10) {
                int t = x + y + bosu - 10;
                ans.append(t);
                bosu = 1;
            } else {
                int t = x + y + bosu;
                ans.append(t);
                bosu = 0;
            }
        }
        if (bosu == 1) {
            ans.append(bosu);
        }

        return ans.reverse().toString();
    }

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseAndAppendZero(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        sb.append("0");
        return sb.toString();
    }

}


/**
 * //case 1] input1 > input2
 * //xx+y
 * //12
 * //02 <-append 0
 * //--
 * //21 <- reverse
 * //20 <- reverse
 * //41
 * //reverse->14
 * <p>
 * //67
 * //04
 * //-----
 * //76
 * //40
 * //1+(1(bosu)+6+0)
 * //17
 * //71
 * <p>
 * //682
 * //583
 * <p>
 * //286
 * //385
 * //56(1+6+5)
 * //562(1)
 * <p>
 * //282
 * //385
 * //56(1+2+5)
 * //568
 *
 * @param input1
 * @param input2
 * @return
 */



