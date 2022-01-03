package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Constants;

public class Rook implements Piece{

    private Image rook;
    private Pane gamePane;

    public Rook(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;

        if (isBlack) {
            this.rook = new Image("pics/Chess_rdt60.png");
        } else {
            this.rook = new Image("pics/Chess_rlt60.png");
        }
        ImageView imageView = new ImageView(this.rook);

        imageView.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        imageView.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(imageView);
    }
    
    @Override
    public void move() {

    }
}
