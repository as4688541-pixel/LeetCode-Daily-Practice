class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index before the start of a valid substring
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            // Opening bracket
            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            // Closing bracket
            else {

                stack.pop();

                // No valid starting point
                if (stack.isEmpty()) {
                    stack.push(i);
                }

                // Valid substring found
                else {
                    int length = i - stack.peek();
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        return maxLen;
    }
}