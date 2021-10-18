package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_행렬_테두리_회전하기 {

  /**
   * 1] 1~n 까지 2차원 배열을 생성한다. (1,1)부터 시작하는 것 유의
   *
   * 2] 주어진 좌표 순회하면서 arrayList 에 움직여야 할 값 담기
   *
   * 3] 해당 arrayList -> 오른쪽 shift (shift 구현은 여러가지 있겠지만, 나같은 경우엔 모듈러 연산으로 처리함)
   *
   * 3-1] 그 와중에 min 값 찾기
   *
   * 4] shift 한 배열값을 원래 주워진 2차원 배열에 다시 채워넣음
   *
   * 5] 그다음 query 수행
   *
   * 메소드 추출이 필요해보이지만, 지금은 그러지 않겠음.
   */
  public static int[] solution(int rows, int columns, int[][] queries) {

    int[][] map = new int[rows + 1][columns + 1];
    int v = 1;
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= columns; j++) {
        map[i][j] = v++;
      }
    }
    int[] answer = new int[queries.length];

    for (int a = 0; a < queries.length; a++) {

      int[] query = queries[a];
      List<Integer> tempArrList = new ArrayList<>();
      int sx = query[0];
      int sy = query[1];
      int ex = query[2];
      int ey = query[3];

      for (int i = sy; i <= ey; i++) {
        int t1 = map[sx][i];
        tempArrList.add(t1);
      }

      for (int i = sx + 1; i <= ex; i++) {
        int t2 = map[i][ey];
        tempArrList.add(t2);
      }

      for (int i = ey - 1; i >= sy; i--) {
        int t3 = map[ex][i];
        tempArrList.add(t3);
      }

      for (int i = ex - 1; i >= sx + 1; i--) {
        int t4 = map[i][sy];
        tempArrList.add(t4);
      }

      int min = Integer.MAX_VALUE;
      int[] tempArr = new int[tempArrList.size()];
      for (int i = 0; i < tempArrList.size(); i++) {
        tempArr[(i + 1) % tempArrList.size()] = tempArrList.get(i);
        if (min > tempArr[(i + 1) % tempArrList.size()]) {
          min = tempArr[(i + 1) % tempArrList.size()];
        }
      }
      answer[a] = min;
//      System.out.println(Arrays.toString(tempArr));

      int idx = 0;

      for (int i = sy; i <= ey; i++) {
        map[sx][i] = tempArr[idx++];
      }

      for (int i = sx + 1; i <= ex; i++) {
        map[i][ey] = tempArr[idx++];
      }

      for (int i = ey - 1; i >= sy; i--) {
        map[ex][i] = tempArr[idx++];
      }

      for (int i = ex - 1; i >= sx + 1; i--) {
        map[i][sy] = tempArr[idx++];
      }
    }

    return answer;
  }


  public static void main(String[] args) {

//    int rows = 6;
//    int columns = 6;
//    int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

//    int rows = 3;
//    int columns = 3;
//    int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};

    int rows = 100;
    int columns = 97;
    int[][] queries = {{1, 1, 100, 97}};

    int[] solution = solution(rows, columns, queries);
    System.out.println(Arrays.toString(solution));
  }
}
