package LeetCode.Leet_StringToInteger;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        int idx = 0;
        // ignore whitespace
        while (idx < len && s.charAt(idx) == ' ')
            idx++;

        if (idx == len) {
            return 0;
        }

        boolean isNegative = false;
        // check positivity
        if (s.charAt(idx) == '-') {
            isNegative = true;
            idx++;
        } else if (s.charAt(idx) == '+') {
            idx++;
        }

        if (idx == len || s.charAt(idx) < '0' || s.charAt(idx) > '9') {
            return 0;
        }

        // check character
        if (s.charAt(idx) < '0' || s.charAt(idx) > '9')
            return 0;

        int startIndex = idx;
        // check digits
        while (idx < len && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            idx++;
        }

        String numStr = s.substring(startIndex, idx);

        long result = 0;
        for (int i = 0; i < numStr.length(); i++) {
            result = result * 10 + (numStr.charAt(i) - '0');
            if (isNegative && -result < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
                break;
            } else if (!isNegative && result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
                break;
            }
        }

        result = isNegative ? -result : result;

        return (int) result;
    }
}
