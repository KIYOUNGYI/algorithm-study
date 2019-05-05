package algolabs.step2.array;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        // [1] 입력개수를 입력받는다.
        // [2] 입력개수만한 크기의 배열을 생성한다.
        // [3] 입력개수만한 크기의 (연속한 1을 셀) (배열2)을 생성한다.
        // [4] 임시 cnt 변수를 선언한다.
        // [5] 입력배열 크기만큼 for loop 를 돈다.
        // [6] input[i] 가 1이면 cnt를 증가시킨다.
        // [7] input[i] 가 1이 아니면 cnt를 배열2 의 인덱스에 집어넣고 1만큼 증가시킨다. 그리고 cnt는 0으로 초기화한다.
        // [8] 최종적으로 반복문을 돌면서 점수를 계산한다.

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr_input = new int[N+1];
        int[] score_count = new int[N+1];


        for(int i=0;i<N;i++){
            arr_input[i] = scan.nextInt();
        }

        int cnt = 0;
        for(int i=0;i<=N;i++){

            if(arr_input[i]==1)
            {
                score_count[cnt]+=1;
                cnt++;
            }
            else
            {
                score_count[cnt]+=1;
                cnt=0;
            }
        }
        int sum = 0;
        for(int j=1;j<=N;j++)
        {
//            System.out.println("j:"+j+" cnt: "+score_count[j]);
            sum = sum + j*score_count[j];
        }
        System.out.println(sum);

        scan.close();
    }
}
