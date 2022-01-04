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
    private Pane gamePane;

    public Square(Pane gamePane, int x, int y, boolean isGreen) {
        // create the square based on the passed in information
        this.square = new Rectangle(x * Constants.SQUARE_SIZE, y * Constants.SQUARE_SIZE, Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        this.square.setStroke(Color.BLACK);
        if (isGreen) {
            this.square.setFill(Color.GREEN);
        } else {
            this.square.setFill(Color.BEIGE);
        }
        // add the square to the gamePane
        gamePane.getChildren().add(this.square);
        // set the piece
        this.piece = null;
        this.gamePane = gamePane;
    }

    public boolean contains(double x, double y) {
        if (this.square.contains(x, y)) {
            return true;
        }
        return false;
    }

    public void setStrokeColor(Color color) {
        if (this.piece != null) {
            this.piece.removeFromPane();
        }
        this.gamePane.getChildren().remove(this.square);
        this.square.setStroke(color);
        this.gamePane.getChildren().add(this.square);
        if (this.piece != null) {
            this.piece.addToPane();
        }
    }

    public void setStrokeWidth(double width) {
        if (this.piece != null) {
            this.piece.removeFromPane();
        }
        this.gamePane.getChildren().remove(this.square);
        this.square.setStrokeWidth(width);
        this.gamePane.getChildren().add(this.square);
        if (this.piece != null) {
            this.piece.addToPane();
        }
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
