package com.study.bj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열의 순서
 * https://www.acmicpc.net/problem/1722
 */
public class P1722
{
    static int cnt=0;
    static boolean[] visit = new boolean[22];
    static int[] arr = new int[22];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        if(input.charAt(0)=='2')
        {
            String t1 = input.substring(2);
            String[] t2 = t1.split(" ");
            System.out.println("t2 :"+Arrays.asList(t2));
            int[] t3 = new int[N];
            System.out.println("t2 len:"+t2.length);
            for(int i=0;i<t3.length;i++)
            {
                t3[i]=Integer.parseInt(t2[i]);
            }
            recursive2(0);
            System.out.println("!!");
        }
        else
        {

        }

    }

    private static void recursive2(int depth)
    {
        if(depth==N)
        {
            cnt+=1;
//            printArr();
            return;
        }

        for(int i=1;i<=N;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                arr[depth]=i;
                recursive2(depth+1);
                visit[i]=false;
            }
        }
    }

    public static void printArr()
    {
        for(int i=0;i<N;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
