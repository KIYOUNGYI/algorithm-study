package com.study.bj;

import java.io.*;
import java.util.ArrayList;

public class P10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int r = Integer.parseInt(temp[1]);
        String[] temp2 = br.readLine().split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < temp2.length; i++) {
            int a = Integer.parseInt(temp2[i]);
            if (a < r) {
                arrayList.add(a);
            }
        }
        for (int i = 0; i < arrayList.size() - 1; i++) {
            bw.write(arrayList.get(i) + " ");
        }
        bw.write(arrayList.get(arrayList.size() - 1) + "\n");
        bw.close();
    }
}
