package main;

import javafx.scene.layout.Pane;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Board {

    private Square[][] board;
    private Pane gamePane;

    public Board(Pane gamePane) {
        this.gamePane = gamePane;
        this.board = new Square[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        this.boardSetup();
    }

    private void boardSetup() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                boolean isGreen;
                if (row % 2 == col % 2) {
                    isGreen = false;
                } else {
                    isGreen = true;
                }
                Square square = new Square(this.gamePane, row, col, isGreen);
                this.board[row][col] = square;
                if (col == 0) {
                    if (row == 0 || row == 7) {
                        square.setPiece(new Rook(this.gamePane, row, col, true));
                    } else if (row == 1 || row == 6) {
                        square.setPiece(new Knight(this.gamePane, row, col, true));
                    } else if (row == 2 || row == 5) {
                        square.setPiece(new Bishop(this.gamePane, row, col, true));
                    } else if (row == 3) {
                        square.setPiece(new Queen(this.gamePane, row, col, true));
                    } else {
                        square.setPiece(new King(this.gamePane, row, col, true));
                    }
                } else if (col == 1) {
                    square.setPiece(new Pawn(this.gamePane, row, col, true));
                } else if (col == 6) {
                    square.setPiece(new Pawn(this.gamePane, row, col, false));
                } else if (col == 7) {
                    if (row == 0 || row == 7) {
                        square.setPiece(new Rook(this.gamePane, row, col, false));
                    } else if (row == 1 || row == 6) {
                        square.setPiece(new Knight(this.gamePane, row, col, false));
                    } else if (row == 2 || row == 5) {
                        square.setPiece(new Bishop(this.gamePane, row, col, false));
                    } else if (row == 3) {
                        square.setPiece(new Queen(this.gamePane, row, col, false));
                    } else {
                        square.setPiece(new King(this.gamePane, row, col, false));
                    }
                }
            }
        }
    }
    
}
