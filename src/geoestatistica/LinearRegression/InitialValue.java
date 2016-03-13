package geoestatistica.LinearRegression;

import static geoestatistica.Statistics.Average.arithmeticAverage;
import java.util.ArrayList;

public class InitialValue {
    public static double getInitialValue(double averageX, double averageY,
            double inclination) {
        return averageY - inclination * averageX;
    }

    public static double getInitialValue(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY, double inclination) {
        double avgY = arithmeticAverage(arrayY);
        double avgX = arithmeticAverage(arrayX);
        return avgY - inclination * avgX;
    }
}
