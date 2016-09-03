package geoestatistica.LinearRegression;

import geoestatistica.Statistics.Average;
import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

public class Inclination {
    public static double getInclination(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY) throws Exception {
        if (arrayX.size() != arrayY.size()) {
            throw new Exception("X and Y arrays must have same size.");
        }
        double sumX2 = 0.;
        double sumXY = 0.;
        for (int i = 0; i < arrayX.size(); i++) {
            sumX2 += Math.pow(arrayX.get(i), 2);
            sumXY += arrayX.get(i)* arrayY.get(i);
        }        
        double avgX = Average.arithmeticAverage(arrayX);
        double avgY = Average.arithmeticAverage(arrayY);
        double sXX = sumX2 - (arrayX.size() * Math.pow(avgX, 2));
        double sXY = sumXY - (arrayX.size() * avgX * avgY);
        return sXY / sXX;
    }

    public static double getInclination(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY, double averageX,
            double averageY) throws Exception {
        if (arrayX.size() != arrayY.size()) {
            throw new Exception("X and Y arrays must have same size.");
        }
        double sumX2 = 0.;
        double sumXY = 0.;
        for (int i = 0; i < arrayX.size(); i++) {
            sumX2 += Math.pow(arrayX.get(i), 2);
            sumXY += arrayX.get(i)
                    * arrayY.get(i);
        }
        double sXX = sumX2 - (arrayX.size() * Math.pow(averageX, 2));
        double sXY = sumXY - (arrayX.size() * averageX * averageY);
        return sXY / sXX;
    }
    
    public static double getInclination(Vector vector1,
            Vector vector2) throws Exception {
        if (vector1.getSize() != vector2.getSize()) {
            throw new Exception("X and Y arrays must have same size.");
        }
        double sumX2 = 0.;
        double sumXY = 0.;
        for (int i = 0; i < vector1.getSize(); i++) {
            sumX2 += Math.pow(vector1.getValue(i).doubleValue(), 2);
            sumXY += vector1.getValue(i).doubleValue()
                    * vector2.getValue(i).doubleValue();
        }
        double avgX = Average.arithmeticAverage(vector1);
        double avgY = Average.arithmeticAverage(vector2);
        double sXX = sumX2 - (vector1.getSize() * Math.pow(avgX, 2));
        double sXY = sumXY - (vector1.getSize() * avgX * avgY);
        return sXY / sXX;
    }
}
