
class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Number of characters must equal number of words
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            // Check character -> word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            }

            // Check word -> character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            }

            // Store both mappings
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }

        return true;
    }
}
