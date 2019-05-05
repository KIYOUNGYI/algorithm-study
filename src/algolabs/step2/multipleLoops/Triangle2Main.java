package algolabs.step2.multipleLoops;

import java.util.Scanner;

public class Triangle2Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
//                System.out.print("[i:"+i+","+"j:"+j+"]");
                if(i+j<=N){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        scan.close();


    }
}
