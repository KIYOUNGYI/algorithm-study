//package com.study.swexpertacademy;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
////https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
//public class 탈주범검거 {
//
//	public static int[] dx = { 0, 1, 0, -1 };
//	public static int[] dy = { 1, 0, -1, 0 };
//	public static boolean[][] visit;
//	public static int[][] map, score;
//	public static int testCase, sero, garo, startx, starty, time;
//	public static int cnt = 0;
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		testCase = scan.nextInt();
//
//		for (int i = 1; i <= testCase; i++) {
//			input(scan);
//			prisonBreak();
//			System.out.println("#" + i + " " + cnt);
//			cnt = 0;
//		}
//
//		scan.close();
//	}
//
//	private static void prisonBreak() {
//		Queue<Point> q = new LinkedList<Point>();
//		visit[startx][starty] = true;
//		score[startx][starty] = 1;
//		q.add(new Point(startx, starty));
//
//		while (!q.isEmpty()) {
//			Point pt = q.peek();
//			q.remove();
//			int cx = pt.x;
//			int cy = pt.y;
//			int pipe = map[cx][cy];
//			int curScore = score[cx][cy];
//			scenario(q, cx, cy, pipe, curScore);
//		}
//
//		count();
//	}
//
//	private static void scenario(Queue<Point> q, int cx, int cy, int pipe, int curScore) {
//		if (pipe == 1) {
//			up(q, cx, cy, curScore);
//			right(q, cx, cy, curScore);
//			down(q, cx, cy, curScore);
//			left(q, cx, cy, curScore);
//		} else if (pipe == 2) {
//			up(q, cx, cy, curScore);
//			down(q, cx, cy, curScore);
//		} else if (pipe == 3) {
//			left(q, cx, cy, curScore);
//			right(q, cx, cy, curScore);
//		} else if (pipe == 4) {
//			up(q, cx, cy, curScore);
//			right(q, cx, cy, curScore);
//		} else if (pipe == 5) {
//			right(q, cx, cy, curScore);
//			down(q, cx, cy, curScore);
//		} else if (pipe == 6) {
//			down(q, cx, cy, curScore);
//			left(q, cx, cy, curScore);
//		} else if (pipe == 7) {
//			up(q, cx, cy, curScore);
//			left(q, cx, cy, curScore);
//		}
//	}
//
//	private static void count() {
//
//		for (int i = 0; i < sero; i++) {
//			for (int j = 0; j < garo; j++) {
//				if (score[i][j] <= time && score[i][j] != 0)
//					cnt += 1;
//			}
//		}
//
//	}
//
//	public static void print() {
//		for (int i = 0; i < sero; i++) {
//			for (int j = 0; j < garo; j++) {
//				System.out.print(score[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//
//	private static void left(Queue<Point> q, int cx, int cy, int curScore) {
//		int nx;
//		int ny;
//		nx = cx;
//		ny = cy - 1;
//		if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
//			if (!visit[nx][ny]) {
//				if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
//					score[nx][ny] = curScore + 1;
//					visit[nx][ny] = true;
//					q.add(new Point(nx, ny));
//				}
//			}
//		}
//	}
//
//	private static void down(Queue<Point> q, int cx, int cy, int curScore) {
//		int nx;
//		int ny;
//		nx = cx + 1;
//		ny = cy;
//		if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
//			if (!visit[nx][ny]) {
//				if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
//					score[nx][ny] = curScore + 1;
//					visit[nx][ny] = true;
//					q.add(new Point(nx, ny));
//				}
//			}
//		}
//	}
//
//	private static void right(Queue<Point> q, int cx, int cy, int curScore) {
//		int nx;
//		int ny;
//		nx = cx;
//		ny = cy + 1;
//		if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
//			if (!visit[nx][ny]) {
//				if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
//					score[nx][ny] = curScore + 1;
//					visit[nx][ny] = true;
//					q.add(new Point(nx, ny));
//				}
//			}
//		}
//	}
//
//	private static void up(Queue<Point> q, int cx, int cy, int curScore) {
//		int nx;
//		int ny;
//		nx = cx - 1;
//		ny = cy;
//		if (nx >= 0 && ny >= 0 && nx < sero && ny < garo) {
//			if (!visit[nx][ny]) {
//				if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
//					score[nx][ny] = curScore + 1;
//					visit[nx][ny] = true;
//					q.add(new Point(nx, ny));
//				}
//			}
//		}
//	}
//
//	private static void input(Scanner scan) {
//		sero = scan.nextInt();
//		garo = scan.nextInt();
//		startx = scan.nextInt();
//		starty = scan.nextInt();
//		time = scan.nextInt();
//		map = new int[sero][garo];
//		score = new int[sero][garo];
//		visit = new boolean[sero][garo];
//		for (int j = 0; j < sero; j++) {
//			for (int k = 0; k < garo; k++) {
//				map[j][k] = scan.nextInt();
//			}
//		}
//	}
//}
//
//class Point {
//	int x;
//	int y;
//
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	@Override
//	public String toString() {
//		return "Point [x=" + x + ", y=" + y + "]";
//	}
//
//}
