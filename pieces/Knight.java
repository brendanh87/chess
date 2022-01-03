package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Constants;

public class Knight implements Piece{

    private Image knight;
    private Pane gamePane;

    public Knight(Pane gamePane, int x, int y, boolean isBlack) {
        this.gamePane = gamePane;

        if (isBlack) {
            this.knight = new Image("pics/Chess_ndt60.png");
        } else {
            this.knight = new Image("pics/Chess_nlt60.png");
        }
        ImageView imageView = new ImageView(this.knight);

        imageView.setX(x * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);
        imageView.setY(y * Constants.SQUARE_SIZE + Constants.PIECE_OFFSET);

        this.gamePane.getChildren().add(imageView);
    }
    
    @Override
    public void move() {
        
    }
}
