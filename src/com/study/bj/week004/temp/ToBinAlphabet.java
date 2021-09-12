package com.study.bj.week004.temp;

import java.util.ArrayList;
import java.util.Scanner;

public class ToBinAlphabet
{
    static int n;
    static int r;
    static ArrayList<Integer> arrList = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        r = scan.nextInt();
        f(0,0);

        scan.close();
    }

    public static void f(int depth,int cnt)
    {
        if(cnt==2)
        {
            System.out.println("[1] "+arrList.toString());
            return;
        }
        if(depth==n)
        {
            System.out.println("[2] "+arrList.toString());
            return;
        }
        arrList.add(depth);
        f(depth+1,cnt+1);
        arrList.remove(depth);
        f(depth+1,cnt);
    }

    public static void print()
    {

    }
}
