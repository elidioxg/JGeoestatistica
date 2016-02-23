package geoestatistica.Prospection;

public class CriticalVolume {
   
    public double criticalVolume(double securityCoeff, double avgMass, 
            double avgUsefulContent){        
        return securityCoeff*avgMass/avgUsefulContent;
    }
    
}
