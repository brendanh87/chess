import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * It's time for Tetris! This is the  main class to get things started.
 *
 * The main method of this application calls the start method. You
 * will need to fill in the start method to instantiate your game.
 */

public class App extends Application {

    /**
     * The start method makes an instance of the PaneOrganizer class, sets the Scene, and shows it.
     */
    @Override
    public void start(Stage stage) {
        // Create top-level object, set up the scene, and show the stage here.
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), Constants.STAGE_WIDTH, Constants.STAGE_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Chess!");
        stage.show();
    }

    /*
     * Here is the mainline! No need to change this.
     */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}