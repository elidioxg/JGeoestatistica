package geoestatistica.LinearRegression;

import geoestatistica.Statistics.Average;
import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

/**
 *
 * @author elidioxg
 */
public class Inclination {

    /**
     *
     * @param arrayX
     * @param arrayY
     * @return
     * @throws Exception
     */
    public static double getInclination(Vector arrayX, Vector arrayY) throws Exception {
        if (arrayX.size() != arrayY.size()) {
            throw new Exception("X and Y arrays must have same size.");
        }
        double sumX2 = 0.;
        double sumXY = 0.;
        for (int i = 0; i < arrayX.size(); i++) {
            sumX2 += Math.pow(arrayX.get(i).doubleValue(), 2);
            sumXY += arrayX.get(i).doubleValue() * arrayY.get(i).doubleValue();
        }
        double avgX = Average.arithmeticAverage(arrayX);
        double avgY = Average.arithmeticAverage(arrayY);
        double sXX = sumX2 - (arrayX.size() * Math.pow(avgX, 2));
        double sXY = sumXY - (arrayX.size() * avgX * avgY);
        return sXY / sXX;
    }

    /**
     *
     * @param arrayX
     * @param arrayY
     * @param averageX
     * @param averageY
     * @return
     * @throws Exception
     */
    public static double getInclination(Vector arrayX,
            Vector arrayY, double averageX,
            double averageY) throws Exception {
        if (arrayX.size() != arrayY.size()) {
            throw new Exception("X and Y arrays must have same size.");
        }
        double sumX2 = 0.;
        double sumXY = 0.;
        for (int i = 0; i < arrayX.size(); i++) {
            sumX2 += Math.pow(arrayX.get(i).doubleValue(), 2);
            sumXY += arrayX.get(i).doubleValue()
                    * arrayY.get(i).doubleValue();
        }
        double sXX = sumX2 - (arrayX.size() * Math.pow(averageX, 2));
        double sXY = sumXY - (arrayX.size() * averageX * averageY);
        return sXY / sXX;
    }

    /**
     *
     * @param arrayX
     * @param arrayY
     * @return
     * @throws Exception
     */
    public static double getInclination(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY) throws Exception {
        if (arrayX.size() != arrayY.size()) {
            throw new Exception("X and Y arrays must have same size.");
        }
        double sumX2 = 0.;
        double sumXY = 0.;
        for (int i = 0; i < arrayX.size(); i++) {
            sumX2 += Math.pow(arrayX.get(i), 2);
            sumXY += arrayX.get(i) * arrayY.get(i);
        }
        double avgX = Average.arithmeticAverage(arrayX);
        double avgY = Average.arithmeticAverage(arrayY);
        double sXX = sumX2 - (arrayX.size() * Math.pow(avgX, 2));
        double sXY = sumXY - (arrayX.size() * avgX * avgY);
        return sXY / sXX;
    }
}
