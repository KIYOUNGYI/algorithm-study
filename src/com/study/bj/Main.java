package com.study.bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    static int n;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n+1];
        visited = new boolean[n+1];
        f(0);
        scan.close();
    }
    public static void f(int depth)
    {

        if(depth==n)
        {
            for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++)
        {

            if(!visited[i])
            {
                visited[i]=true;
                arr[depth]=i;
                System.out.println("depth : "+depth+" arr:"+ Arrays.toString(arr));
                f(depth+1);
                visited[i]=false;
            }
        }
    }
}