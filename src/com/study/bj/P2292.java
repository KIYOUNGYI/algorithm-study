package com.study.bj;

import java.util.Scanner;

/**
 * 벌집
 * https://www.acmicpc.net/problem/2292
 * 기존에 x같이 풀었네 내가 무슨 생각 갖고 풀었는지 좀 확인은 해볼 필요가 있다.
 */
public class P2292
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int s = 2;
        int e = 1;
        int n = scan.nextInt();
        for(int i=0;i<=1000000020;i++)
        {
            s = s + 6*(i-1);
            e = e + i*6;
            if(n>=s && n<=e)
            {
                System.out.println(i+1);
                break;
            }
        }
    }
}
