package com.echo8.aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Part1 {
    private static final String INPUT = "73\n" +
            "114\n" +
            "100\n" +
            "122\n" +
            "10\n" +
            "141\n" +
            "89\n" +
            "70\n" +
            "134\n" +
            "2\n" +
            "116\n" +
            "30\n" +
            "123\n" +
            "81\n" +
            "104\n" +
            "42\n" +
            "142\n" +
            "26\n" +
            "15\n" +
            "92\n" +
            "56\n" +
            "60\n" +
            "3\n" +
            "151\n" +
            "11\n" +
            "129\n" +
            "167\n" +
            "76\n" +
            "18\n" +
            "78\n" +
            "32\n" +
            "110\n" +
            "8\n" +
            "119\n" +
            "164\n" +
            "143\n" +
            "87\n" +
            "4\n" +
            "9\n" +
            "107\n" +
            "130\n" +
            "19\n" +
            "52\n" +
            "84\n" +
            "55\n" +
            "69\n" +
            "71\n" +
            "83\n" +
            "165\n" +
            "72\n" +
            "156\n" +
            "41\n" +
            "40\n" +
            "1\n" +
            "61\n" +
            "158\n" +
            "27\n" +
            "31\n" +
            "155\n" +
            "25\n" +
            "93\n" +
            "166\n" +
            "59\n" +
            "108\n" +
            "98\n" +
            "149\n" +
            "124\n" +
            "65\n" +
            "77\n" +
            "88\n" +
            "46\n" +
            "14\n" +
            "64\n" +
            "39\n" +
            "140\n" +
            "95\n" +
            "113\n" +
            "54\n" +
            "66\n" +
            "137\n" +
            "101\n" +
            "22\n" +
            "82\n" +
            "21\n" +
            "131\n" +
            "109\n" +
            "45\n" +
            "150\n" +
            "94\n" +
            "36\n" +
            "20\n" +
            "33\n" +
            "49\n" +
            "146\n" +
            "157\n" +
            "99\n" +
            "7\n" +
            "53\n" +
            "161\n" +
            "115\n" +
            "127\n" +
            "152\n" +
            "128\n";

    private static final String INPUT2 = "16\n" +
            "10\n" +
            "15\n" +
            "5\n" +
            "1\n" +
            "11\n" +
            "7\n" +
            "19\n" +
            "6\n" +
            "12\n" +
            "4\n";

    public static void main(String[] args) {
        List<Long> nums = Arrays.stream(INPUT2.split("\n")).map(Long::parseLong)
                .sorted().collect(Collectors.toList());
        nums.add(0, 0L);
        nums.add(nums.get(nums.size()-1) + 3);
        int oneCnt = 0;
        int threeCnt = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            long diff = nums.get(i+1) - nums.get(i);
            if (diff == 1L) {
                oneCnt++;
            } else if (diff == 3L) {
                threeCnt++;
            }
        }
        System.out.println(nums);
        System.out.println(oneCnt + " " + threeCnt);
        System.out.println(oneCnt * threeCnt);
    }
}
