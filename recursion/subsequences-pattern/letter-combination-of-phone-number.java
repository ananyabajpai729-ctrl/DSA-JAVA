class Solution {

    private static final String[] KEYPAD = {
        "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder path, List<String> result) {

        if (idx == digits.length()) {
            result.add(path.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String letters = KEYPAD[digit - 2];

        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, idx + 1, path, result);
            path.deleteCharAt(path.length() - 1); 
        }
    }
}
