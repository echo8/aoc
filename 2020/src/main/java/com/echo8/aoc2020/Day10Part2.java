package com.echo8.aoc2020;

import java.util.*;
import java.util.stream.Collectors;

public class Day10Part2 {
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

    private static final String INPUT2 = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3\n";

    public static void main(String[] args) {
        List<Long> nums = Arrays.stream(INPUT.split("\n")).map(Long::parseLong)
                .sorted().collect(Collectors.toList());
        nums.add(0, 0L);
//        nums.add(nums.get(nums.size()-1) + 3);
        System.out.println(nums);
//        System.out.println(search(nums, nums, 0, 0));
        find(nums, 0, 1, new ArrayList<>());
        System.out.println(entrySet.get("0,1"));
        System.out.println(entrySet);
    }

    private static Map<String, Long> entrySet = new HashMap<>();
    private static void find(List<Long> ns, int start, int end, List<String> path) {
        String key = start + "," + end;
        if (end >= ns.size()) {
            if (start == ns.size()-1 && end == ns.size()) {
//                System.out.println(path);
                entrySet.put(key, 1L);
            } else {
                entrySet.put(key, 0L);
            }
            return;
        }
        if (ns.get(end) - ns.get(start) > 3) {
            entrySet.put(key, 0L);
        } else {
//            List<String> cp1 = new ArrayList<>(path);
//            cp1.add("(" + start + "," + end + ")");
//            List<String> cp2 = new ArrayList<>(path);
            String left = end + "," + (end+1);
            if (!entrySet.containsKey(left))
                find(ns, end, end + 1, path);
            String right = start + "," + (end+1);
            if (!entrySet.containsKey(right))
                find(ns, start, end + 1, path);
            entrySet.put(key, entrySet.get(left) + entrySet.get(right));
        }
    }
    /*
    0, 1, 2, 4, 5, 6, 7, 8
    0,    2, 4, 5, 6, 7, 8
    0,    2,    5,

     */

    /*
    find(0, 1)
    - find(1, 2)
      - find(2, 3)
        - find(3, 4)
      - find(1, 3)
    - find(0, 2)
     */

    private static long search(List<Long> orig, List<Long> nums, int i, int s) {
        if (i >= nums.size()) {
            boolean res = valid(orig, nums, s);
//            if (res)
//                System.out.println(nums);
            return res ? 1 : 0;
        }
        if (!valid(orig, nums, s)) {
            return 0;
        }
//        else {
//            System.out.println("ok: " + nums + " " + i);
//        }
        List<Long> cp = new ArrayList<>(nums);
        cp.remove(i);
        return search(orig, nums, i+1, i+1) + search(orig, cp, i, i-1);
    }

    private static boolean valid(List<Long> orig, List<Long> nums, int start) {
        if (!nums.isEmpty() && nums.get(0) != 0) {
            return false;
        }
        if (nums.size() >= 2 && (!nums.get(nums.size() - 1).equals(orig.get(orig.size() - 1)) ||
                !nums.get(nums.size() - 2).equals(orig.get(orig.size() - 2)))) {
            return false;
        }
        if (start < nums.size()-1) {
            long diff = nums.get(start + 1) - nums.get(start);
            if (diff > 3) {
                return false;
            }
        }
        return true;
    }
}
