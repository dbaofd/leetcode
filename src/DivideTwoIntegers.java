/**
 * Created by dbaofd on 2020/9/13.
 */

/**
 * Unsolved, low efficiency, time exceed limitation.
 */
public class DivideTwoIntegers {
    public int divide2(int dividend, int divisor) {
        int quotient = 0;
        int dividendSign;
        int divisorSign;
        int dividendAbs;
        int divisorAbs;
        int dividendAbsGap = 0;
        int divisorAbsGap = 0;
        boolean gapExistenceFlag=false;
        boolean overflowFlag=false;
        if (dividend >= 0) {
            dividendSign = 1;//positive
        } else {
            dividendSign = 0;//negative
        }
        if (divisor >= 0) {
            divisorSign = 1;//positive
        } else {
            divisorSign = 0;//negative
        }
        if (dividend != -2147483648) {
            dividendAbs = Math.abs(dividend);
        } else {
            dividendAbs = 2147483647;
            dividendAbsGap = 1;
            gapExistenceFlag=true;
        }
        if (divisor != -2147483648) {
            divisorAbs = Math.abs(divisor);
        } else {
            divisorAbs = 2147483647;
            divisorAbsGap = 1;
            gapExistenceFlag=true;
        }
        if(gapExistenceFlag) {
            dividendAbs = dividendAbs - divisorAbs - divisorAbsGap;
            quotient++;
            dividendAbs += dividendAbsGap;
        }
        while (dividendAbs >= divisorAbs) {
            dividendAbs = dividendAbs - divisorAbs - divisorAbsGap;
            if(quotient!=2147483647){
                quotient++;
            }else{
                overflowFlag=true;
            }
        }
        if(!overflowFlag) {
            if (dividendSign == 1 && divisorSign == 0) {
                quotient = 0 - quotient;
            } else if (dividendSign == 0 && divisorSign == 1) {
                quotient = 0 - quotient;
            }
        }else{
            quotient=2147483647;
        }
        return quotient;
    }



    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        //int a = divideTwoIntegers.divide(-21474838, -2);

        System.out.println(-21474838>>>1);
    }
}
