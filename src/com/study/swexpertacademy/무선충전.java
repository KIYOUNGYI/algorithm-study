package com.study.swexpertacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
public class 무선충전 {
	public static int[] dx = {0,-1,0,1,0};
	public static int[] dy = {0,0,1,0,-1};
	public static int t,m,a;
	public static int[] moveA,moveB;
	public static int[] power;
	public static int[][] score;
	public static ArrayList<Integer>[][] arrList = new ArrayList[11][11];
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		t  = scan.nextInt();
		for(int i=1;i<=t;i++) 
		{
			input(scan);
//			printArea();
			int x = simulation();
			System.out.println("#"+i+" "+x);
		}
		scan.close();
	}
	private static int simulation() {
		int ax=1;int ay=0;int bx=10;int by=11;
		int totalSum=0;
		for(int i=0;i<=m;i++) 
		{
			int adir = moveA[i];
			int bdir = moveB[i];
			
			if(adir==1) {ax = ax+dx[1];ay = ay+dy[1];}
			else if(adir==2) {ax = ax+dx[2];ay = ay+dy[2];}
			else if(adir==3) {ax = ax+dx[3];ay = ay+dy[3];}
			else if(adir==4) {ax = ax+dx[4];ay = ay+dy[4];}
			
			if(bdir==1) {bx = bx+dx[1];by = by+dy[1];}
			else if(bdir==2) {bx = bx+dx[2];by = by+dy[2];}
			else if(bdir==3) {bx = bx+dx[3];by = by+dy[3];}
			else if(bdir==4) {bx = bx+dx[4];by = by+dy[4];}
			
			ArrayList<Integer> groupA = arrList[ax][ay];
			ArrayList<Integer> groupB = arrList[bx][by];
			
			
			int t = 0;int max=0;
//			System.out.println("p:"+Arrays.toString(power));
//			System.out.println("ga:"+groupA.toString());
//			System.out.println("gb:"+groupB.toString());
			for(int j=0;j<groupA.size();j++) 
			{
				for(int k=0;k<groupB.size();k++) 
				{
					if(groupA.get(j)==groupB.get(k)) 
					{
						t = power[groupA.get(j)];
					}
					else 
					{
						t = power[groupA.get(j)]+power[groupB.get(k)];
					}
					if(t>max)max=t;
				}
			}
//			System.out.println("i:"+i+" 일 때 합:"+max);
			totalSum+=max;
		}
//		System.out.println("total:"+totalSum);
		return totalSum;
	}
	private static void input(Scanner scan) {
		m = scan.nextInt();
		a = scan.nextInt();
		moveA = new int[m+1];
		moveB = new int[m+1];
		power = new int[a+1];
		score = new int[2][m+1];
		moveA[0]=2;moveB[0]=4;
		for(int j=1;j<=m;j++)moveA[j] = scan.nextInt();
		for(int j=1;j<=m;j++)moveB[j] = scan.nextInt();
		
		init();
		
		for(int j=1;j<=a;j++) 
		{
			int w = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			markArea(x,w,y,j);
			power[j]=z;
		}
	}
	private static void printArea() 
	{
		for(int i=0;i<11;i++) 
		{
			for(int k=0;k<11;k++) 
			{
				System.out.print("{"+i+","+k+"}:"+arrList[i][k].toString());
			}System.out.println();
		}
	}
	
	private static void markArea(int x, int y, int range,int idx) {
		// TODO Auto-generated method stub
		for(int i=1;i<11;i++) 
		{
			for(int j=1;j<11;j++) 
			{
				if(abs(x-i)+abs(y-j)<=range) 
				{
//					System.out.println(i+" "+j);
					arrList[i][j].add(idx);
				}
			}
		}
	}

	public static int abs(int x) {if(x>0)return x;else return -x;}
	
	public static void init() 
	{
		for(int i=0;i<11;i++) 
		{
			for(int j=0;j<11;j++) 
			{
				arrList[i][j] = new ArrayList<Integer>();
				arrList[i][j].add(0);
			}
		}
	}
}
