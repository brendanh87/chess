package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Constants;

public class Queen implements Piece{

    private Image queen;
    private Pane gamePane;

    public Queen(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;

        if (isBlack) {
            this.queen = new Image("pics/Chess_qdt60.png");
        } else {
            this.queen = new Image("pics/Chess_qlt60.png");
        }
        ImageView imageView = new ImageView(this.queen);

        imageView.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        imageView.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(imageView);
    }
    
    @Override
    public void move() {
        
    }
}
