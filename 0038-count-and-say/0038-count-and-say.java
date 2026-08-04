class Solution {

    public String countAndSay(int n) {

        String s = "1";

        while (--n > 0) {

            StringBuilder sb = new StringBuilder();

            int i = 0;

            while (i < s.length()) {

                int count = 1;

                while (i + 1 < s.length() &&
                       s.charAt(i) == s.charAt(i + 1)) {

                    count++;
                    i++;
                }

                sb.append(count);
                sb.append(s.charAt(i));

                i++;
            }

            s = sb.toString();
        }

        return s;
    }
}