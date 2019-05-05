package algolabs.step2.array;

import java.util.Scanner;

/**
 * 문제
 * N과 시작 숫자 S가 주어지면 숫자 피라미드를 만드는 프로그램을 작성하시오. 예를 들어, N이 5이고 S가 3 이라면, 그 숫자 피라미드는
 * 아래와 같이 된다.
 *     3
 *    456
 *   21987
 *  3456789
 * 987654321
 *
 * 입력
 * 입력의 첫 번째 줄에 N과 시작 숫자 S가 주어진다. ( 1≤N≤100, 1 ≤S≤ 9)
 *
 * 출력
 * 첫 번째 줄부터 숫자 피라미드를 출력한다. (각 줄에 존재하는 공백의 개수와 숫자의 개수를 정확하게 확인해주시바랍니다.)
 *
 * 예제 입력
 * 5 3
 *     3
 *    456
 *   21987
 *  3456789
 * 987654321
 */
public class 숫자피라미드
{
    public static int N;
    public static int[][] arr;
    public static int Start;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

//        N = 5;
//        Start=3;

        N = scan.nextInt();
        Start = scan.nextInt();
//        System.out.println("N:"+N);
//        arr= new int[6][10];
        arr= new int[N+1][2*N];

        for(int i=1;i<=N;i++)
        {
            int cnt = 2*i-1;
            int flag=0;
            for(int j=1;j<=2*N-1;j++)
            {
                if(i+j<=N)
                {
                    arr[i][j]=0;
                }
                else if(i+j>N)
                {
                    arr[i][j] = Start;
                    Start = Start+1;
                    if(Start==10){Start=1;}

                    flag++;
                    if(flag>=cnt){break;}
                }
            }
//            System.out.println();
        }
//        printArrVersion1();
        printArrVersion3();
        scan.close();
    }

    public static void printArrVersion1()
    {
        for(int i=1;i<6;i++)
        {
            for(int j=1;j<10;j++)
            {
                System.out.print(arr[i][j]);
            }System.out.println();
        }
    }

    public static void printArrVersion2()
    {
        for(int i=1;i<6;i++)
        {
            if(i%2==1)
            {
                for(int j=9;j>=1;j--)
                {
                    if(arr[i][j]==0)
                    {
                        System.out.print(" ");
                    }else
                    {
                        System.out.print(arr[i][j]);
                    }
                }
                System.out.println();
            }
            else
            {
                for(int j=1;j<=9;j++)
                {
                    if(arr[i][j]==0)
                    {
                        System.out.print(" ");
                    }else
                    {
                        System.out.print(arr[i][j]);
                    }
                }
                System.out.println();

            }

        }
    }

    public static void printArrVersion3()
    {
        for(int i=1;i<N+1;i++)
        {
            if(i%2==1)
            {
                for(int j=2*N-1;j>=1;j--)
                {
                    if(arr[i][j]==0)
                    {
                        System.out.print(" ");
                    }else
                    {
                        System.out.print(arr[i][j]);
                    }
                }
                System.out.println();
            }
            else
            {
                for(int j=1;j<=2*N-1;j++)
                {
                    if(arr[i][j]==0)
                    {
                        System.out.print(" ");
                    }else
                    {
                        System.out.print(arr[i][j]);
                    }
                }
                System.out.println();

            }

        }
    }
}
