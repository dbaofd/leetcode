import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/10/30.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return results.get(rowIndex);
    }
}
