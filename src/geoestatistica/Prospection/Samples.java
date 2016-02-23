package geoestatistica.Prospection;

import java.util.ArrayList;

public class Samples {

    //Determinação do número de amostras necessárias na pesquisa de um minério
    public double determineSamplesNumber(double studentConstant,
            double variationCoeff, double maxError) {
        return Math.pow(studentConstant, 2) * Math.pow(variationCoeff, 2)
                / Math.pow(maxError, 2);
    }

    //Determinação da equidistância da amostragem
    //retorna a área de influência da amostra
    //area pode ser em metros ou metros quadrados
    public double determineSamplesSpacing(double area, double studentConstant,
            double variationCoeff, double maxError) {
        return (area * Math.pow(maxError, 2) / (Math.pow(studentConstant, 2)
                * Math.pow(variationCoeff, 2)));
    }

    public double quiSquare(ArrayList<Double> observed,
            ArrayList<Double> expected) throws Exception {
        double sum = 0.;
        if (observed.size() != expected.size()) {
            throw new Exception("Observed and Expected values must have same size.");
        } else {
            for (int i = 0; i <= observed.size() - 1; i++) {
                sum += Math.pow((observed.get(i) - expected.get(i)), 2)
                        / expected.get(i);
            }
        }
        return sum;
    }

    //Estimate accuracy for N > 30
    //precision usually receives as input 90, 95, 97 or 99    
    public double sampleAccuracy(double average, double stdDeviation,
            int samplesNumber, int precision, boolean superiorLimit) {
        double result = 0.;
        if (superiorLimit) {
            result = average + (precision * stdDeviation
                    / Math.sqrt(samplesNumber));
        } else {
            result = average - (precision * stdDeviation
                    / Math.sqrt(samplesNumber));
        }
        return result;
    }
    
    //Estimate accuracy for N < 30
    public double sampleAccuracy(double average, double student, 
            double stdDeviation, int samplesNumber, boolean superiorLimit){
        double result = 0.;
        if(superiorLimit){
            result = average + (student*stdDeviation/Math.sqrt(samplesNumber-1));
        } else {
            result = average - (student*stdDeviation/Math.sqrt(samplesNumber-1));
        }
        return result;
    }
    
    //TODO: sampleAccuracy for log distributions
}
