package geoestatistica.LinearRegression;

import geoestatistica.Vectors.Vector;
import java.util.ArrayList;

public class LinearRegression {

    private double initialValue = 0.;
    private double inclination = 0.;

    public LinearRegression(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY) {        
        try {
            this.inclination = Inclination.getInclination(arrayX, arrayY);
        } catch (Exception e) {

        }
        this.initialValue = InitialValue.getInitialValue(arrayX, arrayY, inclination);
    }
    
    public LinearRegression(Vector vector1, Vector vector2) {        
        try {
            this.inclination = Inclination.getInclination(vector1, vector2);
        } catch (Exception e) {

        }
        this.initialValue = InitialValue.getInitialValue(vector1, vector2, inclination);
    }

    public ArrayList<Double> linearRegressionPointsList(double firstValue,
            double lastValue, double stepValue) {
        ArrayList<Double> result = new ArrayList<>();
        for (double i = firstValue; i <= lastValue; i += stepValue) {
            result.add(this.initialValue + (this.inclination * i));            
        }
        return result;
    }

    /**
     *
     * @param initialValue
     * @param inclination
     * @param valueAt
     * @return
     */
    public double getValueAt(double valueAt) {        
        return (this.initialValue + (this.inclination * valueAt));
    }
    
    /**
     * 
     * @return 
     */
    public double getInclination(){
        return this.inclination;
    }
    
    /**
     * 
     * @return 
     */
    public double getInitialValue(){
        return this.initialValue;
    }

}
