/**
 * Created by dbaofd on 2020/11/26.
 */
public class ExcelSheetColumnNumber {
    //    Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
    //    Memory Usage: 38.7 MB, less than 94.55% of Java online submissions for Excel Sheet Column Number.
    //    Examples:
    //    B='B'-'A'+1
    //    AB=26*('A'-'A'+1)+'B'-'A'+1
    //    ZY=26*('Z'-'A'+1)+'Y'-'A'+1
    //    ABA=26*26*('A'-'A'+1)+26*('B'-'A'+1)+'A'-'A'+1
    //    ZXYD=26*26*26*('Z'-'A'+1)+26*26*('X'-'A'+1)+26*('Y'-'A'+1)+'D'-'A'+1
    public int titleToNumber(String s) {
        int numberOf26 = s.length() - 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'A' + 1;
            for (int j = 0; j < numberOf26; j++) {
                a *= 26;
            }
            sum += a;
            numberOf26--;
        }
        return sum;
    }
}
