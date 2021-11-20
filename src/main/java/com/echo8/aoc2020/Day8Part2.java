package com.echo8.aoc2020;

import java.util.*;

public class Day8Part2 {
    private static final String INPUT = "acc -7\n" +
            "acc +2\n" +
            "acc +20\n" +
            "acc +14\n" +
            "jmp +191\n" +
            "acc +47\n" +
            "nop +339\n" +
            "acc +49\n" +
            "jmp +104\n" +
            "jmp +629\n" +
            "jmp +374\n" +
            "acc +24\n" +
            "jmp +220\n" +
            "nop +474\n" +
            "acc +25\n" +
            "jmp +340\n" +
            "acc +16\n" +
            "acc +3\n" +
            "acc +41\n" +
            "jmp +566\n" +
            "jmp +296\n" +
            "acc +15\n" +
            "jmp +452\n" +
            "acc +21\n" +
            "jmp +129\n" +
            "acc +10\n" +
            "acc -8\n" +
            "acc +39\n" +
            "jmp +396\n" +
            "acc +5\n" +
            "acc -4\n" +
            "acc +0\n" +
            "jmp +496\n" +
            "nop +181\n" +
            "acc +48\n" +
            "acc +7\n" +
            "jmp +1\n" +
            "jmp +370\n" +
            "acc +16\n" +
            "acc -18\n" +
            "acc +47\n" +
            "acc +48\n" +
            "jmp +99\n" +
            "nop +17\n" +
            "acc +25\n" +
            "acc -15\n" +
            "jmp +285\n" +
            "nop +545\n" +
            "nop +147\n" +
            "nop +479\n" +
            "acc -4\n" +
            "jmp +386\n" +
            "acc +36\n" +
            "acc -12\n" +
            "jmp +50\n" +
            "acc +37\n" +
            "nop +133\n" +
            "acc +11\n" +
            "acc +20\n" +
            "jmp +32\n" +
            "jmp +1\n" +
            "nop +210\n" +
            "acc -15\n" +
            "acc -6\n" +
            "jmp +446\n" +
            "acc +25\n" +
            "acc +1\n" +
            "acc +17\n" +
            "acc -4\n" +
            "jmp +355\n" +
            "acc -4\n" +
            "jmp +292\n" +
            "acc +16\n" +
            "acc +44\n" +
            "acc +26\n" +
            "jmp +157\n" +
            "acc -18\n" +
            "acc +15\n" +
            "acc -8\n" +
            "acc -3\n" +
            "jmp +46\n" +
            "acc +30\n" +
            "acc +16\n" +
            "jmp -7\n" +
            "acc +34\n" +
            "jmp +515\n" +
            "acc +11\n" +
            "acc -8\n" +
            "acc -9\n" +
            "acc -3\n" +
            "jmp +548\n" +
            "jmp +278\n" +
            "nop +332\n" +
            "acc -19\n" +
            "acc +49\n" +
            "jmp +536\n" +
            "acc -9\n" +
            "acc +46\n" +
            "jmp +124\n" +
            "acc +41\n" +
            "acc +47\n" +
            "acc -5\n" +
            "acc -13\n" +
            "jmp +41\n" +
            "nop +178\n" +
            "acc +12\n" +
            "acc +45\n" +
            "jmp +461\n" +
            "acc +37\n" +
            "acc +12\n" +
            "acc +38\n" +
            "jmp -68\n" +
            "acc -6\n" +
            "nop +494\n" +
            "acc -9\n" +
            "jmp -63\n" +
            "acc +42\n" +
            "acc +16\n" +
            "acc +30\n" +
            "jmp +70\n" +
            "acc +13\n" +
            "jmp +1\n" +
            "acc -18\n" +
            "jmp +528\n" +
            "acc +48\n" +
            "jmp +493\n" +
            "nop +402\n" +
            "jmp +381\n" +
            "acc -8\n" +
            "jmp +372\n" +
            "acc +20\n" +
            "acc +25\n" +
            "jmp +425\n" +
            "acc -10\n" +
            "jmp +510\n" +
            "jmp +439\n" +
            "nop +78\n" +
            "acc +36\n" +
            "acc +7\n" +
            "nop +281\n" +
            "jmp +504\n" +
            "jmp -108\n" +
            "acc +40\n" +
            "jmp -122\n" +
            "acc +23\n" +
            "acc -2\n" +
            "acc +7\n" +
            "jmp +370\n" +
            "acc +25\n" +
            "nop -5\n" +
            "acc +33\n" +
            "acc +37\n" +
            "jmp +70\n" +
            "acc -6\n" +
            "nop +336\n" +
            "jmp +34\n" +
            "jmp +1\n" +
            "acc -18\n" +
            "jmp +473\n" +
            "jmp +1\n" +
            "acc +20\n" +
            "acc +4\n" +
            "acc +25\n" +
            "jmp -87\n" +
            "acc -12\n" +
            "acc +47\n" +
            "acc +49\n" +
            "jmp +323\n" +
            "jmp +1\n" +
            "jmp +1\n" +
            "jmp +167\n" +
            "acc -10\n" +
            "acc +45\n" +
            "jmp +355\n" +
            "acc +32\n" +
            "acc +38\n" +
            "acc +2\n" +
            "jmp -93\n" +
            "acc +8\n" +
            "acc +20\n" +
            "acc +4\n" +
            "acc -1\n" +
            "jmp +108\n" +
            "nop +164\n" +
            "acc +41\n" +
            "jmp +440\n" +
            "acc -16\n" +
            "acc +47\n" +
            "jmp +355\n" +
            "acc -13\n" +
            "acc +29\n" +
            "acc +50\n" +
            "jmp -101\n" +
            "acc -8\n" +
            "jmp +316\n" +
            "acc +27\n" +
            "acc +31\n" +
            "nop -29\n" +
            "jmp +1\n" +
            "jmp +250\n" +
            "acc +12\n" +
            "acc -13\n" +
            "jmp +73\n" +
            "jmp +72\n" +
            "acc +36\n" +
            "acc +44\n" +
            "jmp +1\n" +
            "jmp -33\n" +
            "acc -18\n" +
            "acc +16\n" +
            "acc -8\n" +
            "acc +6\n" +
            "jmp +104\n" +
            "jmp +295\n" +
            "acc +10\n" +
            "nop -80\n" +
            "jmp +74\n" +
            "acc -13\n" +
            "jmp +1\n" +
            "acc +22\n" +
            "acc +50\n" +
            "jmp +280\n" +
            "jmp +265\n" +
            "jmp +278\n" +
            "acc +46\n" +
            "acc -14\n" +
            "acc -17\n" +
            "jmp -19\n" +
            "acc +39\n" +
            "acc +31\n" +
            "acc -11\n" +
            "jmp +400\n" +
            "jmp +80\n" +
            "acc +0\n" +
            "acc +27\n" +
            "nop +209\n" +
            "jmp -184\n" +
            "acc +12\n" +
            "acc +21\n" +
            "acc +23\n" +
            "jmp +352\n" +
            "acc +29\n" +
            "jmp -5\n" +
            "acc +15\n" +
            "acc +7\n" +
            "jmp +6\n" +
            "acc +31\n" +
            "acc -5\n" +
            "nop +83\n" +
            "acc +31\n" +
            "jmp -239\n" +
            "acc +8\n" +
            "acc -2\n" +
            "acc +49\n" +
            "acc -12\n" +
            "jmp -52\n" +
            "acc -15\n" +
            "acc -14\n" +
            "jmp +126\n" +
            "jmp +385\n" +
            "acc +30\n" +
            "acc -5\n" +
            "acc +6\n" +
            "jmp -187\n" +
            "acc +39\n" +
            "acc +40\n" +
            "acc +0\n" +
            "acc +6\n" +
            "jmp +24\n" +
            "acc +20\n" +
            "jmp +131\n" +
            "jmp -127\n" +
            "acc +8\n" +
            "acc +30\n" +
            "jmp -265\n" +
            "acc -2\n" +
            "jmp -265\n" +
            "acc +22\n" +
            "acc -19\n" +
            "acc -9\n" +
            "nop +10\n" +
            "jmp +148\n" +
            "acc -14\n" +
            "acc +38\n" +
            "acc +50\n" +
            "acc -7\n" +
            "jmp +197\n" +
            "acc +11\n" +
            "acc +22\n" +
            "jmp +201\n" +
            "jmp -155\n" +
            "jmp -32\n" +
            "acc +48\n" +
            "nop -50\n" +
            "jmp -99\n" +
            "jmp -5\n" +
            "acc +11\n" +
            "acc -18\n" +
            "jmp -186\n" +
            "acc +6\n" +
            "acc +43\n" +
            "jmp +159\n" +
            "jmp +249\n" +
            "acc +44\n" +
            "acc +29\n" +
            "nop +313\n" +
            "acc +23\n" +
            "jmp +311\n" +
            "jmp +152\n" +
            "acc +0\n" +
            "acc +41\n" +
            "jmp -251\n" +
            "jmp +102\n" +
            "nop -17\n" +
            "nop +176\n" +
            "jmp +40\n" +
            "acc +28\n" +
            "jmp -21\n" +
            "acc -4\n" +
            "acc -10\n" +
            "acc -19\n" +
            "acc -15\n" +
            "jmp +23\n" +
            "nop +144\n" +
            "acc +9\n" +
            "acc +18\n" +
            "jmp +141\n" +
            "acc -19\n" +
            "acc -10\n" +
            "acc +48\n" +
            "jmp -7\n" +
            "acc +46\n" +
            "acc -9\n" +
            "jmp -174\n" +
            "acc +30\n" +
            "acc +30\n" +
            "jmp -201\n" +
            "acc +34\n" +
            "acc +24\n" +
            "acc +37\n" +
            "acc +44\n" +
            "jmp -158\n" +
            "acc +4\n" +
            "acc +39\n" +
            "jmp -52\n" +
            "jmp -329\n" +
            "jmp +68\n" +
            "acc +25\n" +
            "nop -105\n" +
            "acc -15\n" +
            "acc +34\n" +
            "jmp -6\n" +
            "jmp +1\n" +
            "acc +1\n" +
            "jmp +163\n" +
            "nop -285\n" +
            "acc +8\n" +
            "acc +48\n" +
            "jmp +143\n" +
            "acc -3\n" +
            "nop -269\n" +
            "acc -16\n" +
            "jmp -310\n" +
            "acc -5\n" +
            "jmp -304\n" +
            "acc +45\n" +
            "nop -231\n" +
            "jmp +1\n" +
            "jmp +245\n" +
            "nop -243\n" +
            "jmp +187\n" +
            "acc -6\n" +
            "acc +7\n" +
            "acc +17\n" +
            "acc +6\n" +
            "jmp -111\n" +
            "acc +24\n" +
            "acc -10\n" +
            "acc +21\n" +
            "jmp -97\n" +
            "jmp +1\n" +
            "acc -12\n" +
            "acc +10\n" +
            "jmp +127\n" +
            "acc +0\n" +
            "jmp -211\n" +
            "acc -11\n" +
            "acc +36\n" +
            "acc +45\n" +
            "acc -19\n" +
            "jmp -182\n" +
            "jmp -366\n" +
            "acc +38\n" +
            "acc -11\n" +
            "acc +32\n" +
            "jmp -260\n" +
            "acc +6\n" +
            "acc +31\n" +
            "jmp +3\n" +
            "acc +5\n" +
            "jmp +101\n" +
            "jmp -64\n" +
            "acc +48\n" +
            "acc +5\n" +
            "nop +40\n" +
            "acc -13\n" +
            "jmp +95\n" +
            "nop +76\n" +
            "acc +44\n" +
            "acc +43\n" +
            "acc +43\n" +
            "jmp +196\n" +
            "acc +34\n" +
            "jmp +161\n" +
            "acc +5\n" +
            "acc +45\n" +
            "acc +7\n" +
            "jmp +20\n" +
            "acc +13\n" +
            "jmp -127\n" +
            "acc +5\n" +
            "acc +18\n" +
            "jmp -239\n" +
            "jmp -76\n" +
            "nop +214\n" +
            "jmp -284\n" +
            "acc +10\n" +
            "acc -8\n" +
            "jmp -81\n" +
            "acc +48\n" +
            "acc -3\n" +
            "jmp -55\n" +
            "nop -288\n" +
            "acc +37\n" +
            "acc +1\n" +
            "acc -12\n" +
            "jmp +1\n" +
            "nop +91\n" +
            "acc +20\n" +
            "acc +18\n" +
            "jmp +4\n" +
            "acc -7\n" +
            "acc -10\n" +
            "jmp -229\n" +
            "nop -230\n" +
            "nop +45\n" +
            "acc +37\n" +
            "jmp +127\n" +
            "jmp +69\n" +
            "jmp -153\n" +
            "acc -15\n" +
            "acc -19\n" +
            "acc +32\n" +
            "jmp -33\n" +
            "nop +164\n" +
            "acc +32\n" +
            "jmp -133\n" +
            "acc +20\n" +
            "acc -8\n" +
            "jmp +8\n" +
            "acc -11\n" +
            "nop +82\n" +
            "acc +7\n" +
            "acc +40\n" +
            "jmp +79\n" +
            "acc +0\n" +
            "jmp +159\n" +
            "acc +4\n" +
            "acc -8\n" +
            "acc +20\n" +
            "nop +143\n" +
            "jmp -351\n" +
            "acc -7\n" +
            "jmp +78\n" +
            "acc +0\n" +
            "acc +4\n" +
            "jmp +20\n" +
            "jmp -3\n" +
            "acc +2\n" +
            "acc +23\n" +
            "jmp -256\n" +
            "acc +33\n" +
            "jmp -473\n" +
            "acc +29\n" +
            "acc -13\n" +
            "jmp +77\n" +
            "jmp +158\n" +
            "acc -16\n" +
            "jmp -10\n" +
            "jmp -181\n" +
            "jmp -135\n" +
            "nop -95\n" +
            "acc +46\n" +
            "acc +39\n" +
            "acc -3\n" +
            "jmp -94\n" +
            "jmp -67\n" +
            "acc +49\n" +
            "nop -78\n" +
            "nop -9\n" +
            "jmp +107\n" +
            "acc -19\n" +
            "acc -1\n" +
            "acc +0\n" +
            "acc -4\n" +
            "jmp -189\n" +
            "acc +11\n" +
            "jmp -106\n" +
            "jmp -200\n" +
            "jmp +122\n" +
            "acc +8\n" +
            "acc +48\n" +
            "acc +15\n" +
            "acc +0\n" +
            "jmp -493\n" +
            "acc +13\n" +
            "jmp -8\n" +
            "acc +36\n" +
            "acc -10\n" +
            "jmp +1\n" +
            "acc +9\n" +
            "jmp +7\n" +
            "jmp +85\n" +
            "acc +22\n" +
            "acc -8\n" +
            "nop -124\n" +
            "jmp -517\n" +
            "jmp -338\n" +
            "acc +39\n" +
            "nop -438\n" +
            "acc -11\n" +
            "jmp +69\n" +
            "acc +8\n" +
            "acc +34\n" +
            "acc +34\n" +
            "acc -9\n" +
            "jmp -205\n" +
            "nop -528\n" +
            "jmp -495\n" +
            "acc +47\n" +
            "acc +40\n" +
            "acc +30\n" +
            "jmp -328\n" +
            "acc -2\n" +
            "acc +41\n" +
            "jmp -475\n" +
            "acc +42\n" +
            "acc +48\n" +
            "acc +2\n" +
            "acc +7\n" +
            "jmp -415\n" +
            "nop -249\n" +
            "acc -3\n" +
            "jmp +65\n" +
            "acc +23\n" +
            "nop -4\n" +
            "jmp -254\n" +
            "acc -12\n" +
            "acc +22\n" +
            "acc +27\n" +
            "jmp -176\n" +
            "jmp -408\n" +
            "acc -15\n" +
            "acc +14\n" +
            "acc +30\n" +
            "acc +0\n" +
            "jmp -363\n" +
            "jmp -426\n" +
            "acc +38\n" +
            "nop -425\n" +
            "jmp -440\n" +
            "jmp +1\n" +
            "acc +22\n" +
            "jmp -63\n" +
            "jmp -406\n" +
            "nop -445\n" +
            "acc -5\n" +
            "acc +34\n" +
            "nop -425\n" +
            "jmp +65\n" +
            "acc +33\n" +
            "jmp -91\n" +
            "acc -12\n" +
            "jmp +1\n" +
            "jmp -541\n" +
            "nop -489\n" +
            "jmp -490\n" +
            "acc +20\n" +
            "acc +20\n" +
            "acc +38\n" +
            "acc -18\n" +
            "jmp -548\n" +
            "acc +43\n" +
            "acc -7\n" +
            "jmp -351\n" +
            "acc -9\n" +
            "acc +50\n" +
            "acc +1\n" +
            "nop -587\n" +
            "jmp -230\n" +
            "jmp +1\n" +
            "nop +43\n" +
            "jmp -65\n" +
            "acc +31\n" +
            "acc +5\n" +
            "acc +1\n" +
            "jmp -105\n" +
            "nop -477\n" +
            "acc +21\n" +
            "nop -92\n" +
            "jmp -263\n" +
            "acc +28\n" +
            "jmp -265\n" +
            "jmp -311\n" +
            "acc +2\n" +
            "acc +23\n" +
            "acc +50\n" +
            "jmp -4\n" +
            "acc +42\n" +
            "acc +42\n" +
            "acc +31\n" +
            "jmp -167\n" +
            "acc +49\n" +
            "acc +46\n" +
            "jmp -73\n" +
            "nop -135\n" +
            "acc +43\n" +
            "jmp -236\n" +
            "acc -14\n" +
            "acc -3\n" +
            "jmp -406\n" +
            "acc +2\n" +
            "acc -3\n" +
            "acc +47\n" +
            "jmp -420\n" +
            "acc -8\n" +
            "acc +18\n" +
            "jmp -604\n" +
            "jmp -218\n" +
            "acc +37\n" +
            "acc -16\n" +
            "nop -278\n" +
            "acc -15\n" +
            "jmp -214\n" +
            "acc -6\n" +
            "acc +18\n" +
            "acc +7\n" +
            "acc +0\n" +
            "jmp -252\n" +
            "acc +14\n" +
            "jmp -266\n" +
            "acc +27\n" +
            "acc -16\n" +
            "nop -533\n" +
            "nop -534\n" +
            "jmp +1\n";

