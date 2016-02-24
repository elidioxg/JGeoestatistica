package geoestatistica.Statistics;

import java.util.ArrayList;

public class Correlation {
    
    public double pearsonCoeff(ArrayList<Double> array1, 
            ArrayList<Double> array2) throws Exception{        
        Variance variance = new Variance();
        Covariance covariance = new Covariance();
        double var1 = variance.variance(array1);
        double var2 = variance.variance(array2);
        double cov = covariance.covariance(array1, array2);
        return cov/(Math.sqrt(var1*var2));        
    }
    
}
