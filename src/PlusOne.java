/**
 * Created by dbaofd on 2020/9/19.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i]++;
                carry = 0;
            }
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            for (int i = 0; i < newDigits.length; i++) {
                if (i == 0) {
                    newDigits[i] = 1;
                } else {
                    newDigits[i] = digits[i - 1];
                }
            }
            return newDigits;
        }
        return digits;
    }
}
