package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Constants;

public class Pawn implements Piece {

    private Image pawn;
    private Pane gamePane;

    public Pawn(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;

        if (isBlack) {
            this.pawn = new Image("pics/Chess_pdt60.png");
        } else {
            this.pawn = new Image("pics/Chess_plt60.png");
        }
        ImageView imageView = new ImageView(this.pawn);

        imageView.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        imageView.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(imageView);
    }

    public void move() {

    }
}
