package ctci.chap1;

import ctci.ctciLibrary.AssortedMethods;

public class ZeroMatrix{
	
	// My attempt before reading the solution
	public static int[][] zeroMatrix(int[][] matrix){
		int n = matrix.length;
		if(n == 0){
			return matrix;
		}
		int m = matrix[0].length;
		boolean[] zeroRow = new boolean[n];
		boolean[] zeroCol = new boolean[m];
		//Read what rows/columns are zero
		for(int i=0; i<n ;i++){
			for(int j=0;j<m ;j++){
				if(matrix[i][j] == 0){
					zeroRow[i] = true;
					zeroCol[j] = true;
				}
			}
		}
		//clear specific rows/columns
		for(int i=0; i<n; i++){
			for(int j=0; j<m ;j++){
				if(zeroRow[i] || zeroCol[j]){
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	//Based on "correct" answer in book, utilizing the first row and first column for trackin instead of creating additional lists
	public static int[][] zeroMatrix2(int[][] matrix){
		int n = matrix.length;
		if(n == 0){
			return matrix;
		}
		int m = matrix[0].length;
		//Read what rows/columns are zero
		for(int i=0; i<n ;i++){
			for(int j=0;j<m ;j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		//clear specific rows/columns
		for(int i=0; i<n; i++){
			for(int j=0; j<m ;j++){
				if(matrix[0][j] == 0 || matrix[i][0] == 0){
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	//Test methods from ctci.chap1 Github
	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		
		int[][] matrix2 = cloneMatrix(matrix1);

		AssortedMethods.printMatrix(matrix1);
		
		zeroMatrix2(matrix1);

		System.out.println();
		
		AssortedMethods.printMatrix(matrix1);
		System.out.println();
		AssortedMethods.printMatrix(matrix2);
		
		if (matricesAreEqual(matrix1, matrix2)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}
	}
}
