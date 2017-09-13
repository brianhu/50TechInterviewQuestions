package brian;

/**
 * Created by brian on 8/18/17.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        /*
            頭尾空白字元 => 需處理
            小數點 => 需處理
            科學記號 => 需處理
            string 有數字也有其他字元 => return false
            正負號 => 需處理
            非十進位數字(ex: 0xFF) => return false
            兩數字中間有空白 => return false
         */
        // s = "     +20.123   "
        //                    i
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        // "2."
        // ".2"
        if (i < n && (s.charAt(i) == '.')) {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        // s = "2e+10"
        // s = "2e-10"
        // s = "2e"
        // s = "e2"
        if (isNumeric && i < n && (s.charAt(i) == 'e')) {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && s.charAt(i) == ' ') i++;
        return isNumeric && i == n;
    }
}
