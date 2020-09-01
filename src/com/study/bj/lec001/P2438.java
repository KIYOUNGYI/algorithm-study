package com.study.bj.lec001;

import java.util.Scanner;

/**
 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 *
 * 출력
 * 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
 * 예제 입력 1
 * 5
 * 예제 출력 1
 * *
 * **
 * ***
 * ****
 * *****
 */
public class P2438 {
    //루프 idx 만큼 * 을 찍는다.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        for(int x=1;x<=input;x++)
        {
            for(int y=1;y<=x;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
