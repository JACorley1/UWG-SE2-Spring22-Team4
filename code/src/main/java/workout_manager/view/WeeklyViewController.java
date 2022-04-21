package workout_manager.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import workout_manager.Main;
import workout_manager.model.Days;
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
    private Rectangle preferencesPageButton;

    @FXML
    private Rectangle statsPageButton;

    @FXML
    void initialize() {

    }

    @FXML
    void handleShowWorkoutDetail(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.weeklyViewGridPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.DAILY_DETAILS_PAGE));
        Parent parent = loader.load();

        DailyDetailsController ddc = loader.<DailyDetailsController>getController();
        Circle clickedDay = (Circle) event.getSource();
        ddc.initParams(this.mcm, clickedDay.getId().toString());
        Scene scene = new Scene(parent);

        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleNavigateToStatsPage(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.weeklyViewGridPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.STATS_VIEW_PAGE));
        Parent parent = loader.load();

        StatsController sc = loader.<StatsController>getController();
        sc.initParams(this.mcm);
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

    private void displayWorkoutCalendar() {
        for (Node currentDay : this.weeklyViewGridPane.getChildren()) {
            if (currentDay instanceof Circle && this.checkSelectedDays(currentDay.getId().toUpperCase())) {
                Circle daySelected = (Circle) currentDay;
                daySelected.setFill(Color.GREEN);
            }
        }
    }

    private boolean checkSelectedDays(String dayToCheck) {
        boolean dayPresent = false;
        for (Days currentDay : this.mcm.getCurrentPreferences().getSelectedDays()) {
            if (dayToCheck.contains(currentDay.toString())) {
                dayPresent = true;

            }
        }
        return dayPresent;
    }

    /**
     * initializes this.mcm to the given mcm
     * 
     * @precondition none
     * @postcondition none
     * @param mcm the mcm to be set to
     */
    public void initParams(ModelControllerManager mcm) {
        this.mcm = mcm;
        this.displayWorkoutCalendar();
    }
}
