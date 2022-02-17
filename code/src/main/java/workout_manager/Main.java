package workout_manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import workout_manager.model.WorkoutDataFetcher;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Entry point for the program
 *
 * @author CS 3211
 * @version Fall 2021
 */
public class Main extends Application {
    public static final String WINDOW_TITLE = "Workout Manager";
    public static final String LOGIN_PAGE = "view/codebehind/LoginPage.fxml";
    public static final String PREFERENCE_PAGE = "view/codebehind/PreferencePage.fxml";

    /**
     * JavaFX entry point.
     *
     * @precondition none
     * @postcondition none
     *
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(Main.LOGIN_PAGE));
        Scene scene = new Scene(parent);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Primary Java entry point.
     *
     * @precondition none
     * @postcondition none
     *
     * @param args
     *             command line arguments
     */
    public static void main(String[] args) {
        Main.launch(args);
    }
}
