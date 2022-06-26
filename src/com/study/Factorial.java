package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorial {
//  public int factorialFunc(ArrayList<Integer> dataList) {
//
//    if (dataList.size() <= 0) {
//      return 0;
//    }
//
//
//    return dataList.subList(factorialFunc(),factorialFunc());
//  }

  public static void main(String[] args) {

    ArrayList<Integer> arrList = new ArrayList<>();
    arrList.add(1);
    arrList.add(2);
    arrList.add(3);
    arrList.add(4);
    arrList.add(5);
    arrList.add(6);
    arrList.add(7);
    arrList.add(8);
    arrList.add(9);

    Factorial factorial = new Factorial();
    int i = factorial.factorialFunc(arrList);
    System.out.println("i = " + i);


  }

  public int factorialFunc(List<Integer> dataList) {

    if (dataList.size() <= 0) {
      return 0;
    }

    System.out.println("0 번째 = " + dataList.get(0));
    System.out.println("나머지 list = " + dataList.subList(1, dataList.size()).toString());
    System.out.println("---------------------------------------------------------------");
    return dataList.get(0) + factorialFunc(dataList.subList(1, dataList.size()));

  }
}