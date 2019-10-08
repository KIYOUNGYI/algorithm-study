package com.study.swexpertacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
public class 보호필름 {

	public static boolean flag = false;
	public static ArrayList<Integer> arrList = new ArrayList<Integer>();
	public static int t, d, w, k;
	public static int[][] map, backup;
	public static int limit;
	public static int[] color;
	public static int ans = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();

		for (int i = 1; i <= t; i++) {
			input(scan);
			protectFilm();
			System.out.println("#" + i + " " + ans);
			flag = false;
			ans = 0;
		}

		scan.close();
	}

	private static void protectFilm() {

		for (int i = 0; i <= d; i++) {
			limit = i;
			johab(0, 0);
			if (flag)
				return;
		}

	}

	private static void johab(int depth, int y) {

		if (flag)
			return;

		if (arrList.size() == limit) {
//			System.out.println(arrList.toString());

			color = new int[limit];
			// 어떻게 넣을건데
			tobin(0);

			if (flag) {
				return;
			}

			return;
		} else if (y >= d) {
			return;
		}

		arrList.add(y);
		johab(depth + 1, y + 1);
		int len = arrList.size() - 1;
		arrList.remove(len);
		johab(depth, y + 1);
	}

	private static void tobin(int depth) {

		if (depth == limit) {
//			System.out.println("color:"+Arrays.toString(color));
			/* 지도수정 */
			modifyMap();
			// 확인하기
			if (check()) {
				ans = depth;
				flag = true;
			}
			// 지도 복구
			recoverMap();
			return;
		}

		color[depth] = 1;
		tobin(depth + 1);
		color[depth] = 0;
		tobin(depth + 1);
	}

	private static boolean check() {

		for (int i = 0; i < w; i++) {
			int std = map[0][i];
			int cnt = 1;
			for (int j = 1; j < d; j++) {
				if (map[j][i] == std) {
					cnt += 1;
				} else {
					std = map[j][i];
					cnt = 1;
				}
				if (cnt == k)
					break;
			}
			if (cnt < k)
				return false;
		}

		return true;
	}

	private static void recoverMap() {
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = backup[i][j];
			}
		}

	}

	private static void modifyMap() {

		for (int i = 0; i < arrList.size(); i++) {
			int temp = arrList.get(i);// 열
			int col = color[i];// 색
			for (int j = 0; j < w; j++) {
				map[temp][j] = col;
			}
		}
	}

	private static void printmap() {
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void input(Scanner scan) {
		d = scan.nextInt();
		w = scan.nextInt();
		k = scan.nextInt();
		map = new int[d][w];
		backup = new int[d][w];
		for (int j = 0; j < d; j++) {
			for (int k = 0; k < w; k++) {
				map[j][k] = scan.nextInt();
				backup[j][k] = map[j][k];
			}
		}
	}
}

//1 2 0 0