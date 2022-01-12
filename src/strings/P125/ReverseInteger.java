package strings.P125;

import javax.print.DocFlavor;

/**
 * LeetCode P7. Reverse Integer
 *
 * @author Jonghoon Jang
 * @version Jan, 2022
 */
public final class ReverseInteger {

    private ReverseInteger() {
    }

    public static int reverse(final int x) {
        if (x < -Math.pow(2, 31) || x > Math.pow(2, 31) - 1) {
            return 0;
        }

        String stringValue = String.valueOf(x);
        StringBuilder reversedValue = new StringBuilder();
        System.out.println(stringValue);
        int numberLength = stringValue.length();
        for (int i = numberLength - 1; i >= 0; i--) {
//            System.out.println(stringValue.charAt(i));
            if (stringValue.charAt(i) != '-') {
                reversedValue.append(stringValue.charAt(i));
            }
        }
        try {
            int reversedInt = Integer.parseInt(String.valueOf(reversedValue));
            reversedInt = stringValue.charAt(0) == '-' ? -reversedInt : reversedInt;

            if (reversedInt < -Math.pow(2, 31) || reversedInt > Math.pow(2, 31) - 1) {
                return 0;
            }

            return reversedInt;

        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int test = 123;
        System.out.println(reverse(test));
    }
}
