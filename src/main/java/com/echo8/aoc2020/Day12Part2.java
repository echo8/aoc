package com.echo8.aoc2020;

import java.util.Arrays;
import java.util.List;

public class Day12Part2 {
    private static final String INPUT = "F47\n" +
            "W2\n" +
            "S5\n" +
            "R180\n" +
            "R90\n" +
            "N3\n" +
            "F44\n" +
            "W1\n" +
            "N3\n" +
            "F77\n" +
            "S5\n" +
            "L270\n" +
            "F39\n" +
            "N3\n" +
            "L90\n" +
            "F83\n" +
            "W4\n" +
            "R270\n" +
            "E2\n" +
            "F98\n" +
            "N3\n" +
            "R180\n" +
            "N3\n" +
            "F54\n" +
            "N1\n" +
            "W4\n" +
            "R90\n" +
            "N1\n" +
            "L90\n" +
            "S2\n" +
            "E4\n" +
            "N4\n" +
            "W2\n" +
            "R90\n" +
            "F42\n" +
            "W3\n" +
            "S4\n" +
            "L90\n" +
            "E5\n" +
            "F6\n" +
            "R180\n" +
            "N4\n" +
            "E5\n" +
            "R180\n" +
            "E3\n" +
            "N3\n" +
            "F27\n" +
            "L90\n" +
            "S4\n" +
            "L180\n" +
            "E4\n" +
            "F52\n" +
            "E2\n" +
            "N1\n" +
            "R90\n" +
            "E3\n" +
            "S4\n" +
            "F76\n" +
            "R270\n" +
            "W2\n" +
            "R90\n" +
            "S2\n" +
            "R90\n" +
            "F79\n" +
            "S1\n" +
            "L180\n" +
            "F81\n" +
            "E3\n" +
            "F79\n" +
            "L90\n" +
            "S3\n" +
            "L180\n" +
            "F52\n" +
            "S5\n" +
            "L90\n" +
            "N4\n" +
            "W2\n" +
            "F65\n" +
            "N2\n" +
            "W1\n" +
            "R90\n" +
            "F25\n" +
            "W4\n" +
            "L90\n" +
            "S2\n" +
            "R90\n" +
            "N1\n" +
            "F13\n" +
            "W1\n" +
            "N1\n" +
            "F71\n" +
            "N3\n" +
            "L90\n" +
            "W4\n" +
            "R90\n" +
            "F91\n" +
            "W5\n" +
            "N3\n" +
            "W3\n" +
            "S3\n" +
            "F58\n" +
            "W4\n" +
            "N5\n" +
            "W3\n" +
            "F42\n" +
            "S4\n" +
            "E5\n" +
            "N3\n" +
            "F14\n" +
            "L180\n" +
            "E5\n" +
            "L270\n" +
            "F55\n" +
            "N3\n" +
            "R90\n" +
            "R90\n" +
            "S4\n" +
            "F55\n" +
            "W2\n" +
            "N1\n" +
            "W5\n" +
            "R180\n" +
            "F8\n" +
            "E3\n" +
            "L270\n" +
            "N2\n" +
            "F12\n" +
            "N2\n" +
            "R90\n" +
            "W1\n" +
            "R90\n" +
            "W2\n" +
            "L90\n" +
            "S2\n" +
            "F75\n" +
            "L90\n" +
            "S4\n" +
            "E3\n" +
            "F82\n" +
            "L90\n" +
            "L90\n" +
            "F42\n" +
            "N4\n" +
            "E5\n" +
            "F67\n" +
            "R90\n" +
            "E3\n" +
            "F64\n" +
            "E4\n" +
            "R90\n" +
            "F42\n" +
            "S4\n" +
            "F85\n" +
            "W5\n" +
            "S5\n" +
            "R90\n" +
            "F35\n" +
            "R270\n" +
            "W5\n" +
            "F67\n" +
            "R90\n" +
            "S5\n" +
            "R180\n" +
            "S1\n" +
            "F13\n" +
            "N4\n" +
            "W5\n" +
            "S2\n" +
            "F31\n" +
            "L90\n" +
            "E2\n" +
            "F39\n" +
            "R90\n" +
            "F3\n" +
            "W4\n" +
            "N2\n" +
            "F14\n" +
            "E2\n" +
            "F80\n" +
            "L180\n" +
            "F52\n" +
            "N3\n" +
            "E2\n" +
            "F98\n" +
            "W2\n" +
            "F29\n" +
            "R180\n" +
            "E2\n" +
            "L90\n" +
            "W4\n" +
            "N3\n" +
            "W1\n" +
            "S2\n" +
            "W1\n" +
            "N5\n" +
            "F6\n" +
            "E5\n" +
            "E1\n" +
            "W2\n" +
            "R90\n" +
            "S3\n" +
            "F92\n" +
            "L90\n" +
            "E5\n" +
            "F55\n" +
            "L90\n" +
            "S3\n" +
            "R90\n" +
            "S2\n" +
            "L90\n" +
            "N1\n" +
            "E5\n" +
            "F50\n" +
            "L90\n" +
            "N4\n" +
            "F9\n" +
            "L90\n" +
            "N4\n" +
            "L90\n" +
            "R90\n" +
            "R180\n" +
            "E3\n" +
            "F57\n" +
            "L90\n" +
            "S5\n" +
            "R180\n" +
            "S3\n" +
            "E4\n" +
            "F41\n" +
            "W5\n" +
            "N4\n" +
            "W2\n" +
            "N2\n" +
            "R90\n" +
            "S2\n" +
            "W1\n" +
            "F83\n" +
            "R180\n" +
            "W1\n" +
            "R90\n" +
            "W1\n" +
            "F17\n" +
            "F20\n" +
            "S1\n" +
            "E5\n" +
            "F13\n" +
            "N5\n" +
            "F8\n" +
            "F81\n" +
            "E2\n" +
            "S4\n" +
            "F7\n" +
            "W2\n" +
            "F86\n" +
            "N2\n" +
            "L90\n" +
            "N5\n" +
            "L180\n" +
            "E2\n" +
            "R90\n" +
            "E3\n" +
            "S3\n" +
            "N4\n" +
            "W2\n" +
            "F64\n" +
            "L90\n" +
            "F81\n" +
            "L90\n" +
            "E4\n" +
            "F1\n" +
            "E3\n" +
            "L90\n" +
            "W5\n" +
            "L90\n" +
            "N3\n" +
            "F28\n" +
            "F3\n" +
            "F100\n" +
            "E5\n" +
            "N5\n" +
            "F32\n" +
            "R90\n" +
            "W1\n" +
            "R90\n" +
            "S3\n" +
            "W1\n" +
            "W5\n" +
            "N3\n" +
            "F27\n" +
            "R90\n" +
            "W2\n" +
            "R180\n" +
            "W3\n" +
            "W2\n" +
            "N2\n" +
            "E2\n" +
            "S1\n" +
            "R90\n" +
            "W3\n" +
            "F51\n" +
            "E5\n" +
            "N4\n" +
            "W3\n" +
            "S5\n" +
            "R90\n" +
            "F91\n" +
            "S3\n" +
            "W1\n" +
            "S4\n" +
            "R270\n" +
            "N5\n" +
            "W4\n" +
            "F94\n" +
            "R90\n" +
            "N4\n" +
            "L90\n" +
            "N4\n" +
            "R90\n" +
            "F35\n" +
            "E3\n" +
            "F6\n" +
            "S4\n" +
            "F98\n" +
            "E2\n" +
            "L180\n" +
            "W4\n" +
            "N5\n" +
            "F42\n" +
            "S3\n" +
            "W3\n" +
            "N1\n" +
            "R90\n" +
            "S5\n" +
            "E3\n" +
            "S3\n" +
            "F47\n" +
            "S1\n" +
            "F19\n" +
            "W5\n" +
            "R90\n" +
            "F17\n" +
            "R90\n" +
            "N4\n" +
            "R90\n" +
            "F57\n" +
            "E2\n" +
            "F73\n" +
            "W3\n" +
            "F52\n" +
            "F98\n" +
            "R90\n" +
            "N1\n" +
            "F88\n" +
            "N2\n" +
            "E4\n" +
            "S4\n" +
            "R90\n" +
            "E2\n" +
            "R90\n" +
            "N5\n" +
            "F75\n" +
            "L180\n" +
            "F61\n" +
            "E2\n" +
            "S4\n" +
            "N4\n" +
            "W1\n" +
            "N3\n" +
            "E2\n" +
            "N3\n" +
            "F44\n" +
            "E3\n" +
            "L180\n" +
            "N4\n" +
            "F16\n" +
            "E2\n" +
            "S1\n" +
            "L180\n" +
            "R90\n" +
            "W5\n" +
            "F65\n" +
            "S5\n" +
            "F31\n" +
            "E3\n" +
            "L90\n" +
            "N5\n" +
            "E4\n" +
            "S5\n" +
            "E4\n" +
            "S4\n" +
            "R90\n" +
            "F70\n" +
            "R90\n" +
            "W4\n" +
            "L90\n" +
            "N3\n" +
            "W1\n" +
            "L90\n" +
            "S3\n" +
            "L90\n" +
            "F91\n" +
            "L180\n" +
            "S3\n" +
            "R90\n" +
            "N5\n" +
            "L90\n" +
            "S5\n" +
            "W2\n" +
            "F18\n" +
            "E3\n" +
            "F19\n" +
            "N1\n" +
            "F70\n" +
            "R90\n" +
            "E3\n" +
            "S4\n" +
            "F46\n" +
            "N2\n" +
            "S3\n" +
            "W2\n" +
            "S4\n" +
            "F7\n" +
            "L90\n" +
            "E4\n" +
            "R90\n" +
            "F78\n" +
            "S1\n" +
            "F4\n" +
            "L90\n" +
            "W3\n" +
            "F78\n" +
            "E5\n" +
            "L270\n" +
            "F86\n" +
            "E3\n" +
            "F82\n" +
            "L90\n" +
            "F32\n" +
            "R90\n" +
            "E4\n" +
            "L90\n" +
            "E4\n" +
            "L90\n" +
            "E3\n" +
            "F63\n" +
            "N4\n" +
            "E4\n" +
            "L90\n" +
            "F70\n" +
            "R180\n" +
            "F30\n" +
            "R180\n" +
            "F40\n" +
            "N5\n" +
            "R90\n" +
            "W4\n" +
            "F16\n" +
            "L180\n" +
            "S1\n" +
            "W1\n" +
            "R180\n" +
            "F12\n" +
            "W3\n" +
            "L90\n" +
            "F93\n" +
            "S2\n" +
            "L270\n" +
            "F36\n" +
            "L90\n" +
            "W2\n" +
            "N2\n" +
            "F3\n" +
            "W2\n" +
            "L180\n" +
            "L90\n" +
            "F24\n" +
            "S1\n" +
            "W5\n" +
            "R90\n" +
            "E4\n" +
            "L180\n" +
            "E1\n" +
            "S1\n" +
            "L90\n" +
            "F94\n" +
            "L90\n" +
            "F55\n" +
            "N2\n" +
            "E5\n" +
            "F33\n" +
            "E3\n" +
            "L90\n" +
            "N2\n" +
            "L90\n" +
            "S2\n" +
            "R90\n" +
            "F67\n" +
            "W4\n" +
            "F79\n" +
            "E1\n" +
            "E5\n" +
            "F5\n" +
            "S5\n" +
            "R180\n" +
            "F5\n" +
            "E2\n" +
            "E5\n" +
            "N4\n" +
            "W5\n" +
            "N4\n" +
            "W5\n" +
            "E2\n" +
            "L90\n" +
            "F2\n" +
            "L90\n" +
            "N4\n" +
            "E3\n" +
            "N3\n" +
            "R90\n" +
            "F92\n" +
            "N5\n" +
            "F83\n" +
            "L90\n" +
            "F85\n" +
            "R90\n" +
            "W5\n" +
            "S2\n" +
            "L90\n" +
            "E1\n" +
            "F34\n" +
            "E3\n" +
            "L180\n" +
            "W3\n" +
            "R90\n" +
            "F29\n" +
            "W4\n" +
            "L90\n" +
            "F34\n" +
            "W1\n" +
            "S4\n" +
            "E2\n" +
            "S1\n" +
            "W2\n" +
            "W5\n" +
            "L90\n" +
            "E5\n" +
            "N4\n" +
            "R180\n" +
            "N2\n" +
            "W5\n" +
            "R90\n" +
            "F42\n" +
            "W3\n" +
            "N2\n" +
            "L90\n" +
            "F79\n" +
            "W2\n" +
            "F16\n" +
            "N5\n" +
            "E3\n" +
            "F52\n" +
            "F55\n" +
            "L90\n" +
            "F42\n" +
            "L90\n" +
            "W4\n" +
            "S2\n" +
            "E5\n" +
            "L90\n" +
            "S4\n" +
            "F34\n" +
            "N5\n" +
            "N1\n" +
            "L180\n" +
            "L90\n" +
            "E2\n" +
            "L90\n" +
            "W3\n" +
            "L90\n" +
            "F16\n" +
            "E2\n" +
            "F96\n" +
            "N3\n" +
            "E1\n" +
            "F34\n" +
            "R180\n" +
            "S2\n" +
            "F17\n" +
            "W1\n" +
            "L270\n" +
            "F7\n" +
            "W2\n" +
            "N1\n" +
            "F33\n" +
            "N4\n" +
            "F2\n" +
            "N5\n" +
            "R180\n" +
            "F10\n" +
            "W3\n" +
            "L90\n" +
            "S3\n" +
            "E2\n" +
            "S1\n" +
            "F85\n" +
            "N2\n" +
            "F1\n" +
            "R180\n" +
            "F10\n" +
            "N4\n" +
            "W3\n" +
            "S2\n" +
            "R180\n" +
            "N4\n" +
            "W3\n" +
            "S2\n" +
            "S4\n" +
            "L90\n" +
            "E5\n" +
            "N1\n" +
            "F34\n" +
            "S4\n" +
            "W2\n" +
            "W5\n" +
            "F62\n" +
            "S5\n" +
            "E5\n" +
            "S4\n" +
            "F100\n" +
            "L90\n" +
            "W2\n" +
            "F20\n" +
            "S2\n" +
            "E1\n" +
            "R180\n" +
            "F88\n" +
            "N5\n" +
            "F85\n" +
            "N2\n" +
            "R90\n" +
            "N1\n" +
            "E5\n" +
            "F83\n" +
            "R90\n" +
            "W1\n" +
            "R90\n" +
            "E1\n" +
            "F11\n" +
            "E3\n" +
            "F54\n" +
            "N5\n" +
            "L180\n" +
            "F54\n" +
            "R90\n" +
            "S2\n" +
            "E3\n" +
            "L90\n" +
            "E3\n" +
            "N5\n" +
            "R90\n" +
            "W1\n" +
            "S5\n" +
            "R270\n" +
            "F91\n" +
            "E3\n" +
            "F52\n" +
            "W1\n" +
            "F36\n" +
            "W1\n" +
            "N5\n" +
            "F53\n" +
            "E1\n" +
            "R180\n" +
            "N3\n" +
            "F12\n" +
            "L90\n" +
            "S5\n" +
            "F99\n" +
            "S1\n" +
            "R90\n" +
            "S4\n" +
            "R90\n" +
            "S1\n" +
            "W1\n" +
            "N2\n" +
            "L270\n" +
            "W5\n" +
            "F78\n" +
            "S2\n" +
            "R90\n" +
            "F37\n" +
            "W5\n" +
            "R90\n" +
            "E3\n" +
            "S2\n" +
            "E4\n" +
            "L90\n" +
            "S3\n" +
            "W4\n" +
            "F83\n" +
            "L180\n" +
            "S3\n" +
            "R90\n" +
            "F57\n" +
            "W1\n" +
            "S1\n" +
            "L180\n" +
            "W2\n" +
            "N1\n" +
            "R180\n" +
            "N1\n" +
            "L180\n" +
            "W3\n" +
            "S3\n" +
            "R180\n" +
            "E4\n" +
            "F77\n" +
            "N5\n" +
            "S3\n" +
            "W1\n" +
            "N4\n" +
            "F4\n" +
            "N5\n" +
            "F64\n" +
            "W1\n" +
            "R90\n" +
            "N2\n" +
            "W5\n" +
            "L90\n" +
            "N3\n" +
            "L90\n" +
            "F8\n" +
            "L90\n" +
            "F3\n" +
            "S5\n" +
            "F95\n" +
            "R90\n" +
            "W2\n" +
            "F15\n" +
            "L270\n" +
            "F49\n" +
            "R180\n" +
            "S3\n" +
            "F15\n" +
            "N5\n" +
            "L180\n" +
            "S2\n" +
            "F71\n" +
            "S5\n" +
            "F56\n" +
            "W1\n" +
            "F22\n" +
            "F90\n" +
            "E5\n" +
            "F68\n" +
            "N4\n" +
            "R180\n" +
            "N5\n" +
            "E4\n" +
            "F52\n" +
            "E5\n" +
            "L90\n" +
            "E3\n" +
            "F69\n" +
            "W4\n" +
            "S3\n" +
            "L90\n" +
            "N4\n" +
            "R90\n" +
            "F19\n";

