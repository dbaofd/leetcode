/**
 * Created by dbaofd on 2020/12/19.
 */
public class PowerOfTwo {
    //The idea is that if a number is a poer of 2, its binary form has only one '1' bit,
    //the rest bits should '0'.
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
    //Low efficiency
//    public boolean isPowerOfTwo(int n) {
//        if (n == 1)
//            return true;
//        if (n % 2 != 0)
//            return false;
//        int a = 1;
//        while (true) {
//            if (a > n) {
//                return false;
//            } else if (a == n) {
//                return true;
//            }
//            a = a * 2;
//        }
//    }
}
