package geoestatistica.Statistics;

import static geoestatistica.Statistics.Average.arithmeticAverage;
import static geoestatistica.Statistics.StdDeviation.stdDeviation;
import java.util.ArrayList;

public class VariationCoefficient {
    
    public static double variationCoefficient(double stdDeviation, double 
            arithmeticAvg){
        return 100*stdDeviation/arithmeticAvg;    
    }
    
    public static double variationCoefficient(ArrayList<Double> array){        
        double avgValue = arithmeticAverage(array);        
        double stdDevValue = stdDeviation(array);
        return 100*stdDevValue/avgValue;
    }
    
    //TODO: logVariationCoefficient    
}
