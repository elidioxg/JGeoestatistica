package geoestatistica.Statistics;

import static geoestatistica.Statistics.Covariance.covariance;
import static geoestatistica.Statistics.Variance.variance;
import java.util.ArrayList;

public class Correlation {
    
    public double pearsonCoeff(ArrayList<Double> array1, 
            ArrayList<Double> array2) throws Exception{        
        double var1 = variance(array1);
        double var2 = variance(array2);
        double cov = covariance(array1, array2);
        return cov/(Math.sqrt(var1*var2));        
    }
    
    public double pearsonCoeff(double variance1, double variance2,
            double covariance){
        return covariance/Math.sqrt(variance1*variance2);    
    }
    
}
