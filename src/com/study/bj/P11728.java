package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 10^9 때려넣으면 에러나는구나 힙메모리... ㅠㅠ
 */
public class P11728
{
    static ArrayList<Integer> arrayList = new ArrayList<>();

    static int[] arr=new int[1000020];
    static int[] brr=new int[1000020];
    static int[] temp=new int[1000020];
    static int aLen;
    static int bLen;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        aLen = Integer.parseInt(temp[0]);
        bLen = Integer.parseInt(temp[1]);

        String[] temp1 = br.readLine().split(" ");

        for(int i=0;i<aLen;i++)
        {
            arr[i] = Integer.parseInt(temp1[i]);
        }
//        System.out.println(Arrays.toString(arr));
        String[] temp2  = br.readLine().split(" ");
        for(int i=0;i<bLen;i++)
        {
            brr[i] = Integer.parseInt(temp2[i]);
        }
                printArr();
//        System.out.println(Arrays.toString(brr));
        mergeSortV1(arr,brr);

    }

    private static void mergeSortV1(int[] arr, int[] brr)
    {
        int p=0,q=0;
        int idx=0;
        while(p<aLen && q<bLen)
        {
            if(arr[p]<brr[q])
            {
                temp[idx++]=arr[p++];
            }
            else
            {
                temp[idx++]=brr[q++];
            }
        }

        if(p==aLen)
        {
            //brr남은걸 다 채워넣기
            for(int i=q;i<bLen;i++)
            {
                temp[i]=brr[i];
            }
        }
        else
        {

            for(int i=p;i<=aLen;i++)
            {
                temp[i]=arr[i];
//                System.out.println("->"+temp[i]);
            }
        }

        for(int i=0;i<aLen+bLen;i++)
        {
            System.out.print(temp[i]+" ");
        }
        System.out.println();
    }



    public static void printArr()
    {
        for(int i=0;i<aLen;i++) System.out.print(arr[i]+" ");
        System.out.println();
        for(int i=0;i<bLen;i++) System.out.print(brr[i]+" ");
        System.out.println();
    }

    static int abs(int x)
    {
        if(x>=0)return x;
        else return-x;
    }
}

