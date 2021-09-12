//package com.study.lms;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class ROBOT
//{
//	public static int sero,garo;
//	public static int[][] map;
//	public static int[][][] score;
//	public static int startX,startY,startDirection;
//	public static int endX,endY,endDirection;
//	public static boolean[][][] v;
//	public static int[] dx = new int[] {0,1,0,-1};
//	public static int[] dy = new int[] {1,0,-1,0};
//	public static void main(String[] args)
//	{
//		Scanner scan = new Scanner(System.in);
//		input(scan);
//		bfs();
//	}
//
//	private static void bfs()
//	{
//		Queue<Point> q = new LinkedList<Point>();
//		q.add(new Point(startX,startY,startDirection));
//		v[startX][startY][startDirection] = true;
//		score[startX][startY][startDirection] = 0;
//
//		while(!q.isEmpty())
//		{
//			Point pt = q.peek();
//			int cx = pt.x;
//			int cy = pt.y;
//			int curDir = pt.direction;
//			int curScore = score[cx][cy][curDir];
//
//			q.remove();
//			int dir1=0,dir2=0;
//			if(curDir==1) {dir1=3;dir2=4;}// 동쪽일땐 남과 북
//			if(curDir==2) {dir1=3;dir2=4;}// 서쪽일땐 남과 북
//			if(curDir==3) {dir1=1;dir2=2;}// 남쪽일땐 동과 서
//			if(curDir==4) {dir1=1;dir2=2;}// 북쪽일땐 서와 동
//
//			if(v[cx][cy][dir1]==false)
//			{
//				v[cx][cy][dir1]=true;
//				score[cx][cy][dir1]=curScore+1;
//				q.add(new Point(cx,cy,dir1));
////				System.out.println("cx:"+cx+" cy:"+cy+" dir1:"+dir1+" 는 "+score[cx][cy][dir1]);
//			}
//			if(v[cx][cy][dir2]==false)
//			{
//				v[cx][cy][dir2]=true;
//				score[cx][cy][dir2]=curScore+1;
//				q.add(new Point(cx,cy,dir2));
////				System.out.println("cx:"+cx+" cy:"+cy+" dir1:"+dir2+" 는 "+score[cx][cy][dir1]);
//			}
//
//			// 1,2,3 만큼 이동하는 부분
//			int nx = cx;
//			int ny = cy;
//			for(int i=1;i<=3;i++)
//			{
//				int j=0;
//				j = getIndex(curDir, j);
//
//				nx = nx+dx[j];
//				ny = ny+dy[j];
//
//				if(nx>=1 && ny>=1 && nx<=sero && ny<=garo)
//				{
//					if(!v[nx][ny][curDir])
//					{
//						if(map[nx][ny]==1)
//						{
//							break;
//						}
//						else
//						{
////							System.out.println("[nx,ny,curDir]: "+nx+" "+ny+" "+curDir);
//							v[nx][ny][curDir]=true;
//							score[nx][ny][curDir]=curScore+1;
//							q.add(new Point(nx,ny,curDir));
//						}
//					}
//				}
//			}
//			if(score[endX][endY][endDirection]!=0)break;
////			System.out.println("q->"+q.toString());
//		}
////		System.out.println(">>"+score[endX][endY][endDirection]);
//		System.out.println(score[endX][endY][endDirection]);
//	}
//
//	private static int getIndex(int curDir, int j) {
//		if(curDir==1) //동
//		{
//			j=0;//east
//		}
//		if(curDir==2) //서
//		{
//			j=2;
//		}
//		if(curDir==3) //남
//		{
//			j=1;
//		}
//		if(curDir==4) //북
//		{
//			j=3;
//		}
//		return j;
//	}
//
//	private static void input(Scanner scan) {
//		sero = scan.nextInt();garo = scan.nextInt();
//		map = new int[sero+1][garo+1];
//		v = new boolean[sero+1][garo+1][5];
//		score = new int[sero+1][garo+1][5];
//
//		for(int i=1;i<=sero;i++)
//		{
//			for(int j=1;j<=garo;j++)
//				map[i][j] = scan.nextInt();
//		}
//		startX = scan.nextInt();startY = scan.nextInt();startDirection = scan.nextInt();
//		endX = scan.nextInt();endY = scan.nextInt();endDirection = scan.nextInt();
//	}
//
//}
//class Point
//{
//	int x;
//	int y;
//	int direction;
//	public Point(int x,int y,int direction)
//	{
//		this.x = x;
//		this.y = y;
//		this.direction = direction;
//	}
//	@Override
//	public String toString()
//	{
//		return "[ x : "+x+" y:"+y+" dir:"+direction+" ]";
//	}
//}