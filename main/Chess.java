package main;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Chess {

    private Square[][] board;
    private Piece selectedPiece;
    private Pane gamePane;
    private Square selected;
    private Click clicked;

    public Chess(Pane gamePane) {
        this.gamePane = gamePane;
        this.selected = null;
        this.selectedPiece = null;
        this.board = new Square[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        this.boardSetup();
        this.clicked = Click.FIRST;
        this.gamePane.setOnMouseClicked((MouseEvent e) -> this.select(e.getX(), e.getY()));
    }

    /**
     * This private method sets up the board initially.
     */
    private void boardSetup() {
        // setting up the squares and pieces
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                // setting the checkered pattern
                boolean isGreen;
                if (row % 2 == col % 2) {
                    isGreen = false;
                } else {
                    isGreen = true;
                }
                Square square = new Square(this.gamePane, row, col, isGreen);
                this.board[row][col] = square;
                // setting up the pieces
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

    private void select(double x, double y) {
        // upon first click
        if (this.clicked == Click.FIRST) {
            if (this.selected != null) {
                this.selected.setStrokeWidth(1);
            }
            for (Square[] row : this.board) {
                for (Square square : row) {
                    if (square.contains(x, y) && square.getPiece() != null) {
                        square.setStrokeWidth(5);
                        this.selected = square;
                        this.selectedPiece = square.getPiece();
                        this.selectedPiece.move(this.board);
                        this.clicked = Click.SECOND;
                    }
                }
            } 
        }
    }
}