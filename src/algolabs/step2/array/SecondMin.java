package algolabs.step2.array;

import java.util.Scanner;

public class SecondMin {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //[1]  10,000,000 x 2 크기의 2차원 배열을 선언한다.
        //[2]  9번 입력을 받는다.
        //[3]  입력받은 수의 인덱스에 임의값 1을 집어넣는다.[x][0] = 1,  [x][1] = i 값
        //[4]  갯수를 세는 flag 변수를 선언한고 0으로 초기화 시킨다.
        //[5]  만약 배열 안의 값이 1이면 flag 값을 1 증가시킨다.
        //[6]  flag 값이 2가 되는 순간의 인덱스를 출력한다. 그리고 break한다.

        int[][] arr = new int[10000001][2];
        for(int i=0;i<9;i++){
            int input = scan.nextInt();
            arr[input][0] = input;
            arr[input][1] = i+1;
        }

        int min = 10000000;
        for(int i=0;i<10000001;i++){
           if(arr[i][0]<min && arr[i][0]!=0){
               min = arr[i][0];
           }
        }
        int temp = min;
//        System.out.println("temp:"+temp);
        for(int j=temp+1;j<10000000;j++){
                if(arr[j][0]!=0){
                    System.out.println(arr[j][0]);
                    System.out.println(arr[j][1]);
                    break;
                }

            }
        }

    }


