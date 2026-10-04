class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--;
                maxOpen++;
            }

            // Minimum cannot be negative
            minOpen = Math.max(0, minOpen);

            // Even maximum is negative -> impossible
            if (maxOpen < 0) {
                return false;
            }
        }

        return minOpen == 0;
    }
}