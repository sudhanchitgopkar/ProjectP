class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        
        while (--columnNumber >= 0) {
            char c = (char)((columnNumber % 26) + 'A');
            str.insert(0, c);
            columnNumber /= 26;
        } // while

        return str.toString();
    } // convertToTitle
} // Solution