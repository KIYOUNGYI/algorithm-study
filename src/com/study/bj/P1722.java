package com.study.bj;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 순열의 순서
 * https://www.acmicpc.net/problem/1722
 */
public class P1722
{
    static final int MAX = 21;
    static int N;
    static boolean[] visit=new boolean[MAX];
    static int[] arr=new int[MAX];
    static int[] temp=new int[MAX];
    static int cnt=0;
    static int limit;
    static boolean flag = false;
    static int[] copied = new int[MAX];
    static int case2=0;
    public static void main(String[] args) throws IOException {

        System.out.println((int)' ');
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());
//        System.out.println(N);
        String s = bf.readLine();
        if(s.charAt(0)=='1')
        {
            limit = s.charAt(2)-48;

            recursive(1);
        }
        else if(s.charAt(0)=='2')
        {
            recursive2(1);
            int idx=1;
            for(int i=2;i<s.length();i++)
            {
                int t = s.charAt(i);
                if(t!=32)
                {
                    copied[idx++]=s.charAt(i)-48;
                }
            }
            recursive2(1);
        }
        bw.close();
    }

    private static void recursive2(int depth)
    {
        if(flag)return;

        if(depth==N+1)
        {
            case2+=1;

            int x=0;
            for(int i=1;i<=N;i++)
            {
                if(temp[i]==copied[i])x+=1;
            }
            if(x==N)
            {
                System.out.println(case2);
                flag=false;
            }
            return;
        }

        for(int i=1;i<=N;i++)
        {
            if(visit[i]==false)
            {
                temp[depth]=i;
                visit[i]=true;
                recursive2(depth+1);
                visit[i]=false;
            }
        }
    }

    private static void recursive(int depth)
    {
        if(flag)return;

        if(depth==N+1)
        {
            cnt+=1;

            if(cnt==limit)
            {
                for (int i = 1; i <= N; i++)
                {
                    System.out.print(temp[i]+" ");
                }
                System.out.println();
                flag=true;
            }
            return;
        }

        for(int i=1;i<=N;i++)
        {
            if(visit[i]==false)
            {
                temp[depth]=i;
                visit[i]=true;
                recursive(depth+1);
                visit[i]=false;
            }
        }
    }
}
//4
//1 3
//>>1 3 2 4
//
//4
//2 1 3 2 4
//>>3