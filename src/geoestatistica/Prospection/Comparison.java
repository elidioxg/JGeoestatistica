package geoestatistica.Prospection;

import geoestatistica.Statistics.StdDeviation;
import static geoestatistica.Statistics.Average.arithmeticAverage;
import static geoestatistica.Statistics.StdDeviation.stdDeviation;
import static geoestatistica.Statistics.StdDeviation.stdDeviationTwoSamples;
import java.util.ArrayList;

public class Comparison {
    
    //Comparison of average values​using statistical decision tests
    public double compareSamples(ArrayList<Double> sample1, 
            ArrayList<Double> sample2){        
        double average1 = arithmeticAverage(sample1);
        double average2 = arithmeticAverage(sample2);        
        double deviation1  = stdDeviation(sample1);
        double deviation2  = stdDeviation(sample2);
        double S = stdDeviationTwoSamples(sample1.size(), sample2.size(), 
                deviation1, deviation2);        
        double result;
        result = (average1 - average2) /
                (S*Math.sqrt( (1./sample1.size()) + (1./sample2.size()) ));
        return result;
    }
    
    //TODO: statistic test for sample already know
}
