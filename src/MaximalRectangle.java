/**
 * Created by dbaofd on 2020/9/27.
 */
public class MaximalRectangle {
    //Low efficiency, faster than 5.10%, but less memory usage, less than 89.68%.
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int colNums = matrix[0].length;
        int rowNums = matrix.length;
        int maxArea = 0;
        int currentArea = 0;
        int sum = 0;
        int mergeNum = 1;
        if (colNums == 0 && rowNums == 0)
            return 0;
        while (mergeNum <= colNums) {
            //System.out.println("mergeNum" + mergeNum);
            for (int i = 0; i < colNums - mergeNum + 1; i++) {
                currentArea = 0;
                for (int j = 0; j < rowNums; j++) {
                    sum = 0;
                    for (int k = 0; k < mergeNum; k++) {
                        sum += (matrix[j][i + k] == '1' ? 1 : 0);
                    }
                    //System.out.print(sum + " ");
                    if (sum == mergeNum) {
                        currentArea += mergeNum;
                        if (currentArea > maxArea) {
                            maxArea = currentArea;
                        }
                    } else {
                        currentArea = 0;
                    }
                }
                //System.out.println("max" + maxArea);
            }
            mergeNum++;
        }
        return maxArea;
    }
}
