package geoestatistica.Prospection;

import geoestatistica.Statistics.Average;
import geoestatistica.Statistics.StdDeviation;
import java.util.ArrayList;

public class Comparison {
        
    /**
     * Comparison of average values​using statistical decision tests
     * @param sample1
     * @param sample2
     * @return 
     */
    public double compareSamples(ArrayList<Double> sample1, 
            ArrayList<Double> sample2){        
        double average1 = Average.arithmeticAverage(sample1);
        double average2 = Average.arithmeticAverage(sample2);        
        double deviation1  = StdDeviation.stdDeviation(sample1);
        double deviation2  = StdDeviation.stdDeviation(sample2);
        double S = StdDeviation.stdDeviationTwoSamples(sample1.size(), 
                sample2.size(), deviation1, deviation2);        
        double result;
        result = (average1 - average2) /
                (S*Math.sqrt( (1./sample1.size()) + (1./sample2.size()) ));
        return result;
    }
    
    //TODO: statistic test for sample already know
}
