package com.echo8.aoc2020;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Day23Part2 {
    private static final String INPUT = "962713854";

    public static void main(String[] args) {
        List<Integer> cups = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < INPUT.length(); i++) {
            cups.add(Integer.parseInt(Character.toString(INPUT.charAt(i))));
            max = Math.max(max, cups.get(i));
        }
        for (int i = max+1; i <= 1000000; i++) {
            cups.add(i);
        }
        int curCupPos = 0;
        for (int move = 0; move < 10000000; move++) {
            if (move % 1000 == 0) {
                System.out.println(LocalDateTime.now().toString() + " " + move);
            }
            List<Integer> pickupCups = new ArrayList<>();
            int numBefore = 0;
            for (int i = 1; i <= 3; i++) {
                int pos = curCupPos+i;
                if (pos >= cups.size()) {
                    pos = pos - cups.size();
                    numBefore++;
                }
                pickupCups.add(cups.get(pos));
            }
            for (Integer p : pickupCups) {
                cups.remove(p);
            }
            curCupPos -= numBefore;
            int destPos = getDestPos(cups, curCupPos, pickupCups);
            if (destPos <= curCupPos) {
                curCupPos += 3;
            }
            for (int i = 2; i >= 0; i--) {
                cups.add(destPos, pickupCups.get(i));
            }
            curCupPos++;
            if (curCupPos >= cups.size()) {
                curCupPos = curCupPos - cups.size();
            }
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
        System.out.println(res);
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

    private static int getDestPos(List<Integer> cups, int curCupPos, List<Integer> pickupCups) {
        int lookingForValue = cups.get(curCupPos)-1;
        while (pickupCups.contains(lookingForValue)) {
            lookingForValue--;
        }
        int destPos = 0;
        if (cups.contains(lookingForValue)) {
            destPos = cups.indexOf(lookingForValue)+1;
        } else {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < cups.size(); i++) {
                if (cups.get(i) > maxValue) {
                    maxValue = cups.get(i);
                    destPos = i+1;
                }
            }
        }
        if (destPos >= cups.size()) {
            destPos = destPos - cups.size();
        }
        return destPos;
    }
}
