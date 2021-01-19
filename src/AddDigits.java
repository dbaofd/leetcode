/**
 * Created by dbaofd on 2021/01/19.
 */
public class AddDigits {
//    Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
//    Memory Usage: 36.5 MB, less than 19.85% of Java online submissions for Add Digits.
    public int addDigits(int num) {
        int sum = 0;
        while (num > 9) {
            sum = 0;
            String str = Integer.toString(num);
            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }
            num = sum;
        }
        return num;
    }
}
