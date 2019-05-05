package algolabs.step2.array;

import java.util.Scanner;

/**
 * * 규칙(1) 같은 눈이 3개가 나오면 10,000원+(같은 눈)*1,000원의 상금을 받게 된다.
 * * 규칙(2) 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게 된다.
 * * 규칙(3) 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다.
 *
 * 첫째 줄에는 참여하는 사람 수 이 주어지고 그 다음 줄부터 N개의 줄에 사람들이 주사위를 던진 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.
 *
 * 출력: 첫째 줄에 가장 많은 상금을 받은 사람의 상금을 출력한다.
 *
 */
public class 주사위게임 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //[1] 참여인원수를 입력받는다.
        //[2] 참여인원수만큼 반복문을 돈다. (외부루프)
        //[3] 3개의 주사위 숫자를 입력받는다. 주사위(1~6)까지의 배열을 만들어서 숫자가 나오면, 카운트를 늘려준다. (내부루프)
        //[4] 점수를 계산한다.
        //[5] 점수 배열에 점수를 집어넣는다.

        int N = scan.nextInt();
        int[] scores = new int[N];

        for(int i=0;i<N;i++){

            int[] dice = new int[7];
            for(int j=0;j<3;j++)
            {
                int x = scan.nextInt();
                dice[x] = dice[x]+1;
            }
            int score = calculateScore(dice);
            scores[i]=score;


        }

//        for(int k=0;k<scores.length;k++){
//            System.out.println("score:"+scores[k]);
//        }

        int maxScore = maxScore(scores);
        System.out.println(maxScore);

        scan.close();
    }

    private static int maxScore(int[] scores) {
        int max=scores[0];
        for(int j=0,size=scores.length;j<size;j++){
            if(max<=scores[j]){
                max=scores[j];
            }
        }
        return max;
    }


    private static int calculateScore(int[] dice)
    {
        int score=0;
        for(int i=1;i<7;i++)
        {
            if(dice[i]==3)
            {
                score = 10000+i*1000;
                break;
            }
            else if(dice[i]==2)
            {
                score = 1000+i*100;
                break;
            }
            else
            {
                score =i*100;
            }
        }

        return score;
    }
}
