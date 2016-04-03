package geoestatistica.MonteCarlo;

import java.util.ArrayList;

public class InterpointDistance {
    
    public static double getAverageDistance(ArrayList<Double> arrayX,
            ArrayList<Double> arrayZ) throws Exception{
        if(arrayX.size()!=arrayZ.size()){
            throw new Exception("Arrays X and Z must have same size.");
        }
        double result = 0.;
        for(int i= 0; i < arrayX.size(); i++){
            result+= Math.pow( (arrayX.get(i)- arrayZ.get(i)) , 2);
        }
        result = Math.sqrt(result);
        result/= arrayX.size();
        return result;
    }
    
    // a and b are lenght and height of the rectangle
    public static double getExpectedDistance(double a, double b){
        double result= 0.;
        //to do: substitute Math.log(1) by arccosh( sqrt(a² + b²)/a )
        //       and Math.log(2) by arccosh( sqrt(a² + b²)/b )
        result = (1./15.)* ( 
                (  Math.pow(a, 3)/Math.pow(b, 2)  ) +
                (  Math.pow(b, 3)/Math.pow(a, 2)  ) +
                (  Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) ) ) *
                (  (3) - (Math.pow(a, 2)/Math.pow(b, 2)) -  
                    (Math.pow(b, 2)/Math.pow(a, 2)) ) +
                (  1./6.) * ( ((Math.pow(b, 2)/a)*Math.log(1) )  +
                    ( (Math.pow(a, 2)/b)*Math.log(2) ))
                );
        return result;
    }
    
    
}
