import javax.management.Query;
import java.util.*;


/**
 * Created by dbaofd on 2020/9/18.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> binaryList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (n >= 1) {
            binaryList.add("0");
            binaryList.add("1");
        } else {
            result.add(0);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = (int) Math.pow(2, i - 1) - 1; j >= 0; j--) {
                String binaryString = binaryList.get(j);
                binaryList.add("1" + binaryString);
                binaryList.set(j, "0" + binaryString);
            }
        }
        for (int k = 0; k < binaryList.size(); k++) {
            result.add(Integer.parseUnsignedInt(binaryList.get(k), 2));
        }
        return result;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        //the integer key means the number of '1' bits in an integer number
        Map<Integer, Queue<Integer>> myMap = new HashMap<>();
        int numOfGrayCode = (int) Math.pow(2, n);
        //Classify integers by their number of '1'(binary form)
        for (int i = 0; i < numOfGrayCode; i++) {
            String binaryNumString = Integer.toBinaryString(i).toString();
            int numOfOnes = 0;
            for (int j = 0; j < binaryNumString.length(); j++) {
                if (binaryNumString.charAt(j) == '1') {
                    numOfOnes++;
                }
            }
            if (myMap.containsKey(numOfOnes)) {
                Queue<Integer> myQueue = myMap.get(numOfOnes);
                myQueue.add(i);
            } else {
                Queue<Integer> myQueue = new LinkedList<>();
                myQueue.add(i);
                myMap.put(numOfOnes, myQueue);
            }
        }
        int previousKey = 0;
        result.add(myMap.get(previousKey).poll());
        myMap.remove(previousKey);
        while (myMap.size() != 0) {
            if (myMap.containsKey(previousKey - 1)) {
                result.add(myMap.get(previousKey - 1).poll());
                if (myMap.get(previousKey - 1).size() == 0) {
                    myMap.remove(previousKey - 1);
                }
                previousKey--;
            } else if (myMap.containsKey(previousKey + 1)) {
                result.add(myMap.get(previousKey + 1).poll());
                if (myMap.get(previousKey + 1).size() == 0) {
                    myMap.remove(previousKey + 1);
                }
                previousKey++;
            }
        }
        return result;
    }
}
