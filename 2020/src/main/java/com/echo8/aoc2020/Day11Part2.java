package com.echo8.aoc2020;

import java.util.ArrayList;
import java.util.List;

public class Day11Part2 {
    private static final String INPUT = "LLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLL.LL.L.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLL.L.LLLLLLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLL..LLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLL..L.LLLLLLLLLLLLLLL.LL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLL\n" +
            "LLLLLLLLLL.LL..LLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLL..LLLLLLLL\n" +
            "LL.L..L.L..L.LL..L.....LLLL..L.L.LL..L...LLLLLL...L.....L.....LL.L...LLLLL..L.LL..L..L.LL..\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL..LLLLLLL.LLLLLLL.LLLLL.L.LLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLLLLL\n" +
            "L.LLLLLLLLLL.LLL..LLLLLLLLL.LLLLL.LLLLL..LLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLL..LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLL..LLLLLLLLLLL.L.LL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLL.L.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLL.LLLLL\n" +
            ".......LL.L....L......L....L...L.LL..L..L...L.LL.L.LL..L..L.L.LLL.....L...LL..L..L..L.LL..L\n" +
            "LLL.LLLLLLLLLLLLLLL.LLLLLLL.LLLLL.LLLLL.L.LL.LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLL.LLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL..LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLL.LL.LLLL.LLL..LLLLLL.LLLLL.LLLLLLLLLL.LLLL.LLLLLLLLL.LLLL.LLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LL.LLLLL.LLLLLLLLLLLLL.LLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLL.LLLL.LLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL\n" +
            ".LL..LL.L.L....L...L.........L......LL.L..........L....L...L.L..L.L.L.LLL...LLL.L.....L.L..\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLL.L.LLL.LLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL..LLLLL.LLLLL.LLLLLLLL\n" +
            "LL.LLLLLLL.LL.LLLLL.LLLLLLL.LLLLLLLLLLLLLLLL..LLL.LLL.LLLLL.LLLLLLLL..LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLL.LL..LL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLL.L.LLLLLLLL.LL.LLLL.LLLL.LLLLLLLLL.LLL.LLLLL.L.LLLL.LLLLL.LLLLLLLL\n" +
            "LL.LLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LL.LLLLLLL.LLLL..LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL\n" +
            "......L.L......L.L.LLL.L.......L.LL..L..........LLL.LL..L.L............LL.LL.L.LL.......L..\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLL.L.LLL.LLLLL.LLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL..LLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLL.L.LLL.LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLL.LLLL.LLLL.LLLLLLLLLLL.LLLLL.LLLLL.LLLL..LL..LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LL\n" +
            "LL.LLLLLLLLLLLLLLLL.LLL.LLL.LLLLL.L.LLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.L.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL..LLLLLLLLL..L.LLLLLLLL\n" +
            "........LL.........L........L.L.LL..L.......L....L.....L.......L...L.L..L..........L......L\n" +
            "LL.LLLLLLL.LLLLLLLL.LLLLLL.LLL.LLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLL.LLLLLLLLLLL.LLLLL.LLLL.LLLL.LLLLLLLLLLLLLLL.LLL.LLLLLL.LLLLL.LLLLLL.L\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL..LLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLL.LL.L.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLL.LLL.L.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "...L....L.LL..L.......L..L...L.LL..LL.L....LL......L...L..L.....LL.LL....L.L..L.....L..L.L.\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLL.LL.LLLLL.LLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLL..LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLL.LLL.LLLLLLLLL.LLL.LL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLL.LLLLLLLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLL.LLLL\n" +
            "L.L..LL..L..LL....L...LL...L.LL...L.L.......LL.......L.LLL....L.....L..L.L..L...L.L.L.L....\n" +
            "LLLLLLLLLL.LLLLLLLLLL.LLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LL.LLLLLLLLL.LLLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLL.LLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLL.L.LLLLL.LL\n" +
            "LLLLLLLLLLLLLL.LLLL..LLLLLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLL..LLLLLLLL.LLLLLL.LLL.L.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLL.LL.L.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLL.LL.LLLLLLLLLLLLL.LLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "...LLL.LL.LL.LLL......L.L.L..L..L....L........L........L...LL....L.LLL....LLL..L.......LLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLLLL.LL.LLLLLLLLL.L.LLL.LLL.LLL.LLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLL.LLLL.LLL.LLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLLLLL.L.LLLLLLLL..LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLL.L\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLLLLLLL.LLLL.LLLLLLLLL..LLLLLLL..LLLLLL.LLLLL.LLLLLL.L\n" +
            "LLLLLLLLLL.LLLLLLLLLL.LLLLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.\n" +
            "LLLLLLLLLL.LL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLL.LLL.LLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "LL.LL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLL.L..LL.LLL.LLLLLLLLLLLLLL\n" +
            "L.L........L...LL.L..L....LLLL...LL.L......L.L....L...L.L..LL......LL......L....L..L.LL..L.\n" +
            "LLLLLLLLLLLLLLLLLLL..L.LLLL.L.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL..LLLLLL.L.L..LLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLL.L.LLLL.LLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLLL.LL.L.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLL.L\n" +
            "LLLLLLLLL..LLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.L.LLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLL.LL.LLLLL.LLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLL..L.LLLLLLL.LLLLL.LLL.L.LLLL..LLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL\n" +
            "...LL......L..LL.....L.LLLLLL..LL.LLL...L.L...LLL.LL........L......LLL..L.L.L.L..L..LLL.L..\n" +
            "LL.LLL.LLL.LLLLLLLL.L.LLLLL.LLLLL.L.LLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLL.L.LL.LLLL..LLLLL.LL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLL.LLLLL..LLLLLLLL.LLLLL.L.LLLLL.LLLLL.LLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LL.LLLL.\n" +
            "LLLLLLLLLLLLLLLLLLL.LLL.LLL.LLLL.LLLLLL.LL.L.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            ".......LLL....LLL.LL.L.L.L....LLL..L..L...L.LL.LLLL...LL............LL..LL....L..L...L.LLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLL.LLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLL.LLLLLL..L.LLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLL.LLLL.LLLLLLLL.LLLLLLL..LLLL.LLLLLLLLLL.LLLL.LLLLLLLLL.LLL.LLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLL..LLLL.LLL\n" +
            "LLLLLLLLLL.LLLLLLL..LLLLLLL.LLLLL..LLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLL..LLLLL.LLLL.LLLL.LLLLLLLLL.L.LLLLLLL.LLLLLLLLLLLL.L.LLLLLL\n" +
            "LLLLLLLLLL.LLLLL.L..LLLLLLL.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            ".....L...L..L.L..L.LLLLLLLLL....L.LL...LL...L.LL..L..L.L..L.L.....L...L.LL...L.L.......L..L\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLL.L.LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLL.LLLLL.LLLL.LL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLL.LLL.LLLLL.LLL.L.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLL.L.LLLLLLLL.LLLLLLL.L.LLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLL.LLLL.LLLLLLL.LL.LL.LLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLL.\n" +
            "LLLLLLLLLL.LLLLLLL..LLLLLLL.LLLLL.LLLLL.LLLLLLLLL.LLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLL..LLLL.LLLLLLL.L.LLLLLLLLL..LLLLLLLLLLLLLLLLLLL.\n";

