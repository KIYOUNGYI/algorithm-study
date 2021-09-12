package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P1152 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = br.readLine();
    ArrayList<String> vocab = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<temp.length();i++)
    {
      if((int)temp.charAt(i)==32)
      {
        vocab.add(sb.toString());
        sb.setLength(0);
      }
      else
      {
        sb.append(temp.charAt(i));
      }
    }
    for(int i=0;i<vocab.size();i++)
    {
      if(vocab.get(i).equals(""))
      {
        vocab.remove(i);
      }
    }
//    System.out.println("ArraysList:"+vocab.toString());
    System.out.println(vocab.size());
  }
}
