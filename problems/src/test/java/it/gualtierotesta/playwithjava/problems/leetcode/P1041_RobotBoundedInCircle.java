package it.gualtierotesta.playwithjava.problems.leetcode;

public class P1041_RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int posX = 0;
        int posY = 0;
        char dir = 'N';
        int loops = 0;
        while (loops < 100) {
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    if (dir == 'N')
                        posX++;
                    if (dir == 'S')
                        posX--;
                    if (dir == 'E')
                        posY++;
                    if (dir == 'W')
                        posY--;
                } else {
                    if (dir == 'N')
                        dir = c == 'L' ? 'W' : 'E';
                    else if (dir == 'S')
                        dir = c == 'L' ? 'E' : 'W';
                    else if (dir == 'E')
                        dir = c == 'L' ? 'N' : 'S';
                    else if (dir == 'W')
                        dir = c == 'L' ? 'S' : 'N';
                }
            }
            if (posX == 0 && posY == 0)
                return true;
            loops++;
        }
        return false;
    }

}
