/**
 * Created by dbaofd on 2020/9/12.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        boolean flag = true;
        for (int i = 0, j = xStr.length() - 1; i < xStr.length() / 2; i++, j--) {
            if (xStr.charAt(i) != xStr.charAt(j)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
