package algolabs.step2.array;

import java.util.Scanner;

/**
 * 숫자를 입력 받아 이진수로 출력하는 프로그램을 작성하시오.
 * 입력
 * 첫 번째 줄에 숫자를 입력 받는다. 숫자의 크기는 1,000보다 작거나 같다.
 * 출력
 * 첫째 줄에 숫자를 이진수로 바꾸어 출력한다.
 * 예제 입력
 * 14
 * 예제 출력
 * 1110
 */
public class Binary {
    public static void main(String[] args) {
        //[1] 1000 이하의 숫자이므로 배열크기 10자리 선언
        //[2] 10진수 입력받기
        //[3] 몫이 0이 될때까지 2로 나눈다.
        //[4] 나머지 값은 배열에 순차적으로 저장한다.
        //[5] 유클리드 호제법으로 a b  계속 바꿔치기 한다.
        //[6] 몫이 0이 되면 배열 거꾸로 출력한다.(거꾸로 출력하는 시작점은 인덱스 끝난 점(인덱스 저장필요)

        int[] binary = new int[10];
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int index=0;
        int mok=N;
        while(true)
        {
            if(mok==0)
            {
                break;
            }
            mok = N/2;
            int remain = N%2;

            binary[index] = remain;
            index++;
            N = mok;
        }
//        System.out.println("index:"+index);
        for(int i=index-1;i>=0;i--)
        {
            System.out.print(binary[i]);
        }


        scan.close();
    }
}
