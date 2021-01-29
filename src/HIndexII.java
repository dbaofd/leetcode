/**
 * Created by dbaofd on 2021/01/30.
 */
public class HIndexII {
//    Runtime: 1 ms, faster than 23.09% of Java online submissions for H-Index II.
//    Memory Usage: 45.7 MB, less than 88.77% of Java online submissions for H-Index II.
    public int hIndex(int[] citations) {
        int hindex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i){
                hindex = citations.length - i;
                break;
            }
        }
        return hindex;
    }
}
