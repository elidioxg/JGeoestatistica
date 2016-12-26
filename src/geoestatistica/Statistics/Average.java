package geoestatistica.Statistics;

import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

public class Average {
    
    /**
     * Arithmetic Average
     * @param vector
     * @return 
     */
    public static double arithmeticAverage(Vector vector) {
        double sum = 0.;
        for (int i = 0; i <= vector.size() - 1; i++) {
            sum += vector.get(i).doubleValue();
        }
        return sum / (vector.size());
    }

    //TODO: function for arithmetic average using Frequency Table    
    /**
     * 
     * @param vector
     * @return 
     */
    public static double geometricAverage(Vector vector) {
        double prod = 1.;
        for (int i = 0; i <= vector.size() - 1; i++) {
            prod *= vector.get(i).doubleValue();
        }        
        return Math.pow(prod, (1.0 / vector.size()));
    }

    //TODO: function for geometric average using Frequency Table   
    
    /**
     * 
     * @param vector
     * @return 
     */
    public static double arithmeticAverage(ArrayList<Double> vector) {
        double sum = 0.;
        for (int i = 0; i <= vector.size() - 1; i++) {
            sum += vector.get(i).doubleValue();
        }
        return sum / (vector.size());
    }
    //TODO: function for geometric average using Frequency Table    
}
