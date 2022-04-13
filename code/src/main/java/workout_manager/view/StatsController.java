package workout_manager.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;

public class StatsController {

    @FXML
    private Button backButton;

    @FXML
    private LineChart<?, ?> fitnessTrackingChart;

    @FXML
    private LineChart<?, ?> weightTrackingChart;

    @FXML
    void handleBackButton(ActionEvent event) {

    }

}
