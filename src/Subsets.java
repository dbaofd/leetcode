import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dbaofd on 2020/9/21.
 */
public class Subsets {
    //faster than 65.16% of Java online submissions for Subsets.
    //39.7 MB, less than 70.00% of Java online submissions for Subsets.
    //Take nums=[1,2,3] as example. The main idea of this algorithm is to compute subsets based on the number of
    //elements. Say, I first compute 1-element subsets, add them to the subsetList.
    //next time I compute 2-elements subsets based on 1-element subsets.
    //In the beginning, I creat a map to store all the index of elements in nums.
    //This map is used to judge if the last element of current subset is last element in nums.
    //Here, i am computing 2-elements subset. I get the first 1-element subset by using startIndex.
    //I find that the element is '1' which is not the last element in nums. So I put [1,2],[1,3] to the subsetList.
    //When the loop reach third 1-element subset [3], '3' is the last one in nums, in this case, I don't do any operation.
    //When I try to compute the 3-elements subsets, I will take advantage of 2-elements subsets as well.
    //Say i got the first 2-elements subset [1,2], find '2' is not the last one in nums. So I put[1,2,3] to the subsetList.
    //When the loop reach second[1,3] and third[2,3] 2-elements subset, the program finds that '3' is the last one of nums.
    //Then I don't do any thing.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        Map<Integer, Integer> numsMap = new HashMap<>();
        List<Integer> subset = null;
        List<Integer> preSubset = null;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        // add subsets with one elements
        for (int i = 0; i < nums.length; i++) {
            subset = new ArrayList<>();
            subset.add(nums[i]);
            numsMap.put(nums[i], i);
            subsetList.add(subset);
        }

        //if nums length is 5, we will have 5 types of subsets,
        //e.g. 1-element subsets, 2-elements subsets,..., 5-elements subsets.
        //plus a null subset.
        for (int i = 1; i < nums.length; i++) {//if i equals to 1, means in this loop will compute all the 2-elements subsets.
            while (true) {
                preSubset = subsetList.get(startIndex);
                int lastElementIndexInNums = numsMap.get(preSubset.get(preSubset.size() - 1));
                if (lastElementIndexInNums != nums.length - 1) {
                    for (int k = lastElementIndexInNums + 1; k < nums.length; k++) {
                        subset = new ArrayList<>();
                        for (int j = 0; j < preSubset.size(); j++) {
                            subset.add(preSubset.get(j));
                        }
                        subset.add(nums[k]);
                        subsetList.add(subset);
                    }
                }
                startIndex++;
                if (startIndex == endIndex + 1)
                    break;
            }
            startIndex = endIndex + 1;
            endIndex = subsetList.size() - 1;
        }
        subset = new ArrayList<>();
        subsetList.add(subset);
        return subsetList;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsetList = subsets.subsets(new int[]{1, 2, 3, 4});
        for (int i = 0; i < subsetList.size(); i++) {
            for (int j = 0; j < subsetList.get(i).size(); j++) {
                System.out.print(subsetList.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
