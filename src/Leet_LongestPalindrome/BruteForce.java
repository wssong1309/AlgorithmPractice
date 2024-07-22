package Leet_LongestPalindrome;

public class BruteForce {
    public String longestPalindrome(String s) {
        int length = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int result = isPalindrom(s, i, j);
                if (result > length) {
                    length = result;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public int isPalindrom(String s, int start, int end) {
        int length = end - start + 1;
        while (start <= end) {
            if (s.charAt(start++) == s.charAt(end--)) {
                continue;
            } else {
                return -1;
            }
        }
        return length;
    }
}
