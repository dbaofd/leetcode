/**
 * Created by dbaofd on 2020/9/20.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        String result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    if (carry == 1) {
                        result = "1" + result;
                    } else {
                        result = "0" + result;
                    }
                    carry = 1;
                } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                    result = String.valueOf(carry) + result;
                    carry = 0;
                } else {
                    if (carry == 1) {
                        result = "0" + result;
                        carry = 1;
                    } else {
                        result = "1" + result;
                        carry = 0;
                    }
                }
            } else if (i >= 0) {
                if (carry == 1) {
                    if (a.charAt(i) == '1') {
                        result = "0" + result;
                        carry = 1;
                    } else {
                        result = "1" + result;
                        carry = 0;
                    }
                } else {
                    result = Character.toString(a.charAt(i)) + result;
                }
            } else {
                if (carry == 1) {
                    if (b.charAt(j) == '1') {
                        result = "0" + result;
                        carry = 1;
                    } else {
                        result = "1" + result;
                        carry = 0;
                    }
                } else {
                    result = Character.toString(b.charAt(j)) + result;
                }
            }
            i--;
            j--;
        }
        if (carry == 1)
            result = "1" + result;
        return result;
    }
}
