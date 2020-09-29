package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 시간초과...
 * [문제] -> 부모를 누구로 하느냐가 골때리네
 * ===============================
 * 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.
 * [입력]
 * 트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2≤V≤100,000)둘째 줄부터
 * V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다.
 * (정점 번호는 1부터 V까지 매겨져 있다고 생각한다)
 * 먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다.
 * 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다.
 * 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.
 * [출력]
 * 첫째 줄에 트리의 지름을 출력한다.
 * 예제 입력 1
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 * 예제 출력 1
 * 11
 */
public class P1167
{
    static int answer=0;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer>[] adjacentList;
    static ArrayList<Integer>[] weight;
    static int[] distance;
    static int node;
    static int maxNode;
    static int maxDistance;
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(bf.readLine());
        adjacentList = new ArrayList[node+1];
        weight = new ArrayList[node+1];
        visit = new boolean[node+1];
        parent = new int[node+1];
        distance = new int[node+1];
        for(int i=0;i<=node;i++)
        {
            adjacentList[i] = new ArrayList<Integer>();
            weight[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<node;i++)
        {
            String[] x = bf.readLine().split(" ");
            int[] arr = new int[x.length-1];
            for(int j=0;j<arr.length;j++)
            {
                arr[j]=Integer.parseInt(x[j]);
            }
            int pivot = arr[0];
            for(int j=1;j<arr.length;j++)
            {
                if(j%2==1)
                {
                    adjacentList[pivot].add(arr[j]);
                }
                else
                {
                    weight[pivot].add(arr[j]);
                }
            }
        }

//        for(int i=1;i<=node;i++)
//        {
//            System.out.println(i+" 와 연결된 녀석들 : "+adjacentList[i].toString());
//        }
        problem();
    }

    private static void problem()
    {
        //여담으로 아무 점(v)에서 시작해서 가장 먼 점(v1)을 찾고, 그 점(v1)에서 가장 먼 점(v2)를 찾으면, v1과 v2 사이의 거리가 트리의 지름이됩니다.
        //1번에서 가장 먼 점 -> 그 점에서 또 가장 먼 점 -> 두 개의 거리 합
        //2번에서 가장 먼 점 -> 그 점에서 또 가장 먼 점 -> 두 개의 거리 합
        //3번에서 가장 먼 점 -> 그 점에서 또 가장 먼 점 -> 두 개의 거리 합
//        for(int i=1;i<=node;i++){}
//        int std=1;
//        visit[std]=true;
//        System.out.println("----------------------");
//        dfs(3);
//        dfsWeight(3);
//        System.out.println("3 에서 maxNode : " + maxNode+" maxDistance : "+maxDistance);

        for(int i=1;i<=node;i++)
        {
            dfsWeight(i);
//            System.out.println(i+" 에서 maxNode : " + maxNode+" maxDistance : "+maxDistance);
            int tempMaxNode = maxNode;int tempMaxDistance=maxDistance;

            maxNode=0;maxDistance=0;
            for(int j=0;j<=node;j++){visit[j]=false;distance[j]=0;}

            dfsWeight(tempMaxNode);
            int tempMaxDistance2 = maxDistance;

            if(tempMaxDistance2>answer)answer=tempMaxDistance2;

            maxNode=0;maxDistance=0;
            for(int j=0;j<=node;j++){visit[j]=false;distance[j]=0;}
        }

//        System.out.println("answer:"+answer);
        System.out.println(answer);
    }

    public static void dfsWeight(int pivot)
    {
        visit[pivot]=true;
//        System.out.println(pivot+" ");
        for(int i=0;i<adjacentList[pivot].size();i++)
        {
            int std = adjacentList[pivot].get(i);
            int dis = weight[pivot].get(i);
            if(!visit[std])
            {
//                System.out.println("std : "+std+" "+"dis : "+dis);
                distance[std]=distance[pivot]+dis;

                if(distance[std]>maxDistance)
                {
                    maxNode=std;
                    maxDistance=distance[std];
                }

                dfsWeight(std);
            }
        }
    }

    public static void dfs(int pivot)
    {
        visit[pivot]=true;
        System.out.print(pivot+" ");
        for(int i=0;i<adjacentList[pivot].size();i++)
        {
            int std = adjacentList[pivot].get(i);
            if(!visit[std])
            {
                dfs(std);
            }
        }
    }

}
