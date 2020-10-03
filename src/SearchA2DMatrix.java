/**
 * Created by dbaofd on 2020/10/3.
 */
public class SearchA2DMatrix {
    //special case [[1],[3]], 3
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        if (matrix.length == 0)
            return false;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean isTargetInThisRow = false;
        boolean isTargetFound = false;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (j == 0) {
                    if (i + 1 < rowNum) {
                        if (matrix[i + 1][j] <= target)
                            break;
                        else
                            isTargetInThisRow = true;
                    } else {
                        isTargetInThisRow = true;
                    }
                }
                if (matrix[i][j] == target)
                    return true;
            }
            if (isTargetInThisRow)
                break;
        }
        return isTargetFound;
    }
}
