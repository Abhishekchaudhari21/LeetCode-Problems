
class Solution {

    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {

        // Return cached results if already calculated
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        // Try every operator as the final operation
        for (int i = 0; i < expression.length(); i++) {

            char op = expression.charAt(i);

            if (op == '+' || op == '-' || op == '*') {

                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults =
                    diffWaysToCompute(left);

                List<Integer> rightResults =
                    diffWaysToCompute(right);

                // Combine every possible pair
                for (int a : leftResults) {
                    for (int b : rightResults) {

                        if (op == '+') {
                            results.add(a + b);
                        }
                        else if (op == '-') {
                            results.add(a - b);
                        }
                        else {
                            results.add(a * b);
                        }
                    }
                }
            }
        }

        // No operator found: expression is a number
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);

        return results;
    }
}
