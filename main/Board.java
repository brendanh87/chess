package main;

import javafx.scene.layout.Pane;

public class Board {

    private Square[][] board;
    private Pane gamePane;

    public Board(Pane gamePane) {
        this.gamePane = gamePane;
        this.boardSetup();
    }

    private void boardSetup() {
        board = new Square[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean isGreen;
                if (row % 2 == col % 2) {
                    isGreen = false;
                } else {
                    isGreen = true;
                }
                board[row][col] = new Square(this.gamePane, row * Constants.SQUARE_SIZE, col * Constants.SQUARE_SIZE, isGreen);
            }
        }
    }
    
}
