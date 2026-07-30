class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4 || s.length() > 12)
            return ans;

        backtrack(s, 0, 0, new StringBuilder());

        return ans;
    }

    private void backtrack(String s, int index, int parts, StringBuilder path) {

        if (parts == 4) {
            if (index == s.length()) {
                ans.add(path.substring(0, path.length() - 1));
            }
            return;
        }

        // Pruning
        int remaining = s.length() - index;

        if (remaining < (4 - parts) || remaining > (4 - parts) * 3)
            return;

        int len = path.length();

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {

            String part = s.substring(index, index + i);

            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            int value = Integer.parseInt(part);

            if (value > 255)
                break;

            path.append(part).append('.');

            backtrack(s, index + i, parts + 1, path);

            path.setLength(len);
        }
    }
}