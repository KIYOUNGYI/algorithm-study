package com.study.bj.week004.temp;

import java.util.Scanner;

public class recursive
{
    static boolean[] v = new boolean[10];
    static int[] a;
    static int n;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        a = new int[n];
        f(0);

        scan.close();
    }
    public static void f(int depth)
    {
        if(depth==n)
        {
            print();
            return;
        }
        for(int i=9;i>=0;i--)
        {
            if(!v[i])
            {
                v[i]=true;
                a[depth]=i;
                f(depth+1);
                v[i]=false;
            }


        }
    }
    public static void print()
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
