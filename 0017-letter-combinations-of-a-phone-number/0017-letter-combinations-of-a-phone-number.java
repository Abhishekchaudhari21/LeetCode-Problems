class Solution {

    private final String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private List<String> ans = new ArrayList<>();
    private StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return ans;

        dfs(digits, 0);

        return ans;
    }

    private void dfs(String digits, int index) {

        if (index == digits.length()) {
            ans.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {

            path.append(c);

            dfs(digits, index + 1);

            path.deleteCharAt(path.length() - 1);
        }
    }
}