package com.study.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH
public class 특이한자석 {

	public static int aTop = 0, aLeft = 6, aRight = 2, bTop = 0, bLeft = 6, bRight = 2, cTop = 0, cLeft = 6, cRight = 2,
			dTop = 0, dLeft = 6, dRight = 2;
	public static int[][] arr = new int[5][8];
	public static int[][] scenario;
	public static int T, K;
	public static int sum=0;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		T = scan.nextInt();

		for (int i = 1; i <= T; i++) {
			input(scan);
			wierdMagnetics();
			System.out.println("#"+i+" "+sum);
			init();
			sum=0;
		}

	}

	private static void init() {
		aTop = 0; aLeft = 6; aRight = 2; bTop = 0; bLeft = 6; bRight = 2; cTop = 0; cLeft = 6; cRight = 2;
		dTop = 0; dLeft = 6; dRight = 2;	
	}

	private static void wierdMagnetics() {
		int[] check = new int[5];
		boolean[] rotate = new boolean[5];
		
		for (int i = 0; i < K; i++) {
			int pan = scenario[i][0];
			int dir = scenario[i][1];
//			System.out.println("pan:"+pan+" dir:"+dir);
//			
//			System.out.println("rotate 전 ");
//			System.out.println("aTop val:"+arr[1][aTop]+" aTop Idx:"+aTop);
//			System.out.println("bTop val:"+arr[2][bTop]+" bTop Idx:"+bTop);
//			System.out.println("cTop val:"+arr[3][cTop]+" cTop Idx:"+cTop);
//			System.out.println("dTop val:"+arr[4][dTop]+" dTop Idx:"+dTop);
//			System.out.println("-----");
			
			check[pan]=dir;
			//인접한 것중에 다른 것을 찾고,
			decide(check,pan,check[pan]);
//			System.out.println(">>"+Arrays.toString(check));
			
			//그 중에서 인접한거(즉,돌릴거를 뽑아내고)
			rotateWhat(check, rotate, pan);
			//안돌릴거는 0으로 만들고
			for(int k=1;k<5;k++) 
			{
				if(rotate[k]==false)check[k]=0;
			}
			
//			System.out.println(Arrays.toString(check));
			shift(check);
//			System.out.println("rotate 후 ");
//			System.out.println("aTop val:"+arr[1][aTop]+" aTop Idx:"+aTop);
//			System.out.println("bTop val:"+arr[2][bTop]+" bTop Idx:"+bTop);
//			System.out.println("cTop val:"+arr[3][cTop]+" cTop Idx:"+cTop);
//			System.out.println("dTop val:"+arr[4][dTop]+" dTop Idx:"+dTop);
//			System.out.println("-----");
			check[1]=0;check[2]=0;check[3]=0;check[4]=0;
			rotate[1]=false;rotate[2]=false;rotate[3]=false;rotate[4]=false;
		}
		calculate();
	}

	private static void shift(int[] check) {
		
		
			if(check[1]==1) //시계방향이면
			{
				aTop-=1;
			    aLeft-=1;
			    aRight-=1;
			    if(aTop<0)aTop=7;
			    if(aLeft<0)aLeft=7;
			    if(aRight<0)aRight=7;
			}
			if(check[1]==-1) 
			{
				aTop+=1;
			    aLeft+=1;
			    aRight+=1;
			    if(aTop>7)aTop=0;
			    if(aLeft>7)aLeft=0;
			    if(aRight>7)aRight=0;
			}
			
			if(check[2]==1) 
			{
				bTop-=1;
			    bLeft-=1;
			    bRight-=1;
			    if(bTop<0)bTop=7;
			    if(bLeft<0)bLeft=7;
			    if(bRight<0)bRight=7;
			}
			if(check[2]==-1) 
			{
				bTop+=1;
			    bLeft+=1;
			    bRight+=1;
			    if(bTop>7)bTop=0;
			    if(bLeft>7)bLeft=0;
			    if(bRight>7)bRight=0;
			}
			
			if(check[3]==1) 
			{
				cTop-=1;
			    cLeft-=1;
			    cRight-=1;
			    if(cTop<0)cTop=7;
			    if(cLeft<0)cLeft=7;
			    if(cRight<0)cRight=7;
			}
			if(check[3]==-1) 
			{
				cTop+=1;
			    cLeft+=1;
			    cRight+=1;
			    if(cTop>7)cTop=0;
			    if(cLeft>7)cLeft=0;
			    if(cRight>7)cRight=0;
			}
			if(check[4]==1) 
			{
				dTop-=1;
			    dLeft-=1;
			    dRight-=1;
			    if(dTop<0)dTop=7;
			    if(dLeft<0)dLeft=7;
			    if(dRight<0)dRight=7;
			}
			if(check[4]==-1) 
			{
				dTop+=1;
			    dLeft+=1;
			    dRight+=1;
			    if(dTop>7)dTop=0;
			    if(dLeft>7)dLeft=0;
			    if(dRight>7)dRight=0;
			}
		}
		
	

	private static void rotateWhat(int[] check, boolean[] rotate, int pan) {
		for(int k=pan;k<5;k++) 
		{
			if(check[k]!=0) 
			{
				rotate[k]=true;
			}
			else {break;}
		}
		for(int k=pan;k>=1;k--) 
		{
			if(check[k]!=0) 
			{
				rotate[k]=true;
			}
			else {break;}
		}
	}

	private static int[] decide(int[] check,int pan,int dir) {
		if(pan==1) 
		{
			if(arr[1][aRight]!=arr[2][bLeft]) 
			{
				check[2]=-dir;
				if(arr[2][bRight]!=arr[3][cLeft]) 
				{
					check[3]=dir;
					if(arr[3][cRight]!=arr[4][dLeft]) 
					{
						check[4]=-dir;
					}
					else 
					{
						return check;
					}
				}
				else 
				{
					return check;
				}
			}
			else 
			{
				return check;
			}
		}
		
		if(pan==3)
		{
			if(arr[3][cRight]!=arr[4][dLeft]) 
			{
				check[4]=-dir;
			}

			if(arr[3][cLeft]!=arr[2][bRight]) 
			{
				check[2]=-dir;
				if(arr[2][bLeft]!=arr[1][aRight]) 
				{
					check[1]=+dir;
				}
				else 
				{
					return check;
				}
			}
			else 
			{
				return check;
			}
		}		
		if(pan==2) 
		{
			if(arr[2][bLeft]!=arr[1][aRight]) 
			{
				check[1]=-dir;
			}
			if(arr[2][bRight]!=arr[3][cLeft]) 
			{
				check[3]=-dir;
				if(arr[3][cRight]!=arr[4][dRight]) 
				{
					check[4]=dir;
					return check;
				}
				else 
				{
					return check;
				}
			}
			else 
			{
				return check;
			}
		}
		if(pan==4) 
		{
			if(arr[3][cRight]!=arr[4][dLeft]) 
			{
				check[3]=-dir;
				if(arr[2][bRight]!=arr[3][cLeft]) 
				{
					check[2]=dir;
					
					if(arr[1][aRight]!=arr[2][bLeft]) 
					{
						check[1]=-dir;
					}
					else 
					{
						return check;
					}
				}
				else 
				{
					return check;
				}
			}
			else 
			{
				return check;
			}
			
		}
		
		
		
		
		
		return check;
		
	}

	private static void calculate() {
		
		sum=arr[1][aTop]*1+arr[2][bTop]*2+arr[3][cTop]*4+arr[4][dTop]*8;
		
	}

	private static int[] shift(int dir, int top, int left, int right) {
		if (dir == -1) // 반시계 
		{
			top = top + 1;
			left = left + 1;
			right = right + 1;
			if (top == 8)
				top = 0;
			if (left == 8)
				left = 0;
			if (right == 8)
				right = 0;
		} else //시계방향
		{
			top = top - 1;
			left = left - 1;
			right = right - 1;
			if (top == -1)
				top = 7;
			if (left == -1)
				left = 7;
			if (right == -1)
				right = 7;
		}
//		System.out.println("t:"+top+" l:"+left+" r:"+right);
		int[] a = new int[] {top,left,right};
		return a;
	}

	private static void input(Scanner scan) {
		K = scan.nextInt();
		scenario = new int[K][2];
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		for (int i = 0; i < K; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			scenario[i][0] = x;
			scenario[i][1] = y;
		}
	}
}




