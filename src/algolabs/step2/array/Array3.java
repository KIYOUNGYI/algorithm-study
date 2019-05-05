package algolabs.step2.array;

import java.util.Scanner;

/**
 * 문제
 * N이 주어질 때, 다음과 같은 프로그램을 작성해보자.
 * 입력
 * 첫째 줄에 자연수 N이 주어진다.(1<=N<=100)
 * 출력
 * 예시를 참고하여 작성하자.
 * 예제 입력
 * 3
 * 예제 출력
 * 1 2 4
 * 3 5
 * 6
 * 예제 입력
 * 5
 * 예제 출력
 * 1 2 4 7 11
 * 3 5 8 12
 * 6 9 13
 * 10 14
 * 15
 */
public class Array3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int[][] arr = new int[N][N];
        int value = 1;
        for(int i=0;i<N;i++){
            int temp = (i);
          for(int j=0;j<=i;j++) {
              arr[j][temp] = value++;
//              System.out.print("arr["+j+","+(temp--)+"]");
          }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]!=0)
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        scan.close();
    }
}
