package com.study.annotation_study;

public class Derived_Class extends Java_Annotations{

//  @Override
  public void display() {
    System.out.println("Derived class");
  }

  public static void main(String args[]) {
    Derived_Class obj01 = new Derived_Class();
    obj01.display();
  }
}
