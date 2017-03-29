package gwc.mathlibrary;

/**
 * Created by George on 3/28/2017.
 */
public class Vector {
    protected double[] unitVectors;
    public Vector(double i, double j, double k){
        unitVectors = new double[3];
        unitVectors[0] = i;
        unitVectors[1] = j;
        unitVectors[2] = k;
    }
    public Vector(double[] unitVectors){
        this.unitVectors = unitVectors;
    }
    public double[] getUnitVectors(){
        return unitVectors;
    }
    public int getDimensions(){
        return unitVectors.length;
    }
    public double getMagnitude(){
        double add = 0;
        for(double uv : unitVectors)
            add += Math.pow(uv,2);
        return Math.sqrt(add);
    }
    public String toString(){
        String output = "";
        for(double d : unitVectors)
            output += d + " ";
        return output;
    }
    public Vector crossProduct(Vector secondVector){
        return crossProduct(new Vector[]{this, secondVector});
    }
    private Vector crossProduct(Vector[] vectors){
        double[] output;
        if(vectors.length > 1){
            output = new double[vectors[0].getDimensions()];
            boolean shouldNeg = false;
            for(int i = 0; i < vectors.length + 1; i++){
                double[][] subArray = new double[vectors.length][vectors.length];
                int shift = 0;
                for(int j = 0; j < vectors.length + 1; j++){
                    if(j == i) shift = 1;
                    else
                        for (int k = 0; k < vectors.length; k++)
                            subArray[j - shift][k] = vectors[k].getUnitVectors()[j];
                }
                output[i] = Matrix.determinant(subArray) * ((shouldNeg)?-1:1);
                shouldNeg = !shouldNeg;
            }
            return new Vector(output);
        }else if(vectors.length == 1) {
            return vectors[0];
        }
        else
            return null;
    }
}
