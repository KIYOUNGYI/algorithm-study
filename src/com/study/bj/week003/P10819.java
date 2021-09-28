package com.study.bj.week003;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 차이를 최대로
 * https://www.acmicpc.net/problem/10819
 */
public class P10819
{
    static int max=Integer.MIN_VALUE;
    static int[] arr;
    static int n;
    static int[] input;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        arr = new int[n];
        visit = new boolean[n];
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<temp.length;i++)input[i]=Integer.parseInt(temp[i]);
        recursive(0);
        System.out.println(max);
    }

    private static void recursive(int depth)
    {
        if(depth==n)
        {
            calculate();
            return;
        }

        for(int i=0;i<n;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                arr[depth]=input[i];
                recursive(depth+1);
                visit[i]=false;
            }
        }
    }

    private static void calculate()
    {
        int t = 0;
        for(int i=0;i<n-1;i++)
        {
            t+=abs(arr[i]-arr[i+1]);
        }
        if(max<t)max=t;
    }

    private static int abs(int x)
    {
        return x>0?x:-x;
    }

}
