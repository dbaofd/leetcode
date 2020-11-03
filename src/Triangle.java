import java.util.List;

/**
 * Created by dbaofd on 2020/11/03.
 */
public class Triangle {
    //You need to do it from bottom to top.
    //Special example [[-1],[2,3],[1,-1,-3]], try bottom to top and top to bottom respectively,
    //You will see bottom to top can provide correct answer.
    //Notice point: when you are triangle[i][j],you got two options for the next row,
    //triangle[i+1][j] and triangle[i+1][j+1].
    //The description doesn't make it clear.
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
