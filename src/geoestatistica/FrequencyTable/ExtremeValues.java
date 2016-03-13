package geoestatistica.FrequencyTable;

import java.util.ArrayList;

public class ExtremeValues {
    
    //Teores extremos da classe
    public static ArrayList<Double> setExtremeValues(double minValue,
            double maxValue, double numberOfClasses){
        ArrayList<Double> result = new ArrayList();
        double diff = (maxValue-minValue)/numberOfClasses;
        double value = minValue;        
        for(int i= 1; i<= numberOfClasses; i++){               
            result.add(value += diff);
        }
        return result;
    }    
}
