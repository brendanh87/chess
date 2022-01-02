package main;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.Piece;

/*
This class models one of 64 squares on the chessboard.
It is a wrapper class for a Rectangle.
*/

public class Square {

    // the wrapped Rectangle
    private Rectangle square;
    private Piece piece;

    public Square(Pane gamePane, double x, double y, boolean isGreen) {
        // create the square based on the passed in information
        this.square = new Rectangle(x, y, Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        if (isGreen) {
            this.square.setFill(Color.GREEN);
        } else {
            this.square.setFill(Color.BEIGE);
        }
        // add the square to the gamePane
        gamePane.getChildren().add(this.square);
        // set the piece
        this.piece = null;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
