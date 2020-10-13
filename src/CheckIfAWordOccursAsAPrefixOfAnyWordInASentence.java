public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int count = 0;
        boolean isPrefix = true;
        for (int i = 0; i < words.length; i++) {
            count++;
            isPrefix = true;
            if (words[i].length() >= searchWord.length()) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (j > searchWord.length() - 1) {
                        break;
                    }
                    if (words[i].charAt(j) != searchWord.charAt(j)) {
                        isPrefix = false;
                        break;
                    }
                }
                if (isPrefix) {
                    break;
                }
            } else {
                isPrefix = false;
            }
        }
        if (!isPrefix) {
            count = -1;
        }
        return count;
    }
}
