package strings.P125;

/**
 * LeetCode P125. Valid Palindrome
 *
 * @author Jonghoon Jang
 * @version Dec, 2021
 */
public final class Palindrome {

    private Palindrome() {
    }

    /**
     * Returns true if the given string is a palindrome, or false otherwise.
     *
     * @param s a string
     * @return true if the given string is a palindrome, or false otherwise
     */
    public static boolean isPalindrome(final String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        String transformedString = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        System.out.println(transformedString);
        int pointerToLeft = 0;
        int pointerToRight = transformedString.length() - 1;

        while (pointerToLeft < pointerToRight) {
            System.out.println(transformedString.charAt(pointerToLeft));
            System.out.println(transformedString.charAt(pointerToRight));
            if (transformedString.charAt(pointerToLeft)
                    != transformedString.charAt(pointerToRight)) {
                return false;
            }
            pointerToLeft++;
            pointerToRight--;
        }

        return true;
    }

    /**
     * Runs the program.
     *
     * @param args not used
     */
    public static void main(final String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }

}
