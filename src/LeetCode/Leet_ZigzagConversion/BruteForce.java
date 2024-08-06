package LeetCode.Leet_ZigzagConversion;

public class BruteForce {
    public static String convert(String s, int numRows) {
        int len = s.length();
        int row = 0;
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(s.charAt(i++));
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(s.charAt(i++));
            }
        }

        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }

        return sb[0].toString();
    }
}
