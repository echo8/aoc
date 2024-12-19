package com.echo8.aoc2020;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day23Part2c {
    private static final String INPUT = "962713854";

    public static void main(String[] args) {
        List<Integer> cups = new ArrayList<>();
        Map<Integer, Integer> nextCupMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < INPUT.length(); i++) {
            cups.add(Integer.parseInt(Character.toString(INPUT.charAt(i))));
            if (i > 0) {
                nextCupMap.put(cups.get(i-1), cups.get(i));
            }
            max = Math.max(max, cups.get(i));
        }
        for (int i = max+1; i <= 1000000; i++) {
            cups.add(i);
            int lastPos = cups.size()-1;
            nextCupMap.put(cups.get(lastPos-1), cups.get(lastPos));
        }
        nextCupMap.put(cups.get(cups.size()-1), cups.get(0));
        int curCup = cups.get(0);
        for (int move = 0; move < 10000000; move++) {
            if (move % 1000 == 0) {
                System.out.println(LocalDateTime.now().toString() + " " + move);
            }
            List<Integer> pickupCups = new ArrayList<>();
            int pickupCup = nextCupMap.get(curCup);
            for (int i = 0; i < 3; i++) {
                nextCupMap.put(curCup, nextCupMap.get(pickupCup));
                pickupCups.add(pickupCup);
                pickupCup = nextCupMap.get(curCup);
            }

            int lookingForValue = curCup-1;
            while (pickupCups.contains(lookingForValue)) {
                lookingForValue--;
            }
            if (lookingForValue < 1) {
                lookingForValue = 1000000;
            }

            int lookingNext = nextCupMap.get(lookingForValue);
            int p = lookingForValue;
            for (Integer v : pickupCups) {
                nextCupMap.put(p, v);
                p = v;
            }
            nextCupMap.put(p, lookingNext);

            curCup = nextCupMap.get(curCup);
        }
        int oneIdx = cups.indexOf(1);
        long res = 1L;
        for (int i = 1; i <= 2; i++) {
            int pos = oneIdx+i;
            if (pos >= cups.size()) {
                pos = pos - cups.size();
            }
            res = res * (long)cups.get(pos);
        }
        int oneNext = nextCupMap.get(1);
        int oneNextNext = nextCupMap.get(oneNext);
        System.out.println((long)oneNext * (long)oneNextNext);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < cups.size(); i++) {
//            int pos = oneIdx+i;
//            if (pos >= cups.size()) {
//                pos = pos - cups.size();
//            }
//            sb.append(cups.get(pos));
//        }
//        System.out.println(sb.toString());
    }
}
