package geoestatistica.FrequencyTable;

import java.util.ArrayList;

public class CentralValues {
    
    //Teor central da classe
    public static ArrayList<Double> getCentralClassValues(
            ArrayList<Double> extremeValues){
        ArrayList<Double> result = new ArrayList();
        for(int i = 0; i< extremeValues.size(); i +=2){
            result.add((extremeValues.get(i+1)- extremeValues.get(i))/2.);
        }
        return result;
    }
    
}
