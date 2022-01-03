package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Constants;

public class Bishop implements Piece {

    private Image bishop;
    private Pane gamePane;

    public Bishop(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;

        if (isBlack) {
            this.bishop = new Image("pics/Chess_bdt60.png");
        } else {
            this.bishop = new Image("pics/Chess_blt60.png");
        }
        ImageView imageView = new ImageView(this.bishop);

        imageView.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        imageView.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(imageView);
    }

    @Override
    public void move() {

    }
    
}
