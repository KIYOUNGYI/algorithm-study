package com.study.bj;

import java.util.Arrays;

public class Recursive001
{
    static final int limit = 4;
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[limit];
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
            arr[depth]=i;
            recursive(depth+1);
        }
    }
}
