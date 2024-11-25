package it.gualtierotesta.playwithjava.problems.leetcode;

public class P1275_FindWinnerTicTacToe {

    public String tictactoe(int[][] moves) {
        String winner = "A";
        char[][] grid = new char[3][3];
        for (int m = 0; m < moves.length; m++) {
            int[] move = moves[m];
            char c = winner.equals("A") ? 'X' : '0';
            grid[move[0]][move[1]] = c;
            if (checkWinner(grid)) {
                return winner;
            }
            winner = winner.equals("A") ? "B" : "A";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean checkWinner(char[][] grid) {
        char empty = (char) 0;
        // Column 0
        if (grid[0][0] != empty && grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0])
            return true;
        // Column 1
        if (grid[0][1] != empty && grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1])
            return true;
        // Column 2
        if (grid[0][2] != empty && grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2])
            return true;
        // Row 0
        if (grid[0][0] != empty && grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2])
            return true;
        // Row 1
        if (grid[1][0] != empty && grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2])
            return true;
        // Row 2
        if (grid[2][0] != empty && grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2])
            return true;
        // Primary diagonal
        if (grid[0][0] != empty && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
            return true;
        // Secundary diagonal
        if (grid[0][2] != empty && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])
            return true;
        return false;
    }
}
