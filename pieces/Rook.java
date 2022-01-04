package pieces;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Constants;
import main.Square;

public class Rook implements Piece{

    private ImageView rook;
    private Pane gamePane;
    private int x;
    private int y;
    private boolean isBlack;

    public Rook(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;
        this.isBlack = isBlack;
        this.x = x;
        this.y = y;
        Image image;
        if (isBlack) {
            image = new Image("pics/Chess_rdt60.png");
        } else {
            image = new Image("pics/Chess_rlt60.png");
        }
        this.rook = new ImageView(image);

        this.rook.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        this.rook.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(this.rook);
    }
    
    @Override
    public ArrayList<Square> move(Square[][] board) {
        ArrayList<Square> possible = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i - this.x == 0 || j - this.y == 0) && board[i][j].getPiece() == null) {
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
        this.gamePane.getChildren().add(this.rook);
    }

    @Override
    public void removeFromPane() {
        this.gamePane.getChildren().remove(this.rook);
    }

    @Override
    public boolean getIsBlack() {
        return this.isBlack;
    }
}
