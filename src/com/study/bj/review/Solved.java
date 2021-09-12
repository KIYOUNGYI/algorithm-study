package com.study.bj.review;

import java.util.ArrayList;
import java.util.Collections;

// 16:26 ~
public class Solved
{
    static ArrayList<String> problems = new ArrayList<>();

    public static void main(String[] args)
    {
        init();

        Collections.shuffle(problems);

        for(int i=0;i<5;i++)
        {
            System.out.println(problems.get(i));
        }
    }

    public static void init()
    {
        problems.add("P2438");
        problems.add("P2439");
        problems.add("P2440");
        problems.add("P2440");

        problems.add("P2441");
        problems.add("P2442");
        problems.add("P2444");
        problems.add("P2743");

        problems.add("P9012");
        problems.add("P10808");
        problems.add("P10809");
        problems.add("P10820");

        problems.add("P10828");
        problems.add("P10845");
        problems.add("P11655");
        problems.add("P11656");
        problems.add("P1107");
        problems.add("P1476");
        problems.add("P6603");
        problems.add("P9095");
        problems.add("P10819");

        problems.add("P1676");
        problems.add("P1978");
        problems.add("P2004");
        problems.add("P2609");
        problems.add("P6588");
        problems.add("P9613");
        problems.add("P10872");
        problems.add("P11653");

        problems.add("P1759");
        problems.add("P2292");
        problems.add("P2476");
        problems.add("P2566");
        problems.add("P10157");
        problems.add("P10974");
    }
}
