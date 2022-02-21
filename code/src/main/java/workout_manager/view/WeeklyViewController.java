package workout_manager.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import workout_manager.Main;
import javafx.scene.shape.Rectangle;

public class WeeklyViewController {

    @FXML
    private AnchorPane weeklyViewAnchorPane;

    @FXML
    private GridPane weeklyViewGridPane;

    @FXML
    private Circle sundayCircle;

    @FXML
    private Circle mondayCircle;

    @FXML
    private Circle tuesdayCircle;

    @FXML
    private Circle wednesdayCircle;

    @FXML
    private Circle thursdayCircle;

    @FXML
    private Circle fridayCircle;

    @FXML
    private Circle saturdayCircle;

    @FXML
    private Rectangle preferencesPageButton;

    @FXML
    void handleShowWorkoutDetail(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.weeklyViewGridPane.getScene().getWindow();
        Parent parent = FXMLLoader.load(Main.class.getResource(Main.DAILY_DETAILS_PAGE));
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleNavigateToPreferencesPage(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.weeklyViewGridPane.getScene().getWindow();
        Parent parent = FXMLLoader.load(Main.class.getResource(Main.PREFERENCE_PAGE));
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}
