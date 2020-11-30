/**
 * Created by dbaofd on 2020/11/30.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String str = s.trim();
        String reversedString = "";
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() != 0) {
                reversedString = reversedString + words[i] + " ";
            }
        }
        return reversedString.trim();
    }
}
