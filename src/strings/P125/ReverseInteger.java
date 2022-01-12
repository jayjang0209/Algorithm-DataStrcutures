package strings.P125;

/**
 * LeetCode P7. Reverse Integer
 *
 * @author Jonghoon Jang
 * @version Jan, 2022
 */
public final class ReverseInteger {

    private ReverseInteger() {
    }

    /**
     * Reverse a signed 32-bit integer.
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     *
     * @param x an integer
     * @return string array as a List
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int reverse(final int x) {
        if (x < -Math.pow(2, 31) || x > Math.pow(2, 31) - 1) {
            return 0;
        }

        String stringValue = String.valueOf(x);
        StringBuilder reversedValue = new StringBuilder();
        System.out.println(stringValue);
        int numberLength = stringValue.length();
        for (int i = numberLength - 1; i >= 0; i--) {
            if (stringValue.charAt(i) != '-') {
                reversedValue.append(stringValue.charAt(i));
            }
        }
        try {
            int reversedInt = Integer.parseInt(String.valueOf(reversedValue));

            if (stringValue.charAt(0) == '-') {
                reversedInt = -reversedInt;
            }

            if (reversedInt < -Math.pow(2, 31) || reversedInt > Math.pow(2, 31) - 1) {
                return 0;
            }
            return reversedInt;

        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
