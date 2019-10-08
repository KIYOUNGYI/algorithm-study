package com.study.lms;

import java.util.Scanner;
public class 트리순회결과출력하기{
    public static Node[] nodeList;
    public static int n;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
     
      input(scan);
      preOrder(0);
      System.out.println();
      inOrder(0);
      System.out.println();
      postOrder(0);
      
      scan.close();

    }
    
    public static void preOrder(int x)
    {
      if(x ==-1)return;
      System.out.print(x+" ");
      preOrder(nodeList[x].left);
      preOrder(nodeList[x].right);
    }
    
    public static void inOrder(int x)
    {
      if(x ==-1)return;
      
      inOrder(nodeList[x].left);
      System.out.print(x+" ");
      inOrder(nodeList[x].right);
    }
    
    public static void postOrder(int x)
    {
      if(x ==-1)return;
      postOrder(nodeList[x].left);
      postOrder(nodeList[x].right);
      System.out.print(x+" ");
    }
    
    
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      nodeList = new Node[n];
      for(int i=0;i<n;i++)
      {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        nodeList[a] = new Node(b,c);
      }
    }
}

class Node
{
  int left;
  int right;
  public Node(int left,int right)
  {
    this.left = left;
    this.right = right;
  }
}