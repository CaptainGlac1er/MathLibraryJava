package gwc.mathlibrary;

/**
 * Created by George on 3/28/2017.
 */
public class Matrix {
    public static double determinant(double[][] array){
        double output = 0;
        if(array.length == 2){
            output = array[0][0] * array[1][1] - array[0][1] * array[1][0];
        }else{
            boolean shouldNeg = false;
            for(int i = 0; i < array.length; i++){
                double[][] subArray = new double[array.length - 1][array.length - 1];
                int shift = 0;
                for(int j = 0; j < array.length; j++){
                    if(j == i) shift = 1;
                    else {
                        for (int k = 1; k < array.length; k++) {
                            subArray[j - shift][k - 1] = array[j][k];
                        }
                    }
                }
                output += ((shouldNeg)?-1:1) * array[i][0] * determinant(subArray);
                shouldNeg = !shouldNeg;
            }
        }
        return output;
    }

}
