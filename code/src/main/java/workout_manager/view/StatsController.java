package workout_manager.view;

import java.io.IOException;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import workout_manager.Main;
import workout_manager.model.Stats;
import workout_manager.viewmodel.ModelControllerManager;

public class StatsController {
    private ModelControllerManager mcm;
    private Stats userStats;

    @FXML
    private Button backButton;

    @FXML
    private LineChart<String, Double> fitnessTrackingChart;

    @FXML
    private LineChart<String, Double> weightTrackingChart;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(Main.WEEKLY_VIEW_PAGE));
        Parent parent = loader.load();
        WeeklyViewController wvc = loader.<WeeklyViewController>getController();
        wvc.initParams(this.mcm);
        Scene scene = new Scene(parent);
        stage.setTitle(Main.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

    }

    private void populateWeightChartData() {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        for (Map.Entry<String, Double> currentEntry : this.userStats.getWeightOverTime().entrySet()) {
            series.getData().add(new XYChart.Data<String, Double>(currentEntry.getKey(), currentEntry.getValue()));
        }
        this.weightTrackingChart.getData().add(series);
    }

    private void populateFitnessChartData() {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        for (Map.Entry<String, Double> currentEntry : this.userStats.getWorkoutCompletionOverTime().entrySet()) {
            series.getData().add(new XYChart.Data<String, Double>(currentEntry.getKey(), currentEntry.getValue()));
        }
        this.fitnessTrackingChart.getData().add(series);
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
        this.userStats = mcm.getUserStats();
        this.populateWeightChartData();
        this.populateFitnessChartData();
    }

}
