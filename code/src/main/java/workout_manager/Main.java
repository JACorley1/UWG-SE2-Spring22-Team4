package workout_manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import workout_manager.model.Client;
import workout_manager.view.LoginController;
import workout_manager.viewmodel.ModelControllerManager;
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
    public static final String WEEKLY_VIEW_PAGE = "view/codebehind/WeeklyView.fxml";
    public static final String DAILY_DETAILS_PAGE = "view/codebehind/DailyDetailsPage.fxml";
    public static final String USER_FILE_PATH = "src/main/java/workout_manager/model/userFile.json";
    private ModelControllerManager mcm;

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

        this.mcm = new ModelControllerManager(USER_FILE_PATH);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Main.LOGIN_PAGE));
        Parent parent = loader.load();

        LoginController login = loader.<LoginController>getController();
        login.initParams(this.mcm);

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
