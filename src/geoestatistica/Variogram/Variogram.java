package geoestatistica.Variogram;

import geoestatistica.Matrices.Matrix;
import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

/**
 *
 * @author elidioxg
 */
public class Variogram {

    /**
     *
     * @param matrix
     * @param initialDistance
     * @param stepSize
     * @param maxDistance
     * @param columnX
     * @param columnY
     * @param columnContent
     * @return
     * @throws Exception
     */
    public static Matrix variogram2D(Matrix matrix, double initialDistance,
            double stepSize, double maxDistance, int columnX, int columnY,
            int columnContent) throws Exception {
        double aux = ((maxDistance - initialDistance) / stepSize);
        int linesNumber = (int) aux;
        Matrix result = new Matrix(3, linesNumber);
        if (matrix.getColumnsCount() != matrix.getLinesCount()) {
            throw new Exception("Must be a square matrix");
        } else {

            for (int currentLine = 0; currentLine < linesNumber; currentLine++) {
                double value = 0.;
                int pairsNumber = 0;
                for (int i = 0; i < matrix.getLinesCount(); i++) {
                    for (int j = i + 1; j < matrix.getColumnsCount(); j++) {
                        double distanceX
                                = matrix.get(columnX, i).doubleValue()
                                - matrix.get(columnX, j).doubleValue();
                        double distanceY
                                = matrix.get(columnY, i).doubleValue()
                                - matrix.get(columnY, j).doubleValue();
                        double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                        if (distance >= initialDistance
                                && distance <= initialDistance + stepSize) {
                            value += Math.pow(matrix.get(columnContent, i).doubleValue()
                                    - matrix.get(columnContent, j).doubleValue(),
                                    2);
                            pairsNumber++;
                        }
                    }
                }
                result.set(0, currentLine, initialDistance + stepSize);
                initialDistance += stepSize;
                value /= 2 * pairsNumber;
                result.set(1, currentLine, value);
                result.set(2, currentLine, pairsNumber);
            }
        }
        return result;
    }

    /**
     *
     * @param xData
     * @param yData
     * @param contentData
     * @param initialDistance
     * @param stepSize
     * @param maxDistance
     * @return
     * @throws Exception
     */
    public static Matrix variogram2D(Vector xData, Vector yData, Vector contentData,
            double initialDistance, double stepSize, double maxDistance)
            throws Exception {
        Matrix result;
        if (xData.size() != yData.size()) {
            throw new Exception("Values of X and Y must have same size.");
        } else {
            double aux = ((maxDistance - initialDistance) / stepSize);
            int linesNumber = (int) aux;
            if (linesNumber <= 0) {
                throw new Exception("Invalid Values");
            } else {
                result = new Matrix(3, linesNumber);
                for (int currentLine = 0; currentLine < linesNumber; currentLine++) {
                    double value = 0.;
                    int pairsNumber = 0;
                    for (int i = 0; i < xData.size(); i++) {
                        for (int j = i + 1; j < xData.size(); j++) {
                            double distanceX
                                    = xData.get(i).doubleValue() - xData.get(j).doubleValue();
                            double distanceY
                                    = yData.get(i).doubleValue() - yData.get(j).doubleValue();
                            double distance
                                    = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                            if (distance >= initialDistance
                                    && distance <= initialDistance + stepSize) {

                                value += Math.pow(contentData.get(i).doubleValue()
                                        - contentData.get(j).doubleValue(), 2);
                                pairsNumber++;
                            }
                        }
                    }
                    result.set(0, currentLine, initialDistance + stepSize);
                    initialDistance += stepSize;
                    value /= 2 * pairsNumber;
                    result.set(1, currentLine, value);
                    result.set(2, currentLine, pairsNumber);
                }
            }
        }
        return result;
    }

    /**
     * Variogram for 2 Dimensions
     *
     * @param array
     * @param initialDistance
     * @param stepSize
     * @param maxDistance
     * @param columnX
     * @param columnY
     * @param columnContent
     * @return value of step, variation coefficient, number of pairs
     */
    //TODO: add angle min and max tolerance
    public ArrayList[][] variogram2D(ArrayList[][] array,
            double initialDistance, double stepSize, double maxDistance,
            int columnX, int columnY, int columnContent) {

        double aux = ((maxDistance - initialDistance) / stepSize);
        int linesNumber = (int) aux;
        ArrayList[][] result = new ArrayList[linesNumber][3];
        for (int currentLine = 0; currentLine < linesNumber; currentLine++) {
            double value = 0.;
            int pairsNumber = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    double distanceX
                            = Double.parseDouble(array[i][columnX].get(0).toString())
                            - Double.parseDouble(array[j][columnX].get(0).toString());
                    double distanceY
                            = Double.parseDouble(array[i][columnY].get(0).toString())
                            - Double.parseDouble(array[j][columnY].get(0).toString());
                    double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                    if (distance >= initialDistance
                            && distance <= initialDistance + stepSize) {

                        value += Math.pow(
                                Double.parseDouble(array[i][columnContent].get(0).toString())
                                - Double.parseDouble(array[j][columnContent].get(0).toString()),
                                2);
                        pairsNumber++;
                    }
                }
            }
            result[currentLine][0] = new ArrayList();
            result[currentLine][0].add(initialDistance + stepSize);
            initialDistance += stepSize;
            value /= 2 * pairsNumber;
            result[currentLine][1] = new ArrayList();
            result[currentLine][1].add(value);
            result[currentLine][2] = new ArrayList();
            result[currentLine][2].add(pairsNumber);
        }
        return result;
    }

    /**
     * Returns: value of step, variation coefficient, number of pairs
     *
     * @param xData
     * @param yData
     * @param contentData
     * @param initialDistance
     * @param stepSize
     * @param maxDistance
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList[][] variogram2D(ArrayList<Double> xData,
            ArrayList<Double> yData, ArrayList<Double> contentData,
            double initialDistance, double stepSize, double maxDistance)
            throws Exception {

        if (xData.size() != yData.size()) {
            throw new Exception("Values of X and Y must have same size.");
        }
        double aux = ((maxDistance - initialDistance) / stepSize);
        int linesNumber = (int) aux;
        ArrayList[][] result = new ArrayList[linesNumber][3];
        for (int currentLine = 0; currentLine < linesNumber; currentLine++) {
            double value = 0.;
            int pairsNumber = 0;
            for (int i = 0; i < xData.size(); i++) {
                for (int j = i + 1; j < xData.size(); j++) {
                    double distanceX
                            = xData.get(i) - xData.get(j);
                    double distanceY
                            = yData.get(i) - yData.get(j);
                    double distance
                            = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                    if (distance >= initialDistance
                            && distance <= initialDistance + stepSize) {

                        value += Math.pow(contentData.get(i)
                                - contentData.get(j), 2);
                        pairsNumber++;
                    }
                }
            }
            result[currentLine][0] = new ArrayList();
            result[currentLine][0].add(initialDistance + stepSize);
            initialDistance += stepSize;
            value /= 2 * pairsNumber;
            result[currentLine][1] = new ArrayList();
            result[currentLine][1].add(value);
            result[currentLine][2] = new ArrayList();
            result[currentLine][2].add(pairsNumber);
        }
        return result;
    }

}
