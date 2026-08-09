class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {

            int j = i;
            int letters = 0;

            // Find the maximum words that fit
            while (j < n &&
                   letters + words[j].length() + (j - i) <= maxWidth) {

                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            int spaces = maxWidth - letters;

            StringBuilder line = new StringBuilder(maxWidth);

            // Last line OR single-word line
            if (j == n || gaps == 0) {

                for (int k = i; k < j; k++) {

                    if (k > i)
                        line.append(' ');

                    line.append(words[k]);
                }

                while (line.length() < maxWidth)
                    line.append(' ');

            } else {

                int even = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int count = even + (k - i < extra ? 1 : 0);

                        for (int x = 0; x < count; x++)
                            line.append(' ');
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}