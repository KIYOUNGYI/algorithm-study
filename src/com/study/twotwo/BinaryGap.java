package com.study.twotwo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * result :
 * https://app.codility.com/demo/results/training8EBUCU-3RR/
 */
public class BinaryGap {

    /**
     * 1] 정수를 이진수로 변환하기 (순서 중요)
     * 2] binaryGap 중 maximum 찾기  (1<->1 / (1<---)(x)
     * 9 =>   1001 => 2
     * 529 => 1000010001 => 4
     * 20 =>  10100 => 1
     * 15 =>  1111 => 0
     * 32 =>  100000 => 0
     */
    public int solution(int num) {

        String binary = toBin(num);
        return findMaxBinaryGap(binary);
    }

    private int findMaxBinaryGap(String binary) {

        int cnt = 0;

        List<Integer> arrList = new ArrayList<>();

        for (int idx = 0; idx < binary.length(); idx++) {
            char c = binary.charAt(idx);

            if (c == '1') {

                if (cnt != 0) {
                    arrList.add(cnt);
                    cnt = 0;
                }

            } else {
                cnt += 1;
            }

        }

        //exception case
        if(arrList.isEmpty()){
            return 0;
        }

        return Collections.max(arrList);
    }

    private String toBin(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        return sb.reverse().toString();
    }
}
