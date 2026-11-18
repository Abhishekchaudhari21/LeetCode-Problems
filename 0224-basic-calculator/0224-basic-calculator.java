
class Solution {
    public int calculate(String s) {

        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }

            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }

            else if (c == '(') {

                // Save previous calculation context
                stack.push(result);
                stack.push(sign);

                // Start a new expression
                result = 0;
                sign = 1;
            }

            else if (c == ')') {

                // Complete the current number
                result += sign * number;
                number = 0;

                // Restore previous calculation context
                result *= stack.pop();
                result += stack.pop();
            }

            // Spaces are ignored
        }

        // Add the final number
        return result + sign * number;
    }
}
