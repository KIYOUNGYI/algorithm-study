package com.study.bj;

import java.util.Arrays;

public class Temp
{
    static final int limit = 4;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) {
        arr = new int[limit];
        visit = new boolean[10];
        recursive(0);
    }
    public static void recursive(int depth)
    {
        if(depth==limit)
        {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=0;i<=9;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                arr[depth]=i;
                recursive(depth+1);
                visit[i]=false;
            }
        }

    }
}
