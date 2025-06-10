import java.util.*;

class Solution {
    List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrack(result, digits, mapping, new StringBuilder(), 0);
        return result;
    }

    void backtrack(List<String> result, String digits, String[] mapping, StringBuilder sb, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char c : mapping[digits.charAt(index) - '0'].toCharArray()) {
            sb.append(c);
            backtrack(result, digits, mapping, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        List<String> combinations = new Solution().letterCombinations(digits);
        System.out.println(combinations);
        scanner.close();
    }
}