    public static void main(String[] args) {
        List<Command> cmds = parse(Arrays.asList(INPUT.split("\n").clone()));
        for (int i = 0; i < cmds.size(); i++) {
            Command cmd = cmds.get(i);
            if ("nop".equals(cmd.getCmd())) {
                cmd.setCmd("jmp");
                Integer res = runProgram(cmds);
                if (res != null) {
                    System.out.println(res);
                    break;
                } else {
                    cmd.setCmd("nop");
                }
            } else if ("jmp".equals(cmd.getCmd())) {
                cmd.setCmd("nop");
                Integer res = runProgram(cmds);
                if (res != null) {
                    System.out.println(res);
                    break;
                } else {
                    cmd.setCmd("jmp");
                }
            }
        }
    }

    private static Integer runProgram(List<Command> cmds) {
        int accum = 0;
        int curLine = 0;
        Set<Integer> seen = new HashSet<>();
        while (true) {
            if (cmds.size() == curLine) {
                return accum;
            }
            Command cmd = cmds.get(curLine);
            if (!seen.add(curLine)) {
                return null;
            }
            if ("nop".equals(cmd.getCmd())) {
                curLine++;
            } else if ("acc".equals(cmd.getCmd())) {
                accum += cmd.getParam();
                curLine++;
            } else {
                curLine += cmd.getParam();
            }
        }
    }

    private static List<Command> parse(List<String> cmds) {
        List<Command> res = new ArrayList<>();
        for (String cmd : cmds) {
            String[] part = cmd.split(" ");
            res.add(new Command(part[0], Integer.parseInt(part[1])));
        }
        return res;
    }

    private static class Command {
        private String cmd;
        private int param;

        public Command(String cmd, int param) {
            this.cmd = cmd;
            this.param = param;
        }

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }

        public int getParam() {
            return param;
        }

        public void setParam(int param) {
            this.param = param;
        }
    }
}
