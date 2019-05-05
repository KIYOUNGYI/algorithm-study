package algolabs.step2.array;

import java.util.Scanner;

public class 두번째최소값2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);



        int[] arr = new int[9];
        for(int i=0;i<9;i++)
        {
            arr[i] = scan.nextInt();
        }

        int min=arr[0];
        int min_index=0;
        for(int i=0;i<9;i++)
        {
            if(min>=arr[i])
            {
                min=arr[i];
                min_index=i;
            }
        }

//        System.out.println("max:"+max);
//        System.out.println("max index:"+max_index);

        arr[min_index]=10000001;




        min=arr[0];
        for(int i=0;i<9;i++)
        {
            if(min>=arr[i])
            {
                min=arr[i];
                min_index=i;
            }
        }

        System.out.println(min);
        System.out.println(min_index+1);


        scan.close();
    }

    public static class Max {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int max = 0;
            int idx = 0;

            int[] arr = new int[9];
            for(int i=0,arr_length=arr.length;i<arr_length;i++){
                arr[i] = scan.nextInt();
            }

            max=arr[0];
            for(int j=0,arr_length=arr.length;j<arr_length;j++){
                if(arr[j]>=max){
                   max=arr[j];
                   idx = j+1;
                }
            }
            System.out.println(max);
            System.out.println(idx);

            scan.close();
        }
    }

    public static class Reverse {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int N = scan.nextInt();
            int[] arr = new int[N];
            for(int j=0;j<N;j++){
                arr[j] = scan.nextInt();
            }

            for(int k=N-1;k>=0;k--){
                System.out.print(arr[k]+" ");
            }

            scan.close();
        }
    }
}
