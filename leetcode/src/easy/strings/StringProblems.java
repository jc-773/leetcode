package easy.strings;

public class StringProblems {

    /**
     * Write a function that reverses a string. The input string is given as an
     * array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra
     * memory.
     * 
     * @param a
     * @return
     */
    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
        System.out.println(s);
    }

    /**
     * l r
     * W E L C O M E
     * 
     * @param a
     * @return
     */
    public static int longestSubstringWithoutRepeatingCharacters(String a) {
        // check if the char right is a duplicate or not
        // create a window that keeps moving on the right side for every time a unique
        // character is found
        // if character has been found, move the left side of the windown and place
        // right side where left side is + 1
        // also need to keep track of count for every unique iteration
        int max = 0;

        for (int left = 0, right = 0; right < a.length(); right++) {
            int indexOfCharacter = a.indexOf(a.charAt(right), left);//

            if (indexOfCharacter != right) {
                left = indexOfCharacter + 1;
            }
            max = Math.max(max, right - left + 1);

        }
        return max;

    }

    /**
     * This is a more effecient way to check if a string a palindrome by creating
     * two pointers .
     * Without the need of creating a new String Builder object every time a String
     * is passed in
     * 
     * @param a
     * @return
     */
    public static boolean isPalindromePointers(String a) {
        char[] charArray = a.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * This is one way to accomplish the isPalindrome check while using the
     * StringBuilder object and it's methods
     * 
     * @param a
     * @return
     */
    public static boolean isStringPalindrom(String a) {
        StringBuilder b = new StringBuilder(a);
        String reversed = b.reverse().toString();
        return a.equals(reversed);
    }

    /**
     * Initialize variable p to the value of the first index in the strs array
     * Loop from second index to the end of the arrays length - remember we stored
     * the first index value in p
     * On the context of i, the current string in the iteration, we check if p
     * exists by using the indexOf method
     * - indexOf returns 0 if the string is found and -1 if not
     * if not 0, then we chop off the last character of p using the substring method
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String p = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(p) != 0) {
                p = p.substring(0, p.length() - 1);
            }
        }
        return p;
    }

}
