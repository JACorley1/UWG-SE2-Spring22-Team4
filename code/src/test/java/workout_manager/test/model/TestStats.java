package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import workout_manager.model.Stats;

public class TestStats {
    @Test
    void testValidConstruction() {
        Map<String, Double> weightMap = new HashMap<String, Double>();
        Map<String, Double> completionMap = new HashMap<String, Double>();
        Map<String, Integer> pointsMap = new HashMap<String, Integer>();
        weightMap.put("2", 2.0);
        completionMap.put("1", 2.0);
        pointsMap.put("2", 2);
        Stats stats = new Stats(weightMap, completionMap, pointsMap);

        assertAll(
                () -> assertEquals(stats.getWeightOverTime().size(), weightMap.size()),
                () -> assertEquals(stats.getWorkoutCompletionOverTime().size(), completionMap.size()),
                () -> assertEquals(stats.getFitnessPointsOverTime().size(), pointsMap.size()));
    }

    @Test
    void testTotalFitnessPointsGained() {
        Stats stats = new Stats();
        Date date = new Date();
        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        new Date();
        Date date2 = Date.from(yesterday);
        stats.addFitnessPoints(date2, 5);
        stats.addFitnessPoints(date, 2);  

        assertEquals(stats.totalFitnessPointsGained(), 7);
    }

    @Test
    void testAverageCompletionTime() {
        Stats stats = new Stats();
        Date date = new Date();
        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        new Date();
        Date date2 = Date.from(yesterday);
        stats.addExerciseCompletiton(date2, 2.0);
        stats.addExerciseCompletiton(date, 2.0);  

        assertEquals(stats.getAverageWorkoutTime(), 2.0);

    }
}
