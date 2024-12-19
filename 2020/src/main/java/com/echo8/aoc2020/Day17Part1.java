package com.echo8.aoc2020;

import java.util.*;

public class Day17Part1 {
    private static final String INPUT = "..#..#..\n" +
            ".###..#.\n" +
            "#..##.#.\n" +
            "#.#.#.#.\n" +
            ".#..###.\n" +
            ".....#..\n" +
            "#...####\n" +
            "##....#.";

    private static class Cube {
        int x;
        int y;
        int z;

        public Cube(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Cube(List<Integer> coords) {
            this.x = coords.get(0);
            this.y = coords.get(1);
            this.z = coords.get(2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cube cube = (Cube) o;
            return x == cube.x && y == cube.y && z == cube.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }

        @Override
        public String toString() {
            return "Cube{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<Cube, Boolean> curState = new HashMap<>();
        String[] lines = INPUT.split("\n");
        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                if (lines[y].charAt(x) == '.') {
                    curState.put(new Cube(x, y, 0), false);
                } else {
                    curState.put(new Cube(x, y, 0), true);
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            Map<Cube, Boolean> nextState = new HashMap<>();
            List<Cube> cubes = new ArrayList<>();
            cubes.addAll(curState.keySet());
            for (Cube cube : curState.keySet()) {
                List<Cube> neighbors = getNeighbors(cube);
                for (Cube n : neighbors) {
                    if (!curState.containsKey(n)) {
                        cubes.add(n);
                    }
                }
            }
            for (Cube cube : cubes) {
                List<Cube> neighbors = getNeighbors(cube);
                int activeNeighborCount = 0;
                for (Cube n : neighbors) {
                    if (curState.containsKey(n) && curState.get(n)) {
                        activeNeighborCount++;
                    }
                }
                if (curState.containsKey(cube) && curState.get(cube)) {
                    if (activeNeighborCount == 2 || activeNeighborCount == 3) {
                        nextState.put(cube, true);
                    } else {
                        nextState.put(cube, false);
                    }
                } else {
                    if (activeNeighborCount == 3) {
                        nextState.put(cube, true);
                    } else {
                        nextState.put(cube, false);
                    }
                }
            }
            curState = nextState;
//            System.out.println(curState.values().stream().mapToInt(b -> b ? 1 : 0).sum());
//            System.out.println(curState);
        }

        System.out.println(curState.values().stream().mapToInt(b -> b ? 1 : 0).sum());

//        List<List<Integer>> res = new ArrayList<>();
//        getNeighbor(new Integer[]{1,2,3}, new Integer[]{1,2,3}, 0, res);
//        System.out.println(res);
//        System.out.println(res.size());
    }

    /*
    // input: (1,2,3)
    //
    // output: (2,2,3) (2,2,2) (2,2,4) (2,3,3) (2,3,4) (2,3,2) (2,1,3) (2,1,4) (2,1,2)
    //         (0,2,3) (0,2,2) (0,2,4)  (0,3,3) (0,3,4) (0,3,2) (0,1,3) (0,1,4) (0,1,2)
    //         (1,3,3) (1,3,4) (1,3,2) (1,1,3) (1,1,4) (1,1,2)
    //         (1,2,4) (1,2,2)

    (2,3,4) ru (2,1,4) rd (0,3,4) lu (0,1,4) ld (1,3,4) u (1,1,4) d (1,2,4) s (0,2,4) l (2,2,4) r

    (2,3,2) (2,1,2) (0,3,2) (0,1,2) (1,3,2) (1,1,2) (1,2,2) (0,2,2) (2,2,2)

    (2,2,3) (2,3,3) (2,1,3) (0,2,3) (0,3,3) (0,1,3) (1,3,3) (1,1,3)

    //
    //    ***
    //    ***
    //    ***
    //    8 + 9 + 9
     */
    private static List<Cube> getNeighbors(Cube cube) {
        List<Cube> neighbors = new ArrayList<>();
        Integer[] coords = new Integer[]{cube.x, cube.y, cube.z};
        List<List<Integer>> res = new ArrayList<>();
        getNeighbor(coords, coords, 0, res);
        for (List<Integer> r : res) {
            neighbors.add(new Cube(r));
        }
        return neighbors;
    }

    private static void getNeighbor(Integer[] orig, Integer[] cur, int i, List<List<Integer>> res) {
        if (i == 3) {
            if (!Arrays.equals(orig, cur)) {
                res.add(Arrays.asList(cur));
            }
            return;
        }
        getNeighbor(orig, cur, i+1, res);
        Integer[] up = Arrays.copyOf(cur, cur.length);
        up[i]++;
        getNeighbor(orig, up, i+1, res);
        Integer[] down = Arrays.copyOf(cur, cur.length);
        down[i]--;
        getNeighbor(orig, down, i+1, res);
    }
}
