package pieces;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Constants;
import main.Square;

public class Queen implements Piece{

    private ImageView queen;
    private Pane gamePane;
    private int x;
    private int y;
    private boolean isBlack;

    public Queen(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;
        this.isBlack = isBlack;
        this.x = x;
        this.y = y;
        Image image;
        if (isBlack) {
            image = new Image("pics/Chess_qdt60.png");
        } else {
            image = new Image("pics/Chess_qlt60.png");
        }
        this.queen = new ImageView(image);

        this.queen.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        this.queen.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(this.queen);
    }
    
    @Override
    public ArrayList<Square> move(Square[][] board) {
        ArrayList<Square> possible = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (((i - this.x == 0 || j - this.y == 0) || (i - this.x == j - this.y)) && board[i][j].getPiece() == null) {
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
        this.gamePane.getChildren().add(this.queen);
    }

    @Override
    public void removeFromPane() {
        this.gamePane.getChildren().remove(this.queen);
    }

    @Override
    public boolean getIsBlack() {
        return this.isBlack;
    }
}
