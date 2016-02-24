package geoestatistica.Statistics;

import java.util.ArrayList;

public class VariationCoefficient {
    
    public double variationCoefficient(double stdDeviation, double 
            arithmeticAvg){
        return 100*stdDeviation/arithmeticAvg;    
    }
    
    public double variationCoefficient(ArrayList<Double> array){
        Average average = new Average();
        double avgValue = average.arithmeticAverage(array);
        StdDeviation stdDev = new StdDeviation();
        double stdDevValue = stdDev.stdDeviation(array);
        return 100*stdDevValue/avgValue;
    }
    
    //TODO: logVariationCoefficient
}
