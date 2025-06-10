class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false, seenDot = false, seenE = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '.' && !seenDot && !seenE) {
                seenDot = true;
            } else if ((c == 'e' || c == 'E') && seenDigit && !seenE) {
                seenE = true;
                seenDigit = false;
            } else if ((c == '+' || c == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
            } else {
                return false;
            }
        }
        return seenDigit;
    }
}
