package geoestatistica.FrequencyTable;

import static geoestatistica.Statistics.SampleAmplitude.getAmplitude;
import java.util.ArrayList;

public class ClassIntervals {

    /*
     * Define class intervals for histograms 
     */
    public static double setClassIntervals(double populationAmplitude,
            double samplesNumber) {
        return (populationAmplitude / (1 + (3.32 * Math.log(samplesNumber))));
    }

    public static double setClassIntervals(ArrayList<Double> array) {
        double amplitude = getAmplitude(array);
        return (amplitude / (1 + (3.32 * Math.log(array.size()))));
    }

    /*
     * Define number of classes for histograms using pré-fixes values
     */
    public static int setClassNumbers(int samplesNumber) throws Exception {
        if (samplesNumber < 6) {
            throw new Exception("Number of Samples too small.");
        }
        if (samplesNumber <= 11) {
            return 4;
        } else if (samplesNumber <= 22) {
            return 5;
        } else if (samplesNumber <= 45) {
            return 6;
        } else if (samplesNumber <= 90) {
            return 7;
        } else if (samplesNumber <= 181) {
            return 8;
        } else if (samplesNumber <= 362) {
            return 9;
        } else if (samplesNumber <= 724) {
            return 10;
        } else if (samplesNumber <= 1448) {
            return 11;
        } else if (samplesNumber <= 2896) {
            return 12;
        } else if (samplesNumber <= 5792) {
            return 13;
        } else if (samplesNumber <= 11584) {
            return 14;
        } else {
            return 15;
        }
    }
    
    public static int getClassObservationFrequency(ArrayList<Double> array, 
            double minClassValue, double maxClassValue){
        int result =0;
        for(int i = 0; i<array.size(); i++){
            if(array.get(i)>=minClassValue && array.get(i)<=maxClassValue){
                result++;
            }
        }
        return result;
    }
    
    
}
