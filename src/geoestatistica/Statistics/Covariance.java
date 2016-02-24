package geoestatistica.Statistics;

import java.util.ArrayList;

public class Covariance {
    
    public double covariance(ArrayList<Double> array1, ArrayList<Double> array2,
            double average1, double average2) throws Exception {
        double result = 0.;
        if(array1.size()!=array2.size()){
            throw new Exception("The arrays must have same size");
        } else {
            Average average = new Average();
            double avg1 = average.arithmeticAverage(array1);
            double avg2 = average.arithmeticAverage(array2);
            for(int i = 0; i <array1.size()-1; i++){
                result += (array1.get(i) - avg1)*(array2.get(i) - avg2);
            }
        }               
        return result/array1.size();
    }    
}
