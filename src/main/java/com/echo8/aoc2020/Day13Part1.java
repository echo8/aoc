package com.echo8.aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13Part1 {
    private static final String INPUT = "1000303\n" +
            "41,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,x,541,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,983,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,19";

    public static void main(String[] args) {
        Long startTs = Long.parseLong(INPUT.split("\n")[0]);
        List<Long> buses = Arrays.stream(INPUT.split("\n")[1].split(","))
                .filter(b -> !b.equals("x"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        Long wait = Long.MAX_VALUE;
        Long res = 0L;
        for (Long bus : buses) {
            Long d = startTs / bus;
            Long w = (bus * (d+1)) - startTs;
            if (w < wait) {
                wait = w;
                res = bus * wait;
            }
        }
        System.out.println(res);
    }
}
