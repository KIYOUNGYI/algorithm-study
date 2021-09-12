package com.study.codility.lessons.primeandcompositenumber;

public class CountFactors {

  public static void main(String[] args) {
    //2_147_395_600
    System.out.println(solution100(Integer.MAX_VALUE));
  }

  //https://app.codility.com/demo/results/trainingXNPXQ6-9MP/
  public static int solution71(int N) {

    if (N == 1) {
      return 1;
    }

//    boolean[] isPrime = new boolean[N + 1];
//    Arrays.fill(isPrime, true);
//    isPrime[1] = false;
//    for (int j = 2; j <= N; j++) {
//      for (int k = j + j; k <= N; k = k + j) {
//        isPrime[k] = false;
//      }
//    }
//    if (isPrime[N]) {
//      return 2;
//    }

    int cnt = 0;
    for (int i = 1; i <= N / 2; i++) {
      if (N % i == 0) {
        cnt += 1;
      }
    }
    cnt = cnt + 1;
    return cnt;
  }


  //O(sqrt(N))
  //https://app.codility.com/demo/results/trainingETPZPH-EWK/
  public static int solution100(int N) {
    long i = 1;
    long result = 0;
    while (i * i <= N) {

      if (i*i==N) {
        result += 1;
        break;
      }
      if (N % i == 0) {
        result += 2;
      }
      i += 1;
    }

    return (int)result;
  }


}
