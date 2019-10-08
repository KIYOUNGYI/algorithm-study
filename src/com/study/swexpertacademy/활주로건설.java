package com.study.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 활주로건설 {
	public static int t,n,x;
	public static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		for(int i=1;i<=t;i++) 
		{
			input(scan);
			int x = buildRoad();
			System.out.println("#"+i+" "+x);
		}
		
		
		scan.close();
	}
	private static int abs(int x) {if(x>0)return x;else return -x;}
	
	private static int buildRoad() {
		int cnt=0;
		for(int i=0;i<n;i++) 
		{
			int[] height = new int[n];
			for(int j=0;j<n;j++) {height[j] = map[i][j];}
			
			if(verify(height)) 
			{
				cnt+=1;
			}
		}
		
		for(int i=0;i<n;i++) 
		{
			int[] height = new int[n];
			for(int j=0;j<n;j++) {height[j] = map[j][i];}
			if(verify(height)) 
			{
				cnt+=1;
			}
		}
		return cnt;
	}
	private static boolean verify(int[] height) {
		
		int std = height[0];
		int stdCnt=0;
		for(int i=0;i<n;i++) 
		{
			if(std==height[i])stdCnt+=1;
		}
		if(stdCnt==n)return true;
		
		
		for(int i=0;i<n-1;i++) 
		{
			if(abs(height[i]-height[i+1])>=2) {return false;}
		}
		
		
		boolean[] up = new boolean[n];
		boolean[] down = new boolean[n];
		for(int i=0;i<n-1;i++) 
		{
			if(height[i]+1==height[i+1]) 
			{
				int s = i-x+1;
				int e = i;
				if(!isFlat(height,s,e)) {return false;}
				else 
				{
					for (int t = s; t <= e; t++) {
						up[t] = true;

					}
				}
			}
			if(height[i]==height[i+1]+1) 
			{
				int s = i+1;
				int e = i+x;
				if(!isFlat(height,s,e)) {return false;}
				else 
				{
					for(int k=s;k<=e;k++)down[k]=true;
				}
			}
		}

		if(check(up,down)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	
	private static boolean check(boolean[] up, boolean[] down) {
		
		for (int i = 0; i < n; i++) {
			if (up[i] == true && down[i] == true)
				return false;
		}
		
		return true;
	}
	private static boolean isFlat(int[] height,int s, int e) {
		
		if(s<0 || e>=n) 
		{
			return false;
		}
		
		int std=height[s];
		for(int i=s;i<=e;i++) 
		{
			if(std!=height[i])return false;
		}
		return true;
	}
	
	private static void input(Scanner scan) {
		n = scan.nextInt();x = scan.nextInt();
		map = new int[n][n];
		for(int j=0;j<n;j++) 
		{
			for(int k=0;k<n;k++) 
			{
				map[j][k] = scan.nextInt();
			}
		}
	}
}

