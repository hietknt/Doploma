import ru.diploma.algorithm.OperatingSystem;
import ru.diploma.algorithm.basic.MetricType;
import ru.diploma.algorithm.basic.NeuronInitializeType;
import ru.diploma.algorithm.basic.NormalizationType;
import ru.diploma.algorithm.training_algorithms.TrainingAlgorithm;
import ru.diploma.algorithm.training_algorithms.TrainingAlgorithmType;

public class StartPoint {

    private static final int iterationCountSize = 10;

    public static void main(String[] args) {
        OneIterationStart();
        //ManyIterationStart();
    }

    public static void OneIterationStart() {
        new Training().setParams(
                TrainingAlgorithmType.GREEDY_HEURISTICS,
                OperatingSystem.WINDOWS,
                NeuronInitializeType.KMEANS,
                NormalizationType.DEFAULT,
                MetricType.MAHALANOBIS,
                3,
                0.5,
                0.005,
                100,
                2,
                "/bigData.txt", // Starts with "/" and ends with ".txt"
                ""
        ).start();
    }

    public static void ManyIterationStart() {
        for (int i = 0; i < iterationCountSize; i++) {
            new Training().setParams(
                    TrainingAlgorithmType.KOHONEN_SOM,
                    OperatingSystem.WINDOWS,
                    NeuronInitializeType.RANDOM,
                    NormalizationType.DEFAULT,
                    MetricType.EUCLIDEAN,
                    3,
                    0.7,
                    0.005,
                    100,
                    1,
                    "/bigData.txt", // Starts with "/" and ends with ".txt"
                    String.valueOf(i)
            ).start();
        }
    }
}
