package com.study.lms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class TREEHW {
	public static int n;
	public static int[] parent;
	public static int root;
	public static Tree[] trees;
	public static int height;
	public static ArrayList<Integer>[] result;
	public static int idx=0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		input(scan);
		findParent();
//		System.out.println(">>> root:"+root);
		findMaxHeight();
//		System.out.println(">>> height:"+height);
//		inorder(root);
		result = new ArrayList[height+1];
		for(int i=0;i<=height;i++) {result[i]=new ArrayList();}
		inorder(root,1);
		for(int i=0;i<=height;i++) {Collections.sort(result[i]);}
		
		int max=0;int maxIdx=0;
		for(int i=1;i<=height;i++) 
		{
//			System.out.println("i:" +i+" "+ result[i].toString());
			int s = result[i].get(0);
			int e = result[i].get(result[i].size()-1);
			int v = e-s;
		// 	System.out.println(i+" "+v);
			if(v>max) 
			{
				max=v;maxIdx=i;
			}
		}
		if(maxIdx==0)
		{
		  System.out.println((maxIdx+1)+" "+(max+1));
		}
		else
		{
		  System.out.println(maxIdx+" "+(max+1));
		}
		scan.close();
	}
	
	
	
	private static void findMaxHeight() {
		
		int cnt=1;
		
		int[] heights = new int[n+1];
		
		for(int i=1;i<=n;i++) 
		{
			int x = i;
			while(x!=root) 
			{
				x = parent[x];
//				System.out.println("->"+x);
				cnt+=1;
			}
			heights[i]=cnt;
			cnt=1;
		}
//		System.out.println(Arrays.toString(heights));
		
		int max = 0;
		for(int i=1;i<=heights.length-1;i++) 
		{
			if(max<heights[i])max=heights[i];
		}
		height =max;
	}



	private static void inorder(int x) {
		
		if(trees[x].value==-1) return;
		if(trees[x].left!=-1) 
			inorder(trees[x].left);
		System.out.print(trees[x].value+" ");
		if(trees[x].right!=-1) 
			inorder(trees[x].right);
	}
	
	
private static void inorder(int x,int depth) {
		
		if(trees[x].value==-1) return;
		if(trees[x].left!=-1) 
			inorder(trees[x].left,depth+1);
		
		idx+=1;
//		System.out.print("[X:"+depth+" Y:"+idx+" val:"+trees[x].value+"]");
		result[depth].add(idx);
		
		if(trees[x].right!=-1) 
			inorder(trees[x].right,depth+1);
		
	}
	


	private static void findParent() {
		for(int i=1;i<=n;i++) 
		{
			if(parent[i]==0) {root=i;break;}
		}
	}
	public static void input(Scanner scan) 
	{
		n = scan.nextInt();
		parent = new int[n+1];
		trees = new Tree[n+1];
		for(int i=0;i<=n;i++) {trees[i]=new Tree();}
		for(int i=1;i<=n;i++) 
		{
			int a = scan.nextInt();int b = scan.nextInt();int c = scan.nextInt();
			if(b!=-1) {parent[b]=a;}
			if(c!=-1) {parent[c]=a;}
			
			Tree t = new Tree();
			t.value = a;
			t.left = b;
			t.right = c;
			trees[t.value] = t;
		}
	}
}

class Tree
{
	int value;
	int left;
	int right;
}