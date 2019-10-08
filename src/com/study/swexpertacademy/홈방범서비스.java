package com.study.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
public class 홈방범서비스 {
	public static int[] cost = new int[50];
	public static int t, n, m;
	public static int[][] map;
	public static int maxCnt = 0;

	public static void main(String[] args) {
		makeCost();
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			input(scan);
			securityService();
			System.out.println("#" + i + " " + maxCnt);
			maxCnt = 0;
		}

		scan.close();
	}

	private static void securityService() {
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int k = 1; k <= 2 * n + 5; k++) {

					int cnt = areaCnt(a, b, k);
					int price = m * cnt - cost[k];
//					if(price>=0)System.out.println("price:"+price+" a:"+a+" b:"+b+" range:"+k+" cnt:"+cnt);
					if (price >= 0) {
						if (maxCnt < cnt)
							maxCnt = cnt;
					}

				}
			}
		}
	}

	private static int areaCnt(int x, int y, int range) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (abs(x - i) + abs(y - j) < range) {
					if (map[i][j] == 1)
						cnt += 1;
				}
			}
		}
		return cnt;
	}

	private static void input(Scanner scan) {
		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n][n];
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				map[j][k] = scan.nextInt();
			}
		}
	}

	private static int abs(int x) {
		if (x > 0)
			return x;
		else
			return -x;
	}

	private static void makeCost() {
		cost[1] = 1;
		for (int i = 2; i < 50; i++) {
			cost[i] = i * i + (i - 1) * (i - 1);
		}
	}
}
