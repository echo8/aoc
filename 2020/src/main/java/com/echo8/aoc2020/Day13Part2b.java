package com.echo8.aoc2020;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day13Part2b {
//    private static final String INPUT = "67,7,x,59,61";
    private static final String INPUT = "41,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,x,541,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,983,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,19";

    private static BigInteger base = BigInteger.ZERO;
    private static int basePos = 0;
    private static BigInteger i = BigInteger.ONE;
    public static void main(String[] args) {
        Integer[] nums = Arrays.stream(INPUT.split(",")).map(n -> {
            if ("x".equals(n)) {
                return -1;
            } else {
                return Integer.parseInt(n);
            }
        }).collect(Collectors.toList()).toArray(new Integer[INPUT.split(",").length]);
        Map<Integer, BigInteger> mc = new HashMap<>();
        int last = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j == 0) {
                mc.put(0, new BigInteger(nums[j].toString()));
            } else if (nums[j] > -1) {
                mc.put(j, mc.get(last).multiply(new BigInteger(nums[j].toString())));
                last = j;
            }
        }
        BigInteger t = new BigInteger("0");
        while (true) {
            if (check(nums, 1, t)) {
                System.out.println(t);
                return;
            }
            t = mc.get(basePos).multiply(i).add(base);
            i = i.add(BigInteger.ONE);
        }
    }

    /*
    67*1

    (67*(7*1))+335 = 804 (t of second sol)
    (67*(7*2))+335 = 1273 (t of third sol)
    ...
    (67*(7*14))+335 = 6901

    (6901+2)/59 = 117

    sol: numsPos=2, t=6901, num=59, (t+numsPos)/num=117, t/first=103
    sol: numsPos=2, t=34572, num=59, (t+numsPos)/num=586, t/first=516
    sol: numsPos=2, t=62243, num=59, (t+numsPos)/num=1055, t/first=929

    (67*(59*(7*1)))+6901 = 34572
    (67*(59*(7*2)))+6901 = 62243
    ...
    (67*(59*(7*27)))+6901 = 754018

     */
    private static boolean check(Integer[] nums, int numsPos, BigInteger t) {
        while (numsPos < nums.length && nums[numsPos] < 0) {
            numsPos++;
        }
        if (nums.length == numsPos) {
            return true;
        }
        if (t.add(new BigInteger(Integer.toString(numsPos))).mod(new BigInteger(nums[numsPos].toString())).equals(BigInteger.ZERO)) {
            System.out.println(String.format("sol: numsPos=%s, t=%s, num=%s, (t+numsPos)/num=%s, t/first=%s",
                    numsPos, t.toString(), nums[numsPos].toString(),
                    t.add(new BigInteger(Integer.toString(numsPos))).divide(new BigInteger(nums[numsPos].toString())).toString(),
                    t.divide(new BigInteger(nums[0].toString())).toString()));
            if (numsPos > basePos) {
                base = t;
                i = BigInteger.ONE;
                basePos = numsPos;
            }
            return check(nums, numsPos+1, t);
        }
        return false;
    }
}
