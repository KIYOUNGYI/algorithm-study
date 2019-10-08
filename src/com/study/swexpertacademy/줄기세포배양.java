package com.study.swexpertacademy;

import java.util.Scanner;

public class 줄기세포배양 {
	static int ans;
	static int t, n, m, time;
	static Cell[][] map, next;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			input(scan);
			solve();
			count();
			System.out.println("#"+ i+" "+ans);
			ans = 0;
		}
	}
	
	private static void count() 
	{
		int cnt=0;
		for(int i=0;i<400;i++) 
		{
			for(int j=0;j<400;j++) 
			{
				if(map[i][j].status==1 || map[i][j].status==2) 
				{
					cnt+=1;
				}
			}
		}
		ans = cnt;
	}
	
	private static void solve() {
		
		for(int a=1;a<=time;a++) 
		{
			for(int i=200-time/2-2;i<=200+n+time/2+2;i++) 
			{
				for(int j=200-time/2-2;j<=200+m+time/2+2;j++) 
				{
					if(map[i][j].status!=0) 
					{
						if(map[i][j].status==3) 
						{
							next[i][j].status=3;
							next[i][j].total = map[i][j].total;
							next[i][j].current=0;
							continue;
						}
						else if(map[i][j].status==1) 
						{
							next[i][j].current = map[i][j].current+1;
							next[i][j].total = map[i][j].total;
							if(next[i][j].current==next[i][j].total) 
							{
								next[i][j].status=2;
							}
							else 
							{
								next[i][j].status=1;
							}
						}
						else if(map[i][j].status==2) 
						{
							//처음인 경우 확장
							if(map[i][j].total==map[i][j].current) 
							{
								int nx;
								int ny;
								for(int k=0;k<4;k++) 
								{
									nx = i+dx[k];
									ny = j+dy[k];
									
									if(map[nx][ny].status==0) 
									{
										if(next[nx][ny].status==0) 
										{
											next[nx][ny].status=1;
											next[nx][ny].total = map[i][j].total;
											next[nx][ny].current=0;
										}
										else if(next[nx][ny].status==1) 
										{
											if(next[nx][ny].total < map[i][j].total) 
											{
												next[nx][ny].total = map[i][j].total;
												next[nx][ny].current=0;
												next[nx][ny].status=1;
											}
										}
									}
								}
							}
							// 1개 감소 -> 체력 깍기
							next[i][j].current = map[i][j].current-1;
							if(next[i][j].current==0) 
							{
								next[i][j].status=3;
								next[i][j].total=map[i][j].total;
								next[i][j].current=0;
							}
							else 
							{
								next[i][j].status=2;
								next[i][j].total=map[i][j].total;
							}
						}
					}
				}
			}
			
			// next -> map
			for(int i=200-time/2-2;i<=200+n+time/2+2;i++) 
			{
				for(int j=200-time/2-2;j<=200+m+time/2+2;j++) 
				{
					map[i][j].init();
					map[i][j].set(next[i][j]);
					next[i][j].init();
				}
			}
			
		}
		
	}

	private static void input(Scanner scan) {
		init();
		n = scan.nextInt();
		m = scan.nextInt();
		time = scan.nextInt();
		
		
		for (int i = 200; i < 200 + n; i++) 
		{
			for (int j = 200; j < 200 + m; j++) 
			{
				int v = scan.nextInt();
				if (v != 0) 
				{
					map[i][j].total = v;
					map[i][j].status = 1;
				}
			}
		}

	}

	public static void init() {
		map = new Cell[400][400];
		next = new Cell[400][400];
		for (int i = 0; i < 400; i++) {
			for (int j = 0; j < 400; j++) {
				map[i][j] = new Cell();
				map[i][j].init();
				next[i][j] = new Cell();
				next[i][j].init();
			}
		}
	}
}

class Cell {
	int status;
	int total;
	int current;

	public void init() {
		status = 0;
		total = 0;
		current = 0;
	}

	public void set(Cell cell) {
		status = cell.status;
		total = cell.total;
		current = cell.current;
	}

	public void set(int _status, int _total, int _current) {
		status = _status;
		total = _total;
		current = _current;
	}

	@Override
	public String toString() {
		return "Cell [status=" + status + ", total=" + total + ", current=" + current + "]";
	}

}