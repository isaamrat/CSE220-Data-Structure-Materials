public class twoDArray {

    // Method to calculate the sum of all elements in a 2D array
    public static int sumAll(int[][] mat) {
        int r = mat.length;             // Number of rows
        int c = mat[0].length;          // Number of columns
        int sum = 0;                    // Initialize sum

        // Iterate through each element in the matrix and add to sum
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += mat[i][j];
            }
        }

        return sum;                     // Return the calculated sum
    }

    // Method to calculate column-wise sum and print the result
    public static void columnSum(int[][] mat) {
        int row = mat.length;           // Number of rows
        int col = mat[0].length;        // Number of columns
        int[] arr = new int[col];       // Array to store column sums

        // Calculate column sums
        for (int j = 0; j < col; j++) { // Loop through each column
            for (int i = 0; i < row; i++) { // Loop through each row of the current column
                arr[j] += mat[i][j];    // Add current element to column sum
            }
        }

        // Print each column sum side by side
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();           // Move to the next line after printing sums
    }

    // Method to calculate row-wise sum and print the result matrix
    public static void rowSum(int[][] mat) {
        int r = mat.length;             // Number of rows
        int c = mat[0].length;          // Number of columns
        int[][] resultedArray = new int[r][1]; // Resultant array for row sums

        // Calculate row sums
        for (int i = 0; i < r; i++) {   // Loop through each row
            for (int j = 0; j < c; j++) { // Loop through each column of the current row
                resultedArray[i][0] += mat[i][j]; // Add current element to row sum
            }
        }

        printMatrix(resultedArray);     // Print the resultant matrix
    }

    // Method to multiply two matrices and print the result matrix
    public static void multiplyMatrix(int[][] matA, int[][] matB) {
        int ar = matA.length;           // Rows in matrix A
        int ac = matA[0].length;        // Columns in matrix A
        int br = matB.length;           // Rows in matrix B
        int bc = matB[0].length;        // Columns in matrix B

        int[][] result = new int[ar][bc]; // Resultant matrix

        // Matrix multiplication logic
        for (int i = 0; i < ar; i++) {  // Loop through rows of matrix A
            for (int j = 0; j < bc; j++) { // Loop through columns of matrix B
                for (int k = 0; k < br; k++) { // Loop through rows of matrix B
                    result[i][j] += matA[i][k] * matB[k][j]; // Perform multiplication and sum
                }
            }
        }

        printMatrix(result);            // Print the resultant matrix
    }

    

    // Method to print the diagonal elements of a matrix
    public static void printDiagonal(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(mat[i][i]); // Print diagonal element
        }
    }

    // Method to print the second diagonal elements of a matrix
    public static void printSecondDiagonal(int[][] mat) {
        int col = mat.length;           // Number of columns

        // Print second diagonal elements
        for (int i = 0; i < mat.length; i++) {
            System.out.println(mat[i][col - 1 - i]);
        }
    }

    // Here in printMatrix function multiple inbuilt functions are used to make the formatting look good. You are not allowed to use this in your code.
    public static void printMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        // Find the maximum length of each column
        int[] max_lengths = new int[c];
        for (int j = 0; j < c; j++) {
            max_lengths[j] = Integer.MIN_VALUE;
            for (int i = 0; i < r; i++) {
                int length = String.valueOf(mat[i][j]).length();
                if (length > max_lengths[j]) {
                    max_lengths[j] = length;
                }
            }
        }

        // Print top border
        printHorizontalLine(max_lengths);

        // Print matrix with formatted cells
        for (int i = 0; i < r; i++) {
            StringBuilder formattedRow = new StringBuilder("| ");
            for (int j = 0; j < c; j++) {
                formattedRow.append(String.format("%" + max_lengths[j] + "d", mat[i][j]));
                if (j < c - 1) {
                    formattedRow.append(" | ");
                }
            }
            formattedRow.append(" |");

            System.out.println(formattedRow);

            // Print inner horizontal line between rows, except after the last row
            if (i < r - 1) {
                printHorizontalLine(max_lengths);
            }
        }

        // Print bottom border
        printHorizontalLine(max_lengths);
    }

    // Helper method to print horizontal line
    private static void printHorizontalLine(int[] max_lengths) {
        StringBuilder line = new StringBuilder("+");
        for (int length : max_lengths) {
            line.append("-".repeat(length + 2)).append("+");
        }
        System.out.println(line);
    }
    // Main method for testing purposes
    public static void main(String[] args) {
        int[][] mat2 = { { 1, 2, 3 }, { 44, 555, 66 }, { 7, 8, 9 } };

        // Test cases
        System.out.println("Original Matrix:");
        printMatrix(mat2);

        System.out.println("\nColumn Sum:");
        columnSum(mat2);

        System.out.println("\nDiagonal Elements:");
        printDiagonal(mat2);

        System.out.println("\nSecond Diagonal Elements:");
        printSecondDiagonal(mat2);

        int[][] mat3 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

        System.out.println("\nMultiply Matrix:");
        multiplyMatrix(mat2, mat3);

        System.out.println("\nRow Sum:");
        rowSum(mat2);

        System.out.println("\nSum of all elements: " + sumAll(mat2));
    }
}
