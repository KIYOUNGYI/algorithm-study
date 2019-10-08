package com.study.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl
public class 점심식사시간 {

	public static int t, n;
	static PT[] man;
	static PT[] stair;
	static int[][] map;
	static int[] johab;
	static int MAXN = 11;
	static int MAXT = 11*2+11*11;
	static int M,S;
	static int answer;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		for(int i=1;i<=t;i++) 
		{
			M=S=0;
			n = scan.nextInt();
			map = new int[n+1][n+1];
			man = new PT[n*n];
			johab = new int[n+1];
			
			stair = new PT[2];
			
			for(int j=1;j<=n;j++) 
			{
				for(int k=1;k<=n;k++) 
				{
					map[j][k]=scan.nextInt();
					if(map[j][k]==1) 
					{
						man[M++]=new PT(j,k);
					}
					else if(map[j][k]>=2) 
					{
						stair[S++]=new PT(j,k);
					}
				}
			}
			
//			System.out.println("man:"+Arrays.toString(man));
//			System.out.println("stair:"+Arrays.toString(stair));
			answer=Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#"+i+" "+(answer+1));
			
		}
		
		scan.close();
	}
	private static void dfs(int depth) {
		
		if(depth==n+1) 
		{
//			System.out.println(Arrays.toString(johab));
			//계산하자 ~ 
			calculate();

			return;
		}
		
		for(int i=0;i<stair.length;i++) 
		{
			johab[depth]=i;
			dfs(depth+1);
		}
	}
	
	
	
	private static int dist(int man_index,int stair_index) 
	{
		int dx = abs(man[man_index].x-stair[stair_index].x);
		int dy = abs(man[man_index].y-stair[stair_index].y);
//		System.out.println("dx+dy: "+(dx+dy));
		return dx+dy;
	}
	
	private static void calculate() 
	{
		int total_min_time = 0;
//		System.out.println("M:"+M);
		for(int stair_index=0;stair_index<2;stair_index++) 
		{
			PT now_stair = stair[stair_index];
			
			//도착하는 시간 
			int[] arrival_time = new int[MAXN*2];
			//시간 t일 때 내려가는 사람 수
			int[] cur_stair = new int[MAXT];
			
			for(int i=0;i<MAXT;i++)cur_stair[i]=0;
			for(int i=0;i<MAXN*2;i++)arrival_time[i]=0;
			
			for(int man_idx=0;man_idx<M;man_idx++) 
			{	//man_idx가 어떤 비상구를 탈 지
				if(johab[man_idx]==stair_index) 
				{
//					System.out.println("stair "+stair_index+" man_idx:"+man[man_idx].toString()+" stair_dx:"+stair[stair_index].toString());
					arrival_time[dist(man_idx,stair_index)]+=1;
				}
			}
//			System.out.println("arrival:"+Arrays.toString(arrival_time));
			// stair_idx 번째 계단을 내려가는 사람이 모두 작업을 마치기 위해 필요한 최소 시간
			int now_min_time = 0;
			
			for(int time=1;time<=20;time++) 
			{
				while(arrival_time[time]>0) 
				{
					arrival_time[time]--;
					//해당 계단을 내려가는 시간 
					int remain_time = map[now_stair.x][now_stair.y];
					
					for(int walk_time = time;walk_time<MAXT;walk_time++) 
					{
						if(cur_stair[walk_time]<3) 
						{
							cur_stair[walk_time]++;
							remain_time--;
							
							if(remain_time==0) 
							{
								now_min_time = max(now_min_time,walk_time+1);
								break;
							}
						}
					}
					
				}
				total_min_time = max(total_min_time,now_min_time);
			}
//			System.out.println("total_min_time:"+total_min_time);
		}
		answer = min(answer,total_min_time);
	}
	
	private static int min(int x,int y) 
	{
		if(x<=y)return x;
		else return y;
	}
	
	private static int max(int x, int y) {
		if(x>=y)return x;
		else return y;
	}
	private static int abs(int x) 
	{
		if(x>=0)return x;
		else return -x;
	}
}

class PT {
	int x;
	int y;

	public PT(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "PT [x=" + x + ", y=" + y + "]";
	}

}