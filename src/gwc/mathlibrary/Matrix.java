package gwc.mathlibrary;

/**
 * Created by George on 3/28/2017.
 */
public class Matrix {
    private double[][] array;
    public Matrix(double[][] array){
        this.array = array;
    }
    public Matrix(int columns, int rows){
        array = new double[rows][columns];
    }
    public double getDeterminant(){
        double output = 0;
        if(array.length == 1){
            return array[0][0];
        }else{
            boolean shouldNeg = false;
            for(int i = 0; i < array.length; i++){
                double[][] subArray = new double[array.length - 1][array.length - 1];
                int shift = 0;
                for(int j = 0; j < array.length; j++){
                    if(j == i) shift = 1;
                    else
                        for (int k = 1; k < array.length; k++)
                            subArray[j - shift][k - 1] = array[j][k];
                }
                output += ((shouldNeg)?-1:1) * array[i][0] * determinant(subArray);
                shouldNeg = !shouldNeg;
            }
        }
        return output;
    }
    public static double determinant(double[][] array){
        return (new Matrix(array)).getDeterminant();
    }
    public int getColumnCount(){
        return array[0].length;
    }
    public int getRowCount(){
        return array.length;
    }
    public double[] getColumnArray(int num){
        double[] output = new double[getRowCount()];
        for(int i = 0; i < output.length; i++)
            output[i] = getValue(num, i);
        return output;
    }
    public double[] getRowArray(int num){
        double[] output = new double[getColumnCount()];
        for(int i = 0; i < output.length; i++)
            output[i] = getValue(i, num);
        return output;
    }
    public double getValue(int col, int row){
        return array[row][col];
    }
    public void setValue(int col, int row, double value){
        array[row][col] = value;
    }
    public Matrix multiply(Matrix second){
        int m = getColumnCount();
        if(m != second.getRowCount())
            return null;
        Matrix newMatrix = new Matrix( second.getColumnCount(), getRowCount());
        for(int y = 0; y < newMatrix.getRowCount(); y++){
            for(int x = 0; x < newMatrix.getColumnCount(); x++){
                double cellValue = 0;
                double[] rowData = getRowArray(y);
                double[] colData = second.getColumnArray(x);
                for (int i = 0; i < rowData.length; i++)
                    cellValue += rowData[i] * colData[i];
                newMatrix.setValue(x, y, cellValue);
            }
        }
        return newMatrix;
    }
    public void printMatrix(){
        for(int y = 0; y < getRowCount(); y++){
            for(int x = 0; x < getColumnCount(); x++){
                System.out.print(getValue(x,y) + " ");
            }
            System.out.println();
        }
    }
    public Matrix add(Matrix second){
        if(getColumnCount() != second.getColumnCount() || getRowCount() != second.getRowCount())
            return null;
        Matrix newMatrix = new Matrix(getColumnCount(),getRowCount());
        for(int y = 0; y < newMatrix.getRowCount(); y++){
            for(int x = 0; x < newMatrix.getColumnCount(); x++){
                newMatrix.setValue(x, y, getValue(x,y) + second.getValue(x,y));
            }
        }
        return newMatrix;
    }
    public Matrix subtract(Matrix second){
        if(getColumnCount() != second.getColumnCount() || getRowCount() != second.getRowCount())
            return null;
        Matrix newMatrix = new Matrix(getColumnCount(),getRowCount());
        for(int y = 0; y < newMatrix.getRowCount(); y++){
            for(int x = 0; x < newMatrix.getColumnCount(); x++){
                newMatrix.setValue(x, y, getValue(x,y) - second.getValue(x,y));
            }
        }
        return newMatrix;
    }
}
