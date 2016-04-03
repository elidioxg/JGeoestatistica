package geoestatistica.LinearRegression.Simple;

import geoestatistica.Statistics.Average;
import java.util.ArrayList;

public class SimpleRegression {

    //inclination
    public static double getB(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY) throws Exception {
        double result = 0.;
        if (arrayX.size() != arrayY.size()) {
            throw new Exception("Arrays X and Y must have same size.");
        }
        double avgX = Average.arithmeticAverage(arrayX);
        double avgY = Average.arithmeticAverage(arrayY);
        double sumUp = 0.;
        double sumDown = 0.;
//        double sumX = 0.;
//        double sumY = 0.;        
        double sumX2 = 0.;
        for (int i = 0; i < arrayX.size(); i++) {
            sumUp += arrayX.get(i)*(arrayY.get(i)- avgY);
            sumDown += (arrayX.get(i)*(arrayX.get(i)- avgX));
//            sumX += (arrayX.get(i) - avgX);
//            sumY += (arrayY.get(i) - avgY);
            sumX2 += Math.pow(( arrayX.get(i) - avgX), 2);
        }
        result = sumUp/sumDown;
//        result = sumX*sumY/sumX2;
        System.out.println("B: "+result);
        return result;
    }
    
    //initial value
    public static double getA(ArrayList<Double> arrayX, 
            ArrayList<Double> arrayY, double inclination){
        double result = 0.;
        double avgX = Average.arithmeticAverage(arrayX);
        double avgY = Average.arithmeticAverage(arrayY);
        result = avgY - inclination*avgX;
        System.out.println("A: "+result );
        return result;
    }
    
    //todo: function to get Error²
    public static ArrayList<Double> simpleRegression(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY, double initialValue,
            double finalValue, double step) throws Exception{
        ArrayList<Double> result = new ArrayList();
        double B = getB(arrayX, arrayY);
        double A = getA(arrayX, arrayY, B);
        for(double i = initialValue; i<=finalValue; i = i+step){
            result.add(A+(B*i));        
        }        
        return result;
    }
    
    public static ArrayList<Double> simpleRegression(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY) throws Exception{
        ArrayList<Double> result = new ArrayList();
        double B = getB(arrayX, arrayY);
        double A = getA(arrayX, arrayY, B);
        for(int i = 0; i<arrayX.size(); i++){
            result.add(A+(B*arrayX.get(i)));        
        }
        return result;
    }

}
