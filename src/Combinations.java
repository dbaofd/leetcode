import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dbaofd on 2020/9/26.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination;
        int startIndex = 0;
        int endindex = 0;
        for (int i = 1; i <= k; i++) {
            if (i == 1) {
                for (int j = 1; j <= n; j++) {
                    combination = new ArrayList<>();
                    combination.add(j);
                    combinations.add(combination);
                }
                endindex = n - 1;
            } else {
                for (int j = startIndex; j <= endindex; j++) {
                    List<Integer> myCombination = combinations.get(j);
                    int lastElementOfMC = myCombination.get(myCombination.size() - 1);
                    if (lastElementOfMC != n) {
                        for (int f = lastElementOfMC + 1; f <= n; f++) {
                            combination = new ArrayList<>();
                            for (int t = 0; t < myCombination.size(); t++) {
                                combination.add(myCombination.get(t));
                            }
                            combination.add(f);
                            combinations.add(combination);
                        }
                    }
                }
                startIndex = endindex + 1;
                endindex = combinations.size() - 1;
            }
        }
        return combinations.subList(startIndex, endindex + 1);
    }
}
