package com.echo8.aoc2020;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13Part2 {
    private static final String INPUT = "41,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,x,541,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,983,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,19";
    private static final String INPUT2 = "1789,37,47,1889";

    public static void main(String[] args) {
        List<Long> buses = Arrays.stream(INPUT2.split("\n")[0].split(","))
                .map(b -> "x".equals(b) ? 0L : Long.parseLong(b))
                .collect(Collectors.toList());
        BigInteger first = new BigInteger(buses.get(0).toString());
        BigInteger second = null;
        BigInteger secondPos = null;
        for (int i = 1; i < buses.size(); i++) {
            if (buses.get(i) == 0L) {
                continue;
            }
            second = new BigInteger(buses.get(i).toString());
            secondPos = new BigInteger(Integer.toString(i));
            break;
        }
        BigInteger third = null;
        BigInteger thirdPos = null;
        for (int i = secondPos.intValue()+1; i < buses.size(); i++) {
            if (buses.get(i) == 0L) {
                continue;
            }
            third = new BigInteger(buses.get(i).toString());
            thirdPos = new BigInteger(Integer.toString(i));
            break;
        }
        BigInteger fourth = null;
        BigInteger fourthPos = null;
        for (int i = thirdPos.intValue()+1; i < buses.size(); i++) {
            if (buses.get(i) == 0L) {
                continue;
            }
            fourth = new BigInteger(buses.get(i).toString());
            fourthPos = new BigInteger(Integer.toString(i));
            break;
        }
        BigInteger interval = second.multiply(third);
        BigInteger interval2 = second.multiply(third).multiply(fourth);
        BigInteger step = getFirstSolution(first, second, secondPos, buses).add(second);
        System.out.println("step1=" + step);
        step = getSecondSolution(step, first, second, third, thirdPos, buses).add(interval);
        System.out.println("step2=" + step);
//        step = getThirdSolution(step, first, second, third, fourth, fourthPos, buses).add(interval2);
//        System.out.println("step2=" + step);
        while (true) {
            BigInteger ts = step.multiply(first);
            System.out.println("ts=" + ts + ", step=" + step);
            if (valid(ts, step, thirdPos, buses)) {
                System.out.println(ts.toString());
                break;
            }
            step = step.add(interval);
        }
    }

    private static BigInteger getFirstSolution(BigInteger first, BigInteger second, BigInteger secondPos,
                                               List<Long> buses) {
        BigInteger step = new BigInteger("1");
        while (true) {
            BigInteger ts = step.multiply(first);
            BigInteger d = ts.divide(second);
            if (ts.add(secondPos).equals(d.add(new BigInteger("1")).multiply(second))) {
                return step;
            }
            step = step.add(new BigInteger("1"));
        }
    }

    private static BigInteger getSecondSolution(BigInteger step, BigInteger first, BigInteger second, BigInteger third,
                                                BigInteger thirdPos, List<Long> buses) {
        BigInteger interval = second;
        while (true) {
            BigInteger ts = step.multiply(first);
            BigInteger d = ts.divide(third);
            if (ts.add(thirdPos).equals(d.add(new BigInteger("1")).multiply(third))) {
                return step;
            }
            step = step.add(interval);
        }
    }

    private static BigInteger getThirdSolution(BigInteger step, BigInteger first, BigInteger second, BigInteger third,
                                                BigInteger fourth, BigInteger fourthPos, List<Long> buses) {
        BigInteger interval = second.multiply(third);
        while (true) {
            BigInteger ts = step.multiply(first);
            BigInteger d = ts.divide(fourth);
            if (ts.add(fourthPos).equals(d.add(new BigInteger("1")).multiply(fourth))) {
                return step;
            }
            step = step.add(interval);
        }
    }

    private static boolean valid(BigInteger ts, BigInteger step, BigInteger secondPos, List<Long> buses) {
        for (int i = secondPos.intValue()+1; i < buses.size(); i++) {
            if (buses.get(i) == 0L) {
                continue;
            }
            BigInteger b = new BigInteger(buses.get(i).toString());
            BigInteger d = ts.divide(b);
            if (!ts.add(new BigInteger(Integer.toString(i))).equals(d.add(new BigInteger("1")).multiply(b))) {
                return false;
            } else {
                System.out.println(String.format("ts=%s, step=%s, b=%s, d=%s, left=%s, right=%s", ts, step, b, d,
                        ts.add(new BigInteger(Integer.toString(i))), d.add(new BigInteger("1")).multiply(b)));
            }
        }
        return true;
    }

    /*
    1202161486 = 1789 * 671974
    1202161486 = 37 * 32490851 - 1
    1202161486 = 47 * 25577904 - 2
    1202161486 = 1889 * 636401 - 3

    20,017 / 37 = 541

    1,739 / 37 = 47

    3,284,971

     */
}
