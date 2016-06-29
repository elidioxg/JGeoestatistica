package geoestatistica.Statistics;

import java.util.ArrayList;

public class Variance {

    /**
     *
     * @param array
     * @param average
     * @return
     */
    public static double variance(ArrayList<Double> array, double average) {
        double result = 0.;
        for (int i = 0; i < array.size() - 1; i++) {
            result += Math.pow(array.get(i) - average, 2);
        }
        return result / array.size();
    }

    /**
     *
     * @param array
     * @return
     */
    public static double variance(ArrayList<Double> array) {
        double result = 0.;
        double averageValue = Average.arithmeticAverage(array);
        for (int i = 0; i < array.size() - 1; i++) {
            result += Math.pow(array.get(i) - averageValue, 2);
        }
        return result / array.size();
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
