/**
 * Created by dbaofd on 2020/9/12.
 */
public class ReverseInteger {
    public int reverse(int x) {
        String xStr = String.valueOf(x);
        String reverseStr = "";
        boolean nonZeroFlag = true;
        for (int i = xStr.length() - 1; i >= 0; i--) {
            if (i != 0) {
                //this if condition is to deal with 3200->23
                //if the first n digits of reverse number are all 0,
                //then remove the 0s
                if (xStr.charAt(i) != '0' || !nonZeroFlag) {
                    reverseStr += xStr.charAt(i);
                    nonZeroFlag = false;
                }
            } else {
                if (xStr.charAt(i) == '-') {
                    reverseStr = '-' + reverseStr;
                } else {
                    reverseStr += xStr.charAt(i);
                }
            }
        }
        int reverseInt;
        try {
            reverseInt = Integer.parseInt(reverseStr);
        } catch (Exception e) {
            System.out.println(e);
            reverseInt = 0;
        }
        return reverseInt;
    }
}
