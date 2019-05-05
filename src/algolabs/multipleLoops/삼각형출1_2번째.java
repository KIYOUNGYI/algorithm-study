package algolabs.multipleLoops;

import java.util.Scanner;

/**
 * 문제
 * n층의 삼각형을 출력하는 프로그램을 작성하여라. Input, Output의 예제를 참고한다.
 * 입력
 * 첫째 줄에 정수n이 주어진다. (0≤n≤100)
 * 출력
 * 다음 예제와 같이 삼각형 모양으로 ‘*’을 출력한다.
 * 예제 입력
 * 3
 * *
 * **
 * ***
 */
public class 삼각형출1_2번째
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);


        int N = scan.nextInt();

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
