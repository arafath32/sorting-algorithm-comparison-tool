package sorter;

public class PerformanceResult {
    private String algorithmName;
    private double timeMs;
    private int stepCount;

    public PerformanceResult(String algorithmName, double timeMs, int stepCount) {
        this.algorithmName = algorithmName;
        this.timeMs = timeMs;
        this.stepCount = stepCount;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public double getTimeMs() {
        return timeMs;
    }

    public int getStepCount() {
        return stepCount;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-10.3f ms | %d steps", algorithmName, timeMs, stepCount);
    }
}
