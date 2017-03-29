package gwc.application;
import gwc.mathlibrary.*;

public class Main {

    public static void main(String[] args) {
	    double[][] test = new double[4][4];
	    int cnt = 1;
	    Vector vector1 = new Vector(0,5850,0);
	    Vector vector2 = new Vector(0,0,-1.35);

	    System.out.println(vector1.crossProduct(vector2));
    }
}
