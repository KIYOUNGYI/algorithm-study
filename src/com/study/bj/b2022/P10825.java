package com.study.bj.b2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10825 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int n;
  static Student[] studentArr;

  public static void main(String[] args) throws IOException {

    String s = br.readLine();
    String[] s1 = s.split(" ");
    n = Integer.parseInt(s1[0]);
    studentArr = new Student[n];

    for (int i = 0; i < n; i++) {
      String s2 = br.readLine();
      String[] s3 = s2.split(" ");
      Student student = new Student(s3[0], Integer.parseInt(s3[1]), Integer.parseInt(s3[2]), Integer.parseInt(s3[3]));
      studentArr[i] = student;
    }

    Arrays.sort(studentArr);
    for (int i = 0; i < studentArr.length; i++) {
      bw.write(studentArr[i].name + "\n");
    }
    bw.flush();
    bw.close();
  }


  static class Student implements Comparable<Student> {

    String name;
    Integer kor;
    Integer eng;
    Integer math;

    public Student() {
    }

    public Student(String name, Integer kor, Integer eng, Integer math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
    }

    @Override
    public String toString() {
      return name + " " + kor + " " + eng;
    }

    // 음수 결과 : 타원소가 크다
    // 0 우리는 같아!
    // 양수 결과 : 내가 크다
    @Override
    public int compareTo(Student other) {

      //국어 내림차순
      if (this.kor != other.kor) {
        return other.kor - this.kor;//양수를 리턴하면 other 를 더 작다고 판단하고, 먼저 옴
      }
      //영어 오름차순 //양수를 리턴하면 this 가 더 작다고 판단하고 먼저 옴
      if (this.eng != other.eng) {
        return this.eng - other.eng;
      }
      //수학 내림차순
      if (this.math != other.math) {
        return other.math - this.math;//양수를 리턴하면 파라미터로 들어온 녀석을 더 작다고 판단하고 먼저 옴
      }

      return this.name.compareTo(other.name);

    }


  }

}
