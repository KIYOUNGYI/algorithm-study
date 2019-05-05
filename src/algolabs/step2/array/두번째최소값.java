package algolabs.step2.array;

import java.util.Scanner;

/**
 * 9개의 서로 다른 자연수가 주어질 때, 이들 중 두 번째 최소값을 찾고, 그 두 번째 최소값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
 * 예를 들어, 서로 다른 9개의 자연수 3, 29, 38, 12, 57, 74, 40, 85, 61 이 주어지면, 이들 중 두 번째 최소값은 12이고, 이 값은 4번째 수이다.
 */
public class 두번째최소값 {
    public static void main(String[] args) {
        //[1] 크기 9의 배열을 선언한다.
        //[2] 숫자를 입력받는다.
        //[3] 첫번째 값을 min이라 가정한다.
        //[4] 배열을 순회하면서 min 값을 갱신한다.
        //[5] 최소값을 엄청큰값으로 바꿔치기한다.
        //[6] 다시 한 번 최소값을 찾는다.

        Scanner scan = new Scanner(System.in);
        //[1]
        int[] arr = new int[9];

        //[2]
        for(int i=0;i<9;i++){
            arr[i] = scan.nextInt();
        }

        int min=arr[0];
        int min_index=0;
        for(int i=0;i<9;i++){
           if(min>=arr[i]){
               min = arr[i];
               min_index = i;
           }
        }
//        System.out.println("min_index:"+min_index);
        arr[min_index] = 10000001;


        int second_min=arr[0];
        int second_min_index=0;
        for(int j=0;j<9;j++){
            if(second_min>=arr[j])
            {
                second_min = arr[j];
                second_min_index = j;
            }
        }

        System.out.println(arr[second_min_index]);
        System.out.println((second_min_index+1));

        scan.close();
    }

    public static class 대표값 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int[] arr = new int[10];
            int[] cnt = new int[1001];
            int sum=0;
            int avg=0;
            int temp =0;
            for(int i=0;i<10;i++){
                arr[i] = scan.nextInt();
                sum = sum+arr[i];
                cnt[arr[i]]++;
            }
            avg = sum/10;

            int bin=cnt[1000];
            for(int j=1001;j>=0;j--){
                if(cnt[bin]<=cnt[j]){
                    bin=j;
                }
            }

            System.out.println(avg);
            System.out.println(bin);

            scan.close();

        }
    }

    /**
     * 문제
     * 자연수n,m이 주어질 때, n부터m까지 존재하는 소수를 모두 출력하는 프로그램을 작성하여라. 여기서 소수란, 약수가 1과 자기자신밖에 존재하지 않는 수를 말한다.
     * 입력
     * 첫째 줄에 자연수 n, m이 주어진다. (1≤n,m≤20,000)
     * 출력
     * 첫째 줄에 n부터m까지 존재하는 소수를 모두 출력한다.
     * 예제 입력
     * 1 10
     * 예제 출력
     * 2 3 5 7
     * 예제 입력
     * 13 30
     * 예제 출력
     * 13 17 19 23 29
     */
    public static class 소수판별2
    {
        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);
            boolean[] isPrime = new boolean[20001];
            isPrime[1] = true;
            isPrime[2] = true;
            isPrime[3] = false;
            for(int i=2;i<20001;i++)
            {
                for(int j=i;j<20001;j=j+i)
                {
                    isPrime[j]=false;
                }
            }

            for(int i=0;i<isPrime.length;i++)
            {
                System.out.println("i:"+i+"는 "+isPrime[i]);
            }

        }
    }

    /**
     *
     * 자연수n,m이 주어질 때, n부터m까지 존재하는 소수를 모두 출력하는 프로그램을 작성하여라. 여기서 소수란, 약수가 1과 자기자신밖에 존재하지 않는 수를 말한다.
     * 입력
     * 첫째 줄에 자연수 n, m이 주어진다. (1≤n,m≤20,000)
     * 출력
     * 첫째 줄에 n부터m까지 존재하는 소수를 모두 출력한다.
     * 1 10
     * 예제 출력
     * 2 3 5 7
     *
     */

    public static class 소수판별3
    {
        public static int MAX = 20001;
        public static int[] arr = new int[MAX];
        public static boolean[] isPrime = new boolean[MAX];

        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);
            initIsPrime();

            calculateWhetherNumberIsPrime();

            int start = scan.nextInt();
            int end = scan.nextInt();

            printAnswer(start,end);


            scan.close();
        }

        /**
         * print answer.
         * TIME : O(N)
         * @param start
         * @param end
         */
        private static void printAnswer(int start,int end)
        {
            for(int i=start;i<=end;i++)
            {
                if(isPrime[i])
                {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }


        /**
         * Determine whether given number is prime or not through for nested loop.
         * TIME : o(N * logN)
         */
        private static void calculateWhetherNumberIsPrime()
        {
            for(int i=2;i<MAX/2;i++)
            {
                for(int j=i+i;j<MAX;j=j+i)
                {
                    isPrime[j]=false;
                }
            }
        }

        /**
         * init isPrime Array
         * TIME : O(N)
         */
        private static void initIsPrime()
        {
            int len = isPrime.length;
            for(int i=0;i<len;i++)
            {
                isPrime[i]=true;
            }
            // 1 is not a prime number.
            isPrime[0]=false;
            isPrime[1]=false;
        }

        /**
         * temp
         */
        private static void printIsPrime()
        {
            for(int i=0;i<1000;i++)
            {
                System.out.print(isPrime[i]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 2번째 풀이
     * 2차원 배열 활용
     * beforeValue라는 변수 활용이 포인트
     */
    public static class 점수계산2
    {
        public static int[][] arr;
        public static int N;

        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);
    //        N = 10;
            N = scan.nextInt();
            arr = new int[N][2];

    //        initArr();

            for(int i=0;i<N;i++) arr[i][0] = scan.nextInt();

            calculateScore();

            totalScore();

            scan.close();
        }

        private static void initArr()
        {
            arr[0][0]=1;
            arr[1][0]=0;
            arr[2][0]=1;
            arr[3][0]=1;
            arr[4][0]=1;
            arr[5][0]=0;
            arr[6][0]=0;
            arr[7][0]=1;
            arr[8][0]=1;
            arr[9][0]=0;
        }

        private static void totalScore()
        {
            int totalSum=0;
            for(int i=0;i<N;i++)
            {
                totalSum+=arr[i][1];
            }
            System.out.println(totalSum);
        }

        private static void calculateScore()
        {
            int beforeValue=0;

            for(int i=0;i<N;i++)
            {
                if(arr[i][0]==1 && beforeValue==0)
                {
                    beforeValue=1;
                }
                else if(arr[i][0]==1 && beforeValue!=0)
                {
                    beforeValue=beforeValue+1;
                }
                else if(arr[i][0]==0)
                {
                    beforeValue=0;
                }
                arr[i][1]=beforeValue;
            }
        }
    }
}
