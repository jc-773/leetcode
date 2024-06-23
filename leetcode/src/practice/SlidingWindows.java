package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindows {
    public static final String s = "abzcabcbb";
    public static final int[] sumWindow = { 1, 4, 2, 9, 1, 3, 2, 7, 5 };
    public static final int[] processDup = { 5, 4, 2, 4, 1, 2, 2, 4, 1 };
    public static final int[] moveZeros = { 0, 1, 0, 3, 12 };
    public static final int[] concatenation = { 1, 2, 1 };
    public static final String word1 = "ab";
    public static final String word2 = "pqrs";
    public static final String reverseWords = "  hello world  ";
    public static final Set<Integer> mySet = new HashSet<>();

    public static void main(String[] args) {
        // mySet.add(5);
        // mySet.add(4);
        // mySet.add(2);
        // mySet.add(15);
        // mySet.add(8);

        // printArray(convertedArray(mySet));

        //findTargetFormulaInMap(processDup, 6);

        reverseStringLoop("Hello");
    }

    /* SLIDING WINDOW */

    // return the largest sum of k windows within an array
    //
    // {1,4,2,9,1,3,2,7,5};
    public static int sumOfLargestWindow(int[] a, int k) {
        int max = 0;

        for (int i = 0; i < k; i++) {
            max += a[i];
        }

        int windowSum = max;
        for (int i = k; i < a.length; i++) {
            windowSum += a[i] - a[i - k];
            max = Math.max(max, windowSum);
        }
        System.out.println("Max: " + max);
        return max;
    }

    /* ARRAYS */


    /**
     * Leetcode 1768
     */
    public static String mergeAlternately(String word1, String word2) {
       StringBuilder builder = new StringBuilder();
       int maxLength = Math.max(word1.length(), word2.length());


       for(int i = 0; i < maxLength; i++) {
        if(i < word1.length()) {
            builder.append(word1.charAt(i));
        }
        if(i < word2.length()) {
            builder.append(word2.charAt(i));
        }
       }
       return builder.toString();
    }



    // take all duplicate integers from a passed in array order them, and replace
    // empty indicies with 0
    public static void proccessDuplicateArray(int[] a) {
        int arraySize = a.length;

        Set<Integer> uniqueIntegers = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            uniqueIntegers.add(a[i]);
        }

        int indexCount = 0;
        for (Integer i : uniqueIntegers) {
            a[indexCount++] = i;
        }

        for (int i = uniqueIntegers.size(); i < a.length; i++) {
            a[i] = 0;
        }
        printArray(a);
        // System.out.println("Array size: " + arraySize + "\nSet size: " +
        // uniqueIntegers.size());
    }


   /**
    * you need an array double the size of the array that is passed in
    * loop through the passed in array assign each element to the beggining and end
    * simultaneously of doubled array
    * 
    */
    public static int[] getMirror(int[] nums) {
        int[] a = new int[nums.length * 2];
        int indexCounter = a.length - 1;
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
            a[indexCounter--] = nums[i];
        }

        return a;
    }

    /**
     * Leetcode 1929 
     *
     * That thought process creates a mirror effect on the array and not a
     * concatenation
     * 
     * You need a way to copy over the existing array to the doubled array
     */
    public static int[] getConcatenation(int[] nums) {
        int[] a = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        for (int i = nums.length; i < a.length; i++) {
            a[i] = nums[i - nums.length];
        }

        return a;
    }

    public static void moveZeroes(int[] nums) {

        int index = 0; // this int variable will maintain the index order of the logic inside of the
                       // if-conditional so that elements will be added sequentially
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /* STRINGS */

    public static String reverseString(String s) {
        int left = 0;
        int right = s.length()-1;
        char [] a = s.toCharArray();

        while(left < right) {
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        System.out.println(s.valueOf(a));
        return s.valueOf(a);
    }

    public static String reverseStringBuilder (String s) {
        StringBuilder builder = new StringBuilder(s);
        System.out.println(builder.reverse().toString());
        return builder.reverse().toString();
    }

    public static String reverseStringLoop(String s) {
        String s2 = "";
        for (int i = s.length()-1; i >= 0; i--) {
            s2 += s.charAt(i);
        }
        System.out.println(s2);
        return s2;
    }

    public static String reverseWords(String s) {
        String cleanedString = s.replaceAll("\\s{2,}", " ");
        String trimmed = cleanedString.trim();
        String [] words = trimmed.split(" ");

        String [] reversed = new String [words.length];
        int index = 0;
        for(int i = words.length-1; i >= 0; i--) {
            if(words[i].length() > 0) {
                reversed [index++] = words[i];
            }
        }
        
        String result = String.join(" ", reversed);
        System.out.println(result);
        return result;
    }

    /* HASH MAPS */


    public static Map<Integer, Integer> findTargetFormulaInMap(int [] a, int t) {
        Map<Integer, Integer> occurenceMap = new HashMap<>();

        for(int i = 0; i < a.length; i++) {
            occurenceMap.put(a[i], occurenceMap.getOrDefault(a[i], 0) + 1);
        }

        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            int difference = t - a[i]; // we want to see if the difference is within the hashmap
            if(occurenceMap.getOrDefault(difference, 0) > 0) {
                System.out.println("Target found " + occurenceMap.get(difference) + " time(s)");
            }
        }

        return occurenceMap;
    }

    //Store values from an array as keys, and the value for the associated key represents how many times the key occurs
    public static Map<Integer, Integer> countOccurenceMap(int [] a) {
        Map<Integer, Integer> occurenceMap = new HashMap<>();

        for(int i = 0; i < a.length; i++) {
            occurenceMap.put(a[i], occurenceMap.getOrDefault(a[i], 0) + 1);
        }

        return occurenceMap;
    }

    // get the index of the last unique character in a passed in string
    public static int lastUniqChar(String s) {
        Map<Character, Integer> uniqueCharMap = new HashMap();

        for (Character c : s.toCharArray()) {
            uniqueCharMap.put(c, uniqueCharMap.getOrDefault(c, 0) + 1);
        }

        for (int i = s.length() - 1; i > 0; i--) {
            if (uniqueCharMap.get(s.charAt(i)) == 1) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    // get the index of the first unique character in a passed in string
    public static int firstUniqChar(String s) {
        Map<Character, Integer> uniqueCharMap = new HashMap();

        for (Character c : s.toCharArray()) {
            uniqueCharMap.put(c, uniqueCharMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (uniqueCharMap.get(s.charAt(i)) == 1) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    // count the frequency of unique chartacters in a passed in string
    public static int countUniqueChars(String s) {
        Map<Character, Integer> characterMap = new HashMap();

        for (Character c : s.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        System.out.println();
        return count;
    }

    // count the frequency of all characters in a passed in string
    // a = 2, b = 4, c = 2
    public static void countChars(String s) {
        Map<Character, Integer> characterMap = new HashMap();

        for (Character c : s.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /* HASH SET */

    // remove all duplicate characters from the passed in string
    public static void something(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uniqueSet.add(s.charAt(i));
        }
        printSet(uniqueSet);
    }

    // convert integer hashSet to an int array
    private static int[] convertedArray(Set<Integer> s) {
        int[] a = new int[s.size()];

        int indexCount = 0;
        for (Integer i : s) {
            a[indexCount++] = i;
        }

        return a;
    }

    /* UTILITIES */

    public static void printSet(Set<Character> s) {
        for (char c : s) {
            System.out.print(c);
        }
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
