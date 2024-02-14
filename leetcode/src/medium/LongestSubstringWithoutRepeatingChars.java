package medium;

public class LongestSubstringWithoutRepeatingChars {
    

    /**
     * Instantiate an int variable to store the max length
     * Create a loop with your two pointers, left and right
     * Instantiate an int variable that stores the index we find for the current character
     *      - using the indexOf method, we can search for a character at index i, starting from the left window
     *      - if the char at ith index is the first occurence of this character, int variable indexOfCharacter should equal i
     *      - if the char at ith index is not the first occurence of this character, int variable indexOfCharacter will equal the index where the first occurence of that char was found
     * With that logic, we can assume that if indexOfCharacter does NOT equal right, then the character is already present within the string
     *      - So, we move the left pointer to where the repeated character is found
     * If the value of indexOfCharacter equals right, then there was no repeat character found
     * We compare max with the size of the window and store the highest value in max
     * Return max
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for(int left = 0, right = 0; right < s.length(); right++) {
            int indexOfCharacter = s.indexOf(s.charAt(right), left);

            if(indexOfCharacter != right) {
                left = indexOfCharacter + 1;
            }
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}
