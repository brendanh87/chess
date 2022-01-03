package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Constants;

public class King implements Piece{

    private Image king;
    private Pane gamePane;

    public King(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;

        if (isBlack) {
            this.king = new Image("pics/Chess_kdt60.png");
        } else {
            this.king = new Image("pics/Chess_klt60.png");
        }
        ImageView imageView = new ImageView(this.king);

        imageView.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        imageView.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(imageView);
    }

    @Override
    public void move() {

    }
    
}
