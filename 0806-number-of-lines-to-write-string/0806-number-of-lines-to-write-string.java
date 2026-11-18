
class Solution {
    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int currentWidth = 0;

        for (int i = 0; i < s.length(); i++) {

            int charWidth = widths[s.charAt(i) - 'a'];

            if (currentWidth + charWidth > 100) {
                lines++;
                currentWidth = charWidth;
            } else {
                currentWidth += charWidth;
            }
        }

        return new int[]{lines, currentWidth};
    }
}
