package algolabs.multipleLoops;

import java.util.Scanner;

/**
 * 문제
 * n층의 삼각형을 출력하는 프로그램을 작성하여라. Input, Output의 예제를 참고한다.
 * 입력
 * 첫째 줄에 정수n이 주어진다. (0≤n≤100)
 * 출력
 * 다음 예제와 같이 삼각형 모양으로 ‘*’을 출력한다.(공백의 개수와 별의 개수를 정확하게 확인해주시바랍니다.)
 * 예제 입력
 * 3
 *   *
 *  ***
 * *****
 * 6
 *      *
 *     ***
 *    *****
 *   *******
 *  *********
 * ***********
 */
public class 삼각형출력3_2번째
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int width = N*2-1;

        for(int i=1;i<=N;i++)
        {
            int cnt = 2*i-1;
//            System.out.println("cnt:"+cnt);
            int flag=0;

            for(int j=1;j<=2*N-1;j++)
            {
                if(i+j<=N)
                {
                    System.out.print(" ");
                }else
                {
                    flag++;
                    System.out.print("*");
                    if(flag>=cnt){break;}
                }
            }
//            flag=0;
            System.out.println();
        }

        scan.close();

    }
}
