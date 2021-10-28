package com.study.codility.stack_queue;

import java.util.Stack;

/**
 * https://app.codility.com/demo/results/trainingVNEXGR-J22/
 */
public class Fish {

  public static int solution(int[] A, int[] B) {

    Stack<Node> stack = new Stack<>();

    for (int i = 0; i < A.length; i++) {

      Node node = new Node(A[i], B[i]);

      if (stack.isEmpty()) {

        stack.push(node);

      } else {

        if (stack.peek().dir == 1 && node.dir == 0) {

          if (stack.peek().val < node.val) {

            stack.pop();
            stack.push(node);

          }

        } else {

          stack.push(node);
        }
      }

    }

    return stack.size();
  }

  public static void main(String[] args) {

    int[] A = {10, 11, 8, 7, 6, 7, 15};
    int[] B = {1, 0, 0, 0, 0, 1, 0};

    System.out.println(solution(A, B));

  }

  static class Node {

    int val;
    int dir;

    public Node(int val, int dir) {
      this.val = val;
      this.dir = dir;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          ", dir=" + dir +
          '}';
    }
  }

}
