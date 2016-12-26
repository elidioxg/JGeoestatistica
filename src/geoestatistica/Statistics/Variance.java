package geoestatistica.Statistics;

import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

public class Variance {

    /**
     * Calculate the Variance of a vector
     *
     * @param vector
     * @return
     */
    public static double variance(Vector vector) {
        double result = 0.;
        Average avg = new Average();
        double averageValue = avg.arithmeticAverage(vector);
        for (int i = 0; i < vector.size(); i++) {
            result += Math.pow(vector.get(i).doubleValue() - averageValue, 2);
        }
        return result / vector.size();
    }

    /**
     * Calculate the Variance of a vector with already known average value
     *     
     * @param vector
     * @param average
     * @return
     */
    public static double variance(Vector vector, double average) {
        double result = 0.;
        for (int i = 0; i < vector.size(); i++) {
            result += Math.pow(vector.get(i).doubleValue() - average, 2);
        }
        return result / vector.size();
    }

    public static double[] distance1DMatrix(double[][] array, int columnX, 
            int columnY, double posX, double posY){
        double[] result = new double[array.length];
        for(int i = 0 ; i< array.length; i++){
            result[i] = Math.sqrt( 
                    Math.pow( array[i][columnX] - posX, 2) +
                    Math.pow(array[i][columnY] - posY, 2)
                            );
        }
        return result;
    }
    
    public static double[][] distance2DMatrix(double[][] array, int columnX,
            int columnY) {
        double[][] result = new double[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                double distance = 0.;
                if (i != j) {
                    distance = Math.sqrt(
                            Math.pow(array[i][columnX] - array[j][columnX], 2)
                            + Math.pow(array[i][columnY] - array[j][columnY], 2)
                    );
                }
                result[i][j] = distance;
            }

        }
        return result;
    }
}
