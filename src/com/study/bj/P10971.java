package com.study.bj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 외판원 순회 2
 * https://www.acmicpc.net/problem/10971
 */
public class P10971
{
    static int MINVal = Integer.MAX_VALUE;
    static ArrayList<Integer>[] arrList;
    static int N;
    static int[] arr;
    static boolean[] visit = new boolean[1000020];
    static int temp;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        arrList = new ArrayList[N];
        arr = new int[N];
        for(int i=0;i<N;i++)arrList[i]=new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                int k = scan.nextInt();
                arrList[i].add(k);
            }
        }

        for(int startCity=0;startCity<N;startCity++)
        {
            temp=startCity;
            dfs(0,startCity);
            init();
        }
        System.out.println(MINVal);
        scan.close();
    }

    public static void dfs(int depth,int startCity)
    {
        if(depth==N)
        {
            if(temp==startCity) {
                int sum = 0;
                for (int i = 0; i < N; i++) sum += arr[i];
                if (sum <= MINVal) MINVal = sum;
            }
            return;
        }
        for(int destCity=0;destCity<N;destCity++)
        {
            if(destCity!=startCity && visit[destCity]==false && arrList[startCity].get(destCity)!=0)
            {
//                System.out.println("dest:"+destCity);
                visit[destCity]=true;
                arr[depth]=arrList[startCity].get(destCity);
                dfs(depth+1,destCity);
                visit[destCity]=false;
            }
        }
    }

    public static void init()
    {
        for(int i=0;i<visit.length;i++)visit[i]=false;
        for(int i=0;i<arr.length;i++)arr[i]=0;
    }
}
