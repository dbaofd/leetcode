import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/29.
 */
public class PascalsTriangle {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
//    Memory Usage: 37.1 MB, less than 12.73% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0)
            return results;
        for (int i = 0; i < numRows; i++) {
            List<Integer> li = new ArrayList<>();
            if (i == 0) {
                li.add(1);
                results.add(li);
            } else if (i == 1) {
                li.add(1);
                li.add(1);
                results.add(li);
            } else {
                List<Integer> previousList = results.get(i - 1);
                li.add(1);
                for (int j = 1; j < previousList.size(); j++) {
                    li.add(previousList.get(j - 1) + previousList.get(j));
                }
                li.add(1);
                results.add(li);
            }
        }
        return results;
    }
}
