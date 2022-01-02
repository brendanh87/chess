package main;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/* 
This class organizes the panes, the visual space our game elements will live on.
*/

public class PaneOrganizer {
    
    private BorderPane root;
    private Pane gamePane;
    private VBox infoPane;

    public PaneOrganizer() {
        this.root = new BorderPane();
        this.gamePane = new Pane();
        this.infoPane = new VBox();

        this.gamePane.setPrefWidth(Constants.GAME_WIDTH);
        this.infoPane.setPrefWidth(Constants.INFO_WIDTH);

        this.gamePane.setStyle(Constants.GAME_COLOR);
        this.infoPane.setStyle(Constants.INFO_COLOR);

        this.root.setCenter(this.gamePane);
        this.root.setLeft(this.infoPane);

        new Chess(this.gamePane);
    }

    public BorderPane getRoot() {
        return root;
    }
}
