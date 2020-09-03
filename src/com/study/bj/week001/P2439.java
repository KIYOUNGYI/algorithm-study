package com.study.bj.week001;

import java.util.Scanner;

/**
 *     *
 *    **
 *   ***
 *  ****
 * *****
 */
//4분 11초
public class P2439
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        for(int i=1;i<=x;i++)
        {
            for(int j=1;j<=x;j++)
            {
                if(i+j<=x)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }


    }
}
