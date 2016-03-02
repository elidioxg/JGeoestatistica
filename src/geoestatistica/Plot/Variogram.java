package geoestatistica.Plot;

import java.util.ArrayList;

public class Variogram {
    
    //TODO: add angle min and max tolerance
    public ArrayList[][] variogram2D(ArrayList[][] array,
            double initialDistance, double stepSize, double maxDistance,
            int columnX, int columnY, int columnContent) {

        double aux = ((maxDistance - initialDistance) / stepSize) ;
        int linesNumber = (int) aux;        
        ArrayList[][] result = new ArrayList[linesNumber][3];
        for (int currentLine = 0; currentLine < linesNumber; currentLine++) {                    
            double value = 0.;
            int pairsNumber = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length - 1; j++) {                    
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
            result[currentLine][0].add(initialDistance+stepSize);
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
