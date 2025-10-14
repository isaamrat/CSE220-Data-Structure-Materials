import numpy as np

# Here in printMatrix function multiple inbuilt functions are used to make the formatting look good. You are not allowed to use this in your code.

def printMatrix(mat):
    """
    Prints a matrix with formatted output.
    """
    r, c = mat.shape
    max_lengths = [max(len(str(mat[i, j])) for i in range(r)) for j in range(c)]
    rowChars = []
    for i in range(r):
        formatted_row = '| ' + ' | '.join(f"{mat[i, j]:>{max_lengths[j]}}" for j in range(c)) + ' | '
        rowChars.append(formatted_row)
    for i in range(len(rowChars)):
        print('-'*(len(rowChars[i])-1))
        print(rowChars[i])
        if i == len(rowChars)-1:
            print('-'*(len(rowChars[i])-1))

def columnSum(matrix1):
    """
    Calculates and prints the sum of each column in a matrix.
    """
    r, c = matrix1.shape
    resultedArray = np.zeros(c, dtype=int)
    for j in range(c):
        for i in range(r):
            resultedArray[j] += matrix1[i][j]
    print(resultedArray)

def printDiagonal(matrix1):
    """
    Prints the elements of the main diagonal of a square matrix.
    """
    r, c = matrix1.shape
    for i in range(r):
        print(matrix1[i][i])

def printSecondDiagonal(mat):
    """
    Prints the elements of the secondary diagonal of a square matrix.
    """
    r, c = mat.shape
    for i in range(r):
        print(mat[i][r-1-i])


def sumAll(mat):
    """
    Calculates the sum of all elements in a 2D array.
    """
    r, c = mat.shape # Get the number of rows and columns
    total_sum = 0 # Initialize the sum
    for i in range(r): # Iterate through each row
        for j in range(c): # Iterate through each column
            total_sum += mat[i][j] # Add the element to the sum
    return total_sum # Return the total sum

def rowSum(mat):
    """
    Calculates and prints the row sums of a matrix.
    """
    r, c = mat.shape # Get the number of rows and columns
    resultedArray = np.zeros((r, 1), dtype=int) # Initialize the result array
    for i in range(r): # Iterate through rows
        for j in range(c): # Iterate through columns
            resultedArray[i][0] += mat[i][j] # Calculate the row sum
    printMatrix(resultedArray) # Print the row sums

def multiplyMatrix(matA, matB):
    """
    Multiplies two matrices and prints the result.
    """
    ar, ac = matA.shape # Dimensions of matrix A
    br, bc = matB.shape # Dimensions of matrix B
    result = np.zeros((ar, bc), dtype=int) # Initialize the result matrix
    for i in range(ar): # Iterate through rows of A
        for j in range(bc): # Iterate through columns of B
            for k in range(br): # Iterate through rows of B
                result[i][j] += matA[i][k] * matB[k][j] # Perform matrix multiplication
    printMatrix(result) # Print the result matrix

def print_spiral(matrix):
    """
    Print matrix in spiral order.
    """
    # Check for empty matrix
    if not matrix or not matrix[0]:
        return
    # Define matrix boundaries
    row_start, row_end = 0, len(matrix) - 1
    col_start, col_end = 0, len(matrix[0]) - 1
    # Traverse the matrix in spiral order
    while row_start <= row_end and col_start <= col_end:
        # Traverse top row (left → right)
        for c in range(col_start, col_end + 1):
            print(matrix[row_start][c], end=" ")
        row_start += 1  # Move top boundary down
        # Traverse right column (top → bottom)
        for r in range(row_start, row_end + 1):
            print(matrix[r][col_end], end=" ")
        col_end -= 1  # Move right boundary left
        # Traverse bottom row (right → left), if rows remain
        if row_start <= row_end:
            for c in range(col_end, col_start - 1, -1):
                print(matrix[row_end][c], end=" ")
            row_end -= 1  # Move bottom boundary up
        # Traverse left column (bottom → top), if columns remain
        if col_start <= col_end:
            for r in range(row_end, row_start - 1, -1):
                print(matrix[r][col_start], end=" ")
            col_start += 1  # Move left boundary right
    print()  # Newline after full traversal

# Main method with test cases
if __name__ == "__main__":
    # Test case for printMatrix
    mat_test = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    print("Test Case printMatrix:")
    printMatrix(mat_test)

    # Test case for columnSum
    mat_sum_test = np.array([[1, 2, 3], [4, 5, 6]])
    print("\nTest Case columnSum:")
    columnSum(mat_sum_test)

    # Test case for printDiagonal
    mat_diag_test = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    print("\nTest Case printDiagonal:")
    printDiagonal(mat_diag_test)

    # Test case for printSecondDiagonal
    mat_sec_diag_test = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    print("\nTest Case printSecondDiagonal:")
    printSecondDiagonal(mat_sec_diag_test)


    # Test case for sumAll
    mat_sum_all_test = np.array([[1, 2, 3], [4, 5, 6]])
    print("\nTest Case sumAll:")
    print(sumAll(mat_sum_all_test))

    # Test case for rowSum
    mat_row_sum_test = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    print("\nTest Case rowSum:")
    rowSum(mat_row_sum_test)

    # Test case for multiplyMatrix
    mat_multiply_test_A = np.array([[1, 2], [3, 4], [5, 6]])
    mat_multiply_test_B = np.array([[5, 6], [7, 8]])
    print("\nTest Case multiplyMatrix:")
    multiplyMatrix(mat_multiply_test_A, mat_multiply_test_B)
