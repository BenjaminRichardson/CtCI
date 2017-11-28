package ctci;

public class RotateMatrix{
	
	public static void main(String[] args) {
		int[][] matrix = randomMatrix(5, 5, 0, 9);
		printMatrix(matrix);
		rotateMatrix(matrix);
		System.out.println();
		printMatrix(matrix);
	}

	public static int[][] rotateMatrix(int[][] matrix){
		int n = matrix.length; //assuming sqare as per specification
		int midPoint = n/2;
		int innerMidPoint; //hacky I know
		if(n%2 == 0){
			innerMidPoint = n/2;
		}else{
			innerMidPoint = n/2 +1;
		}
		for(int i = 0; i < midPoint ; i++){
			for(int j=0; j < innerMidPoint; j++){
				int tempInt1,tempInt2;
				//top left to top right (quadrants)
				tempInt1 = matrix[j][n-1-i];
				matrix[j][n-1-i] = matrix[i][j];

				//top right to bottom right (quadrants)
				tempInt2 = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = tempInt1;

				//bottom right to bottom left
				tempInt1 = matrix[n-1-j][i];
				matrix[n-1-j][i] = tempInt2;

				//bottom left to top left
				matrix[i][j] = tempInt1;
			}
		}
		return matrix;

	}

	// Taken from utils in CtCI Github
	// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/CtCILibrary/CtCILibrary/AssortedMethods.java
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
}