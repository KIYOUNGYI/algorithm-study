package com.study.bj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
    /**
     * bfs 로 푸는데 약 30~40분 걸린거 같다.
     * dfs 로 푸는게 가능할까? 모든 케이스를 커버치지 못할 거 같은데...
     * 커버 가능하네... 각 점에서 모두 dfs 로 돌고 score 테이블을 기록하는 것이다.
     * 그런데 매번 visited 테이블을 초기화해주고 score 테이블도 초기화 시켜줘야 한다.
     * 이게 성능상
     */
    static int maxScore;
    static boolean[][] visited;
    static int n, m;
    static int[][] arr, score;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n + 1][m + 1];
        score = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        scan.nextLine();
        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            for (int j = 0; j < input.length(); j++) {
                int t = (int) input.charAt(j) - 48;
                arr[i][j + 1] = t;
            }
        }

        solution();


        System.out.println(score[n][m]);
        scan.close();
    }

    public static void solution()
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                dfs(i,j);
            }
        }
    }

    public static void dfs(int x,int y)
    {

    }

    public static void bfs() {
    }

    public static void init()
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                visited[i][j]=false;
                score[i][j]=0;
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