    public static void main(String[] args) {
        List<List<Character>> layout = new ArrayList<>();
        for (String row : INPUT.split("\n")) {
            List<Character> r = new ArrayList<>();
            for (int i = 0; i < row.length(); i++) {
                r.add(row.charAt(i));
            }
            layout.add(r);
        }
        while (true) {
            List<List<Character>> nextLayout = new ArrayList<>();
            for (int i = 0; i < layout.size(); i++) {
                List<Character> nextRow = new ArrayList<>();
                for (int j = 0; j < layout.get(i).size(); j++) {
                    Character next = '.';
                    if (layout.get(i).get(j) == 'L') {
                        int occ = 0;
                        if (check(layout, i, j, -1, -1)) {
                            occ++;
                        }
                        if (check(layout, i, j, -1, 0)) {
                            occ++;
                        }
                        if (check(layout, i, j, -1, 1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 0, -1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 0, 1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 1, -1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 1, 0)) {
                            occ++;
                        }
                        if (check(layout, i, j, 1, 1)) {
                            occ++;
                        }
                        if (occ == 0) {
                            next = '#';
                        } else {
                            next = 'L';
                        }
                    } else if (layout.get(i).get(j) == '#') {
                        int occ = 0;
                        if (check(layout, i, j, -1, -1)) {
                            occ++;
                        }
                        if (check(layout, i, j, -1, 0)) {
                            occ++;
                        }
                        if (check(layout, i, j, -1, 1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 0, -1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 0, 1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 1, -1)) {
                            occ++;
                        }
                        if (check(layout, i, j, 1, 0)) {
                            occ++;
                        }
                        if (check(layout, i, j, 1, 1)) {
                            occ++;
                        }
                        if (occ >= 5) {
                            next = 'L';
                        } else {
                            next = '#';
                        }
                    }
                    nextRow.add(next);
                }
                nextLayout.add(nextRow);
            }
            if (layout.equals(nextLayout)) {
                break;
            } else {
                layout = nextLayout;
            }
        }
        int cnt = 0;
        for (List<Character> row : layout) {
            cnt += row.stream().filter(c -> c == '#').count();
        }
        System.out.println(cnt);
    }

    private static boolean check(List<List<Character>> map, int i, int j, int iv, int jv) {
        for (i += iv, j += jv; i >= 0 && i < map.size() && j >= 0 && j < map.get(i).size(); i += iv, j += jv) {
            if (map.get(i).get(j) == '#') {
                return true;
            } else if (map.get(i).get(j) == 'L') {
                return false;
            }
        }
        return false;
    }
}
