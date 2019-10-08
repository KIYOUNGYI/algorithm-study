package com.study.swexpertacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
public class 보물상자비밀번호 {
	public static int t, n, k;
	public static String input;
	public static int loopCnt;
	public static int std;
	public static long ans;
	public static ArrayList<String> arrList = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			n = scan.nextInt();
			k = scan.nextInt();
			scan.nextLine();
			input = scan.next();
			std = input.length() / 4;
			input = input + input + input + input + input + input + input + input+input + input + input + input + input + input + input + input;
			loopCnt = decideLoopCnt(n);
			findCode();
			System.out.println("#" + i + " " + ans);
            arrList.clear();
			ans=0;
		}
	}

	private static void findCode() {

		for (int i = 0; i <= loopCnt; i++) {
			makeArr(i, n + i);
		}

		ArrayList<Long> numList = new ArrayList<Long>();
		for (int i = 0; i < arrList.size(); i++) {
			long x = changeNumToDecimal(arrList.get(i));
			numList.add(x);
		}
//		System.out.println(numList.toString());
		Collections.sort(numList);
		int temp = 0;
		for (int i = numList.size() - 1; i >= 0; i--) {
			temp += 1;
			if (temp == k) {
				ans = numList.get(i);
				return;
			}
		}

	}

	private static long changeNumToDecimal(String str) {
//		System.out.println(str);
		int len = str.length();
		int idx = 0;
		long v = 0;
		for (int i = len - 1; i >= 0; i--) {
			int num = what(str.charAt(i));
//			System.out.println(num);
			long x = pow(idx++);
//			System.out.println("x:"+x);
			v = v + num * x;
		}
		return v;
	}

	private static long pow(int idx) {
		long num = 1;
		for (int i = 1; i <= idx; i++) {
			num = num * 16;
		}
		return num;
	}

	private static int what(char ch) {
		if (ch >= 48 && ch <= 57)
			return (int) ch - 48;
		if (ch >= 65)
			return (int) ch - 55;

		return 0;
	}

	private static void makeArr(int s, int e) {

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = s; i < e; i++) {
			sb.append(input.charAt(i));
			cnt += 1;
			if (cnt == std) {
				if (!arrList.contains(sb.toString())) {
					arrList.add(sb.toString());
				}
				cnt = 0;
				sb = new StringBuilder();
			}
		}

	}

	private static int decideLoopCnt(int x) {
		if (x == 8)
			return 2;
		if (x == 12)
			return 3;
		if (x == 16)
			return 4;
		if (x == 20)
			return 5;
		if (x == 24)
			return 6;
		if (x == 28)
			return 7;
		return 0;
	}
}

