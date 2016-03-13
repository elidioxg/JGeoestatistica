package geoestatistica.Prospection;

public class CriticalVolume {
    
    /*
    * P = (Average Volume of mineral crystal)³ * density of mineral *4/3 pi 
    * k = Security coeffiecient
    * t = Teor médio do mineral útil no minério
    */
   
    public double criticalVolume(double securityCoeff, double avgMass, 
            double avgUsefulContent){        
        return securityCoeff*avgMass/avgUsefulContent;
    }
    
}
