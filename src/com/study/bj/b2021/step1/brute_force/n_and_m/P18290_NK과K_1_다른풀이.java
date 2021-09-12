package com.study.bj.b2021.step1.brute_force.n_and_m;
import java.io.*;
import java.util.StringTokenizer;

public class P18290_NK과K_1_다른풀이 {
  static int n,m,k;
  static int ans =-987654321;
  static int[][] arr = new int[11][11];
  static int[][] visit = new int[11][11];
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    bw.flush();
    for(int i=0;i<n;i++)
    {
      String []str= br.readLine().split(" ");
      for(int j=0;j<m;j++)
      {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }


    dfs(0,0,0);



    bw.write(Integer.toString(ans));
    bw.flush();
  }
  public static boolean check(int row,int col)
  {
    if(visit[row][col] == 1)
      return false;
    if(row -1>= 0  &&visit[row-1][col] == 1)
      return false;
    if(row + 1 < n && visit[row+1][col] == 1)
      return false;
    if(col -1 >=0 && visit[row][col-1] == 1)
      return false;
    if(col + 1 < m &&visit[row][col+1] == 1)
      return false;
    return true;
  }
  public static void dfs(int row, int col , int cnt)
  {
    if(cnt ==k)
    {
      int sum = 0;
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
        {
          if(visit[i][j]== 1)
            sum+= arr[i][j];
        }
      }
      ans = Math.max(sum,ans);
      return;
    }
    for(int i=row;i<n;i++)
    {
      for(int j=0;j<m;j++) {
        if(check(i,j)) {
          visit[i][j] = 1;
          dfs(i, j, cnt + 1);
          visit[i][j] = 0;
        }
      }
    }
  }

}
