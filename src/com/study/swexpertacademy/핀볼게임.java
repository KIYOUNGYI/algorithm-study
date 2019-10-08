package com.study.swexpertacademy;

import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo
public class 핀볼게임 {
	static int[][] changeDir= {
			{0,1,2,3},
			{1,3,0,2},//1
			{1,2,3,0},//2
			{2,0,3,1},//3
			{3,0,1,2},//4
			{1,0,3,2}//5
		};
	public static int ans=0;
	public static int t,n;
	public static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int sx,sy;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		for(int i=1;i<=t;i++) 
		{
			input(scan);
			solve();
			System.out.println("#"+i+" "+ans);
			ans=0;
		}
		
		scan.close();
	}
	
	
	private static void solve() {
		
		for(int i=1;i<=n;i++) 
		{
			for(int j=1;j<=n;j++) 
			{
				//방향
				for(int k=0;k<4;k++) 
				{
					if(map[i][j]==0) 
					{
						sx = i;sy=j;
//						System.out.println("sx:"+sx+" sy:"+sy+" dir:"+k);
						simulation(i,j,k);
					}
				}
			}
		}
		
	}


	private static void simulation(int x, int y, int dir) {
		int nx = x,ny=y;
		int cnt=0;
		int bx = nx;
		int by = ny;
		
		while(true) 
		{
			bx = nx;
			by = ny;
			nx = nx+dx[dir];
			ny = ny+dy[dir];
//			System.out.println("nx:"+nx+" ny:"+ny+" dir:"+dir);
			if(map[nx][ny]==-1 || (nx==sx && ny==sy)) 
			{
				if(cnt>ans)ans=cnt;
				return;
			}
			
			if(map[nx][ny]<=5 && map[nx][ny]>=1) 
			{
     				dir = changeDir[map[nx][ny]][dir];
			//	dir = changeDir(bx, by, nx, ny, dir);
				cnt+=1;
			}
			else if(map[nx][ny]>=6 && map[nx][ny]<=10) 
			{
				int[] nextXY = move(nx,ny);
				nx = nextXY[0];
				ny = nextXY[1];
			}
		}
		
	}
	
	private static int[] move(int nx, int ny) {
		int std = map[nx][ny];
		
		for(int i=1;i<=n;i++) 
		{
			for(int j=1;j<=n;j++) 
			{
                if(i==nx && j==ny)continue;
				if(map[i][j]==std) 
				{
					int[] temp = {i,j};
                    return temp;
				}
			}
		}
		
		return null;
	}
	
	private static int[] move2(int px, int py) {
		int v = map[px][py];
		int[] t = new int[2];
		for(int i=1;i<=n;i++) 
		{
			for(int j=1;j<=n;j++) 
			{
				if(px==i && py==j)continue;
				
				if(map[i][j]==v) 
				{
					t[0]=i;t[1]=j;
				}
			}
		}
		return t;
	}

	private static void input(Scanner scan) {
		n = scan.nextInt();
		map = new int[n+2][n+2];
		
		for(int i=1;i<=n;i++) 
			for(int j=1;j<=n;j++) 
			{
				map[i][j] = scan.nextInt();
			}
		
		for(int i=0;i<n+2;i++) {map[i][0]=5;map[0][i]=5;map[n+1][i]=5;map[i][n+1]=5;}
//		print();
	}
	
	private static void print() 
	{
		for(int i=0;i<n+2;i++) 
		{
			for(int j=0;j<n+2;j++) 
			{
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
