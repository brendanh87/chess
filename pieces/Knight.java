package pieces;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Constants;
import main.Square;

public class Knight implements Piece{

    private ImageView knight;
    private Pane gamePane;
    private int x;
    private int y;
    private boolean isBlack;

    public Knight(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;
        this.isBlack = isBlack;
        Image image;
        if (isBlack) {
            image = new Image("pics/Chess_ndt60.png");
        } else {
            image = new Image("pics/Chess_nlt60.png");
        }
        this.knight = new ImageView(image);

        this.knight.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        this.knight.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(this.knight);
    }
    
    @Override
    public ArrayList<Square> move(Square[][] board) {
        ArrayList<Square> possible = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((Math.abs(i - this.x) + Math.abs(j - this.y) == 3) && (i - this.x != 0 && j - this.y != 0) && board[i][j].getPiece() == null) {
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
        this.gamePane.getChildren().add(this.knight);
    }

    @Override
    public void removeFromPane() {
        this.gamePane.getChildren().remove(this.knight);
    }

    @Override
    public boolean getIsBlack() {
        return this.isBlack;
    }
}
