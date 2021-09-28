//package com.study.swexpertacademy;
//
//import java.util.ArrayList;
//import java.util.Scanner;
////https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
//public class 등산로조성 {
//	public static int[] dx = { 0, 1, 0, -1 };
//	public static int[] dy = { 1, 0, -1, 0 };
//	public static int T, N, K;
//	public static int[][] map;
//	public static ArrayList<Point> hPointList = new ArrayList();
//	public static int maxCnt = 0;
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		T = scan.nextInt();
//		for (int i = 1; i <= T; i++) {
//			// 입력 & 가장 높은 부분 찾기
//			input(scan);
//
//			//
//			mountainPath();
//			System.out.println("#" + i + " " + maxCnt);
//			maxCnt = 0;
//			hPointList.clear();
//		}
//
//		scan.close();
//	}
//
//	private static void mountainPath() {
//
////		System.out.println(hPointList.toString());
//
//		for (int i = 0; i < hPointList.size(); i++) {
//			int stdx = hPointList.get(i).x;
//			int stdy = hPointList.get(i).y;
//
//			for (int a = 0; a < N; a++) {
//				for (int b = 0; b < N; b++) {
//					if (stdx == a && stdy == b)
//						continue;
//					else {
//						// [1] 깍고 탐색하고 원복하고
//						for (int x = 1; x <= K; x++) {
//							map[a][b] = map[a][b] - x;
//
//							// stdx,stdy 에서 탐색하고
//							dfs(stdx, stdy, 1);
//
//							// 원복하고
//							map[a][b] = map[a][b] + x;
//
//						}
//					}
//				}
//			}
//
//		}
//	}
//
//	private static void dfs(int stdx, int stdy, int cnt) {
//
//		if (cnt >= maxCnt)
//			maxCnt = cnt;
//		// TODO Auto-generated method stub
//		int nx = stdx;
//		int ny = stdy;
//		int val = map[nx][ny];
//
//		for (int i = 0; i < 4; i++) {
//			nx = stdx + dx[i];
//			ny = stdy + dy[i];
////			System.out.println("nx:"+nx+" ny:"+ny);
//			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
//				if (map[nx][ny] < val) {
//					dfs(nx, ny, cnt + 1);
//				}
//			}
//		}
//	}
//
//	/**
//	 * 입
//	 * @param scan
//	 */
//	private static void input(Scanner scan) {
//		N = scan.nextInt();
//		K = scan.nextInt();
//		map = new int[N][N];
//		int tm = 0;
//		for (int j = 0; j < N; j++) {
//			for (int k = 0; k < N; k++) {
//				map[j][k] = scan.nextInt();
//				if (tm < map[j][k])
//					tm = map[j][k];
//			}
//		}
//
//		for (int j = 0; j < N; j++) {
//			for (int k = 0; k < N; k++) {
//				if (map[j][k] == tm) {
//					hPointList.add(new Point(j, k));
//				}
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
//
