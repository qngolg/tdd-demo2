package com.test.game;

public class TicTacTeo {

    private char[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };
    private char lastPlayer;

    public String play(int x, int y) {
        checkAxis(x, "x outside board");
        checkAxis(y, "y outside board");
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWins()) {
            return lastPlayer + " is winner";
        } else if (isDraw()) {
            return "the result is draw";
        }
        return "No Winner";
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWins() {
        for (int i = 0; i < 3; i++) {

            //水平线
            if (board[0][i] == lastPlayer && board[1][i] == lastPlayer && board[2][i] == lastPlayer) {
                return true;
            }

            //垂直线
            if (board[i][0] == lastPlayer && board[i][1] == lastPlayer && board[i][2] == lastPlayer) {
                return true;
            }

            //主水平线
            if (board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer) {
                return true;
            }

            //主水平线
            if (board[2][0] == lastPlayer && board[1][1] == lastPlayer && board[0][2] == lastPlayer) {
                return true;
            }


        }
        return false;
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("box is occupied");
        }
        board[x - 1][y - 1] = lastPlayer;
    }

    private void checkAxis(int x, String s) {
        if (x < 1 || x > 3) {
            throw new RuntimeException(s);
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    public void test(){
        System.out.println("aaaa");
    }
}
