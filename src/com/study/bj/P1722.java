package com.study.bj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열의 순서 [실패]
 * https://www.acmicpc.net/problem/1722
 */
public class P1722
{
    static int cntV1Limit=0;
    static int cntV1=0;
    static int cntV2=0;
    static boolean flagV1 = false;
    static boolean flagV2 = false;
    static int N;
    static int[] input2;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        int problem = temp.charAt(0)-48;
        if(problem==2)
        {
            String[] temp2 = temp.substring(2).split(" ");
            input2 = new int[temp2.length];
            arr = new int[temp2.length];
            visit = new boolean[temp2.length+1];
            for(int i=0;i<input2.length;i++)input2[i]=Integer.parseInt(temp2[i]);
            recursive2(0);
            System.out.println(cntV2);
        }
        else
        {
            String[] temp1 = temp.split(" ");
            cntV1Limit = Integer.parseInt(temp1[1]);
            visit = new boolean[N+1];
            arr = new int[N];
            recursive1(0);
        }
    }

    private static void recursive1(int depth)
    {
        if(flagV1)return;

        if(depth==N)
        {
            cntV1+=1;
            if(cntV1==cntV1Limit)
            {
                for(int i=0;i<arr.length;i++)
                {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
                flagV1 = true;
            }
            return;
        }

        for(int i=1;i<=arr.length;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                arr[depth]=i;
                recursive1(depth+1);
                visit[i]=false;
            }
        }
    }


    private static void recursive2(int depth)
    {
        if(flagV2)return;
        cntV2+=1;
        if(depth>=1)
        {
            for(int i=0;i<depth-1;i++)
            {
                if(arr[i]!=input2[i])
                {
                    System.out.println(Arrays.toString(arr));
                    return;
                }
            }
        }

        if(depth==N)
        {
//            cntV2+=1;
            int cnt=0;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==input2[i])cnt+=1;
//                if(arr[i]!=input2[i])return;
            }
            if(cnt==N)
            {
                flagV2=true;
            }
            return;
        }

        for(int i=1;i<=input2.length;i++)
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
    }
}
//4
//2 1 3 2 4