package algolabs.multipleLoops;

import java.util.Scanner;

/**
 * 문제
 * n층의 삼각형을 출력하는 프로그램을 작성하여라. Input, Output의 예제를 참고한다.
 * 입력
 * 첫째 줄에 정수n이 주어진다. (0≤n≤100)
 * 출력
 * 다음 예제와 같이 삼각형 모양으로 ‘*’을 출력한다. (공백의 개수와 별의 개수를 정확하게 확인해주시바랍니다.)
 *
 * 예제 입력
 * 3
 *   *
 *  **
 * ***
 * 6
 *      *
 *     **
 *    ***
 *   ****
 *  *****
 * ******
 * 힌트: 좌표를 연습장에 적고, 규칙성을 찾아낸다.
 *
 */
public class 삼깍형출력2_2번째
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
                if(i+j<=N)
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



        scan.close();
    }
}
