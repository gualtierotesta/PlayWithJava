package it.gualtierotesta.playwithjava.problems.leetcode;

// https://leetcode.com/problems/robot-return-to-origin

public class P0657_RobotReturnToOrigin {

    record Position(int x, int y) {

        Position update(char c) {
            int newX = x;
            int newY = y;
            switch ((char) c) {
                case 'U' -> newY--;
                case 'D' -> newY++;
                case 'L' -> newX--;
                case 'R' -> newX++;
            }
            return new Position(newX, newY);
        }

        boolean atHome() {
            return x == 0 && y == 0;
        }
    }

    public boolean judgeCircle(String moves) {
        Position current = new Position(0, 0);
        for (char c : moves.toCharArray()) {
            current = current.update(c);
        }
        return current.atHome();
    }
}
