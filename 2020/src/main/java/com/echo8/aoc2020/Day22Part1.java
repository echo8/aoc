package com.echo8.aoc2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day22Part1 {
    private static final String INPUT = "Player 1:\n" +
            "27\n" +
            "29\n" +
            "30\n" +
            "44\n" +
            "50\n" +
            "5\n" +
            "33\n" +
            "47\n" +
            "34\n" +
            "38\n" +
            "36\n" +
            "4\n" +
            "2\n" +
            "18\n" +
            "24\n" +
            "16\n" +
            "32\n" +
            "21\n" +
            "17\n" +
            "9\n" +
            "3\n" +
            "22\n" +
            "41\n" +
            "31\n" +
            "23\n" +
            "\n" +
            "Player 2:\n" +
            "25\n" +
            "1\n" +
            "15\n" +
            "46\n" +
            "6\n" +
            "13\n" +
            "20\n" +
            "12\n" +
            "10\n" +
            "14\n" +
            "19\n" +
            "37\n" +
            "40\n" +
            "26\n" +
            "43\n" +
            "11\n" +
            "48\n" +
            "45\n" +
            "49\n" +
            "28\n" +
            "35\n" +
            "7\n" +
            "42\n" +
            "39\n" +
            "8";

    private static final String INPUT2 = "Player 1:\n" +
            "9\n" +
            "2\n" +
            "6\n" +
            "3\n" +
            "1\n" +
            "\n" +
            "Player 2:\n" +
            "5\n" +
            "8\n" +
            "4\n" +
            "7\n" +
            "10";

    public static void main(String[] args) {
        String[] players = INPUT.split("\n\n");
        String[] p1Cards = players[0].split("\n");
        String[] p2Cards = players[1].split("\n");
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        for (int i = 1; i < p1Cards.length; i++) {
            player1.add(Integer.parseInt(p1Cards[i]));
            player2.add(Integer.parseInt(p2Cards[i]));
        }

        int cnt = 0;
        while (!player1.isEmpty() && !player2.isEmpty()) {
//            System.out.println("p1:" + player1);
//            System.out.println("p2:" + player2);
            Integer p1Card = player1.remove(0);
            Integer p2Card = player2.remove(0);

            if (p1Card > p2Card) {
                player1.add(p1Card);
                player1.add(p2Card);
            } else {
                player2.add(p2Card);
                player2.add(p1Card);
            }
            cnt++;
        }

        List<Integer> winner = player1.isEmpty() ? player2 : player1;
        Collections.reverse(winner);
        int res = 0;
        for (int i = 0; i < winner.size(); i++) {
            res += winner.get(i) * (i+1);
        }
        System.out.println(res);
    }
}
