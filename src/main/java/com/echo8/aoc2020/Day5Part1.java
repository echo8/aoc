package com.echo8.aoc2020;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Day5Part1 {
    private static final String INPUT = "FBBFBBBRLR\n" +
            "BFFBBFFLLL\n" +
            "BFFBBBBRRR\n" +
            "BBBFBBFRLL\n" +
            "FFBFFFFLRL\n" +
            "FFBFBBBLLL\n" +
            "BFFBBFBLLL\n" +
            "FBFFFFBLLL\n" +
            "FBBBBBBRLL\n" +
            "BBFFBBFLLR\n" +
            "FFBFBBBLRL\n" +
            "FFBBBBFLLL\n" +
            "FBBFFBBRLL\n" +
            "BFBFFFFRLR\n" +
            "BFBBFBBLLL\n" +
            "FBFFBBBRRR\n" +
            "BBFBFBFLRR\n" +
            "FFBBFFFRRR\n" +
            "BBFFBBFLRL\n" +
            "FBFBBBBLRR\n" +
            "BFFFBFBLRL\n" +
            "FBFFBFFLLR\n" +
            "FFFBFBBRLR\n" +
            "BFFBBBFRLR\n" +
            "BFFBFFFLLR\n" +
            "FFBBBFFLLL\n" +
            "BBBFBBFRRL\n" +
            "BBFBFBFRLR\n" +
            "BFBFFBBRRL\n" +
            "BFFFFFFRLR\n" +
            "FBFBFBBLLL\n" +
            "BFFFBBFRLR\n" +
            "FBFBBBBRRR\n" +
            "BFBFBFBRLR\n" +
            "BBBFFBBLRL\n" +
            "FBFFBFBRLR\n" +
            "FBBBBBFLLR\n" +
            "FFBBBFBRRL\n" +
            "BFFBBFBRLL\n" +
            "BBFFBFFLLL\n" +
            "BFBFBBBLRL\n" +
            "FFBBBFBRRR\n" +
            "FFBBBBBRLL\n" +
            "BFBFBBFLRR\n" +
            "FFBFFBBLRR\n" +
            "BBBFBFFLRL\n" +
            "BBFBBBFLLL\n" +
            "BFBBFFFRLL\n" +
            "FBFBFBFRRR\n" +
            "BBFFBFFLRR\n" +
            "FBFBFBBRRL\n" +
            "BBFFBFFRLR\n" +
            "BBFFFFBRRL\n" +
            "FBFBBBFRLL\n" +
            "BFFFBBFRRR\n" +
            "BFBFBFFLLL\n" +
            "BBFBBFFRRR\n" +
            "FFBBFFBLRR\n" +
            "BFBBFBBRLR\n" +
            "FFFBFBBLLR\n" +
            "FBBFBBFLLR\n" +
            "BBBFBFBRRL\n" +
            "BFBBBFFRLR\n" +
            "BBBFBFBRLL\n" +
            "BBFBBBFLLR\n" +
            "BBFFBFFRRL\n" +
            "FFBFBBBLLR\n" +
            "FFBFBBFLRR\n" +
            "FBBFFBFRLL\n" +
            "BBBFFFBLLL\n" +
            "BBFBFBBLLL\n" +
            "BFFBFBBLRL\n" +
            "BBFFBFBRRR\n" +
            "FFFBFBBRRR\n" +
            "FBFBFFFRRR\n" +
            "FFFBBBBRRR\n" +
            "BFFBBFFRRL\n" +
            "FFBBBFBLRL\n" +
            "BFBBFBFLRL\n" +
            "FFFBBFFLLL\n" +
            "FBBBBFBLLR\n" +
            "FBBBFFBLRL\n" +
            "FBFBFFBLRR\n" +
            "FFBFBFFLLR\n" +
            "BFFFFFFLRL\n" +
            "BFFFBBBLRR\n" +
            "BBBFBFFLLL\n" +
            "BFFFBBFRLL\n" +
            "FBFFFFFRRR\n" +
            "BBFFBBFRLR\n" +
            "FBBFFFFRLL\n" +
            "FBBFBFFLLR\n" +
            "FBBFFFFRLR\n" +
            "BBFFBBBRLL\n" +
            "BFFBFFFRLR\n" +
            "FFBBFBBLLL\n" +
            "BFBFBFBRRL\n" +
            "BFFFBBFLRL\n" +
            "FFBBFFBLRL\n" +
            "FBFFFFFRLR\n" +
            "BFFBBBBRLL\n" +
            "BBFBBBFRLL\n" +
            "BBBFFBFRRR\n" +
            "FBBBBBFLRL\n" +
            "FFBFBBFRRR\n" +
            "BFFFFFBLRL\n" +
            "FBFBFFFRLL\n" +
            "BFFFBBBRLR\n" +
            "BFFFBBBRRR\n" +
            "FFBBBBBRLR\n" +
            "BFFFBBFLLR\n" +
            "BFBBBFBLRR\n" +
            "BBFFFFFLRR\n" +
            "FBBFFBFRRL\n" +
            "FFBBBBBLLL\n" +
            "FBBBBFBLRL\n" +
            "BFBFFBBRLR\n" +
            "BFFFFBBRRL\n" +
            "BBFBBBBRRL\n" +
            "BFFFFBFLRL\n" +
            "BBFFFBBLLR\n" +
            "FBFFFFBRLL\n" +
            "FBBBFBBRRL\n" +
            "FFBFBBBRLR\n" +
            "BFFFBFBRLR\n" +
            "BFBFFBFLLR\n" +
            "BBFBFFFRRL\n" +
            "FBBBFBFRRL\n" +
            "BFBFBBFRLL\n" +
            "FBBBFFFLLL\n" +
            "BBFBBFFRLL\n" +
            "BFBBBBFRRL\n" +
            "BBFFFBFLRR\n" +
            "BFFBFFBLRL\n" +
            "FBBBFFBRRL\n" +
            "BBBFFFBRLR\n" +
            "BFBBFBBRRL\n" +
            "FFBBFBBRRL\n" +
            "FBBFBBFRRL\n" +
            "BBFBFFBRRR\n" +
            "BFBBFFFLLL\n" +
            "BFFBBBFLLR\n" +
            "FBBBBFBRRL\n" +
            "BBFBFBFLLL\n" +
            "BFBFBBFLLR\n" +
            "BBFFFBBRLR\n" +
            "BBFFFBBRRR\n" +
            "FFBFFBBRLR\n" +
            "FFBFFBFRRL\n" +
            "BBFFBBBLRR\n" +
            "FBBBFFBLRR\n" +
            "FBBBFBFRLR\n" +
            "FBFBBFBLRR\n" +
            "BFFBBFFLLR\n" +
            "BBFBBFBRLL\n" +
            "FFBFFBBLLL\n" +
            "FBFBBBBRLR\n" +
            "FBFFFFFLRL\n" +
            "BFFBFFFLRL\n" +
            "BBFFFFFRLR\n" +
            "FBBBBBBLLL\n" +
            "BFFBBFFLRL\n" +
            "FFFBBBBLLR\n" +
            "FFFBBFBRRL\n" +
            "BFFBBBFLRR\n" +
            "FBBFFFFLRR\n" +
            "FBBFBBBLLL\n" +
            "FFFBFBFRLR\n" +
            "FFBBBBFRRL\n" +
            "BFBFFBBRLL\n" +
            "FFBBFBFLLL\n" +
            "BBFFFFBRRR\n" +
            "BFFFBFFLLR\n" +
            "FFBFFBFLLR\n" +
            "FFBFFFFRLL\n" +
            "FBFBBBFRRL\n" +
            "BBFFFBFLLL\n" +
            "FBFBFFFLLR\n" +
            "BFBBBFFLLR\n" +
            "BBBFBBFLLL\n" +
            "BBBFBFFRRR\n" +
            "BBFBFBFLRL\n" +
            "FBBFFBBRLR\n" +
            "BBFBFFFLRR\n" +
            "FBFBBFFLRR\n" +
            "BFFBBBFLRL\n" +
            "BFFBFBFRLR\n" +
            "FBFBFFFRRL\n" +
            "BFBBBBBRRR\n" +
            "BFBFBFBLRL\n" +
            "FFFBBFFLRL\n" +
            "BBBFBFBLRR\n" +
            "FFBFFFFLLL\n" +
            "FBBFBFBRRL\n" +
            "BBFBFFFLLL\n" +
            "FFFBFBFLLR\n" +
            "BFFFBFFRRR\n" +
            "FBBBFFFRRL\n" +
            "BFFBBBFRLL\n" +
            "FBBBFFBRLR\n" +
            "FBFBBFBLLL\n" +
            "BBBFFFFLRL\n" +
            "FBFFBFFRRL\n" +
            "BBFFFFFLLL\n" +
            "BBFFFFFLRL\n" +
            "FBFFBFBRRR\n" +
            "FFBFFFBLRL\n" +
            "FBFFFFFRLL\n" +
            "BFBFBFFRRR\n" +
            "BFFBBBBLLR\n" +
            "FFFBFBBRRL\n" +
            "FFBFBFFRRL\n" +
            "FBBBFFFLRR\n" +
            "BBFBFBFRRL\n" +
            "FFBFBFFRRR\n" +
            "BBFFFFBLLL\n" +
            "FBBFBFBRLR\n" +
            "FFBFFBFRRR\n" +
            "BBBFBBBLRL\n" +
            "BFBBFBFRRR\n" +
            "BBBFFFBLRR\n" +
            "FBBBBBFRLR\n" +
            "BFBFFBFRRR\n" +
            "BFBBFFBLRR\n" +
            "FFBFFBBRRR\n" +
            "FBBFFBFRLR\n" +
            "BFBBFFBRRL\n" +
            "BBBFBBBRLR\n" +
            "BBBFBBBLRR\n" +
            "BFBFFBFRLR\n" +
            "FBBBFBBRRR\n" +
            "BFBFFBBLRL\n" +
            "BBFFFBBRLL\n" +
            "FBBFFFFLLR\n" +
            "FFBFBBFLLR\n" +
            "BFFFFFBLLL\n" +
            "BFBFBFFLRR\n" +
            "BFFBBFBRRL\n" +
            "FBBBFFFRLL\n" +
            "FBFBFFBLRL\n" +
            "FFFBFFBRRL\n" +
            "BFFFFFFLLL\n" +
            "FFBBFFFRLL\n" +
            "FFBBBFBLRR\n" +
            "FFBBFFFRRL\n" +
            "FFFBBBFRRR\n" +
            "FFBFFBBRLL\n" +
            "BFFFFFFRLL\n" +
            "BBFFFBFLRL\n" +
            "FFBBFBBLLR\n" +
            "FBFBBBBLLL\n" +
            "FBBFFBFLLR\n" +
            "BFFBBFFRLR\n" +
            "BFFBFFBLLL\n" +
            "FFBBFBBLRR\n" +
            "BBFBBFFRRL\n" +
            "FBBFFBBLRR\n" +
            "FBBFBFFLLL\n" +
            "BBBFFFBRRL\n" +
            "BFBBFFFLRR\n" +
            "BBBFBBBLLL\n" +
            "FBBBFBFRRR\n" +
            "BFFBBBFRRR\n" +
            "BBBFFFBLRL\n" +
            "BFBFFFBLRL\n" +
            "BFFBFBBLRR\n" +
            "BBBFFBBRRR\n" +
            "BBFBBFFRLR\n" +
            "FFFBBBBLRL\n" +
            "BBFFBBBLRL\n" +
            "FFFBFBFLRL\n" +
            "FFBFBBBRRR\n" +
            "BFFFFFFLLR\n" +
            "FBFBBBBRLL\n" +
            "FBBBFFFRRR\n" +
            "BFBFFBBLLL\n" +
            "BFBFBFFLRL\n" +
            "BBFFFBFLLR\n" +
            "FBBFFFBRLR\n" +
            "FFFBBBFLRR\n" +
            "BFFFFBFRRR\n" +
            "BBFFBBFRRL\n" +
            "BFBFFBFLRL\n" +
            "FBBBFBFLLL\n" +
            "FBBFFBFLRL\n" +
            "BBFBBFBLRL\n" +
            "BBBFBBFLLR\n" +
            "BBFBFFBLRR\n" +
            "FBFBBBFRLR\n" +
            "BBBFBFFLLR\n" +
            "FBBFFBBLLL\n" +
            "BBFFFBBLRR\n" +
            "BFBFBBBLLR\n" +
            "BBFFBBBRLR\n" +
            "FFFBFBBLLL\n" +
            "FBFBBFBRLL\n" +
            "BBFBFFBRRL\n" +
            "BBFFFFBRLL\n" +
            "BFBFFBBLRR\n" +
            "BBFBBBFLRL\n" +
            "FBFFFFBRLR\n" +
            "FBFBFFBRRR\n" +
            "BFBBBBFRRR\n" +
            "BBFFBFFLRL\n" +
            "FBFFFFFRRL\n" +
            "FBFFFFBLLR\n" +
            "BFFBBFBLRR\n" +
            "BBBFFBFLLL\n" +
            "FBFFBFBLRR\n" +
            "FFBBFBFRLR\n" +
            "BBFBFBFRRR\n" +
            "BBFBFBFRLL\n" +
            "FBBBFBBLRL\n" +
            "BBBFFFFRRR\n" +
            "FBBBBBFLLL\n" +
            "BBFFBBBRRR\n" +
            "BFFFFBBRLR\n" +
            "FFBBFBBRLL\n" +
            "BBFBFBBLRL\n" +
            "BFFBFFBLRR\n" +
            "FBBFFFBRLL\n" +
            "FFFBBFBRLR\n" +
            "BBBFFBFLLR\n" +
            "BBFFFFBRLR\n" +
            "BFFBBFFRRR\n" +
            "FFBFFBFRLR\n" +
            "FBBFFFFRRL\n" +
            "BFBBBFFRRL\n" +
            "BFFBFBFLRR\n" +
            "FBBBFBBRLL\n" +
            "FBFFBBFRRL\n" +
            "BFFFBFFLRL\n" +
            "FFFBBFFRRR\n" +
            "BBFFFFBLLR\n" +
            "BFFBFBBRLL\n" +
            "BFFFBFBLLR\n" +
            "BBBFBBFLRR\n" +
            "FFBFBFFLRL\n" +
            "BFFBFFBRLL\n" +
            "FBBBFBBLLL\n" +
            "BFBBFBFLLL\n" +
            "FBFBBFFRLL\n" +
            "BFBFFFFLRR\n" +
            "FFBBFFBRRL\n" +
            "FBFBFBBLRR\n" +
            "FFFBFBBRLL\n" +
            "FBBFFBBRRR\n" +
            "FBFBBBBLLR\n" +
            "FBBFBFBLRR\n" +
            "BFFFFFBRLR\n" +
            "BFBBFBBRRR\n" +
            "BFBBBBBLLR\n" +
            "FFFBBFBLLR\n" +
            "FBBFFBBLRL\n" +
            "FFFBFBFRRL\n" +
            "BFFFFBFLLL\n" +
            "FBBBBBBRLR\n" +
            "FFBBBFFLLR\n" +
            "BFBBBBFRLL\n" +
            "FFBFBFFLRR\n" +
            "BFFBBFBLLR\n" +
            "FBFBFBBRLR\n" +
            "BBBFFFFLLR\n" +
            "FFBBBBFLLR\n" +
            "BFBBFFBRRR\n" +
            "BBFBBFFLLL\n" +
            "BFBBBBFRLR\n" +
            "FFFBBFFLRR\n" +
            "FFBFBBBRLL\n" +
            "BFBBFFBLRL\n" +
            "BFFBBBFRRL\n" +
            "FFFBFBFLRR\n" +
            "BFFFBBBRLL\n" +
            "BBBFBFBRLR\n" +
            "FBFFBBBRRL\n" +
            "FFBBBBFLRR\n" +
            "BFBBFBFRLL\n" +
            "BFBBBFFRRR\n" +
            "BBBFFBFRRL\n" +
            "BBFBFFFRLL\n" +
            "FFBFBFBRLL\n" +
            "FBBFBBFLRL\n" +
            "FFBBFFFRLR\n" +
            "FBBFFBBRRL\n" +
            "FBBBBFBLRR\n" +
            "BFFFBFFRRL\n" +
            "BFFFFBFRRL\n" +
            "BFBFBFBRLL\n" +
            "BFFBFBFRLL\n" +
            "FBFBBFBRRL\n" +
            "FFFBBFFRLL\n" +
            "BFFFFBFLRR\n" +
            "BFBBBBFLRR\n" +
            "BBFBFBBRRR\n" +
            "FBBBBBFRRR\n" +
            "BFBBBFFLLL\n" +
            "BFBBBFBRRR\n" +
            "FBFBBFFRRL\n" +
            "BBFBBBBLLR\n" +
            "BFBBFFBLLR\n" +
            "BFBBFBFLRR\n" +
            "FBFBBFFLLR\n" +
            "BFBFFFFLLR\n" +
            "BFFFBFBRRR\n" +
            "FBFBBFFLLL\n" +
            "FBFBFBFRLL\n" +
            "BBFBFFBLRL\n" +
            "BBBFFFFRRL\n" +
            "BFFFFBBLLR\n" +
            "FFFBBBBRLR\n" +
            "BFFFBFFLLL\n" +
            "BFFFBFFRLL\n" +
            "BFBFFBFRRL\n" +
            "FFBFBFBLRL\n" +
            "FFBFFFFRLR\n" +
            "BFFBBBFLLL\n" +
            "FBFFFBFRRL\n" +
            "BBFFBBBLLR\n" +
            "BFFBFFFRRR\n" +
            "BFBFFFBRLL\n" +
            "FFBFFBFLLL\n" +
            "BBFBBFBRRL\n" +
            "BBFBFBBRRL\n" +
            "BFBBFFBRLR\n" +
            "BBFFFBFRLR\n" +
            "BBBFFFBLLR\n" +
            "BFFBBFBRLR\n" +
            "BBFBFBBLLR\n" +
            "BBFFBBBRRL\n" +
            "FFFBBBFLRL\n" +
            "BFFBFFFRLL\n" +
            "FBFBFFFLRL\n" +
            "FBFBBBFLRL\n" +
            "BFBFFBFLLL\n" +
            "BFBFFFBLRR\n" +
            "BFBFFFFLRL\n" +
            "FBBBBFFLRL\n" +
            "BFFBFFBRRL\n" +
            "BFBBBBBLRL\n" +
            "BFBFBBBRLL\n" +
            "BBBFFBBLLL\n" +
            "FBBFBBBRRR\n" +
            "FFBBFFFLRR\n" +
            "FBBFFFFLRL\n" +
            "BBBFBFFLRR\n" +
            "BFBFBBFRLR\n" +
            "BBFBBFBRLR\n" +
            "FBFBFFBLLR\n" +
            "BFBFBBBRRL\n" +
            "BBFFBFBLLL\n" +
            "FBFFFFBLRL\n" +
            "FFBFBBFLLL\n" +
            "FBFFBFFLRR\n" +
            "BFFFFBFLLR\n" +
            "FFBFFFBRLL\n" +
            "FBFBBBBRRL\n" +
            "FFBFFFBLLL\n" +
            "BFBBFFBLLL\n" +
            "FFBBFFFLRL\n" +
            "FBFFFBFLRL\n" +
            "FBBBBBBLRL\n" +
            "BBBFFBBLRR\n" +
            "FBFBFBFRLR\n" +
            "BFBFBFFRLL\n" +
            "BFFFBBBLRL\n" +
            "BFFFBFBRRL\n" +
            "BBFFBBBLLL\n" +
            "FBFFFBBLRR\n" +
            "BFFBFBFRRL\n" +
            "BFFFBFBLLL\n" +
            "FBFBBFBRRR\n" +
            "BFBFBBFRRR\n" +
            "BBBFBFFRLL\n" +
            "FBBFFBFLRR\n" +
            "FFBBBFBLLL\n" +
            "BFBBBFFLRR\n" +
            "FFBBBFFRLR\n" +
            "BFFFBFFLRR\n" +
            "FFBBBFFRLL\n" +
            "FFBFBFBLLR\n" +
            "FBFFBFBLRL\n" +
            "FBFFFBBRRR\n" +
            "FFBFFFBLLR\n" +
            "FFBFFFBRLR\n" +
            "BFBFFBBLLR\n" +
            "BFBBBFBRLR\n" +
            "BFFBBBBLRL\n" +
            "BFBFFFBRRL\n" +
            "FBFFFBBLLL\n" +
            "BFFFFFFRRL\n" +
            "BBBFFBFLRL\n" +
            "FFFBBFBLRR\n" +
            "FBFFBBFRLL\n" +
            "BBFFBFBLRL\n" +
            "BBFBBFFLLR\n" +
            "FBBBFBFLRL\n" +
            "BBBFFBBLLR\n" +
            "FBBFFFBLRR\n" +
            "BFFFBBBRRL\n" +
            "BFBBFFFRLR\n" +
            "FFBFBBFLRL\n" +
            "BFFBBBBLLL\n" +
            "FBBBBBBRRL\n" +
            "FBFFBFFRLR\n" +
            "FBFFBFFLRL\n" +
            "BFFBBFBLRL\n" +
            "FBFFBBFLLR\n" +
            "BBFFFFBLRR\n" +
            "FBBFFBFRRR\n" +
            "BFFBFFBRLR\n" +
            "FBBBBBFLRR\n" +
            "BFBFFBFRLL\n" +
            "FBFFBFBLLR\n" +
            "FBFBBFBRLR\n" +
            "BBBFFFFRLR\n" +
            "FFFBFFBRRR\n" +
            "BBFFFBFRRL\n" +
            "BFBFBBFLRL\n" +
            "FBBFBBFRLL\n" +
            "FFFBBBBLRR\n" +
            "BFBBFBBLLR\n" +
            "BFBFFFBLLR\n" +
            "FBBFBBBRRL\n" +
            "BFBFFFFLLL\n" +
            "FBFFFBFLLL\n" +
            "BBFFFBFRRR\n" +
            "FBFFBBBRLL\n" +
            "FBFFBFBRLL\n" +
            "FFBBFBFLRR\n" +
            "FFFBBBFRRL\n" +
            "FBBFBFFLRR\n" +
            "FBFFBBBLRL\n" +
            "BFBBFFFRRR\n" +
            "FBBFBFBRLL\n" +
            "FBFFBBBLRR\n" +
            "FFBBBFBLLR\n" +
            "BFBFBFFRLR\n" +
            "BFFBFBBLLR\n" +
            "FBFFBFBLLL\n" +
            "FBBBFBFLLR\n" +
            "BFFFFBBLLL\n" +
            "FFBBBBFLRL\n" +
            "BFBBFBFLLR\n" +
            "BFFBFFBRRR\n" +
            "FBFBBFFRLR\n" +
            "FBFBBBFLRR\n" +
            "FBBFFFBRRL\n" +
            "BBFFBFBRLR\n" +
            "BFBFFBBRRR\n" +
            "BBFFBFFLLR\n" +
            "BBBFFFFLLL\n" +
            "FFBFBFFRLL\n" +
            "BFFBFBFRRR\n" +
            "FBBBBFBLLL\n" +
            "FBFBFBFLRR\n" +
            "FBFBBFBLLR\n" +
            "BFFFBBBLLL\n" +
            "FBBFFFBRRR\n" +
            "FBBBBFFRRR\n" +
            "FFFBBFFRRL\n" +
            "FFBBBFFRRR\n" +
            "FBBFBBFLLL\n" +
            "BBBFBFFRRL\n" +
            "BBFFBFBRLL\n" +
            "FBFFFFBLRR\n" +
            "FFBFFBFLRR\n" +
            "FBBBFBFLRR\n" +
            "BFBBBBFLRL\n" +
            "FFBBFBFLLR\n" +
            "FFBBFFBRLR\n" +
            "BFBFBBBRLR\n" +
            "BFBFFBFLRR\n" +
            "FBBFBFBLRL\n" +
            "FFFBBFBRRR\n" +
            "BFFFFFFLRR\n" +
            "BBFBFFBRLR\n" +
            "FBBBFFFRLR\n" +
            "FBBFBFFRLL\n" +
            "FBFBBBFRRR\n" +
            "FBFFBBFRRR\n" +
            "BBFBBFBLLR\n" +
            "FBFFFBBRRL\n" +
            "BFBFBBFLLL\n" +
            "FBFFFBFRRR\n" +
            "FBFBFBBRLL\n" +
            "FFBBFFBRLL\n" +
            "FBBBFBBRLR\n" +
            "FBBBFBBLLR\n" +
            "BFBBFBFRRL\n" +
            "FBFFBBFRLR\n" +
            "FBBFBFFRRL\n" +
            "BFBFBBBLLL\n" +
            "BFBBBFBLRL\n" +
            "BFFFFBBLRR\n" +
            "BFBBBFFLRL\n" +
            "FBFFFBBRLR\n" +
            "FFBFFFFRRR\n" +
            "FBBFBFFLRL\n" +
            "BFBFFFFRRL\n" +
            "BFBBFFFRRL\n" +
            "BFBFBFBLLR\n" +
            "BBFFFBFRLL\n" +
            "BFBBBBFLLL\n" +
            "BFFBBBBRLR\n" +
            "FBBBBBBRRR\n" +
            "BFFFFBBRLL\n" +
            "BBBFBBBRRL\n" +
            "BFFBFFFRRL\n" +
            "FBFBBBBLRL\n" +
            "BBFBBFBLLL\n" +
            "FBFFFBFRLR\n" +
            "FBFFFBFLRR\n" +
            "BBBFBBFRLR\n" +
            "FFBBBBFRRR\n" +
            "FBFBFBFLLR\n" +
            "FBBBFFFLRL\n" +
            "FFBFBFBLLL\n" +
            "BFFBFBFLRL\n" +
            "BFFBFBBRRR\n" +
            "FBBFFFFLLL\n" +
            "BBFBBBBLRL\n" +
            "FFFBFBFRLL\n" +
            "FFBBBFBRLR\n" +
            "BFBBBFBLLR\n" +
            "BFBBBBBRLL\n" +
            "FBFFBBFLRR\n" +
            "BFBBBBBLLL\n" +
            "FBBFBFFRRR\n" +
            "FBBBBBBLRR\n" +
            "BFBBFBFRLR\n" +
            "BBFFFFFLLR\n" +
            "BBFBBFBLRR\n" +
            "BFFFFFBRLL\n" +
            "FFBBFBBLRL\n" +
            "FBFBFBBLLR\n" +
            "BBFBFBBRLL\n" +
            "BFFFFBFRLL\n" +
            "FFFBBFFLLR\n" +
            "BBBFBFFRLR\n" +
            "BFBBBFFRLL\n" +
            "FBBFBBFLRR\n" +
            "BFBFBFBLLL\n" +
            "BFFBBBBRRL\n" +
            "BBFBBBFRRL\n" +
            "FFBBBBBLRR\n" +
            "FFBBBFBRLL\n" +
            "BFBBFBBRLL\n" +
            "FBBBFBBLRR\n" +
            "FFFBFBBLRR\n" +
            "BBFBFFFRRR\n" +
            "BFBFBFFLLR\n" +
            "BFFFBFBRLL\n" +
            "BBFFBFFRLL\n" +
            "FFBFFBFLRL\n" +
            "FBBBBFFRLL\n" +
            "FFBFBFBRRR\n" +
            "BBFBBBBLLL\n" +
            "BBFFBFBLRR\n" +
            "FFBBFFBRRR\n" +
            "FBBFFFFRRR\n" +
            "FFBFFBBLLR\n" +
            "FBFBFBBRRR\n" +
            "FFFBFBFLLL\n" +
            "FFBBFBFRRL\n" +
            "BFFFBBFRRL\n" +
            "FBFBFFBRRL\n" +
            "FFBBFFFLLR\n" +
            "BFFBBBBLRR\n" +
            "BFFFFFBRRL\n" +
            "BBFBBBBRLL\n" +
            "BFFFBBBLLR\n" +
            "BFBFFFFRRR\n" +
            "BBFBFFBLLR\n" +
            "FBFFFFFLRR\n" +
            "FBBBBBFRLL\n" +
            "BFFBFBBLLL\n" +
            "BBBFBBFLRL\n" +
            "BBFFFBBRRL\n" +
            "FBFBBBFLLR\n" +
            "FFBBBBBRRL\n" +
            "BFFFFFBLRR\n" +
            "FFBFBBFRLL\n" +
            "FBBFFFBLLL\n" +
            "FFBBFBFRRR\n" +
            "FBFFBBFLLL\n" +
            "FBBFBBFRLR\n" +
            "BFFFFBBRRR\n" +
            "BFFFBBFLRR\n" +
            "FBFFFFBRRL\n" +
            "BFBFBBBLRR\n" +
            "BBBFFBBRLL\n" +
            "BBFFBBFLLL\n" +
            "BFBFBBFRRL\n" +
            "FBBFBFBLLL\n" +
            "FFBFFBBRRL\n" +
            "FBFBBFFRRR\n" +
            "BFBBBFBRRL\n" +
            "FFBFFBBLRL\n" +
            "FFBBBBBLRL\n" +
            "FFFBBFBLRL\n" +
            "FBBBBFBRLL\n" +
            "FBBBFFBLLL\n" +
            "BBFFFBBLLL\n" +
            "BFFFFFFRRR\n" +
            "BFBBBBBRRL\n" +
            "FBFBFBFRRL\n" +
            "FBBBFFBRLL\n" +
            "BBBFBFBLRL\n" +
            "FBBBBFFRRL\n" +
            "FBFFBFFRRR\n" +
            "FBFFBFFRLL\n" +
            "FBFBFFFLLL\n" +
            "BBFBBFBRRR\n" +
            "FFBBFFBLLR\n" +
            "BBBFBBFRRR\n" +
            "BBBFFBFRLR\n" +
            "FFBFFFFRRL\n" +
            "BFFFBFBLRR\n" +
            "FBBBFFBRRR\n" +
            "FFFBBBFLLL\n" +
            "FBFFFBBRLL\n" +
            "BBFBBFFLRL\n" +
            "FFBFBBBLRR\n" +
            "FFBBBFFLRR\n" +
            "FFBBBBFRLL\n" +
            "FFFBFBBLRL\n" +
            "BBBFFBBRLR\n" +
            "BBBFFFFRLL\n" +
            "FBBFFBFLLL\n" +
            "BFBBBBFLLR\n" +
            "FBFBFBFLLL\n" +
            "FBFFFBFLLR\n" +
            "BFBBFFFLRL\n" +
            "FFBFBFFRLR\n" +
            "BFFBFBBRRL\n" +
            "FBFFFFFLLL\n" +
            "BFFFFBBLRL\n" +
            "BFBBBFBLLL\n" +
            "BBFFBFBRRL\n" +
            "BBFBBBFRRR\n" +
            "FBBBFFFLLR\n" +
            "FFFBBBFRLL\n" +
            "BFBBBBBLRR\n" +
            "BBFFFBBLRL\n" +
            "BBFBFBBLRR\n" +
            "BBFBFBBRLR\n" +
            "FBBBBFFRLR\n" +
            "BBBFBFBRRR\n" +
            "BBBFFFBRRR\n" +
            "FBBFBBBRLL\n" +
            "FBFBFFFLRR\n" +
            "FFBBBFFLRL\n" +
            "FBBBBFBRLR\n" +
            "BFFBFBFLLL\n" +
            "BFBFBFFRRL\n" +
            "BFBFFFFRLL\n" +
            "BBBFFBBRRL\n" +
            "FBBBFBFRLL\n" +
            "BFBBFBBLRR\n" +
            "BBBFBBBRLL\n" +
            "BBBFFBFLRR\n" +
            "FBBFFFBLLR\n" +
            "BFBFBBBRRR\n" +
            "BBBFBBBRRR\n" +
            "FBFFBBBLLR\n" +
            "FBFBFFBRLR\n" +
            "FFBFFFBRRR\n" +
            "FBFFFBBLLR\n" +
            "BFFBFFFLLL\n" +
            "FBFBFFBLLL\n" +
            "FBFBBBFLLL\n" +
            "FFBFBFFLLL\n" +
            "FFBFBBFRLR\n" +
            "FFBFFFFLRR\n" +
            "FFBBFBBRRR\n" +
            "FFBFBBBRRL\n" +
            "BFBBBFBRLL\n" +
            "BBBFFFBRLL\n" +
            "FBFFBFFLLL\n" +
            "BBFFBFFRRR\n" +
            "FFFBBFBRLL\n" +
            "BFFBFFFLRR\n" +
            "FBBBBBFRRL\n" +
            "FFBFBBFRRL\n" +
            "BBFFFFFRRR\n" +
            "BFFFFFBLLR\n" +
            "FBFBFFBRLL\n" +
            "BFBFFFBRLR\n" +
            "FFBBFBFRLL\n" +
            "BBFBBBFRLR\n" +
            "FBFBBFBLRL\n" +
            "FFBFFFBLRR\n" +
            "FBFBFFFRLR\n" +
            "BFFBBFFRLL\n" +
            "FBBFBFBRRR\n" +
            "FFBBBBBRRR\n" +
            "FBBFFBBLLR\n" +
            "FFFBBBBRRL\n" +
            "FFFBBBBRLL\n" +
            "BBFFFFFRLL\n" +
            "BBFBBBBRRR\n" +
            "BFFBBFBRRR\n" +
            "BFBBFBBLRL\n" +
            "BBFBBBBRLR\n" +
            "FBBBFFBLLR\n" +
            "FBBFBBBLRR\n" +
            "FFBBBFFRRL\n" +
            "BBFBBBBLRR\n" +
            "FBBFBBFRRR\n" +
            "FFBBFBFLRL\n" +
            "FBBFBBBLRL\n" +
            "FBFFFFBRRR\n" +
            "FFBBFFFLLL\n" +
            "BBBFFFFLRR\n" +
            "FBFBBFFLRL\n" +
            "FFFBBFFRLR\n" +
            "FBBBBFFLLR\n" +
            "BFBFBFBLRR\n" +
            "FBBBBFFLRR\n" +
            "BBFBFFFLLR\n" +
            "FFBBFBBRLR\n" +
            "BFFBBFFLRR\n" +
            "FFBFFBFRLL\n" +
            "BBFBBFFLRR\n" +
            "BBFBFBFLLR\n" +
            "BBFBFFBRLL\n" +
            "FFBFBFBRRL\n" +
            "BFBBFFBRLL\n" +
            "FFFBBBFLLR\n" +
            "FBFFBBBLLL\n" +
            "FFFBBBFRLR\n" +
            "FFBBFFBLLL\n" +
            "FFBBBBFRLR\n" +
            "BBFFFFBLRL\n" +
            "FBBBBFBRRR\n" +
            "BFFFBBFLLL\n" +
            "BBBFBBBLLR\n" +
            "BBFBFFFRLR\n" +
            "FBFFFBFRLL\n" +
            "BBFBBBFLRR\n" +
            "BBFBFFFLRL\n" +
            "FFBFFFFLLR\n" +
            "FBBFBBBLLR\n" +
            "BBFFBBFRRR\n" +
            "BBBFBFBLLL\n" +
            "FBBFBFFRLR\n" +
            "FBFFBBFLRL\n" +
            "FFFBBBBLLL\n" +
            "BFBFFFBLLL\n" +
            "FBBFBFBLLR\n" +
            "BBFBFFBLLL\n" +
            "FFFBBFBLLL\n" +
            "BFFBFBFLLR\n" +
            "FFBFBFBRLR\n" +
            "BFFBFBBRLR\n" +
            "FFBFBFBLRR\n" +
            "FBFFFBBLRL\n" +
            "BBFFBFBLLR\n" +
            "BFBFFFBRRR\n" +
            "BFFFFBFRLR\n" +
            "FBFBFBBLRL\n" +
            "BFFFBFFRLR\n" +
            "BBFFBBFRLL\n" +
            "BFBBBBBRLR\n" +
            "BFBFBFBRRR\n" +
            "BBFFBBFLRR\n" +
            "FFBBBBBLLR\n" +
            "FBFFFFFLLR\n" +
            "FBFBFBFLRL\n" +
            "FBFFBBBRLR\n" +
            "BBBFBFBLLR\n" +
            "BFFBFFBLLR\n" +
            "FBBBBFFLLL\n" +
            "BFBBFFFLLR\n" +
            "FFFBFBFRRR\n" +
            "FFBFFFBRRL\n" +
            "FBBBBBBLLR\n" +
            "FBBFFFBLRL\n" +
            "BBBFFBFRLL\n" +
            "FBFFBFBRRL\n" +
            "BBFFFFFRRL";

    public static void main(String[] args) {
        List<String> tickets = Arrays.asList(INPUT.split("\n").clone());
        long maxId = Long.MIN_VALUE;
        for (String ticket : tickets) {
            int curMin = 0;
            int curMax = 127;
            for (int i = 0; i < 6; i++) {
                char c = ticket.charAt(i);
                int mid = (curMin+curMax)/2;
                if (c == 'F') {
                    curMax = mid;
                } else {
                    curMin = mid+1;
                }
            }
            char lastC = ticket.charAt(6);
            int row = 0;
            if (lastC == 'F') {
                row = curMin;
            } else {
                row = curMax;
            }
            curMin = 0;
            curMax = 7;
            for (int i = 7; i < ticket.length(); i++) {
                char c = ticket.charAt(i);
                int mid = (curMin+curMax)/2;
                if (c == 'L') {
                    curMax = mid;
                } else {
                    curMin = mid+1;
                }
            }
            int col = curMin;
            int val = (row*8)+col;
            maxId = Math.max(maxId, val);
        }
        System.out.println(maxId);
    }
}