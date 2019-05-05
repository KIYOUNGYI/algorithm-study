package algolabs.step2.multipleLoops;

import java.util.Scanner;

public class 삼각형출력3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int temp = N;
//        System.out.println("before increase temp->"+temp);
        for(int i=0;i<N;i++){

            for(int j=0;j<=temp;j++){
                if(i+j>=N-1 && i+j<temp){
//                    System.out.print("["+i+","+j+"]");
                    System.out.print("*");
                }else{
//                    System.out.println("no print ");
                    System.out.print(" ");
                }
            }

            temp = temp+2;
//            System.out.println("after increase temp->"+temp);
            System.out.println();
        }

        scan.close();
    }
}
