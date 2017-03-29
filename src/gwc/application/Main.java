package gwc.application;
import gwc.mathlibrary.*;

public class Main {

    public static void main(String[] args) {
	    double[][] test = new double[4][4];
	    int cnt = 1;
	    Vector vector1 = new Vector(5,-5,3);
	    Vector vector2 = new Vector(1,-6.5,5);

	    System.out.println(vector1.crossProduct(vector2));

    }
}
