package pieces;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Constants;
import main.Square;

public class Bishop implements Piece {

    private ImageView bishop;
    private Pane gamePane;
    private int x;
    private int y;
    private boolean isBlack;

    public Bishop(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;
        this.isBlack = isBlack;
        this.x = x;
        this.y = y;
        Image image;
        if (isBlack) {
            image = new Image("pics/Chess_bdt60.png");
        } else {
            image = new Image("pics/Chess_blt60.png");
        }
        this.bishop = new ImageView(image);

        this.bishop.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        this.bishop.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(this.bishop);
    }

    @Override
    public ArrayList<Square> move(Square[][] board) {
        ArrayList<Square> possible = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i - this.x == j - this.y && board[i][j].getPiece() == null) {
                    possible.add(board[i][j]);
                    board[i][j].setStrokeColor(Color.HOTPINK);
                    board[i][j].setStrokeWidth(5);
                }
            }
        }
        return possible;
    }

    @Override
    public void addToPane() {
        this.gamePane.getChildren().add(this.bishop);
    }

    @Override
    public void removeFromPane() {
        this.gamePane.getChildren().remove(this.bishop);
    }

    @Override
    public boolean getIsBlack() {
        return this.isBlack;
    }
    
}
