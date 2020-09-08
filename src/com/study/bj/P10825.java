package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 국어점수 감소 (큰거에서 작은거로)
 * 국어 같으면 영어 오름차순
 * 국어 영어 같으면 수학 내림차순
 * 모든 점수가 같으면 이름 오름차순
 * 학생수 N 1~100,000
 *
 */
public class P10825 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String x = bf.readLine();
            String[] arr = x.split(" ");
            String name = arr[0];
            int kor = Integer.parseInt(arr[1]);
            int eng = Integer.parseInt(arr[2]);
            int math = Integer.parseInt(arr[3]);
            Student std = new Student(name,kor,eng,math);
            studentList.add(std);
        }

        Collections.sort(studentList, new SortStudentByComparator());

//        for (int i = 0; i < studentList.size(); i++) {
//            System.out.println(studentList.get(i).name + "   " + studentList.get(i).kor + " " + studentList.get(i).eng+" "+studentList.get(i).math);
//        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).name);
        }
    }

    static class SortStudentByComparator implements Comparator<Student> {

        //1 ->오른쪽게 와야 한다.
        //0 ->같다
        //-1 ->왼쪽게 와야 한다.
        @Override
        public int compare(Student std1, Student std2) {
            if (std1.kor < std2.kor) {
                return 1;//1 -> 오
            } else if (std1.kor > std2.kor) {
                return -1;//올라가
            } else
            {
                //영어는 작은거에서 큰거로
                if (std1.eng < std2.eng) {
                    return -1;//왼쪽게 작으면 왼쪽게
                } else if (std1.eng > std2.eng) {
                    return 1;//오른쪽게 와야 한다.
                }
                else// eng 같은 경우
                {
                    if (std1.math < std2.math) {
                        return 1;//내림차순
                    } else if (std1.math > std2.math) {
                        return -1;//오름차순
                    } else//math 점수 같은 경우
                    {
//                        return 1;
                        char[] arr = std1.name.toCharArray();
                        char[] brr = std2.name.toCharArray();
                        int smallLen = 0;
                        if(arr.length<brr.length)smallLen=arr.length;
                        else smallLen = brr.length;
                        for(int i=0;i<smallLen;i++)
                        {
                            if(arr[i]<brr[i])return -1;
                            else if(arr[i]>brr[i])return 1;
                        }

                        if(arr.length<brr.length)return -1;
                        else if(arr.length>brr.length)return 1;
                        else return 0;
                    }

                }
            }

        }
    }

    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        protected Student() {
        }

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", kor=" + kor +
                    ", eng=" + eng +
                    ", math=" + math +
                    '}';
        }
    }
}
