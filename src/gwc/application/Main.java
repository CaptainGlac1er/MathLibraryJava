package gwc.application;
import gwc.mathlibrary.*;

public class Main {

    public static void main(String[] args) {
	    testMatrixMultiplication();
        //testVectorProduct();
    }
    public static void testMatrixMultiplication(){
		double[][] test = new double[1][5];
		for(int x = 0; x < test.length; x++){
			for(int y = 0; y < test[x].length; y++){
				test[x][y] = (Math.random() * 10) - 5;
			}
		}
		double[][] test1 = new double[5][2];
		for(int x = 0; x < test1.length; x++){
			for(int y = 0; y < test1[x].length; y++){
				test1[x][y] = (Math.random() * 10) - 5;
			}
		}
		Matrix matrix1 = new Matrix(test);
		matrix1.printMatrix();
		System.out.println("\r\n\r\n");

		Matrix matrix2 = new Matrix(test1);
		matrix2.printMatrix();

		System.out.println("\r\n\r\n");
		matrix1.multiply(matrix2).printMatrix();
	}
    public static void testVectorProduct(){
		int cnt = 1;
		Vector vector1 = new Vector(5,-5,3);
		Vector vector2 = new Vector(1,-6.5,5);

		System.out.println(vector1.crossProduct(vector2));
	}
}
