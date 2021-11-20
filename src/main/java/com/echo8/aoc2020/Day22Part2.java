package com.echo8.aoc2020;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Day22Part2 {
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

    private static final String INPUT3 = "Player 1:\n" +
            "43\n" +
            "19\n" +
            "\n" +
            "Player 2:\n" +
            "2\n" +
            "29\n" +
            "14";

    public static void main(String[] args) {
        String[] players = INPUT.split("\n\n");
        String[] p1Cards = players[0].split("\n");
        String[] p2Cards = players[1].split("\n");
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        for (int i = 1; i < p1Cards.length; i++) {
            player1.add(Integer.parseInt(p1Cards[i]));
        }
        for (int i = 1; i < p2Cards.length; i++) {
            player2.add(Integer.parseInt(p2Cards[i]));
        }

        boolean playerOneWon = play(new Game(player1, player2), new HashSet<>(), new HashMap<>());

        List<Integer> winner = !playerOneWon ? player2 : player1;
        Collections.reverse(winner);
        int res = 0;
        for (int i = 0; i < winner.size(); i++) {
            res += winner.get(i) * (i+1);
        }
        System.out.println(res);
    }

    // 22,242,000
    private static boolean play(Game game, Set<Game> pastGames, Map<Game, Boolean> results) {
        while (!game.player1.isEmpty() && !game.player2.isEmpty()) {
//            if (results.containsKey(game)) {
////                System.out.println("Got result: " + results.get(game) + " for " + game);
//                return results.get(game);
//            }
            if (pastGames.contains(game)) {
//                System.out.println("Seen before: " + game);
//                for (Game g : pastGames) {
//                    results.put(g, true);
//                }
                return true;
            }
            pastGames.add(new Game(new ArrayList<>(game.player1), new ArrayList<>(game.player2)));
//            if (pastGames.size() % 1000 == 0) {
//                System.out.println(pastGames.size());
//            }

            Integer p1Card = game.player1.remove(0);
            Integer p2Card = game.player2.remove(0);

            if (game.player1.size() >= p1Card && game.player2.size() >= p2Card) {
                boolean playerOneWon = play(new Game(new ArrayList<>(game.player1.subList(0, p1Card)), new ArrayList<>(game.player2.subList(0, p2Card))),
                        new HashSet<>(), results);
                if (playerOneWon) {
                    game.player1.add(p1Card);
                    game.player1.add(p2Card);
                } else {
                    game.player2.add(p2Card);
                    game.player2.add(p1Card);
                }
            } else {
                if (p1Card > p2Card) {
                    game.player1.add(p1Card);
                    game.player1.add(p2Card);
                } else {
                    game.player2.add(p2Card);
                    game.player2.add(p1Card);
                }
            }
        }
        boolean res = !game.player1.isEmpty();
//        for (Game g : pastGames) {
//            results.put(g, res);
//        }
//        if (!res) {
//            System.out.println("Game over, result=" + res);
//        }
        return res;
    }

    // 25,165,000
    private static boolean playv2(Gamev2 game, Map<SeenGame, Gamev2> pastGames, Set<Gamev2> pastGames2) {
        while (game.player1.length != 0 && game.player2.length != 0) {
            if (pastGames.containsKey(new SeenGame(game)) && pastGames2.contains(game)) {
                System.out.println("Seen before: " + game);
                return true;
            } else if (pastGames.containsKey(new SeenGame(game)) && !pastGames2.contains(game)) {
                System.out.println("Disagree, cur game: " + game + " seen game: " + pastGames.get(new SeenGame(game)));
                return true;
            }
            Gamev2 thisGame = new Gamev2(Arrays.copyOf(game.player1, game.player1.length),
                    Arrays.copyOf(game.player2, game.player2.length));
            pastGames.put(new SeenGame(thisGame), thisGame);
            pastGames2.add(thisGame);
            if (pastGames.size() % 1000 == 0) {
                System.out.println(pastGames.size());
            }

            int p1Card = game.player1[0];
            int p2Card = game.player2[0];
            game.player1 = ArrayUtils.remove(game.player1, 0);
            game.player2 = ArrayUtils.remove(game.player2, 0);

            if (game.player1.length >= p1Card && game.player2.length >= p2Card) {
                boolean playerOneWon = playv2(new Gamev2(Arrays.copyOf(game.player1, game.player1.length),
                        Arrays.copyOf(game.player2, game.player2.length)),
                        pastGames, pastGames2);
                if (playerOneWon) {
                    game.player1 = ArrayUtils.add(game.player1, p1Card);
                    game.player1 = ArrayUtils.add(game.player1, p2Card);
                } else {
                    game.player2 = ArrayUtils.add(game.player2, p2Card);
                    game.player2 = ArrayUtils.add(game.player2, p1Card);
                }
            } else {
                if (p1Card > p2Card) {
                    game.player1 = ArrayUtils.add(game.player1, p1Card);
                    game.player1 = ArrayUtils.add(game.player1, p2Card);
                } else {
                    game.player2 = ArrayUtils.add(game.player2, p2Card);
                    game.player2 = ArrayUtils.add(game.player2, p1Card);
                }
            }
        }
        return game.player1.length != 0;
    }

    private static class Game {
        List<Integer> player1;
        List<Integer> player2;

        public Game(List<Integer> player1, List<Integer> player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Game game = (Game) o;
            return player1.equals(game.player1) && player2.equals(game.player2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(player1, player2);
        }

        @Override
        public String toString() {
            return "Game{" +
                    "player1=" + player1 +
                    ", player2=" + player2 +
                    '}';
        }
    }

    private static class Gamev2 {
        int[] player1;
        int[] player2;

        public Gamev2(int[] player1, int[] player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Gamev2 gamev2 = (Gamev2) o;
            return Arrays.equals(player1, gamev2.player1) && Arrays.equals(player2, gamev2.player2);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(player1);
            result = 31 * result + Arrays.hashCode(player2);
            return result;
        }

        @Override
        public String toString() {
            return "Gamev2{" +
                    "player1=" + Arrays.toString(player1) +
                    ", player2=" + Arrays.toString(player2) +
                    '}';
        }
    }

    private static class SeenGame {
        int p1;
        int p2;

        public SeenGame(Gamev2 game) {
            for (int i = 0; i < game.player1.length; i++) {
                p1 = game.player1[i] * (i+1);
            }
            for (int i = 0; i < game.player2.length; i++) {
                p2 = game.player2[i] * (i+1);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SeenGame seenGame = (SeenGame) o;
            return p1 == seenGame.p1 && p2 == seenGame.p2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
    }
}
