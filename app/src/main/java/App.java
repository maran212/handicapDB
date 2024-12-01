/**
 * An application to track and help organize wood chopping shows and athletes handicaps.
 * Using javafx for the GUI and SQLite for the database.
 * 
 * @author  Angus J. Martin
 * @version 1.0
 * @since   2024-12-01
 */

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class for the application.
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned, and after the system is ready for the application to begin running.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }
}
