package geoestatistica.LinearRegression;

import static geoestatistica.LinearRegression.Inclination.getInclination;
import static geoestatistica.LinearRegression.InitialValue.getInitialValue;
import java.util.ArrayList;

public class LinearRegression {    

    public static ArrayList<Double> linearRegression(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY) throws Exception {
        double inc = getInclination(arrayX, arrayY);
        double initialValue = getInitialValue(arrayX, arrayY, inc);
        ArrayList<Double> result = new ArrayList<>();
        for (int i = 0; i < arrayX.size(); i++) {
            result.add(initialValue + (inc * arrayX.get(i)));
        }
        return result;
    }

    //TODO: values must be reversed
    public static ArrayList<Double> linearRegression(ArrayList<Double> arrayX,
            ArrayList<Double> arrayY, double minValue,
            double maxValue, double stepValue) throws Exception {
        double inc = getInclination(arrayX, arrayY);
        double initialValue = getInitialValue(arrayX, arrayY, inc);
        double steps = (maxValue - minValue) / stepValue;
        ArrayList<Double> result = new ArrayList<>();
        int j = (int) steps;
        for (int i = 0; i < j; i++) {
            result.add(initialValue + (inc * minValue));
            minValue += steps;
        }
        return result;
    }

    public double getValueAt(double initialValue, double inclination,
            double valueAt) {
        return (initialValue + (inclination * valueAt));
    }

}
