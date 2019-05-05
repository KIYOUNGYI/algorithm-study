package algolabs.step2.array;

import java.util.Scanner;

public class Binary2
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        recursive(n);
    }

    public static void recursive(int n)
    {
        if(n==0)
        {
            System.out.print(0);
            return;
        }
        if(n==1)
        {
            System.out.print(1);
            return;
        }

        int temp = n%2;
        recursive(n/2);
        System.out.print(temp);
    }
}


