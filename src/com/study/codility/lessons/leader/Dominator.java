package com.study.codility.lessons.leader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dominator {


  public static void main(String[] args) {
    int[] a = {42};
    int[] b = {9, 3, 9, 3, 9, 7, 9};
    int[] c = {3, 4, 3, 2, 3, -1, 3, 3};
    int[] d = {0, 0, 1, 1, 1};
    int[] e = {0, 0, 0, 1, 1, 1};
    System.out.println(solution(d));
  }

  public static int solution(int[] arr) {

    Arrays.sort(arr);

    int maxVal=0;
    int max=0;
    int cnt=0;


    System.out.println(Arrays.toString(arr));
    int std = arr[0];

    for(int i=0;i<arr.length;i++){
      if(arr[i]==std){
        cnt+=1;
      }else{
        if(max<cnt){
          max = cnt;
          maxVal = std;
          System.out.println("i = " + i);
          System.out.println("max = " + max);
          System.out.println("maxVal = " + maxVal);
        }
        std = arr[i];
      }
    }

    return maxVal;
  }


  //https://app.codility.com/demo/results/trainingGER5P7-YR5/
  public static int solution55(int[] arr) {

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {

      if (map.get(arr[i]) == null) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(i);
        map.put(arr[i], arrList);
      } else {
        ArrayList<Integer> arrayList = map.get(arr[i]);
        arrayList.add(i);
        map.put(arr[i], arrayList);
      }
    }

    System.out.println(map.toString());
    int size = 0;
    int idx = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key).size() > size) {
        size = map.get(key).size();
        idx = key;
      }
    }

    ArrayList<Integer> arrayList = map.get(idx);

    return arrayList.get(0);
  }


}
