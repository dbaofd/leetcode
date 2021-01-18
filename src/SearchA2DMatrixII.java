/**
 * Created by dbaofd on 2021/01/18.
 */
public class SearchA2DMatrixII {
//    Runtime: 24 ms, faster than 5.02% of Java online submissions for Search a 2D Matrix II.
//    Memory Usage: 44.4 MB, less than 89.36% of Java online submissions for Search a 2D Matrix II.
    // The core idea is to find a sub matrix that contains the target, and traversal the sub matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        int columnRange = -1;
        int rowRange = -1;
        for (int i = 0; i < matrix[0].length; i++) {
            if (target < matrix[0][i]) {
                if (i == 0) {
                    return false;
                }
                columnRange = i - 1;
                break;
            }
        }
        if (columnRange == -1) {
            columnRange = matrix[0].length - 1;
        }
        for (int j = 0; j < matrix.length; j++) {
            if (target < matrix[j][0]) {
                rowRange = j - 1;
            }
            break;
        }
        if (rowRange == -1) {
            rowRange = matrix.length - 1;
        }
        for (int i = 0; i <= rowRange; i++) {
            for (int j = 0; j <= columnRange; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
