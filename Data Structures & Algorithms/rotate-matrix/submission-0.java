class Solution {
    public void rotate(int[][] matrix) {
        // first reverse the matrix vertically
        reverse(matrix);
        int rows = matrix.length;
        int columns = matrix[0].length;
        // then swap the matrix by column and row
        for (int i = 0; i < rows; i++ ){
            for (int j = i; j < columns; j++){
                int temp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        
    }

    public void reverse(int[][] matrix){
        int rows = matrix.length;
        for (int i = 0; i < rows/2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[rows-1-i];
            matrix[rows-1-i] = temp;
        }
    }
}
