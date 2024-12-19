package com.echo8.aoc2020;

import java.time.LocalDateTime;
import java.util.*;

public class Day23Part2b {
    private static final String INPUT = "962713854";

    private static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "{" + value +
                    ", next=" + next.value +
                    ", prev=" + prev.value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        int max = 0;
        for (int i = 0; i < INPUT.length(); i++) {
            int value = Integer.parseInt(Character.toString(INPUT.charAt(i)));
            if (head == null) {
                head = new Node(value, null, null);
                head.next = head;
                tail = head;
                head.prev = tail;
            } else {
                Node n = new Node(value, null, null);
                n.prev = tail;
                n.next = head;
                tail.next = n;
                tail = n;
            }
            max = Math.max(max, value);
        }
        for (int i = max+1; i <= 1000000; i++) {
            Node n = new Node(i, null, null);
            n.prev = tail;
            n.next = head;
            tail.next = n;
            tail = n;
        }

//        Node cur = head;
//        do {
//            System.out.println(cur.value);
//            cur = cur.next;
//        } while (cur != head);

//        Node c2 = head;
//        do {
//            System.out.print(c2.value + ", ");
//            c2 = c2.next;
//        } while (c2 != head);
//        System.out.println();

        Node curCup = head;
        for (int move = 0; move < 10000000; move++) {
//        for (int move = 0; move < 10; move++) {
            if (move % 1000 == 0) {
                System.out.println(LocalDateTime.now().toString() + " " + move);
            }
//            System.out.println("CurCup=" + curCup.value);
            Set<Integer> pickupCupSet = new HashSet<>();
            List<Integer> pickupCups = new ArrayList<>();
            Node cur = curCup.next;
            for (int i = 0; i < 3; i++) {
                pickupCupSet.add(cur.value);
                pickupCups.add(cur.value);
                if (cur == head) {
                    head = cur.next;
                } else if (cur == tail) {
                    tail = cur.prev;
                }
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur = cur.next;
            }
//            System.out.println("CurCup.next=" + curCup.next.value);
            Node destCup = getDestCup(curCup, pickupCupSet);
            for (Integer value : pickupCups) {
                Node n = new Node(value, null, null);
                n.prev = destCup.next.prev;
                n.next = destCup.next;
                destCup.next = n;
                n.next.prev = n;
                destCup = destCup.next;
            }
            curCup = curCup.next;

//            Node c = head;
//            do {
//                System.out.print(c + ", ");
//                c = c.next;
//            } while (c != head);
//            System.out.println();
        }

//        int oneIdx = cups.indexOf(1);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < cups.size(); i++) {
//            int pos = oneIdx+i;
//            if (pos >= cups.size()) {
//                pos = pos - cups.size();
//            }
//            sb.append(cups.get(pos));
//        }
//        System.out.println(sb.toString());
    }

    private static Node getDestCup(Node curCup, Set<Integer> pickupCups) {
        int lookingForValue = curCup.value-1;
        while (pickupCups.contains(lookingForValue)) {
            lookingForValue--;
        }
        if (lookingForValue < 1) {
            lookingForValue = 1000000;
        }
//        System.out.println("Looking for: " + lookingForValue);
        Node destCup = curCup;
        while (destCup.value != lookingForValue) {
            destCup = destCup.next;
        }
        return destCup;
    }
}
