package com.study.prority_queue;

import java.util.ArrayList;

/**
 * https://wonit.tistory.com/203 (arrayList)
 * 힙 직접 구현 연습1
 */
public class HeapPractice {

  public static void main(String[] args) {

  }


  static class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {

      this.heap = new ArrayList<>();
      heap.add(0);

    }

    private void insert(int data) {

      heap.add(data);

      int pos = heap.size() - 1;

      while (pos > 1 && heap.get(pos / 2) < heap.get(pos)) {

        swap(pos / 2, pos);

        pos = pos / 2;
      }

    }

    private int delete() {

      if (heap.size() == 0) {
        return 0;
      }

      int deleteData = heap.get(1);

      heap.set(1, heap.get(heap.size()-1));//말단 노드의 data 를 루트에 설정

      heap.remove(heap.size()-1);//말단 노드 삭제

      int pos = 1;

      while (pos*2 < heap.size()){

        //현 노드의 왼쪽 자식 노드 값
        //현 노드의 왼쪽 자식 노드 인덱스

        //오른쪽 자식 노드와 왼쪽 자식 노드 중 더 큰 노드에 값과 비교하고
        //교환하기 때문에 왼쪽 자식노드와 오른쪽 자식 노드의 값을 비교하는 과정을 거친다.

        //현 노드의 값보다 자식 노드의 값이 더 크면 종료

        //자식과 부모 swap
      }

      return deleteData;
    }


    private void swap(int parentPos, int childPos) {

      int temp = heap.get(parentPos);

      heap.set(parentPos, heap.get(childPos));

      heap.set(childPos, temp);
    }


  }
}
