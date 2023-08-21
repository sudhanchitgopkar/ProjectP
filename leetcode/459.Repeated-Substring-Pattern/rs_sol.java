class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (verifyString(s, i + 1)) return true;
        } // for

        return false;
    } // repeatedSubstringPattern

    public boolean verifyString(String s, int r) {
        if (s.length() % r != 0) return false;

        for (int i = r; i < s.length(); i++) {
            char curr = s.charAt(i % r);
            if (curr != s.charAt(i)) return false;
        } // for

        return true;
    } // verifyString
} // Solution