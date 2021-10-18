package com.study.prority_queue;

import java.util.PriorityQueue;

public class Practice {

  public static void main(String[] args) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


    priorityQueue.add(1);
    priorityQueue.add(10);
    priorityQueue.add(2);
    priorityQueue.add(11);
    priorityQueue.add(3);

    Integer poll = priorityQueue.poll();
    System.out.println("poll = " + poll);

    Integer poll1 = priorityQueue.poll();
    System.out.println("poll1 = " + poll1);

    Integer poll2 = priorityQueue.poll();
    System.out.println("poll2 = " + poll2);

  }
}
