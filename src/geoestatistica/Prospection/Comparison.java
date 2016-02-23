package geoestatistica.Prospection;

import geoestatistica.Statistics.StdDeviation;
import geoestatistica.Statistics.Average;
import java.util.ArrayList;

public class Comparison {
    
    //Comparison of average values​using statistical decision tests
    public double compareSamples(ArrayList<Double> sample1, 
            ArrayList<Double> sample2){
        Average average = new Average();
        double average1 = average.arithmeticAverage(sample1);
        double average2 = average.arithmeticAverage(sample2);
        StdDeviation dev = new StdDeviation();
        double deviation1  = dev.stdDeviation(sample1);
        double deviation2  = dev.stdDeviation(sample2);
        double S = dev.stdDeviationTwoSamples(sample1.size(), sample2.size(), 
                deviation1, deviation2);        
        double result = 0.;
        result = (average1 - average2) /
                (S*Math.sqrt( (1./sample1.size()) + (1./sample2.size()) ));
        return result;
    }
    
    //TODO: statistic test for sample already know
}
