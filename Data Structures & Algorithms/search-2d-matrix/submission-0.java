class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search turn 2D array to 1D array
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / column;
            int l = mid % column;
            if (matrix[r][l] == target) {
                return true;
            } else if (matrix[r][l] < target) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return false;
    }
}
