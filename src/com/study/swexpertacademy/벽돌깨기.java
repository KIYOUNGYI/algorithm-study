package com.study.swexpertacademy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기 {
	static boolean flag = false;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int t, n, w, h;
	static int[] dropLocation;
	static int[][] map, backup;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			input();
			dfs(0);
			System.out.println("#" + i + " " + ans);
			ans = Integer.MAX_VALUE;
			flag = true;
		}

	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] != 0)
					cnt += 1;
			}
		}

		return cnt;
	}

	private static void calculate() {
		for (int i = 0; i < dropLocation.length; i++) {
			bfs(dropLocation[i]);

		}
		int x = count();
		if (x < ans) {
			ans = x;
		}
		if (x == 0) {
			flag = false;
		}
		recover();
	}

	private static void bfs(int idx) {
		Queue<Pt> q = new LinkedList<Pt>();
		int temp = -1;
		for (int i = 0; i < h; i++) {
			if (map[i][idx] != 0) {
				temp = i;
				break;
			}
		}
		if (temp == -1)
			return;

		q.add(new Pt(temp, idx));

		while (!q.isEmpty()) {
			Pt pt = q.peek();
			int range = map[pt.x][pt.y];
			map[pt.x][pt.y] = 0;
			q.remove();

			for (int j = 0; j < 4; j++) {
				int nx = pt.x;
				int ny = pt.y;
				for (int k = 0; k < range - 1; k++) {
					nx = nx + dx[j];
					ny = ny + dy[j];
//					if(dropLocation[0]==2 && dropLocation[1]==2 && dropLocation[2]==6) 
//					{
//						System.out.println("nx:"+nx+" ny:"+ny);
//					}
					if (nx >= 0 && ny >= 0 && nx < h && ny < w) {

						if (map[nx][ny] != 0) {

							q.add(new Pt(nx, ny));
						}
					}
				}
			}
		}

		for (int i = 0; i < w; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();

			for (int j = h - 1; j >= 0; j--) {
				if (map[j][i] != 0) {
					arr.add(map[j][i]);
				}
			}

			for (int j = h - 1; j >= 0; j--) {
				map[j][i] = 0;
			}
			int t = h - 1;
			for (int j = 0; j < arr.size(); j++) {
				map[t--][i] = arr.get(j);
			}
		}

	}

	private static void print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void dfs(int depth) {

		if (depth == n) {
			calculate();

			return;
		}
		for (int i = 0; i < w; i++) {
			dropLocation[depth] = i;
			dfs(depth + 1);
		}
	}

	private static void recover() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = backup[i][j];
			}
		}
	}

	private static void input() {

		n = scan.nextInt();
		w = scan.nextInt();
		h = scan.nextInt();
		map = new int[h][w];
		backup = new int[h][w];
		dropLocation = new int[n];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = scan.nextInt();
				backup[i][j] = map[i][j];
			}
		}
//		print();
	}

}

class Pt {
	int x;
	int y;

	public Pt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pt [x=" + x + ", y=" + y + "]";
	}

}
