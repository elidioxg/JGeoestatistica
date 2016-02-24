package geoestatistica.Statistics;

import java.util.ArrayList;

public class Average {

    //Arithmetic Average
    public double arithmeticAverage(ArrayList<Double> array) {
        double sum = 0.;
        for (int i = 0; i <= array.size() - 1; i++) {
            sum += array.get(i);
        }
        return sum / (array.size());
    }

    //TODO: function for arithmetic average using Frequency Table
    //Geometric Average
    public double geometricAverage(ArrayList<Double> array) {
        double prod = 0.;
        for (int i = 0; i <= array.size() - 1; i++) {
            prod *= array.get(i);
        }
        double result = Math.pow(prod, (1.0 / array.size()));
        return result;
    }

    //TODO: function for geometric average using Frequency Table    
}
