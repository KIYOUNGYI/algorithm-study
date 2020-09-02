package com.study.bj.lec004;

import java.util.Scanner;

// 다시 풀 문제
// https://www.acmicpc.net/problem/1978
// 에라토스테스체
// isPrime(int x)

public class P1978
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)arr[i]=scan.nextInt();
        int ans=0;
        for(int i=0;i<N;i++)
        {
            boolean prime = isPrime(arr[i]);
            if(prime)ans+=1;
        }
        System.out.println(ans);
        scan.close();
    }

    public static boolean isPrime(int x)
    {
        if(x==1)return false;
        if(x==2)return true;

        for(int i=2;i<x;i++)
        {
            if(x%i==0){return false;}
        }
        return true;
    }
}
