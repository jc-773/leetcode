package easy.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringProblems {

    
    
    /**
     * l r
     * [1,0,1]
     * 
     * @param nums
     */
    public static int[] moveZeroes(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    public static int[] convertHashSetToArray(Set<Integer> convertThisSet) {
        int[] array = new int[convertThisSet.size()];
        int index = 0;
        for (int num : convertThisSet) {
            array[index++] = num;
        }

        return array;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // store nums1 in a hash set to remove all duplicates
        Set<Integer> numsOneSet = new HashSet<>();
        for (int nums : nums1) {
            numsOneSet.add(nums);
        }

        // get all the intersected elements and store in a hash set
        Set<Integer> numsTwoSet = new HashSet<>();
        for (int nums : nums2) {
            if (numsOneSet.contains(nums)) {
                numsTwoSet.add(nums);
            }
        }

        // convert the interected set to an array and return it
        int[] intersectionArray = new int[numsTwoSet.size()];
        int index = 0;
        for (int nums : numsTwoSet) {
            intersectionArray[index++] = nums;
        }

        return intersectionArray;

    }

    /**
     * Not fast enough...
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKkFrequent(int[] nums, int k) {
        if (nums.length >= k) {
            Map<Integer, Integer> mapCount = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (mapCount.containsKey(nums[i])) {
                    int count = mapCount.get(nums[i]).intValue();
                    mapCount.put(nums[i], count += 1);
                } else {
                    mapCount.put(nums[i], 1);
                }
            }

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(mapCount.entrySet());
            entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            List<Map.Entry<Integer, Integer>> topEntries = entryList.subList(0, k);

            int count = 0;
            int[] returnArray = new int[k];
            for (Map.Entry<Integer, Integer> entry : topEntries) {
                returnArray[count] = entry.getKey();
                count++;
            }

            return returnArray;

        }
        return null;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length >= k) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int left = 0, right = 0; right < nums.length; right++) {
                if (nums[right] == nums[left]) {
                    countMap.put(nums[right], right - left + 1);
                } else {
                    left = right;
                    countMap.put(nums[right], 1);
                }
            }

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
            entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            List<Map.Entry<Integer, Integer>> topEntries = entryList.subList(0, k);

            int count = 0;
            int[] returnArray = new int[k];
            for (Map.Entry<Integer, Integer> entry : topEntries) {
                returnArray[count] = entry.getKey();
                count++;
            }

            return returnArray;
        }
        return null;
    }

    public static int firstUniqChar(String s) {

        // this stores the unique characters in a hashmap key along with an integer
        // representation of the frequency of said character
        Map<Character, Integer> uniqueCount = new HashMap<>();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            if (uniqueCount.containsKey(a[i])) {
                uniqueCount.put(a[i], count += 1);
            } else {
                uniqueCount.put(a[i], count);
            }

        }

        // this loops through the beginning of the string to find the first character in
        // the hashmap with a value of 1
        for (int i = 0; i < s.length(); i++) {
            if (uniqueCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     * 
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
     * and upper cases, more than once.
     * 
     * @param s
     */

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        Set<Character> vowels = new HashSet();
        vowels.add('i');
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');
        char[] a = s.toCharArray();

        while (left < right) {
            while (left < right && !vowels.contains(a[left])) {
                left++;
            }
            while (left < right && !vowels.contains(a[right])) {
                right--;
            }

            if (left < right) {
                char temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }

        }
        return s;
    }

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
     * W E L C L O M E
     * 
     * Essentially, expanding the right side of the window for ever unique character
     * If the character is not unique, we stop and move the left side of the window to where the initial non-unique character is 
     * 
     * 
     * @param a
     * @return
     */
    public static int longestSubstringWithoutRepeatingCharacters(String a) {
       int max = 0;

       for(int left = 0, right = 0; right < a.length(); right++) {
        int indexOfCharacter = a.indexOf(a.charAt(right), 0);

        if(indexOfCharacter != right) {
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
        int left = 0;
        int right = a.length() - 1;

        while (left < right) {
            if (a.charAt(left) != a.charAt(right)) {
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
