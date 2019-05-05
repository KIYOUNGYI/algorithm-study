package algolabs.step2.array;

import java.util.Scanner;

/**
 * 열의 개수 N, 행의 개수 M이 주어질 때, 다음과 같이 출력하는 프로그램을 작성해보자. (단, 2차원 배열을 활용할 것)
 * 입력
 * 첫째 줄에 자연수 N,M이 주어진다.(1<=N,M<=100)
 * 출력
 * 출력 예시와 같은 형식으로 출력한다.
 */
public class Array1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] arr = new int[N][M];

        int x=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=x;
                x++;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }



        scan.close();
    }
}
