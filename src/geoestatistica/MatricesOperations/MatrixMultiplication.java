package geoestatistica.Matrices;

/**
 *
 * @author elidioxg
 */
public class MatrixMultiplication {
    
    /**
     * Iterative algorithm
     * @param matrixA Square matrix
     * @param matrixB Square matrix
     * @return the result of matrixA * matrixB
     */
    public double[][] squareMatrices(double[][] matrixA, double[][] matrixB){
        double[][] matrixC = new double[matrixA.length][];
        for(int i = 0; i< matrixA.length; i++){
            for(int j = 0; j < matrixA.length; j++){
                double sum = 0;
                for(int k = 0; k < matrixA.length; k++){
                    sum += matrixA[i][k] * matrixB[k][j]; 
                }
                matrixC[i][j] = sum;
            }
        }
        return matrixC;
    }
    
}
