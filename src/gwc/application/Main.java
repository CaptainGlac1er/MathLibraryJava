package gwc.application;
import gwc.mathlibrary.*;

public class Main {

    public static void main(String[] args) {
	    double[][] test = new double[4][4];
	    int cnt = 1;
	    vector[] vectors = new vector[]{
	            new vector(0,5850,0),
                new vector(0,0,-1.35)
        };
	    System.out.println(vector.crossProduct(vectors));
    }
}
