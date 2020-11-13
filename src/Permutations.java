import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbaofd on 2020/11/13.
 */
public class Permutations {
    //    Runtime: 1 ms, faster than 91.93% of Java online submissions for Permutations.
//    Memory Usage: 39.3 MB, less than 49.50% of Java online submissions for Permutations.
    private void doPermutation(List<List<Integer>> myList, List<Integer> restNum, List<Integer> currentList) {
        if (restNum.size() == 1) {//got one unselected num, in this step, new permutation is generated
            currentList.add(restNum.get(0));
            myList.add(currentList);//add new permutation to the permutation list
            return;
        } else {
            for (int i = 0; i < restNum.size(); i++) {
                List<Integer> newCurrentList = new ArrayList<>();
                //Copy selected numbers from selected number list
                for (int j = 0; j < currentList.size(); j++) {
                    newCurrentList.add(currentList.get(j));
                }
                //select new number
                newCurrentList.add(restNum.get(i));

                //create new unselected num list (remove element i from restNum)
                List<Integer> newRestNum = new ArrayList<>();
                for (int k = 0; k < restNum.size(); k++) {
                    if (k != i) {
                        newRestNum.add(restNum.get(k));
                    }
                }
                doPermutation(myList, newRestNum, newCurrentList);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> myList = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> li = new ArrayList<>();
            li.add(nums[0]);
            myList.add(li);
            return myList;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> restNum = new ArrayList<>();//to store unselected numbers
            List<Integer> currentList = new ArrayList<>();//to store selected numbers
            currentList.add(nums[i]);
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    restNum.add(nums[j]);
                }
            }
            doPermutation(myList, restNum, currentList);
        }
        return myList;
    }
}
