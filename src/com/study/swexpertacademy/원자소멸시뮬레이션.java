package com.study.swexpertacademy;

import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
public class 원자소멸시뮬레이션 {
	static int[][]  atom = new int[1000][4];
	static int[][] visit;
	static boolean[][] collide;
	static int t,n,ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		for(int i=1;i<=t;i++) 
		{
			input(scan);
			simulation();
			System.out.println("#"+i+" "+ans);
			ans=0;
		}
	}
	
	
	private static void simulation() {
		int nRest = n;
		ans=0;
		
		for(int j=0;j<nRest;j++) 
		{
			atom[j][0]=atom[j][0]*2;
			atom[j][1]=atom[j][1]*2;
			visit[atom[j][0]][atom[j][1]]+=1;
		}
		
		int nMaxLoop = 4002;
		for(int j=0;j<nMaxLoop;j++) 
		{
			for(int k=0;k<nRest;k++) 
			{
				int d = atom[k][2];
//				System.out.println(atom[k][0]+" "+atom[k][1]);
				visit[atom[k][0]][atom[k][1]]-=1;
				// 0 상 , 1 하 , 2 좌, 3 우 
				if(d==0)atom[k][1]+=1;
				else if(d==1)atom[k][1]-=1;
				else if(d==2)atom[k][0]-=1;
				else if(d==3)atom[k][0]+=1;
				
				
				if(atom[k][0]<0 || atom[k][0]>4000 || atom[k][1]<0 || atom[k][1]>4000) 
				{
					remove(k,nRest);
					nRest--;
					k--;
				}
				else 
				{
					visit[atom[k][0]][atom[k][1]]+=1;
					if(visit[atom[k][0]][atom[k][1]]>=2) {
						collide[atom[k][0]][atom[k][1]]=true;
					}
				}
			}
			
			for(int k=0;k<nRest;k++) 
			{
				if(collide[atom[k][0]][atom[k][1]]==true) 
				{
					if(visit[atom[k][0]][atom[k][1]]==1)
						collide[atom[k][0]][atom[k][1]]=false;
					visit[atom[k][0]][atom[k][1]]-=1;
					ans+=atom[k][3];
					remove(k,nRest);
					nRest--;
					k--;
				}
			}
			if(nRest==0)break;
		}
		
	}

	private static void remove(int n,int pnSize) 
	{
		int nLastIdx = pnSize-1;
		atom[n][0] = atom[nLastIdx][0];
		atom[n][1] = atom[nLastIdx][1];
		atom[n][2] = atom[nLastIdx][2];
		atom[n][3] = atom[nLastIdx][3];
		return;
	}
	
	
	private static void input(Scanner scan) {
		n = scan.nextInt();
		visit =  new int[4005][4005];
		collide = new boolean[4005][4005];
		for(int j=0;j<n;j++) 
		{
			int a = scan.nextInt();int b= scan.nextInt();int c= scan.nextInt();int d = scan.nextInt();
			atom[j][0]=a;
			atom[j][1]=b;
			atom[j][2]=c;
			atom[j][3]=d;
			atom[j][0]+=1000;
			atom[j][1]+=1000;
			
			
		}
	}
	
	private static void print() 
	{
		for(int i=0;i<n;i++) 
		{
			System.out.println("[ x:"+atom[i][1]+" y:"+atom[i][0]+" d:"+atom[i][2]+" v:"+atom[i][3]+"]");
		}
	}
}



