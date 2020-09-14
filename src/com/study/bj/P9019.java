package com.study.bj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DSLR
 * https://www.acmicpc.net/problem/9019
 * 최소값을 구하는건 맞지만
 * 과정도 기록해야 한다.
 *
 * [1] v[i]=i 를 어떤 수에서 만들었는지
 * [2] w[i]=i 를 어떻게 만들었는지
 */
public class P9019
{
    private static ArrayList<Character> commandList = new ArrayList<>();
    private static char[] command = new char[10020];
    private static int[] score = new int[10020];
    private static boolean[] visit = new boolean[10020];
    static String input1;
    static String input2;
    static String code;
    static int len=Integer.MAX_VALUE;
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<t;i++)
        {
            input1 = scan.next();
            input2 = scan.next();
            score[Integer.parseInt(input1)]=0;
            dfs(input1,0);
            System.out.println(code);
            code="";
        }
    }


    private static void bfs(String input,int depth)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(Integer.parseInt(input));
        visit[Integer.parseInt(input)]=true;
        while(!q.isEmpty())
        {
            int t= q.poll();
            int c1 = t;
            c1 = (2*c1)%10000;
            if(!visit[c1])
            {
                visit[c1]=true;

            }

        }


    }



    private static void dfs(String input,int depth)
    {
        if(input.equals(input2))
        {
//            System.out.println();
            if(len>depth)
            {
                len=depth;
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<=depth;i++)
                {
                    sb.append(command[i]);
                }
                code = sb.toString();
            }
            return;
        }

        int x = Integer.parseInt(input);
        int c1 = x;
        //case1 D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
        c1 = (2*c1)%10000;
        if(!visit[c1])
        {
            visit[c1]=true;
            command[depth]='D';
            dfs(Integer.toString(c1),depth+1);
            visit[c1]=false;
            command[depth]='x';
        }

        //case2 S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
        int c2 = x;
        c2 = c2-1;
        if(c2==0){c2=9999;}
        if(!visit[c2])
        {
            visit[c2]=true;
            command[depth]='S';
            dfs(Integer.toString(c2),depth+1);
            visit[c2]=false;
            command[depth]='x';
        }
        //case3 L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
        int c3 = x;

        int d1,d2,d3,d4;
        d1 = x / 1000;//1
        d2 = (x%1000) / 100;//2
        d3 = (x%1000) % 100 / 10;//3
        d4 = (x%1000) % 100 % 10;//4
        c3 = 1000*d2+100*d3+10*d4+1*d1;
        if(!visit[c3])
        {
            visit[c3]=true;
            command[depth]='L';
            dfs(Integer.toString(c3),depth+1);
            visit[c3]=false;
            command[depth]='x';
        }


        //case4 R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
        int c4 = x;
        c4 = 1000*d4 + 100*d1 + 10*d2 + 1*d3;
        if(!visit[c4])
        {
            visit[c4]=true;
            command[depth]='R';
            dfs(Integer.toString(c4),depth+1);
            visit[c4]=false;
            command[depth]='x';
        }
    }


    public static void init()
    {

    }
}
