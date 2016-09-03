package geoestatistica.Matrices;

/**
 *
 * @author elidioxg
 */
public class Determinant {

    //add 2 columns to the table to opearate calculations of laplace
    //considering number of lines = number of columns
    //rename to laplaceBuild?
    public static double matrixDeterminant(double[][] matrix) {
        double[][] newMatrix = new double[matrix.length][matrix.length + 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) {
                    newMatrix[i][matrix.length] = matrix[i][j];
                } else
                if (j == 1) {
                    newMatrix[i][matrix.length+1] = matrix[i][j];
                }
                newMatrix[i][j] = matrix[i][j];
                
            }
        }
        /*System.out.println("Matrix:");
        for(int i = 0; i< newMatrix.length; i++){
            for(int j = 0; j<newMatrix.length+2; j++){
                System.out.print(newMatrix[i][j]+" ");
            }
            System.out.println("");
        }
*/     
        double sum =0.;
        for(int i = 0; i <matrix.length; i++){            
            double cSum = 1.; //Sum for the column
            for(int j = i; j< matrix.length; j++){
                cSum *= newMatrix[j-i][j]; 
                System.out.println("");
                System.out.println("column: "+j);
                System.out.println("Matrix[j-i][j]= "+newMatrix[j-i][j]);
                System.out.println("");
            }
            System.out.println("cSum: "+cSum);
            sum += cSum;
            System.out.println("Sum(+): "+sum);
        }           
        
        for(int i = matrix.length-1; i >=0 ; i--){
            double cSum = 1.;
            for(int j= i; j >= 0 ; j--){
                cSum *= newMatrix[j][j];                
                System.out.println("cSum: "+cSum);
            }
            sum -= cSum;
            System.out.println("Sum(-): "+sum);
        }
        System.out.println("Matrix determinant: "+ sum);
        return sum;
    }

}
