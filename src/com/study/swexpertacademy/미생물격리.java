package com.study.swexpertacademy;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl
public class 미생물격리 {

	public static int t, n, m, k;
	public static Node[][] map, nextMap;
	public static int[] dx = { 0, -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			input(scan);

			for (int j = 1; j <= m; j++) {
				cellSeperate();
			}

			int x = calculate();
			System.out.println("#" + i + " " + x);
		}

		scan.close();
	}

	private static int calculate() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += map[i][j].cnt;
			}
		}
		return sum;

	}

	private static void cellSeperate() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].cnt > 0) {
					int cdir = map[i][j].dir;
					int nx = 0, ny = 0;
					if (cdir == 1) {
						nx = i + dx[1];
						ny = j + dy[1];
					} else if (cdir == 2) {
						nx = i + dx[2];
						ny = j + dy[2];
					} else if (cdir == 3) {
						nx = i + dx[3];
						ny = j + dy[3];
					} else if (cdir == 4) {
						nx = i + dx[4];
						ny = j + dy[4];
					}

					if (checkTeduri(nx, ny)) {
//						System.out.println("nx:"+nx+" ny:"+ny);
						int val = map[i][j].cnt / 2;
						int dir = map[i][j].dir;

						dir = changeDirection(dir);
						nextMap[nx][ny].cnt = val;
						nextMap[nx][ny].maxCnt = val;
						nextMap[nx][ny].dir = dir;
					} else {
						if (nextMap[nx][ny].cnt > 0) {
							int dir = 0;
							int maxCnt = 0;
							int cnt = 0;
							cnt = map[i][j].cnt;
							if (nextMap[nx][ny].maxCnt < map[i][j].maxCnt) {
								dir = map[i][j].dir;
								maxCnt = map[i][j].maxCnt;
								nextMap[nx][ny].dir = dir;
								nextMap[nx][ny].maxCnt = maxCnt;
							}
							nextMap[nx][ny].cnt += cnt;
						} else {
							nextMap[nx][ny].cnt = map[i][j].cnt;
							nextMap[nx][ny].maxCnt = map[i][j].maxCnt;
							nextMap[nx][ny].dir = map[i][j].dir;
						}
					}
				}
			}
		}

		init();
	}

	private static int changeDirection(int dir) {
		if (dir == 1)
			dir = 2;
		else if (dir == 2)
			dir = 1;
		else if (dir == 3)
			dir = 4;
		else if (dir == 4)
			dir = 3;
		return dir;
	}

	private static void init() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j].set(0, 0, 0);
				map[i][j].set(nextMap[i][j]);
				nextMap[i][j].set(0, 0, 0);
			}
		}
	}

	private static boolean checkTeduri(int nx, int ny) {

		if (nx == 0 || ny == 0 || nx == n - 1 || ny == n - 1)
			return true;

		return false;
	}

	private static void input(Scanner scan) {
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		map = new Node[n][n];
		nextMap = new Node[n][n];
		for (int w = 0; w < n; w++) {
			for (int x = 0; x < n; x++) {
				map[w][x] = new Node();
				nextMap[w][x] = new Node();
			}
		}

		for (int j = 0; j < k; j++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			int d = scan.nextInt();
			map[a][b].cnt = c;
			map[a][b].maxCnt = c;
			map[a][b].dir = d;
		}

//		printArr();

	}

	private static void printArr() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].cnt > 0)
					System.out.println(i + " " + j + " " + map[i][j].toString());
			}
		}
	}
}

class Node {
	int cnt;
	int dir;
	int maxCnt;

	public void set(int _cnt, int _dir, int _maxCnt) {
		cnt = _cnt;
		dir = _dir;
		maxCnt = _maxCnt;
	}

	public void set(Node t) {
		cnt = t.cnt;
		dir = t.dir;
		maxCnt = t.cnt;
	}

	@Override
	public String toString() {
		return "Node [cnt=" + cnt + ", dir=" + dir + ", maxCnt=" + maxCnt + "]";
	}

}