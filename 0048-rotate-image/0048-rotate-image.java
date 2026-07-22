class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //ring ke luye h outer loop
        for(int i = 0 ; i < (n + 1) / 2 ; i++){
            //ring ke elements ke liye h yeh wali 
            for(int j = 0 ; j < n / 2 ; j++){
                //4 way swap 
                int temp = matrix[n - 1 - j][i];//bottem left value
                matrix[n - 1 - j][i] = matrix[n - 1 -i][n - j - 1];//bottom right
                matrix[n - 1 -i][n - j - 1] = matrix[j][n - 1 -i]; // top right
                matrix[j][n - 1 -i] = matrix[i][j];//top left
                matrix[i][j] = temp;
            }
        }
    }
}