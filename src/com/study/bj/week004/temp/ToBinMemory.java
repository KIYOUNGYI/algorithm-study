package com.study.bj.week004.temp;

import java.util.Scanner;

public class ToBinMemory
{
    static int[] arr;
    static int n;
    static int r;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        arr = new int[n];
        r = scan.nextInt();

        f(0,0);

    }

    public static void f(int depth,int cnt)
    {
        if(cnt==2)
        {
            System.out.println("depth:"+depth+" cnt:"+cnt);
            print();
            return;
        }
        if(depth==n)
        {
            System.out.println("depth:"+depth+" cnt:"+cnt);
            return;
        }

        arr[depth]=1;
        f(depth+1,cnt+1);
        arr[depth]=0;
        f(depth+1,cnt);
    }

    public static void print()
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
