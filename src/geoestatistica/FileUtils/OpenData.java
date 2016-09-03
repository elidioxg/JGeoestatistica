package geoestatistica.FileUtils;

import geoestatistica.Matrices.Matrix;
import geoestatistica.Vectors.Vector;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class OpenData {

    public static ArrayList<Double> openCSVFileToDouble(String fileName, String separator,
            int column, boolean hasHeader) {
        BufferedReader br = null;
        ArrayList<Double> values = new ArrayList<>();
        String line = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            if (hasHeader) {
                br.readLine();
            }
            while ((line = br.readLine()) != null) {
                String[] lineValues = line.split(separator);
                values.add(Double.valueOf(lineValues[column]));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return values;
    }

    public static Vector openCSVFileToVector(String fileName, String separator,
            int column, boolean hasHeader, int size) {
        BufferedReader br = null;
        Vector vector = new Vector();
        Number[] number = new Number[size];
        String line = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            if (hasHeader) {
                br.readLine();
            }
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] lineValues = line.split(separator);
                final int ii = i;
                number[i] = new Number() {
                    @Override
                    public int intValue() {
                        return (int) number[ii];
                    }

                    @Override
                    public long longValue() {
                        return (long) number[ii];
                    }

                    @Override
                    public float floatValue() {
                        return (float) number[ii];
                    }

                    @Override
                    public double doubleValue() {
                        return (double) number[ii];
                    }
                };
                try {
                    number[i] = NumberFormat.getInstance().parse(lineValues[column]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                i++;
            }
            vector.setData(number, i);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

        return vector;
    }
    
    public static Vector openCSVFileToVector(String fileName, String separator,
            int column, boolean hasHeader) {
        BufferedReader br = null;
        Vector vector = new Vector();
        String line = null;
        int size = 0;
        try{
            br = new BufferedReader(new FileReader(fileName));
            if (hasHeader) {
                br.readLine();
            }
            
            while ((line = br.readLine()) != null) {               
                size++;
            }
            
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }                
        Number[] number = new Number[size];
        line = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            if (hasHeader) {
                br.readLine();
            }
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] lineValues = line.split(separator);
                final int ii = i;
                number[i] = new Number() {
                    @Override
                    public int intValue() {
                        return (int) number[ii];
                    }

                    @Override
                    public long longValue() {
                        return (long) number[ii];
                    }

                    @Override
                    public float floatValue() {
                        return (float) number[ii];
                    }

                    @Override
                    public double doubleValue() {
                        return (double) number[ii];
                    }
                };
                try {
                    number[i] = NumberFormat.getInstance().parse(lineValues[column]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                i++;
            }
            vector.setData(number, i);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

        return vector;
    }


    public static Matrix openCSVFileToMatrix(String fileName, String separator,
            boolean hasHeader) {
        BufferedReader br = null;
        String line = null;
        int xSize = 0;
        int ySize = 0;
        try{
            br = new BufferedReader(new FileReader(fileName));
            if(hasHeader){
                br.readLine();
            }
            
            line = br.readLine();
            ySize++;
            String[] lineValues = line.split(separator);            
            xSize = lineValues.length;
            while ((line = br.readLine()) != null) {
                ySize++;
            }
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        Matrix matrix = new Matrix();
        Number[][] number = new Number[xSize][ySize];
        line = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            if (hasHeader) {
                br.readLine();
            }
            int i = 0;
            while ((line = br.readLine()) != null) {

                String[] lineValues = line.split(separator);
                for (int j = 0; j < lineValues.length; j++) {
                    final int ii = i;
                    final int jj = j;
                    number[j][i] = new Number() {
                        @Override
                        public int intValue() {
                            return (int) number[jj][ii];
                        }

                        @Override
                        public long longValue() {
                            return (long) number[jj][ii];
                        }

                        @Override
                        public float floatValue() {
                            return (float) number[jj][ii];
                        }

                        @Override
                        public double doubleValue() {
                            return (double) number[jj][ii];
                        }
                    };
                    try {
                        number[j][i] = NumberFormat.getInstance().parse(lineValues[j]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
                i++;

            }
            matrix.setData(number, xSize,ySize);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return matrix;
    }

}
