package com.study;

public class TestMain {

  public static void main(String[] args) {
    int cnt = 0;
    String dataset[] = {
        "Braund, Mr. Owen Harris",
        "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
        "Heikkinen, Miss. Laina",
        "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
        "Allen, Mr. William Henry",
        "Moran, Mr. James",
        "McCarthy, Mr. Timothy J",
        "Palsson, Master. Gosta Leonard",
        "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
        "Nasser, Mrs. Nicholas (Adele Achem)",
        "Sandstrom, Miss. Marguerite Rut",
        "Bonnell, Miss. Elizabeth",
        "Saundercock, Mr. William Henry",
        "Andersson, Mr. Anders Johan",
        "Vestrom, Miss. Hulda Amanda Adolfina",
        "Hewlett, Mrs. (Mary D Kingcome) ",
        "Rice, Master. Eugene",
        "Williams, Mr. Charles Eugene",
        "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
        "Masselmani, Mrs. Fatima",
        "Fynney, Mr. Joseph J",
        "Beesley, Mr. Lawrence",
        "McGowan, Miss. Anna",
        "Sloper, Mr. William Thompson",
        "Palsson, Miss. Torborg Danira",
        "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
        "Emir, Mr. Farred Chehab",
        "Fortune, Mr. Charles Alexander",
        "Dwyer, Miss. Ellen",
        "Todoroff, Mr. Lalio"
    };
//    for (String s : dataset) {
//      if(s.contains("M")){
//        System.out.println(s);
//        cnt+=1;
//      }
//      else{
//        System.out.println("wrong -> " + s);
//      }
//    }

    for (String s : dataset) {

      if (s.indexOf("M") > 0) {
        cnt += 1;
      } else {
        System.out.println("wrong ->" + s + " s.indexOf(\"M\"):" + s.indexOf("M"));
      }
    }
    System.out.println(cnt);




  }
}
