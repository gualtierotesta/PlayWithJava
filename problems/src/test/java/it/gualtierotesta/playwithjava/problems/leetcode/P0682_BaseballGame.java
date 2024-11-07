package it.gualtierotesta.playwithjava.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class P0682_BaseballGame {

    @Test
    void test01() {
        Assertions.assertEquals(30, calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    private static int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String operation : operations) {
            switch (operation) {
                case "D":
                    int previous = stack.peekLast();
                    stack.add(previous * 2);
                    System.out.println("D stack = " + stack);
                    break;
                case "C":
                    stack.removeLast();
                    System.out.println("C stack = " + stack);
                    break;
                case "+":
                    Iterator<Integer> iterator = stack.descendingIterator();
                    int p1 = iterator.next();
                    int p2 = iterator.next();
                    stack.add(p1 + p2);
                    System.out.println("+ stack = " + stack);
                    break;
                default:
                    stack.add(Integer.valueOf(operation));
                    System.out.println("* stack = " + stack);
                    break;
            }
        }
        System.out.println("stack = " + stack);
        return stack.stream().reduce(0, Integer::sum);
    }
}
