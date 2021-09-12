package com.study.bj;
import java.util.ArrayList;

public class recursiveCheatSheet
{
    public static ArrayList<Integer> arrList = new ArrayList();
    public static int n = 11;
    public static int cnt=0;
    public static void main(String[] args) {
        f(0,0);
        System.out.println("cnt:"+cnt);
    }

    private static void f(int depth, int y) {
        if(depth==n)
        {
            System.out.println(arrList.toString());
            cnt+=1;
            return;
        }
        else if(y==12){return;}
        arrList.add(y);
        f(depth+1,y+1);
        int len = arrList.size();
        arrList.remove(len-1);
        f(depth,y+1);
    }
}
