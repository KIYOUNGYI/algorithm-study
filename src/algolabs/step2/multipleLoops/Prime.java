package algolabs.step2.multipleLoops;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

//        long start = System.currentTimeMillis();

        boolean[] arr = new boolean[20001];


        for(int i=2;i<20001;i++){
            arr[i] = true;
        }

        for(int i=2;i<20001;i++){
            for(int j=i+i;j<20001;j=j+i){
                arr[j] = false;
            }
        }


        for(int i=N;i<=M;i++){
            if(arr[i]==true){
                System.out.print(i+" ");
            }
        }

        scan.close();
//
//        long end = System.currentTimeMillis();
//        System.out.println("end-start:"+(end-start));
    }
}
