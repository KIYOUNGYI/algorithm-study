package com.study.bj.lec004;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2609
 * 8분 걸림
 */
public class P2609
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();
        int a=0;
        int b=0;
        int m=0;
        int r=-1;
        if(x>=y){a=x;b=y;}
        else{a=y;b=x;}
        while(true)
        {
            m = a/b;
            r = a%b;
            if(r==0)break;
            a=b;
            b=r;
        }
        System.out.println(b);
        System.out.println((x/b)*(y/b)*b);
        scan.close();
    }
}
