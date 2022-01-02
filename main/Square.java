package main;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
This class models one of 64 squares on the chessboard.
It is a wrapper class for a Rectangle.
*/

public class Square {

    // the wrapped Rectangle
    private Rectangle square;

    public Square(Pane gamePane, double x, double y, boolean isGreen) {
        // create the square based on the passed in information
        square = new Rectangle(x, y, Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        if (isGreen) {
            square.setFill(Color.GREEN);
        } else {
            square.setFill(Color.BEIGE);
        }
        // add the square to the gamePane
        gamePane.getChildren().add(this.square);
    }
}
