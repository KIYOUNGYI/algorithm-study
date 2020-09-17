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

    public static void main(String[] args) throws IOException
    {
        int limit = 1000000020;
        int[] score = new int[limit];
        int[] minusScore = new int[limit];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        String[] temp2 = br.readLine().split(" ");

        for(int i=0;i<a;i++)
        {
            int r = Integer.parseInt(temp2[i]);
            if(r>=0) score[r]+=1;
            else minusScore[abs(r)]+=1;
        }

        String[] temp3 = br.readLine().split(" ");
        for(int i=0;i<b;i++)
        {
            int r = Integer.parseInt(temp3[i]);
            if(r>=0) score[r]+=1;
            else minusScore[abs(r)]+=1;
        }


        for(int i=limit-1;i>=1;i--)
        {
            if(minusScore[i]>=1)
            {
                int t = minusScore[i];
                int val = -1 * i;

                for(int j=0;j<t;j++)
                {
                    arrayList.add(val);
                }
            }
        }

        for(int i=0;i<limit;i++)
        {
            if(score[i]>=1)
            {
                int t = score[i];
                int val = 1 * i;

                for(int j=0;j<t;j++)
                {
                    arrayList.add(val);
                }
            }
        }

        printArr();
    }

    public static void printArr()
    {
        for(int i=0;i<arrayList.size()-1;i++)
        {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println(arrayList.get(arrayList.size()-1));
    }

    static int abs(int x)
    {
        if(x>=0)return x;
        else return-x;
    }
}

