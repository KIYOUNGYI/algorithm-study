package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 암호 [ 실패 ]
 * https://www.acmicpc.net/problem/1718
 */
public class P1718
{

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plainText = br.readLine();
        String key =  br.readLine();//love


        int keyLen = key.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<plainText.length();i++)
        {
            sb.append(key.charAt(i%keyLen));
        }
        String genKey = sb.toString();
        System.out.println("[1]"+genKey);
        System.out.println("[2]"+plainText);

        int[] arr = new int[plainText.length()];

        for(int i=0;i<plainText.length();i++)
        {
            arr[i] = (int)plainText.charAt(i)-(int)genKey.charAt(i);
            System.out.println(arr[i]);
        }


        scan.close();
    }

    static int abs(int x)
    {
        return x>0?x:-x;
    }
}

