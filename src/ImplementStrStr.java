/**
 * Created by dbaofd on 2020/9/13.
 */
public class ImplementStrStr {
    //Special test case ("aaa","aaaa"), ("mississippi","issip").
    //A test case for testing performance, ("aaaaa....aaaaa"(30000 a),"");
    public int strStr(String haystack, String needle) {
        int firstIndex = -1;
        if (needle.length() > 0) {
            for (int i = 0; i < haystack.length(); i++) {
                int j = 0;
                int t = i;
                // For special case ("mississippi","issip"), neddle[0] is 'i'.
                // The first time to map, find that "issi" cannot be mapped to "issip",
                // but the second 'i' in "issi" can be next potential first index.
                // So nextPotentialFirstIndex used for recording index of second 'i' in "issi".
                int nextPotentialFirstIndex = -1;
                while (haystack.charAt(i) == needle.charAt(j)) {
                    if (j == needle.length() - 1) {
                        firstIndex = t;
                        break;
                    }
                    if (nextPotentialFirstIndex == -1 && haystack.charAt(i) == needle.charAt(0)) {
                        // In the if condition, we need to make sure nextPotentialFirstIndex is -1, since
                        // I want to find next potential first index. Once find one, no need find other potential indexes.
                        nextPotentialFirstIndex = i;
                    }
                    i++;
                    j++;
                    if (i > haystack.length() - 1) {
                        break;
                    }
                }
                // If find nextPotentialFirstIndex, then next loop in for loop start from nextPotentialFirstIndex,
                // otherwise just start with the final i in previous while loop.
                if (nextPotentialFirstIndex != -1) {
                    i = nextPotentialFirstIndex;
                }
                // If find the first index, then break the loop.
                if (firstIndex != -1) {
                    break;
                }
            }
        } else {
            firstIndex = 0;
        }
        return firstIndex;
    }
}
