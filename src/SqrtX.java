/**
 * Created by dbaofd on 2020/10/1.
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x >= 2147395600) {
            return 46340;
        } else if (x >= 2147302921) {
            return 46339;
        }
        int product = 0;
        int root = 1;
        while (product <= x) {
            product = root * root;
            root++;
        }
        root = root - 2;
        System.out.println(root);
        return root;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        sqrtX.mySqrt(2147302920);
    }
}
