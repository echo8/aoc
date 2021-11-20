package com.echo8.aoc2020;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day15Part1 {
    private static final String INPUT = "19,0,5,1,10,13";

    public static void main(String[] args) {
        Integer[] nums = Arrays.stream(INPUT.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList())
                .toArray(new Integer[INPUT.split(",").length]);
        Map<Integer, Integer> lastPos = new HashMap<>();
        Multiset<Integer> counts = HashMultiset.create();
        Integer lastNum = 0;
        Integer lastLastNum = 0;
        for (int i = 0; i < 30000000; i++) {
            if (i < nums.length) {
                counts.add(nums[i]);
                lastLastNum = lastNum;
                lastNum = nums[i];
            } else {
                if (counts.count(lastNum) == 1) {
                    counts.add(0);
                    lastLastNum = lastNum;
                    lastNum = 0;
                } else {
                    Integer newNum = i - lastPos.get(lastNum);
                    counts.add(newNum);
                    lastLastNum = lastNum;
                    lastNum = newNum;
                }
            }
            lastPos.put(lastLastNum, i);
        }
//        System.out.println(lastPos);
        System.out.println(lastNum);
    }
}
