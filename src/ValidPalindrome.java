public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        String[] words = s.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
        String newS = "";
        for (String str : words) {
            System.out.println(str);
            newS = newS + str;
        }
        for (int i = 0, j = newS.length() - 1; i < newS.length() / 2; i++, j--) {
            if (newS.charAt(i) != newS.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
