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
import workout_manager.viewmodel.ModelControllerManager;
import javafx.scene.shape.Rectangle;

/**
 * the weeklyViewController
 * 
 * @author group4
 */
public class WeeklyViewController {

    private ModelControllerManager mcm;

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
    void initialize() {

    }

    @FXML
    void handleShowWorkoutDetail(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.weeklyViewGridPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.DAILY_DETAILS_PAGE));
        Parent parent = loader.load();

        DailyDetailsController ddc = loader.<DailyDetailsController>getController();
        ddc.initParams(this.mcm);
        Scene scene = new Scene(parent);

        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleNavigateToPreferencesPage(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.weeklyViewGridPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.PREFERENCE_PAGE));
        Parent parent = loader.load();

        PreferenceController pc = loader.<PreferenceController>getController();
        pc.initParams(this.mcm);
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public void initParams(ModelControllerManager mcm) {
        this.mcm = mcm;
    }
}
