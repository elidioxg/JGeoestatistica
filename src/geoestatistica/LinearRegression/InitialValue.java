package geoestatistica.LinearRegression;

import static geoestatistica.Statistics.Average.arithmeticAverage;
import geoestatistica.Vectors.Vector;
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
    
    public static double getInitialValue(Vector vector1,
            Vector vector2, double inclination) {
        double avgY = arithmeticAverage(vector2);
        double avgX = arithmeticAverage(vector1);
        return avgY - inclination * avgX;
    }
}
