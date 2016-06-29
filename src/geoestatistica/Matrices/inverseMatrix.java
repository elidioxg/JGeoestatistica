package geoestatistica.Matrices;

/**
 *
 * @author exg
 */
public class inverseMatrix {

    public static double[][] stripedMatrix(double[][] matrix,
            int lineIndex, int columnIndex) {
        double[][] result = new double[matrix.length - 1][matrix.length - 1];
        int line = 0, column = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == lineIndex ) {
                i++;
            } else {
                line++;
            }
            for (int j = 0; j < matrix.length; j++) {
                if (j == columnIndex) {
                    j++;
                } else {
                    column++;
                }
                result[line][column] = matrix[i][j];
            }
        }
        return result;
    }
    //calcular o determinante
    public static double matrixDet(double[][] matrix) {
        double result = 0;
        
        return result;
    }

    public static double[][] generateCofactors(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

        }
        double[][] result = new double[matrix.length][matrix.length];
        return result;
    }

    public static double[][] inverse(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix.length];

        return result;
    }

}
