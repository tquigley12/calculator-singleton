package singleton.work;

public class ThreadSafeCalcTool {

    private static final ThreadSafeCalcTool INSTANCE = new ThreadSafeCalcTool();
    
    private static int totalBMICalculated = 0;
    private static int numberOfCaculations = 0;

    public static double calcBMI(double height, double weight, MeasurementSystem measurementSystem) {
        double bmi = weight / Math.pow(height, 2);
        if (measurementSystem == MeasurementSystem.ENGLISH) {
            bmi *= 703;
        }
        totalBMICalculated += bmi;
        numberOfCaculations++;

        return bmi;
    }

    public static double averageBMI() {
        return totalBMICalculated / numberOfCaculations;
    }

    public static ThreadSafeCalcTool getInstance() {
        return INSTANCE;
    }
    
}
