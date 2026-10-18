class Solution {
    public int[][] imageSmoother(int[][] img) {
        int colLength = img[0].length;
        int rowLength = img.length;
        int[][] res = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++){
            for (int j = 0; j < colLength; j++){
                int total = 0;
                int count = 0;
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < rowLength && c >= 0 && c < colLength) {
                            total += img[r][c];
                            count++;
                        }
                    }
                }

                res[i][j] = total/count;
        }
        }
        return res;
        }




}
