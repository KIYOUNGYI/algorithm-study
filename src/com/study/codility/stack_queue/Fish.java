package com.study.codility.stack_queue;

import java.util.Stack;

/**
 * [인터넷 참조해서 푼 문제] -> 기억이 희석되면 다시 풀어봐야지
 * <p>
 * https://yceffort.kr/2020/06/codility-07-02-fish
 *
 * <p>
 * https://app.codility.com/demo/results/trainingA7D49U-GSF/
 *
 *
 * <p>
 * [wrong answer] https://app.codility.com/demo/results/trainingVNEXGR-J22/
 */
public class Fish {

  public static int solution(int[] A, int[] B) {

    Stack<Integer> stack = new Stack<>();

    int upperCnt = 0;

    for (int i = 0; i < A.length; i++) {

      //하류행
      if (B[i] == 1) {
        stack.push(A[i]);

      }
      //상류행
      else {

        while (stack.size() > 0) {

          if (stack.peek() > A[i]) {
            break;
          } else {
            stack.pop();
          }

        }
        //상류행
        if (stack.size() == 0) {
          upperCnt += 1;
        }

      }
    }

    //stack 크기가 하류 통과한 물고기 개수다.
    return upperCnt + stack.size();
  }


  public static int solutionWrongAnswer(int[] A, int[] B) {

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

    System.out.println(solutionWrongAnswer(A, B));

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
