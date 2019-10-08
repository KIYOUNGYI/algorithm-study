package com.study.lms;

import java.util.Scanner;
//뒤집기 횟수 n
//1행 0이면 1만들고,1이면 0만들고 (0,0)      / 2행 2열 

public class 행렬뒤집기2 {
	public static int n;
	public static int[][] arr = new int[10][10];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		input(scan);
		int stage = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[stage][j] == 0)
					arr[stage][j] = 1;
				else {
					arr[stage][j] = 0;
				}
			}
			for (int j = 0; j < 10; j++) {
				if (arr[j][stage] == 0)
					arr[j][stage] = 1;
				else {
					arr[j][stage] = 0;
				}
			}
			if (arr[stage][stage] == 1)
				arr[stage][stage] = 0;
			else {
				arr[stage][stage] = 1;
			}
			stage += 1;
		}

		print();

		scan.close();
	}

	public static void input(Scanner scan) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
	}

	public static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}