    private static final String INPUT2 = "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "F11";

    public static void main(String[] args) {
        List<String> cmds = Arrays.asList(INPUT.split("\n").clone());
        int x = 0;
        int y = 0;
        int wx = 10;
        int wy = -1;
        for (String cmd : cmds) {
            System.out.println(cmd);
            int v = Integer.parseInt(cmd.substring(1));
            if (cmd.charAt(0) == 'N') {
                wy -= v;
            } else if (cmd.charAt(0) == 'S') {
                wy += v;
            } else if (cmd.charAt(0) == 'E') {
                wx += v;
            } else if (cmd.charAt(0) == 'W') {
                wx -= v;
            } else if (cmd.charAt(0) == 'F') {
                x += v*wx;
                y += v*wy;
            } else if (cmd.charAt(0) == 'L') {
                v = v % 360;
                for (int c = 0; c < (v/90); c++) {
                    int t = wx;
                    wx = wy;
                    wy = -t;
                }
            } else if (cmd.charAt(0) == 'R') {
                v = v % 360;
                for (int c = 0; c < (v/90); c++) {
                    int t = wx;
                    wx = -wy;
                    wy = t;
                }
            }
            System.out.println("x=" + x + ",y=" + y + ",wx=" + wx + ",wy=" + wy);
        }
        System.out.println(x + "," + y);
        System.out.println(Math.abs(x) + Math.abs(y));
    }

    /*
    x=10,y=-1  L90 -> x=-1,y=-10
    x=-1,y=-10 L90 -> x=-10,y=1
    x=-10,y=1  L90 -> x=1,y=10
    x=1,y=10   L90 -> x=10,y=-1
    t = x
    x = y
    y = -t

    x=10,y=-1 R90 -> x=1,y=10
    x=1,y=10  R90 -> x=-10,y=1
    t = x
    x = -y
    y = t
     */
}