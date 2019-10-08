package com.study.lms;
import java.util.Scanner;
public class CombinationPascal{
    
    public static int arr[][] = new int[31][31];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      for(int i=1;i<31;i++){arr[i][0]=1;arr[i][i]=1;}
      
      for(int i=2;i<31;i++)
        for(int j=1;j<i;j++)
          arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
      
      arr[0][0]=1;
          
      int x = scan.nextInt();
      int y = scan.nextInt();
      
      System.out.println(arr[x][y]);
       
      scan.close();
    }
}