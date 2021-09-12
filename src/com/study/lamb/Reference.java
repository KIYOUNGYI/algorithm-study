package com.study.lamb;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reference {

  public static void main(String[] args) {
    Stream.of("method referenced").forEach(Reference::print);
    Stream.of("method referenced").forEach(Reference::print);
//    IntStream.of(4,5,6).forEach(int[]::new);
    Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream();
    stream = stream.filter(number -> number % 2 == 0);
    System.out.println(stream.collect(Collectors.toList()));
  }

  public static void print(String message) {
    System.out.println(message);
  }
}
