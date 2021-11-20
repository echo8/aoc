package com.echo8.aoc2020;

public class Day25Part1 {
    private static final String INPUT = "1526110\n" +
            "20175123";

    private static final String INPUT2 = "5764801\n17807724";

    public static void main(String[] args) {
        String[] publicKeys = INPUT.split("\n");
        long cardPublicKey = Long.parseLong(publicKeys[0]);
        long doorPublicKey = Long.parseLong(publicKeys[1]);
        long subjectNum = 7;
        long val = 1;
        long loopNum = 0;
        while (true) {
            val = val * subjectNum;
            val = val % 20201227;
            loopNum++;
            if (val == cardPublicKey) {
                break;
            }
        }

        subjectNum = doorPublicKey;
        val = 1;
        for (int i = 0; i < loopNum; i++) {
            val = val * subjectNum;
            val = val % 20201227;
        }
        System.out.println(val);
    }
}
