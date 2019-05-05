package algolabs.step2.array;

import java.util.Scanner;

public class CardGame2
{
    public static int[][] scoreBoard = new int[10][2];
    public static int aWin=0;
    public static int bWin=0;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        for(int i=0;i<10;i++){scoreBoard[i][0]=scan.nextInt();}
        for(int i=0;i<10;i++){scoreBoard[i][1]=scan.nextInt();}

        calculate();
        finalResult();

        scan.close();
    }

    private static void finalResult()
    {
        if(aWin>bWin)
        {
            System.out.println("A");
        }
        else if(aWin<bWin)
        {
            System.out.println("B");
        }
        else
        {
            System.out.println("D");
        }
    }

    private static void calculate()
    {
        for(int i=0;i<10;i++)
        {

            if(scoreBoard[i][0] > scoreBoard[i][1])
            {
                aWin=aWin+1;
            }
            else if(scoreBoard[i][0]<scoreBoard[i][1])
            {
                bWin=bWin+1;
            }
        }
    }
}
