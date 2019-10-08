package com.study.swexpertacademy;

import java.util.ArrayList;
import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu
public class 디저트카페 {
	public static int sum=0;
	public static int max=-1;
	public static int t,n;
	public static int[][] map,score;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		for(int i=1;i<=t;i++) 
		{
			input(scan);
			dessertCafe();
			int x = findMaxScore();
			if(x==0)x=-1;
			System.out.println("#"+i+" "+x);
			max=-1;
		}
		
		scan.close();
	}
	private static int findMaxScore() {
		int t = 0;
		for(int i=1;i<=n;i++) 
		{
			for(int j=1;j<=n;j++) 
			{
				if(t<score[i][j])t=score[i][j];
//				System.out.print(score[i][j]+" ");
			}
//			System.out.println();
		}
		
		return t;
	}
	private static void dessertCafe() {
		//1.맵을 1,1 ~ n,n 까지 순회한다.
		//		기준점에서 (1,1)~(n,n)을 사각형 범위로 잡는다.
		//			3개점의 범위를 검사한다.
		//				검사에 걸리면 continue한다.
		//				안결리면 4방향 순회한다.arrList에 담고, 개수 검사 & 계산) 
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++) 
		{
			for(int j=1;j<=n;j++) 
			{
				//한점에서 (1,1)~(n,n)
				for(int a=1;a<=n;a++) 
				{
					for(int b=1;b<=n;b++) 
					{
						if(rangeCheck(i,j,a,b)) 
						{
//							System.out.println("i: "+i+" j: "+j+" a: "+a+" b: "+b);
							directionCheck(i,j,a,b,arrList);//방향순회 & arrlist 갱신
							if(arrList.size()!=2*a+2*b) {arrList.clear();continue;}
							else 
							{
								sum=arrList.size();
								arrList.clear();
							}
							if(sum>max)max=sum;
						}
						else 
						{
							arrList.clear();
							//범위 걸림
							continue;
						}
					}
				}
				arrList.clear();
				//한점의 최대값
				score[i][j]=max;
			}
		}
	}
	
	
	
	private static void directionCheck(int curx,int cury,int rangeX,int rangeY,ArrayList<Integer> arrList) {
		int tx = curx;int ty = cury;
		for(int i=0;i<rangeX;i++) 
		{
			tx = tx+1;ty=ty+1;
//			System.out.println("tx:"+tx+" "+ty);
			if(!arrList.contains(map[tx][ty])) 
			{
				arrList.add(map[tx][ty]);
			}
		}
		
		for(int i=0;i<rangeY;i++) 
		{
			tx = tx+1;ty=ty-1;
//			System.out.println("tx:"+tx+" "+ty);
			if(!arrList.contains(map[tx][ty])) 
			{
				arrList.add(map[tx][ty]);
			}
		}
		for(int i=0;i<rangeX;i++) 
		{
			tx = tx-1;ty=ty-1;
//			System.out.println("tx:"+tx+" "+ty);
			if(!arrList.contains(map[tx][ty])) 
			{
				arrList.add(map[tx][ty]);
			}
		}
		for(int i=0;i<rangeY;i++) 
		{
			tx = tx-1;ty=ty+1;
//			System.out.println("tx:"+tx+" "+ty);
			if(!arrList.contains(map[tx][ty])) 
			{
				arrList.add(map[tx][ty]);
			}
		}
		
	}
	private static boolean rangeCheck(int curx,int cury,int a, int b) {
		
		int x1 = curx+a;
		int y1 = cury+a;
		
		int x2 = curx+a+b;
		int y2 = cury+a-b;
		
		int x3 = curx+b;
		int y3 = cury-b;
		
		if(x1>=1 && y1>=1 && x2>=1 && y2>=1 && x3>=1 && y3>=1 && x1<=n && y1<=n && x2<=n && y2<=n && x3<=n && y3<=n)return true;
		
//		if(x1==8 && )
		
		return false;
	}
	private static void input(Scanner scan) {
		n = scan.nextInt();
		map = new int[n+1][n+1];
		score = new int[n+1][n+1];
		for(int j=1;j<=n;j++) 
		{
			for(int k=1;k<=n;k++) 
			{
				map[j][k]=scan.nextInt();
			}
		}
	}
}
