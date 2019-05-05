package algolabs.step2.array;

import java.util.Scanner;

/**
 * N*M의 2차원 배열이 주어지고, 주어진 2차원 배열의 [A][B]에는 어떠한 값이 있는지 출력하는 프로그램을 작성해보자. (단, 2차원 배열을 활용할 것)
 *
 * 입력:첫째 줄에 자연수 행의 개수 N,열의 개수 M이 주어진다.(1<=N,M<=100) 둘째 줄 부터 N*M의 배열이 주어지고, 마지막 줄에는 A,B가 주어진다. ( 0<=A<N, 0<=B<M )
 * */
public class Array2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] arr = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=scan.nextInt();
            }
        }

        int O = scan.nextInt();
        int P = scan.nextInt();
        System.out.println(arr[O][P]);

        scan.close();
    }
}
